package com.co.juanvera.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.co.juanvera.*;
import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.entidades.Persona;
import com.co.juanvera.entidades.PersonasProductos;
import com.co.juanvera.entidades.Producto;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarProductosGui extends JDialog implements ActionListener {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JTextField txtProductoComprar;
	private JTextField txtComprarPersona;
	private JButton btnComprar;
	//private JTextField txtidProducto;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public RegistrarProductosGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 364);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Registrar y Comprar Productos");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 109);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 11, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 11, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(214, 11, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(271, 11, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 43, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(271, 66, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 66, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		JLabel lblTitulo_1 = new JLabel("COMPRAR PRODUCTOS");
		lblTitulo_1.setBounds(10, 196, 372, 28);
		contentPanel.add(lblTitulo_1);
		lblTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		
		JLabel etiProducto_1 = new JLabel("Id Producto:");
		etiProducto_1.setBounds(20, 241, 75, 21);
		contentPanel.add(etiProducto_1);
		
		txtProductoComprar = new JTextField();
		txtProductoComprar.setColumns(10);
		txtProductoComprar.setBounds(99, 242, 86, 20);
		contentPanel.add(txtProductoComprar);
		
		JLabel etiIdPersona_1 = new JLabel("Id Persona:");
		etiIdPersona_1.setBounds(195, 241, 75, 21);
		contentPanel.add(etiIdPersona_1);
		
		txtComprarPersona = new JTextField();
		txtComprarPersona.setColumns(10);
		txtComprarPersona.setBounds(265, 241, 86, 21);
		contentPanel.add(txtComprarPersona);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(148, 291, 89, 23);
		contentPanel.add(btnComprar);
		btnComprar.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegistrar) {
			if(txtNombre.getText().equals("") || txtPrecio.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
					
				Producto miProducto = new Producto();
				
				miProducto.setIdProducto(null);
				miProducto.setNombreProducto(txtNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
					boolean r = miCoordinador.registrarProducto(miProducto);
					if (r == true) {
						JOptionPane.showMessageDialog(null, "Registro Exitoso!");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"No se pudo registrar el Producto!!\nVerifique que no exista previamente.","ERROR",JOptionPane.ERROR_MESSAGE );
					}
			}		
		}
		else if(e.getSource() == btnComprar) {
			Long personaid;
			Long productoid;
							
				PersonasProductos producto = new PersonasProductos();
				
				personaid = Long.parseLong(txtComprarPersona.getText());
				
				Persona r = miCoordinador.consultarPersona(personaid);
				
				if (r != null) {
					productoid = Long.parseLong(txtProductoComprar.getText());
					
					Producto a = miCoordinador.consultarProducto(productoid);
					if (a != null) {
						producto.setPersonaId(personaid);
						producto.setProductoId(productoid);
						
						boolean res = miCoordinador.comprarProducto(producto);
						if (res == true) {
							JOptionPane.showMessageDialog(null,"Producto Comprado!!");
						}else {
							JOptionPane.showMessageDialog(null, "No se puede Comprar el Producto!!\n","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null,"El Producto no Existe!!","ERROR",JOptionPane.ERROR_MESSAGE );
					}
				}else {
					JOptionPane.showMessageDialog(null,"La persona no Existe!!","ERROR",JOptionPane.ERROR_MESSAGE );
			}
		}
		
		else if(e.getSource() == btnCancelar) {
			setVisible(false);
		}
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
	
	public void limpiar() {
	//	txtidProducto.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
	}
}
