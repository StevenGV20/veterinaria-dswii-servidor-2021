package com.veterinaria.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Opcion;
import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@ResponseBody
	@PostMapping(path = "/login")
	public Usuario login(@RequestBody Usuario bean){
		return service.login(bean);
	}
	
	@ResponseBody
	@GetMapping(value = "/traerEnlaces/{id}")
	public List<Opcion> traerEnlaces(@PathVariable("id") int id){
		return service.traerEnlacesDeUsuario(id);
	}
}
