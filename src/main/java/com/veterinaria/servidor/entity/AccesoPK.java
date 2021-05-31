package com.veterinaria.servidor.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Embeddable
public class AccesoPK implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int idRol;
	private int idOpcion;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOpcion;
		result = prime * result + idRol;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccesoPK other = (AccesoPK) obj;
		if (idOpcion != other.idOpcion)
			return false;
		if (idRol != other.idRol)
			return false;
		return true;
	}
	
	
}
