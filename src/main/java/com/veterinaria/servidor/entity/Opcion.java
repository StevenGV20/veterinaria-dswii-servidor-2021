package com.veterinaria.servidor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "opcion")
public class Opcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idopcion;
	private String nombre;
	private String ruta;
	private String estado;
	private String icono;
	
	
}
