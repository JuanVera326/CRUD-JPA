package clases;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;
import	com.co.juanvera.entidades.*;
import com.co.juanvera.aplicacion.Program;
import com.co.juanvera.dao.*;

public class GestionPersonas {
	
	PersonaDao miPersonaDao = new PersonaDao();
	
	public GestionPersonas() {
		Program miprogram = new Program();
		String menu = "MENU OPCIONES - GESTION PERSONAS\n\n";
		menu += "1. Registrar Persona\n";
		menu += "2. Consultar Perosna\n";
		menu += "3. Consultar Lista Personas\n";
		menu += "4. Consultar Lista Personas por Sexo\n";
		menu += "5. Actualizar Nombre Persona\n";
		menu += "6. Eliminar Persona\n";
		menu += "7. Salir\n\n";

		int opc = 0;
		
		while (opc!=6) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar();; break;
			case 2: consultar(); break;
			case 3: cosultarLista(); break;
			case 4: cosultarListaPorSexo(); break;
			case 5: actualizarNombre(); break;
			case 6: eliminar(); break;
			case 7: miPersonaDao.close(); miprogram.iniciar(); break;
			}
		}
	}

	private void eliminar() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la Persona a Eliminar: "));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if (miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
		}else {
			System.out.println();
			System.out.println("No se encontro la Persona a Eliminar!!");
		}System.out.println();
	}

	private void actualizarNombre() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la persona a Actualizar su Nombre:"));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
	
		if (miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
			miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de la Persona:"));
			System.out.println(miPersonaDao.actualizarPersona(miPersona));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se Encontro la Persona para Actualizar!!");
		}
		
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Desea actualizar una Mascota?\n"));
			
			MascotaDao miMascotaDao = new MascotaDao();
			
			Long idmascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la Mascota:\n"));
			Mascota miMascota = miMascotaDao.consultarMascota(idmascota);
			
			if (miMascota != null) {
				System.out.println(miMascota);
				System.out.println();
				miMascota.setNombre(JOptionPane.showInputDialog("Ingres el nuevo nombre de la Mascota:\n"));
				miMascota.setRaza(JOptionPane.showInputDialog("Ingres la nueva raza de la Mascota:\n"));
				miMascota.setColorMascota(JOptionPane.showInputDialog("Ingres el nuevo color de la Mascota:\n"));
				miMascota.setSexo(JOptionPane.showInputDialog("Ingres el nuevo sexo de la Mascota:\n"));
				
				System.out.println(miMascotaDao.actualizarMascota(miMascota));
				System.out.println();
				
			}else {
				System.out.println();
				System.out.println("No se encontro la Mascota");
			}
			
		} while (opc != 2);
	}

	private void cosultarListaPorSexo() {
		String sex = JOptionPane.showInputDialog("Ingrese el Sexo").toLowerCase();
		
		List<Persona> listPersonas = miPersonaDao.consultarPorSexo(sex);
		for (Persona persona : listPersonas) {
			System.out.println(persona);
		}
	}

	private void cosultarLista() {
		
		System.out.println("Lista de Personas!!");
		List<Persona> listaPersonas = miPersonaDao.consultarListaPersonas();
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}
	}

	private void consultar() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el Documento de la Persona a Consultar:"));
		
		Persona miPersona = miPersonaDao.consultarPersonas(idPersona);
		
		if (miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se Encontro la Persona!!");
		}
	}

	private void registrar() {
		Persona miPersona = new Persona();
		
		miPersona.setIdPersona(Long.parseLong(JOptionPane.showInputDialog("Ingrese el Documento de la Persona:")));
		miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el Nombre de la Persona:"));
		miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el Telefono de "+miPersona.getNombre()+":"));
		miPersona.setProfesion(JOptionPane.showInputDialog("Ingrese la Profesion de "+miPersona.getNombre()+":"));
		miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Tipo: ")));
		miPersona.setSexo(JOptionPane.showInputDialog("Ingrese el Sexo de "+miPersona.getNombre()+":"));
		
		miPersona.setNacimiento(obtenerDatosNacimiento(miPersona));
		
		int opc = Integer.parseInt(JOptionPane.showInputDialog("Desea registrar una Mascota?\n1: No\n2: Si"));
		while (opc == 2){
			Mascota miMascota = new Mascota();
			miMascota.setIdMascota(null);
			miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Mascota:\n"));
			miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de "+miMascota.getNombre()+":"));
			miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de "+miMascota.getNombre()+":"));
			miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de "+miMascota.getNombre()+":"));
			
			miMascota.setDuenio(miPersona);
			
			miPersona.getListaMascotas().add(miMascota);
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Desea registrar otra Mascota?\n1: No\n2: Si"));
		}
		System.out.println(miPersonaDao.registrarPersona(miPersona));		
	}

	private Nacimiento obtenerDatosNacimiento(Persona miPersona) {
		int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DIA de Nacimiento de "+miPersona.getNombre()+":"));
		int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el MES de Nacimiento de "+miPersona.getNombre()+":"));
		int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el A�O de Nacimiento de "+miPersona.getNombre()+":"));
		
		Nacimiento datosNacimiento = new Nacimiento();
		
		datosNacimiento.setIdNacimiento(null);
		datosNacimiento.setFechaNacimiento(LocalDate.of(dia, mes, anio));
		datosNacimiento.setCiudadNacimiento(JOptionPane.showInputDialog("Ingrese la Ciudad de Nacimiento de "+miPersona.getNombre()+":"));
		datosNacimiento.setDepartamentoNacimiento(JOptionPane.showInputDialog("Ingrese el Departamento de Nacimiento de "+miPersona.getNombre()+":"));
		datosNacimiento.setPaisNacimiento(JOptionPane.showInputDialog("Ingrese el Pais de Nacimiento de "+miPersona.getNombre()+":"));

		
		return datosNacimiento;
	}
}
