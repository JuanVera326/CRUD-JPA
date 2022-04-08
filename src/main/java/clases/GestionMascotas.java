package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.co.juanvera.aplicacion.Program;
import com.co.juanvera.dao.MascotaDao;
import com.co.juanvera.entidades.Mascota;
import com.co.juanvera.entidades.Persona;

public class GestionMascotas {
	
	MascotaDao miMascotaDao = new MascotaDao();
	
	public  GestionMascotas() {
		Program miprogram = new Program();
		String menu = "MENU OPCIONES - GESTION MASCOTAS\n\n";
		menu += "1. Registrar Mascota\n";
		menu += "2. Consultar Mascota\n";
		menu += "3. Consultar Lista Mascotas\n";
		menu += "4. Consultar Lista Mascotas por Sexo\n";
		menu += "5. Actualizar Mascota\n";
		menu += "6. Eliminar Mascota\n";
		menu += "7. Salir\n\n";

		int opc = 0;
		
		while (opc!=6) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar(); break;
			case 2: consultar(); break;
			case 3: cosultarLista(); break;
			case 4: cosultarListaPorSexo(); break;
			case 5: actualizar(); break;
			case 6: eliminar(); break;
			case 7: miMascotaDao.close(); miprogram.iniciar(); break;
			}
		}
	}

	private void cosultarListaPorSexo() {
		String sex = JOptionPane.showInputDialog("Ingrese el sexo de la Mascota:");
		System.out.println("Lista de Mascotas por Sexo\n\n");
		List<Mascota> listaMascotas = miMascotaDao.consultarListaPorSexo(sex);
		for (Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		}
	}

	private void consultar() {
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la Mascota:\n"));
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if (miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro");
		}System.out.println();
	}

	private void eliminar() {
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingres el ID para eliminar:\n"));
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if (miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
			
			System.out.println(miMascotaDao.eliminarMascota(miMascota));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encotro la Mascota");
		}System.out.println();
	}

	private void actualizar() {
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
	}

	private void cosultarLista() {
		System.out.println("Lista de Mascotas\n\n");
		List<Mascota> listaMascotas = miMascotaDao.consultarListaMascotas();
		for (Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		}
	}

	private void registrar() {
		Mascota miMascota = new Mascota();
		miMascota.setIdMascota(null);
		miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Mascota:\n"));
		miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de "+miMascota.getNombre()+":"));
		miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de "+miMascota.getNombre()+":"));
		miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de "+miMascota.getNombre()+":"));	
		Long idDuenio = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del Dueño\n"));
		Persona duenio = new Persona();
		duenio.setIdPersona(idDuenio);
		miMascota.setDuenio(duenio);
		System.out.println(miMascotaDao.registrarMascota(miMascota));
		System.out.println();
	}
	
}
