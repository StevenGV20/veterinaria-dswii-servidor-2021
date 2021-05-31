package com.veterinaria.servidor.entity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoUsuarioPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "idpedido", unique = true, nullable = false, length = 10,insertable = true,updatable = false)
	private int idpedido;
	@Column(name = "idusuario",unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idusuario;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idusuario;
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
		DetallePedidoUsuarioPK other = (DetallePedidoUsuarioPK) obj;
		if (idusuario != other.idusuario)
			return false;
		if (idpedido != other.idpedido)
			return false;
		return true;
	}
}
