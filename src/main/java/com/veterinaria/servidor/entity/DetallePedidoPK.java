package com.veterinaria.servidor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class DetallePedidoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name = "idpedido", unique = true, nullable = false, length = 10,insertable = true,updatable = false)
	private int idpedido;
	@Column(name = "idproducto",unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idproducto;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idproducto;
		result = prime * result + idpedido;
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
		DetallePedidoPK other = (DetallePedidoPK) obj;
		if (idproducto != other.idproducto)
			return false;
		if (idpedido != other.idpedido)
			return false;
		return true;
	}

}
