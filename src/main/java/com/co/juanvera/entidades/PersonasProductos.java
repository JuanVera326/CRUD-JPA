package com.co.juanvera.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas_productos")
public class PersonasProductos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "producto_id")
	private Long productoId;
	
	@Id
	@Column(name = "persona_id")
	private Long personaId;
	
	public PersonasProductos() {
		
	}
	public PersonasProductos( Long productoId,  Long personaId) {
		super();
		this.personaId = personaId;
		this.productoId = productoId;
	}
	public Long getProductoId() {
		return productoId;
	}
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}
	public Long getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PersonasProductos:\nproductoId=" + productoId + "\npersonaId=" + personaId;
	}
}
