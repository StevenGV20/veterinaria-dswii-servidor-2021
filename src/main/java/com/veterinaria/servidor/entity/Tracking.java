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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trackingpedido")
public class Tracking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtrackingPedido")
	private int idtracking;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Timestamp(value = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEntrega;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Timestamp(value = "HH:mm:ss")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date horaEntrega;
	
	private String ubicacion;
	private String estado;
	private String motivo;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpedido")
	private Pedido pedido;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtrabajador")
	private Usuario trabajador;
	
}
