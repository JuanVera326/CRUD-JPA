package com.co.juanvera.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.co.juanvera.*;
import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.entidades.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ConsultarProductosGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private JTextField textId;
	private Coordinador miCoordinador;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnCancelar;
	private JTextField txtNombreProducto;
	private JLabel lblNombreProducto;
	private JLabel lblPrecioproducto;
	private JTextField txtPrecioProducto;
	private JButton btnActualizar;
	private JButton btnConcultarTodo;

	
	public ConsultarProductosGui() {
		setBounds(100, 100, 474, 398);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Gestion Productos");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		etiTitulo.setBounds(150, 11, 176, 20);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25, 77, 423, 116);
		miPanel.add(scroll);
		
		JLabel etiId = new JLabel("Id:");
		etiId.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiId.setBounds(300, 269, 26, 20);
		miPanel.add(etiId);
		
		textId = new JTextField();
		textId.setBounds(341, 271, 86, 20);
		miPanel.add(textId);
		textId.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(238, 204, 100, 23);
		btnEliminar.addActionListener(this);
		miPanel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(120, 204, 100, 23);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(348, 204, 100, 23);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setColumns(10);
		txtNombreProducto.setBounds(150, 271, 86, 20);
		miPanel.add(txtNombreProducto);
		
		lblNombreProducto = new JLabel("Nombre Producto:");
		lblNombreProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreProducto.setBounds(10, 269, 137, 20);
		miPanel.add(lblNombreProducto);
		
		lblPrecioproducto = new JLabel("Precio Producto:");
		lblPrecioproducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioproducto.setBounds(10, 313, 137, 20);
		miPanel.add(lblPrecioproducto);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setColumns(10);
		txtPrecioProducto.setBounds(150, 315, 86, 20);
		miPanel.add(txtPrecioProducto);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(10, 204, 100, 23);
		btnActualizar.addActionListener(this);
		miPanel.add(btnActualizar);
		
		btnConcultarTodo = new JButton("Consultar Todo");
		btnConcultarTodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConcultarTodo.setBounds(274, 42, 174, 23);
		btnConcultarTodo.addActionListener(this);
		miPanel.add(btnConcultarTodo);
	}

	

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnConcultarTodo) {
			
			List<Producto> productos = miCoordinador.consultarTodosLosProductos();
			System.out.println(productos);
				AreaResultado.setText(""+productos);
		}
		else if (e.getSource() == btnConsultar) {
			if(textId.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor llene el Campo de ID","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}else {
				Long idLong = Long.parseLong(textId.getText());
				Producto r = miCoordinador.consultarProducto(idLong);
				if (r != null) {
					txtNombreProducto.setText(r.getNombreProducto());
					txtPrecioProducto.setText(""+r.getPrecioProducto());
				}else {
					JOptionPane.showMessageDialog(null, "El Producto no Existe!!" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
					limpiar();
				}
			}
		}
		
		else if(e.getSource() == btnEliminar) {
			
			if(textId.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor llene el Campo de ID para Eliminar","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				Long idLong = Long.parseLong(textId.getText());
				Producto r = miCoordinador.consultarProducto(idLong);
				
				if (r != null) {
					boolean resul = miCoordinador.eliminarProducto(r);
					
					if(resul == true) {
						JOptionPane.showMessageDialog(null, "Eliminacion Exitosa!");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
						limpiar();
					}
				}else {
					JOptionPane.showMessageDialog(null, "El Producto no Existe!!" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
					limpiar();
				}
				
			}
		
		}
		
		else if (e.getSource() == btnActualizar) {
			
			if (textId.getText().equals("") || txtNombreProducto.equals("") || txtPrecioProducto.equals("")) {
				JOptionPane.showMessageDialog(null, "Por favor llena todos los campos!!" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
			}else {
			Long idProducto = Long.parseLong(textId.getText());
			Producto miProducto = miCoordinador.consultarProducto(idProducto);
		
			if (miProducto != null) {
				
				miProducto.setNombreProducto(txtNombreProducto.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecioProducto.getText()));
				
				boolean r = miCoordinador.actualizarProducto(miProducto);
				
				if (r == true) {
					JOptionPane.showMessageDialog(null, "Actualizacion Exitosa!!");
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Producto" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
				}
			}else {
				System.out.println();
				JOptionPane.showMessageDialog(null, "El Producto no Existe!!" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
			}
		}
	}
			
		
		
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
		
	}
	public void limpiar() {
		textId.setText("");
		txtNombreProducto.setText("");
		txtPrecioProducto.setText("");
	}	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
