package com.veterinaria.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.entity.Especie;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.service.ComboService;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091","http://localhost:3000"}, methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/combo")
public class ComboController {

	@Autowired
	private ComboService service;
	
	//METODOS GET DE LISTAS O CONSULTAS
	//@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_VETERINARIO"})
	@GetMapping("/especie")
	@ResponseBody
	public List<Especie> listaEspecie(){
		List<Especie> listaEspecie= service.listaEspecie();
		return listaEspecie;
	}
	
	//@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_VETERINARIO", "ROLE_REPARTIDOR"})
	@ResponseBody
	@GetMapping(path = "/distrito")
	public List<Distrito> listaDistritos(){
		return service.listaDistrito();
	}
	
	//@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_VETERINARIO", "ROLE_REPARTIDOR"})
	@ResponseBody
	@GetMapping(path = "/categoria")
	public List<Categoria> listaCategoria(){
		return service.listaCategoria();
	}
	
	//@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_VETERINARIO", "ROLE_REPARTIDOR"})
	@ResponseBody
	@GetMapping(path = "/rol")
	public List<Rol> listaRol(){
		return service.listaRol();
	}
}
