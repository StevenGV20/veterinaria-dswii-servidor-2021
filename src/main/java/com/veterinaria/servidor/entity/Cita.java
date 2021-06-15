package com.veterinaria.servidor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcita")
	private int idcita;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Timestamp(value = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaRegistro=new Date();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Timestamp(value = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAtencion;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Timestamp(value = "HH:mm:ss")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date horaAtencion;
	
	private String observacion;
	private String estado;

	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idservicio")
	private Servicio servicio;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente")
	private Usuario cliente;;

	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idveterinario")
	private Usuario veterinario;;
}
