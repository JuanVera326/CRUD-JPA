package com.co.juanvera.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.aplicacion.JPAUtil;
import com.co.juanvera.entidades.Persona;
import com.co.juanvera.entidades.PersonasProductos;
import com.co.juanvera.entidades.Producto;

public class ProductoDao {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;

	public boolean registrarProducto(Producto miProducto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit(); 
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean registrarCompra(PersonasProductos producto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	public Producto consultarProducto(Long idProducto) {
		Producto miProducto = entityManager.find(Producto.class,idProducto);
		
		if (miProducto != null) {
			
			return miProducto;
		}else {
			return null;
		}
	}

	public List<Producto> consultarListaProductos() {
		List<Producto> listProductos = new ArrayList<Producto>();
		try {
			Query query = entityManager.createQuery("SELECT p FROM Producto p");
			listProductos = query.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pueden mostrar los Productos!!\n","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return listProductos;
	}

	public boolean actualizarProducto(Producto miProducto) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miProducto);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede Actualizar el Producto!!\n","ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean eliminarProducto(Producto miProducto) {

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miProducto);
			entityManager.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede Eliminar el Producto","ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

}
