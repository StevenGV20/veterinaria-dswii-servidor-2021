package com.veterinaria.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.service.ClienteService;
import com.veterinaria.servidor.service.UsuarioService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	

	@ResponseBody
	@GetMapping(path = "/lista")
	public List<Usuario> lista(){
		return clienteService.listaCliente();
	}
	
	@PostMapping(path = "/registra")
	public void registra(@RequestBody Usuario bean) {
		clienteService.registrarCiente(bean);
		/*List<Usuario> verific=usuarioService.verificarRegistro(bean);
		if(!verific.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
					.body(Problem.create()
							.withTitle("Error")
							.withDetail("Este Usuario ya existe. Revise sus datos por favor"));
		}else {
			Usuario nuevo= clienteService.registrarCiente(bean);
			return ResponseEntity.ok(nuevo);
			
		}*/
	}
	
	
	@PutMapping(path = "/actualiza")
	public void actualiza(@RequestBody Usuario bean) {
		clienteService.registrarCiente(bean);
		/*List<Usuario> verific=usuarioService.verificarRegistro(bean);
		if(!verific.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
					.body(Problem.create()
							.withTitle("Error")
							.withDetail("Este Usuario ya existe. Revise sus datos por favor"));
		}else {
			Usuario nuevo= clienteService.registrarCiente(bean);
			return ResponseEntity.ok(nuevo);
			
		}*/
	}
	
	@DeleteMapping(path = "/elimina/{id}")
	public void eliminaCliente(@PathVariable(name = "id") int id) {
		usuarioService.eliminaUsuario(id);
	}
	
	
	
	
}
