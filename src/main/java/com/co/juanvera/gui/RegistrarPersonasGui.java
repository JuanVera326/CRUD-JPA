package com.co.juanvera.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.co.juanvera.*;
import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.entidades.Nacimiento;
import com.co.juanvera.entidades.Persona;

import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class RegistrarPersonasGui extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtProfesion;
	private JTextField txtTipo;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField txtPais;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JComboBox comboBox;

	public RegistrarPersonasGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 624, 423);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestion de Personas");	
	}

	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR PERSONAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 599, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 588, 324);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Documento:");
		lblNewLabel.setBounds(24, 34, 71, 21);
		panel.add(lblNewLabel);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(99, 34, 86, 20);
		panel.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(195, 34, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(259, 34, 303, 20);
		panel.add(txtNombre);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 66, 71, 21);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(99, 66, 86, 20);
		panel.add(txtTelefono);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(195, 66, 71, 21);
		panel.add(lblProfesion);
		
		txtProfesion = new JTextField();
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(259, 66, 167, 20);
		panel.add(txtProfesion);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(439, 66, 71, 21);
		panel.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(476, 66, 86, 20);
		panel.add(txtTipo);
		
		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setBorder(new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(24, 122, 538, 109);
		panel.add(panelNacimiento);
		panelNacimiento.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);
		
		txtDia = new JTextField();
		txtDia.setBounds(142, 28, 25, 20);
		panelNacimiento.add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(190, 28, 25, 20);
		panelNacimiento.add(txtMes);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(238, 28, 54, 20);
		panelNacimiento.add(txtAnio);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(177, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setBounds(224, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1_1);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 59, 71, 21);
		panelNacimiento.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(74, 59, 86, 20);
		panelNacimiento.add(txtCiudad);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(281, 59, 86, 20);
		panelNacimiento.add(txtDepartamento);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(424, 59, 86, 20);
		panelNacimiento.add(txtPais);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 253, 538, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(463, 276, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(364, 276, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBox.setBounds(259, 97, 86, 22);
		panel.add(comboBox);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(195, 98, 71, 21);
		panel.add(lblSexo);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			if ( txtDocumento.getText().equals("") || txtNombre.getText().equals("") || txtProfesion.getText().equals("") || txtTelefono.getText().equals("") || 
					  txtTipo.getText().equals("") || txtCiudad.getText().equals("") || txtDepartamento.getText().equals("") || txtPais.getText().equals("") || 
					  txtAnio.getText().equals("") || txtMes.getText().equals("") || txtDia.getText().equals("")) {
				
				JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
			
				Long idPersona = Long.parseLong(txtDocumento.getText());
				
				Persona resp = miCoordinador.consultarPersona(idPersona);
				if ( resp == null ) {
					
					Persona miPersona = new Persona();
					
					miPersona.setIdPersona(idPersona);
					miPersona.setNombre(txtNombre.getText());
					miPersona.setTelefono(txtTelefono.getText());
					miPersona.setProfesion(txtProfesion.getText());
					miPersona.setTipo(Integer.parseInt(txtTipo.getText()));
					miPersona.setSexo((String)comboBox.getSelectedItem());
					
					int dia = Integer.parseInt(txtDia.getText());
					int mes = Integer.parseInt(txtMes.getText());
					int anio = Integer.parseInt(txtAnio.getText());
					
					Nacimiento datosNacimiento = new Nacimiento();
					
					datosNacimiento.setIdNacimiento(null);
					datosNacimiento.setFechaNacimiento(LocalDate.of(dia, mes, anio));
					datosNacimiento.setCiudadNacimiento(txtCiudad.getText());
					datosNacimiento.setDepartamentoNacimiento(txtDepartamento.getText());
					datosNacimiento.setPaisNacimiento(txtPais.getText());
					
					miPersona.setNacimiento(datosNacimiento);
					boolean res = miCoordinador.registrarPersona(miPersona);
					
						if (res == true) {
							JOptionPane.showMessageDialog(null, "Registro Exitoso!");
							limpiar();
						}else {
							JOptionPane.showMessageDialog(null,"No se pudo Registrar!!","ERROR",JOptionPane.ERROR_MESSAGE );
						}
				}
				else {
					JOptionPane.showMessageDialog(null,"ADVERTENCIA: "+"Lo sentimos, el documento esta DUPLICADO","ERROR",JOptionPane.ERROR_MESSAGE );
				}
				
			}
		}
		
		else if ( e.getSource()  == btnCancelar ) {		
			setVisible(false);
		}
	}
	
	private void limpiar() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtProfesion.setText("");
		txtTipo.setText("");
		txtDia.setText("");
		txtMes.setText("");
		txtAnio.setText("");
		txtCiudad.setText("");
		txtDepartamento.setText("");
		txtPais.setText("");
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}