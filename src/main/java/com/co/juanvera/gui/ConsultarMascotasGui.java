package com.co.juanvera.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.co.juanvera.*;
import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.entidades.Mascota;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class ConsultarMascotasGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextField textDocumnto;
	private JTextField textNombre;
	private JTextField textRaza;
	private JTextField textSexo;
	private JTextField textColor;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private Coordinador miCoordinador;

	public ConsultarMascotasGui() {
		
		setBounds(100, 100, 453, 314);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(308, 46, 107, 23);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		JLabel etiIdDuenio = new JLabel("Id de Mascota");
		etiIdDuenio.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiIdDuenio.setBounds(22, 46, 89, 23);
		miPanel.add(etiIdDuenio);
		
		textDocumnto = new JTextField();
		textDocumnto.setBounds(132, 49, 100, 20);
		miPanel.add(textDocumnto);
		textDocumnto.setColumns(10);
		
		JLabel etiTitulo = new JLabel("Gestion de mascotas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(122, 11, 203, 23);
		miPanel.add(etiTitulo);
		
		JLabel etiNombre = new JLabel("Nombre:");
		etiNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiNombre.setBounds(22, 133, 66, 28);
		miPanel.add(etiNombre);
		
		JLabel etiRaza = new JLabel("Raza:");
		etiRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiRaza.setBounds(246, 136, 50, 22);
		miPanel.add(etiRaza);
		
		textNombre = new JTextField();
		textNombre.setBounds(122, 139, 100, 20);
		miPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textRaza = new JTextField();
		textRaza.setBounds(306, 139, 117, 20);
		miPanel.add(textRaza);
		textRaza.setColumns(10);
		
		JLabel etiSexo = new JLabel("Sexo:");
		etiSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiSexo.setBounds(22, 175, 59, 28);
		miPanel.add(etiSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(122, 181, 100, 20);
		miPanel.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel etiColor = new JLabel("Color:");
		etiColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiColor.setBounds(246, 175, 50, 28);
		miPanel.add(etiColor);
		
		textColor = new JTextField();
		textColor.setBounds(306, 181, 117, 20);
		miPanel.add(textColor);
		textColor.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(325, 241, 90, 23);
		btnEliminar.addActionListener(this);
		miPanel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(22, 241, 100, 23);
		btnActualizar.addActionListener(this);
		miPanel.add(btnActualizar);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnConsultar) {
			if ( textDocumnto.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Ingrese el campo de su documento y nombre de su mascota", "Incompleto",JOptionPane.WARNING_MESSAGE);
			}else {
				Long idDocumento=Long.parseLong(textDocumnto.getText());
				Mascota mascota = miCoordinador.consultarMascota(idDocumento);
				
				
				if ( mascota!=null) {
					
					System.out.println(mascota);	
					textDocumnto.setText(textDocumnto.getText());
					textNombre.setText(mascota.getNombre());
					textColor.setText(mascota.getColorMascota());
					textRaza.setText(mascota.getRaza());
					textSexo.setText(mascota.getSexo());
						
				}else {
					JOptionPane.showMessageDialog(null,"La Mascota no existe!!","ADVERTENCIA!!!",JOptionPane.ERROR_MESSAGE);
				}	
			}
			
			
		}
		
		else if(e.getSource() == btnActualizar) {
			
			if(textDocumnto.getText().equals("") || textNombre.getText().equals("") || textColor.getText().equals("") || textRaza.getText().equals("") || textSexo.getText().equals("")) {
				
				
				JOptionPane.showMessageDialog(null,"Ingrese todos los campos!!","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);

			}
			else {
				Long idLong = Long.parseLong(textDocumnto.getText());
				
				Mascota miMascota = new Mascota();
				
				miMascota.setIdMascota(idLong);
				miMascota.setNombre(textNombre.getText());
				miMascota.setRaza(textRaza.getText());
				miMascota.setColorMascota(textColor.getText());
				miMascota.setSexo(textSexo.getText());
				
				
				boolean resul = miCoordinador.actualizarMascota(miMascota);
				
				
				if (resul == true) {
					JOptionPane.showMessageDialog(null, "Actualización Exitosa!");
					limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No se pudo Actualizar La Mascota" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
				}
			}
			
		}
		
		
		
		else if(e.getSource() == btnEliminar){
			
			if(textDocumnto.getText().equals("") || textNombre.getText().equals("") || textColor.getText().equals("") || textRaza.getText().equals("") || textSexo.getText().equals("")) {
				
				JOptionPane.showMessageDialog(null,"Ingrese el campo de su documento y nombre de su mascota","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);

			}
			else {
				
				//Long idLong = Long.parseLong(textDocumnto.getText());
				Long idLong = Long.parseLong(textDocumnto.getText());
				
				Mascota miMascota = miCoordinador.consultarMascota(idLong);
				
				miMascota.setIdMascota(idLong);
				miMascota.setNombre(textNombre.getText());
				miMascota.setRaza(textRaza.getText());
				miMascota.setColorMascota(textColor.getText());
				miMascota.setSexo(textSexo.getText());
				
				boolean resul = miCoordinador.eliminarMascota(miMascota);
				
				if(resul == true) {
					JOptionPane.showMessageDialog(null, "Eliminacion Exitosa!");
					limpiar();
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo Eliminar la Mascota" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
				}
			}
			
			
		}
		
	}
	
	private void limpiar() {
		textDocumnto.setText("");
		textNombre.setText("");
		textRaza.setText("");
		textColor.setText("");
		textSexo.setText("");

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
