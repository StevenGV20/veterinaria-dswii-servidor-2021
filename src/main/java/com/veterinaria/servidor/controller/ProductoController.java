package com.veterinaria.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Producto;
import com.veterinaria.servidor.service.ProductoService;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@ResponseBody
	@GetMapping(value = "/lista")
	public List<Producto> listaProducto(){
		return service.listaProducto();
	}
	
	@GetMapping(value = "/buscaProductoById/{cod}")
	@ResponseBody
	public  Optional<Producto> buscaProductoById(@PathVariable("cod")int cod){
		return service.buscaProductoPorId(cod);
	}
	
}
