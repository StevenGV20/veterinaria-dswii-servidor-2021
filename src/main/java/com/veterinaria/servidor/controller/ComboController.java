package com.veterinaria.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.service.ComboService;

@RestController
@RequestMapping("/combo")
public class ComboController {

	@Autowired
	private ComboService service;
	
	@ResponseBody
	@GetMapping(path = "/distrito")
	public List<Distrito> listaDistritos(){
		return service.listaDistrito();
	}
	
	@ResponseBody
	@GetMapping(path = "/categoria")
	public List<Categoria> listaCategoria(){
		return service.listaCategoria();
	}
}
