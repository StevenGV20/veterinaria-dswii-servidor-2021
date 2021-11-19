package com.veterinaria.servidor.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Cita;
import com.veterinaria.servidor.service.CitaService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@RequestMapping("/cita")
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091","http://localhost:3000"}, methods = {RequestMethod.GET,RequestMethod.POST})
public class CitaController {
	@Autowired
	private CitaService citaService;
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_VETERINARIO"})
	@GetMapping("/listAll")
	@ResponseBody
	public List<Cita> listAll(){
		List<Cita> lista= citaService.listarCita();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_VETERINARIO"})
	@GetMapping("/buscaCitaById/{codigo}")
	@ResponseBody
	public Optional<Cita> buscaCitaById(@PathVariable("codigo") int cod){
		Optional<Cita> lista= citaService.listarCitaById(cod);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_VETERINARIO"})
	@GetMapping("/listaCitaByCliente/{cliente}")
	@ResponseBody
	public List<Cita> listaCitaByCliente(@PathVariable("cliente") int cod){
		List<Cita> lista= citaService.listarCitaByCliente(cod);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_VETERINARIO"})
	@GetMapping("/listarCitaByVeterinario/{veterinario}")
	@ResponseBody
	public List<Cita> listarCitaByVeterinario(@PathVariable("veterinario") int cod){
		List<Cita> lista= citaService.listarCitaByVeterinari(cod);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@PostMapping("/registra")
	@ResponseBody
	public ResponseEntity<?> registrarCita(@RequestBody Cita obj){
		try {
			//Usuario cliente=(Usuario) session.getAttribute("objUsuario");
			Date dia=new Date();
			//LocalDateTime dt=LocalDateTime.now();
			if(obj.getFechaAtencion().before(dia)) {
				
				return Constantes.mensaje(HttpStatus.CONFLICT, "Error", "Solo puede sacar cita con Fecha de Atencion a partir de mañana");
			}else {
				return ResponseEntity.ok(citaService.mantenerCita(obj));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Error en el proceso");
		}
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR"})
	@PutMapping("/asignaVeterinario")
	public  ResponseEntity<?> asignaTrabajador(@RequestBody Cita bean){
		try {
			bean.setEstado("APROBADO");
			return ResponseEntity.ok(citaService.mantenerCita(bean));
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Error en el proceso"); 
		}
	}
}
