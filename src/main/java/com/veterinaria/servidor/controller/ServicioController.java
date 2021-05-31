package com.veterinaria.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Servicio;
import com.veterinaria.servidor.service.ServicioService;

@RestController
@RequestMapping(value = "/servicio")
public class ServicioController {

	@Autowired
	private ServicioService service;
	
	@GetMapping(value = "/lista")
	@ResponseBody
	public List<Servicio> lista(){
		return service.listaServicios();
	}
	
	@GetMapping(value = "/buscaServicioById/{cod}")
	@ResponseBody
	public  Optional<Servicio> buscaServicioXID(@PathVariable("cod")int cod){
		return service.buscarServicioxID(cod);
	}
	
}
