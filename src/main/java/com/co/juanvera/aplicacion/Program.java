package com.co.juanvera.aplicacion;

import javax.swing.JOptionPane;

import clases.GestionMascotas;
import clases.GestionPersonas;
import clases.GestionProductos;

public class Program {
	
	public void iniciar() {
		
		String menu = "MENU DE OPCIONES\n\n";
		menu += "1. Gestionar Personas\n";
		menu += "2. Gestionar Mascotas\n";
		menu += "3. Gestionar Productos\n";
		menu += "4. Salir\n";
		
		int opc = 0;
		
		while (opc != 3) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opc) {
			case 1: new GestionPersonas(); break;
			case 2: new GestionMascotas(); break;
			case 3: new GestionProductos(); break;
			case 4: exit(); break;
			}
		}
}

	private static void exit() {
		System.exit(0);	
	}
}
