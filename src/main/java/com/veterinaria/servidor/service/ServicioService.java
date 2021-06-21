package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.veterinaria.servidor.entity.Servicio;

public interface ServicioService {

	public abstract List<Servicio> listaServicios();
	public abstract Servicio mantenerServicio(Servicio obj);
	public abstract Optional<Servicio> buscarServicioxID(int id);
	public abstract void eliminaServicio(int id);
	public abstract Servicio detalleServicioXID(int id);
	//SUBIR ARCHIVOS
	public abstract void guardarFotoServicio(MultipartFile file) throws Exception;
	//CONSULTAS
	public abstract List<Servicio> listaServicioByNombre(String nombre);
	public abstract List<Servicio> listaServicioByAaZ();
	public abstract List<Servicio> listaServicioByZaA();
	public abstract List<Servicio> listaServicioByPrecioMenor();
	public abstract List<Servicio> listaServicioByPrecioMayor();
	public abstract Page<Servicio> listaServicioByPage(Pageable pageable);
}
