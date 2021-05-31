package com.veterinaria.servidor.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.veterinaria.servidor.entity.Servicio;
import com.veterinaria.servidor.repository.ServicioRepository;

@Service
public class ServicioServiceImpl  implements ServicioService{

	@Autowired
	private ServicioRepository repository;
	
	@Override
	public List<Servicio> listaServicios() {
		return repository.findAll();
	}

	@Override
	public Servicio mantenerServicio(Servicio obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Servicio> buscarServicioxID(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaServicio(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void guardarFotoServicio(MultipartFile file) throws Exception {
		String ruta=".//src//main//resources//static//img//";
		if(!file.isEmpty()) {
			byte[] bytes=file.getBytes();
			Path path=Paths.get(ruta + file.getOriginalFilename());
			Files.write(path, bytes);
		}
	}

	@Override
	public Servicio detalleServicioXID(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Servicio> listaServicioByNombre(String nombre) {
		return repository.listaServicioByName(nombre+"%");
	}

	@Override
	public List<Servicio> listaServicioByAaZ() {
		return repository.listaServicioByNameAaZ();
	}

	@Override
	public List<Servicio> listaServicioByZaA() {
		return repository.listaServicioByNameZaA();
	}

	@Override
	public List<Servicio> listaServicioByPrecioMenor() {
		return repository.listaServicioByPrecioMenor();
	}

	@Override
	public List<Servicio> listaServicioByPrecioMayor() {
		return repository.listaServicioByPrecioMayor();
	}

}
