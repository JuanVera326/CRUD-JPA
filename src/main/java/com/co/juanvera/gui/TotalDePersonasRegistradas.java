package com.co.juanvera.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.co.juanvera.*;
import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.entidades.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class TotalDePersonasRegistradas extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private Coordinador miCoordinador;
	private JButton btnConsultarTodasLasPersonas;
	private JButton btnLimpiar;

	
	public TotalDePersonasRegistradas() {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Total De Personas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		etiTitulo.setBounds(135, 11, 168, 24);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(31, 46, 375, 133);
		miPanel.add(scroll);
		
		btnConsultarTodasLasPersonas = new JButton("Consultar");
		btnConsultarTodasLasPersonas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarTodasLasPersonas.setBounds(31, 215, 117, 31);
		btnConsultarTodasLasPersonas.addActionListener(this);
		miPanel.add(btnConsultarTodasLasPersonas);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(158, 215, 99, 31);
		btnLimpiar.addActionListener(this);
		miPanel.add(btnLimpiar);
		
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnConsultarTodasLasPersonas) {
			List<Persona> persona = miCoordinador.consultarTodasLasPersonas();
			AreaResultado.setText(""+persona.toString());
		}
		
		else if(e.getSource()==btnLimpiar) {
			AreaResultado.setText("");
		}
		
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
