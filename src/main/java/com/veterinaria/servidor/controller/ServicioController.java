package com.veterinaria.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Servicio;
import com.veterinaria.servidor.service.ServicioService;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091"}, methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping(value = "/servicio")
public class ServicioController {

	@Autowired
	private ServicioService service;
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/lista")
	@ResponseBody
	public List<Servicio> lista(){
		return service.listaServicios();
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/buscaServicioById/{cod}")
	@ResponseBody
	public  Optional<Servicio> buscaServicioXID(@PathVariable("cod")int cod){
		return service.buscarServicioxID(cod);
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/listaServiciosByName/{nombre}")
	@ResponseBody
	public List<Servicio> listaServiciosByName(@PathVariable("nombre") String nombre){
		List<Servicio> lista= service.listaServicioByNombre(nombre);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/listaServiciosByNameAZ")
	@ResponseBody
	public List<Servicio> listaServiciosByNameAZ(){
		List<Servicio> lista= service.listaServicioByAaZ();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/listaServiciosByNameZA")
	@ResponseBody
	public List<Servicio> listaServiciosByNameZA(){
		List<Servicio> lista= service.listaServicioByZaA();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/listaServiciosByPrecioMenor")
	@ResponseBody
	public List<Servicio> listaServiciosByPrecioMenor(){
		List<Servicio> lista= service.listaServicioByPrecioMenor();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@GetMapping(value = "/listaServiciosByPrecioMayor")
	@ResponseBody
	public List<Servicio> listaServiciosByPrecioMayor(){
		List<Servicio> lista= service.listaServicioByPrecioMayor();
		return lista;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@PostMapping("/registra")
	public void registra(@RequestBody Servicio obj){
		try {
			service.mantenerServicio(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@PutMapping("/actualiza")
	public void actualiza(@RequestBody Servicio obj){
		try {
			service.mantenerServicio(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@DeleteMapping(path = "/elimina/{id}")
	public void eliminaCliente(@PathVariable(name = "id") int id) {
		service.eliminaServicio(id);
	}
}
