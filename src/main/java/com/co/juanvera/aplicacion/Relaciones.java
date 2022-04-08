package com.co.juanvera.aplicacion;
import com.co.juanvera.gui.*;
import com.co.juanvera.dao.*;

public class Relaciones {
	VentanaPrincipal miVentanaPrincipal;
	
	public Relaciones() {
		
			Coordinador miCoordinador;
			RegistrarPersonasGui miRegistrarPersonasGui;
			RegistrarMascotasGui miRegistrarMascotasGui;
			RegistrarProductosGui miRegistrarProductosGui;
			ConsultarPersonaGui miColsultaPersonaGui;
			ConsultarMascotasGui miConsultarMascotasGui;
			ConsultarProductosGui miConsultarProductosGui;
			TotalDePersonasRegistradas miTotalDePersonasRegistradas;
			PersonaDao miPersonaDao;
			MascotaDao miMascotaDao;
			ProductoDao miProductoDao;
			
					
			miVentanaPrincipal= new VentanaPrincipal();
			miCoordinador= new Coordinador();
			miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, true);
			miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, true, "");
			miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
			miColsultaPersonaGui=new ConsultarPersonaGui();
			miConsultarMascotasGui=new ConsultarMascotasGui();
			miConsultarProductosGui=new ConsultarProductosGui();
			miTotalDePersonasRegistradas=new TotalDePersonasRegistradas();
			
			miPersonaDao= new PersonaDao();
			miMascotaDao= new MascotaDao();
			miProductoDao= new ProductoDao();
			
			miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
			miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
			miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
			miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
			miCoordinador.setConsultarPersonaGui(miColsultaPersonaGui);
			miCoordinador.setConsultarMascotaGui(miConsultarMascotasGui);
			miCoordinador.setConsultarProductosGui(miConsultarProductosGui);
			miCoordinador.setTotalDePersonasRegistradas(miTotalDePersonasRegistradas);
			
			miCoordinador.setPersonaDao(miPersonaDao);
			miCoordinador.setMascotaDao(miMascotaDao);
			miCoordinador.setProductoDao(miProductoDao);

			
			
			miVentanaPrincipal.setCoordinador(miCoordinador);
			miRegistrarPersonasGui.setCoordinador(miCoordinador);
			miRegistrarMascotasGui.setCoordinador(miCoordinador);
			miRegistrarProductosGui.setCoordinador(miCoordinador);
			miColsultaPersonaGui.setCoordinador(miCoordinador);
			miConsultarMascotasGui.setCoordinador(miCoordinador);
			miConsultarProductosGui.setCoordinador(miCoordinador);
			miTotalDePersonasRegistradas.setCoordinador(miCoordinador);
			miPersonaDao.setCoordinador(miCoordinador);
			miMascotaDao.setCoordinador(miCoordinador);
			miProductoDao.setCoordinador(miCoordinador);

					
		}
		
		public void iniciar() {
			miVentanaPrincipal.setVisible(true);
		}
}
