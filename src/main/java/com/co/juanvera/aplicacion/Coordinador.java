package com.co.juanvera.aplicacion;

import java.util.ArrayList;
import java.util.List;

import com.co.juanvera.dao.MascotaDao;
import com.co.juanvera.dao.PersonaDao;
import com.co.juanvera.dao.ProductoDao;
import com.co.juanvera.entidades.Mascota;
import com.co.juanvera.entidades.Persona;
import com.co.juanvera.entidades.PersonasProductos;
import com.co.juanvera.entidades.Producto;
import com.co.juanvera.gui.ConsultarMascotasGui;
import com.co.juanvera.gui.ConsultarPersonaGui;
import com.co.juanvera.gui.ConsultarProductosGui;
import com.co.juanvera.gui.RegistrarMascotasGui;
import com.co.juanvera.gui.RegistrarPersonasGui;
import com.co.juanvera.gui.RegistrarProductosGui;
import com.co.juanvera.gui.TotalDePersonasRegistradas;
import com.co.juanvera.gui.VentanaPrincipal;

public class Coordinador {
	
	private VentanaPrincipal miVentanaPrincipal;
	private RegistrarPersonasGui miRegistrarPersonasGui;
	private RegistrarMascotasGui miRegistrarMascotasGui;
	private RegistrarProductosGui miRegistrarProductosGui;
	private PersonaDao miPersonaDao;
	private MascotaDao miMascotaDao;
	private ProductoDao miProductoDao;
	private ConsultarPersonaGui miColsultaPersonaGui;
	private ConsultarMascotasGui miConsultarMascotasGui;
	private ConsultarProductosGui miConsultarProductosGui;
	private TotalDePersonasRegistradas miTotalDePersonasRegistradas;
	
	
	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		
	}
	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui = miRegistrarPersonasGui;
		
	}
	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
	}
	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui = miRegistrarProductosGui;
		
	}
	public void setConsultarPersonaGui(ConsultarPersonaGui miColsultaPersonaGui) {
		this.miColsultaPersonaGui = miColsultaPersonaGui;
		
	}
	public void setConsultarMascotaGui(ConsultarMascotasGui miConsultarMascotasGui) {
		this.miConsultarMascotasGui = miConsultarMascotasGui;
		
	}
	public void setConsultarProductosGui(ConsultarProductosGui miConsultarProductosGui) {
		this.miConsultarProductosGui = miConsultarProductosGui;
		
	}
	public void setTotalDePersonasRegistradas(TotalDePersonasRegistradas miTotalDePersonasRegistradas) {
		this.miTotalDePersonasRegistradas = miTotalDePersonasRegistradas;
		
	}
	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
		
	}
	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao = miMascotaDao;
		
	}
	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao = miProductoDao;
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void mostrarVentanaRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
		
	}
	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
	}
	public void registrarVentanaRegistrarProductos() {
		miRegistrarProductosGui.setVisible(true);
		
	}
	public void mostrarVentanaConsultaPersona() {
		miColsultaPersonaGui.setVisible(true);
		
	}
	public void mostrarVentanaConsultaMascotas() {
		miConsultarMascotasGui.setVisible(true);
		
	}
	public void mostrarVentanaConsultarProductos() {
		miConsultarProductosGui.setVisible(true);
		
	}
	public void mostrarVentanaTotalDePersonasRegistradas() {
		miTotalDePersonasRegistradas.setVisible(true);
		
	}
	/////////////////////////////////////////////////////////////////////////
	public Persona consultarPersona(Long idPersona) {
		return miPersonaDao.consultarPersona(idPersona);
	}
	public boolean registrarPersona(Persona miPersona) {
		return miPersonaDao.registrarPersona(miPersona);
	}
	public boolean registrarMascota(Mascota miMascota) {
		return miMascotaDao.registrarMascota(miMascota);
	}
	public List<Persona> consultarTodasLasPersonas() {
		return miPersonaDao.consultarListaPersonas();
	}
	public boolean actualizarPersona(Persona miPersona) {
		return miPersonaDao.actualizarPersona(miPersona);
	}
	public boolean eliminarPersona(Persona miPersona) {
		return miPersonaDao.eliminarPersona(miPersona);
	}
	public Mascota consultarMascota(Long idDocumento) {
		return miMascotaDao.consultarMascota(idDocumento);
	}
	public boolean actualizarMascota(Mascota miMascota) {
		return miMascotaDao.actualizarMascota(miMascota);
	}
	public boolean eliminarMascota(Mascota miMascota) {
		return miMascotaDao.eliminarMascota(miMascota);
	}
	public boolean registrarProducto(Producto miProducto) {
		return miProductoDao.registrarProducto(miProducto);
	}
	public Producto consultarProducto(Long idProducto) {
		return miProductoDao.consultarProducto(idProducto);
	}
	public boolean comprarProducto(PersonasProductos producto) {
		return miProductoDao.registrarCompra(producto);
	}
	public List<Producto> consultarTodosLosProductos() {
		return miProductoDao.consultarListaProductos();
	}
	public boolean eliminarProducto(Producto r) {
		return miProductoDao.eliminarProducto(r);
	}
	public boolean actualizarProducto(Producto miProducto) {
		return miProductoDao.actualizarProducto(miProducto);
	}
	
	
}
