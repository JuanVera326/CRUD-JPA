package com.co.juanvera.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.co.juanvera.aplicacion.Coordinador;
import com.co.juanvera.aplicacion.JPAUtil;
import com.co.juanvera.entidades.Mascota;
import com.co.juanvera.entidades.Persona;

public class PersonaDao {

	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;
	
	public boolean registrarPersona(Persona miPersona) {
		//.out.println(miPersona);
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miPersona);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
			}
	}

	public Persona consultarPersonas(Long idPersona) {
		
		Persona miPersona = entityManager.find(Persona.class, idPersona);
		
		if (miPersona != null) {
			return miPersona;
		}else {
			return null;
		}	
	}
		

	public List<Persona> consultarListaPersonas() {

		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		Query query = entityManager.createQuery("SELECT p FROM Persona p");
		listaPersonas = query.getResultList();
		return listaPersonas;
	}

	public Persona consultarPersona(Long idPersona) {
		Persona miPersona = entityManager.find(Persona.class,idPersona);
		
		if (miPersona != null) {
			
			return miPersona;
		}else {
			return null;
		}
	}

	public boolean actualizarPersona(Persona miPersona) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miPersona);
			entityManager.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean eliminarPersona(Persona miPersona) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar la persona!!\nVerifique que no tenga archivos pendientes","ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public List<Persona> consultarPorSexo(String sex) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE sexo = :sex");
		query.setParameter("sex", sex);
		listaPersonas = query.getResultList();
		return listaPersonas;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

}
