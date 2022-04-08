package com.co.juanvera.dao;


import java.util.ArrayList;
import java.util.List;

import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.aplicacion.JPAUtil;
import com.co.juanvera.entidades.Mascota;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class MascotaDao {
	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public Mascota consultarMascota(Long idMascota) {
		Mascota miMascota = entityManager.find(Mascota.class,idMascota);
		
		if (miMascota != null) {
			
			return miMascota;
		}else {
			return null;
		}
	}

	public List<Mascota> consultarListaMascotas() {
		List<Mascota> listaMascotas = new ArrayList<Mascota>();

		try {
			Query query = entityManager.createQuery("SELECT m FROM Mascota m");
			listaMascotas = query.getResultList();
			return listaMascotas;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede Listar las Mascotas!.","ERROR",JOptionPane.ERROR_MESSAGE);
			return listaMascotas;
		}
	}

	public List<Mascota> consultarListaPorSexo(String sex) {
		List<Mascota> listaMascotas = new ArrayList<Mascota>();
		try {
			Query query = entityManager.createQuery("SELECT m FROM Mascota m WHERE sexo = :sex");
			query.setParameter("sex",sex);
			listaMascotas = query.getResultList();
			return listaMascotas;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede Listar las Mascotas!	","ERROR",JOptionPane.ERROR_MESSAGE);
			return listaMascotas;
		}
		
	}

	public boolean actualizarMascota(Mascota miMascota) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miMascota);
			entityManager.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean eliminarMascota(Mascota miMascota) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miMascota);
			entityManager.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public boolean registrarMascota(Mascota miMascota) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miMascota);
			entityManager.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede registrar la Mascota!!\nVerifique que el dueño exista.","ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

}