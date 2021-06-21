package com.veterinaria.servidor.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.veterinaria.servidor.entity.Mascota;
import com.veterinaria.servidor.service.MascotaService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@RequestMapping(value = "/mascota")
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091"}, methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MascotaController {
	@Autowired
	private MascotaService mascotaService;
		
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_VETERINARIO"})
	@GetMapping("/lista")
	@ResponseBody
	public List<Mascota> listaMascotas(){
		List<Mascota> lista= mascotaService.listaMascota();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_VETERINARIO", "ROLE_CLIENTE"})
	@GetMapping("/listaMascotasByCliente/{cliente}")
	@ResponseBody
	public List<Mascota> listaMascotasByCliente(@PathVariable("cliente") int cod){
		List<Mascota> lista= mascotaService.listaMascotaByCliente(cod);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_VETERINARIO", "ROLE_CLIENTE"})
	@GetMapping("/buscarMascotaById/{codigo}")
	@ResponseBody
	public Optional<Mascota> buscarMascotaById(@PathVariable("codigo") int cod){
		Optional<Mascota> mascota= mascotaService.buscaMascotaPorId(cod);
		return mascota;
	}

	//METODOS PARA CRUD
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE"})
	@PostMapping("/registra")
	@ResponseBody
	public ResponseEntity<?> registraMascota (@RequestBody Mascota obj){
		try {
			Date dia=new Date();
			if(obj.getFechaNacimiento().before(dia))
				return ResponseEntity.ok(mascotaService.mantenerMascota(obj));
			else
				return Constantes.mensaje(HttpStatus.CONFLICT, "Error", "La fecha de nacimiento no puede ser una fecha futura");
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error en la operacion");
		}
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE"})
	@PutMapping("/actualiza")
	@ResponseBody
	public ResponseEntity<?> actualizaMascota (@RequestBody Mascota obj){
		try {
			Optional<Mascota> option=mascotaService.buscaMascotaPorId(obj.getIdmascota());
			if(option.isPresent()) {
				Date dia=new Date();
				if(obj.getFechaNacimiento().before(dia))
					return ResponseEntity.ok(mascotaService.mantenerMascota(obj));
				else
					return Constantes.mensaje(HttpStatus.CONFLICT, "Error", "La fecha de nacimiento no puede ser una fecha futura");
			}					
			else{
				return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "La mascota no existe.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error en la operacion");
		}
	}

	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE"})
	@DeleteMapping("/elimina/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminaMascota(@PathVariable("id") int id){
		Optional<Mascota> option=mascotaService.buscaMascotaPorId(id);
		try {
			if(option.isPresent()) {
				mascotaService.eliminaMascota(id);
				return ResponseEntity.ok().build();
			}else {
				return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Eror", "No estar registrada esta mascota");
			}
		} catch (Exception e) {
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Eror", "No estar registrada esta mascota");
		}
	}
	

}
