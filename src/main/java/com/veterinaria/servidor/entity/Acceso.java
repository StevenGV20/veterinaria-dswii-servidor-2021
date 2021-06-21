package com.veterinaria.servidor.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "acceso")
public class Acceso implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccesoPK accesoPK;

	@ManyToOne
	@JoinColumn(name = "idrol", nullable = false, insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "idopcion", nullable = false, insertable = false, updatable = false)
	private Opcion opcion;

	public AccesoPK getAccesoPK() {
		return accesoPK;
	}

	public void setAccesoPK(AccesoPK accesoPK) {
		this.accesoPK = accesoPK;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

}
