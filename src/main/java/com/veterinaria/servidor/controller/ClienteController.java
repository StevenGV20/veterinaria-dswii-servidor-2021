package com.veterinaria.servidor.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.service.ClienteService;
import com.veterinaria.servidor.service.UsuarioService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091"}, methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	

	@ResponseBody
	@GetMapping(path = "/lista")
	public List<Usuario> lista(){
		//URI uri
		return clienteService.listaCliente();
	}
	
	@ResponseBody
	@GetMapping(path = "/listaResponse")
	public List<EntityModel<Usuario>> listaResponse(){
							
		List<EntityModel<Usuario>> clientes= clienteService.listaCliente().stream()
				.map(cliente -> EntityModel.of(cliente,
						linkTo(methodOn(ClienteController.class)
								.buscaUsuarioXID(cliente.getIdusuario())).withSelfRel())).collect(Collectors.toList());
		
		return clientes;
		
	}
	
	@GetMapping("/{id}")
	public EntityModel<Usuario> buscaUsuarioXID(@PathVariable int id) {
	  Usuario usuario = usuarioService.buscaUsuarioPorId(id).orElseThrow();
	  return EntityModel.of(usuario,//
				linkTo(methodOn(ClienteController.class).buscaUsuarioXID(usuario.getIdusuario())).withSelfRel());
	}
	
	@PostMapping(path = "/registra")
	public ResponseEntity<?> registra(@RequestBody Usuario bean) {
		//clienteService.registrarCiente(bean);
		try {
			List<Usuario> verific=usuarioService.verificarRegistro(bean);
			if(!verific.isEmpty()) {
				return Constantes
						.mensaje(HttpStatus.BAD_REQUEST, "Error", "Este Usuario ya existe. Revise sus datos por favor");
			}else {
				Usuario nuevo= clienteService.registrarCiente(bean); 
				return ResponseEntity.ok(nuevo);			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes
					.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error al realizar la operacion.");
		}
	}
	
	
	@PutMapping(path = "/actualiza")
	public ResponseEntity<?>  actualiza(@RequestBody Usuario bean) {
		try {
			List<Usuario> verific=usuarioService.verificarRegistro(bean);
			if(!verific.isEmpty()) {
				return Constantes
						.mensaje(HttpStatus.BAD_REQUEST, "Error", "Este Usuario ya existe. Revise sus datos por favor");
			}else {
				Usuario nuevo= clienteService.registrarCiente(bean); 
				return ResponseEntity.ok(nuevo);			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes
					.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error al realizar la operacion.");
		}
	}
	
	@DeleteMapping(path = "/elimina/{id}")
	public void eliminaCliente(@PathVariable(name = "id") int id) {
		usuarioService.eliminaUsuario(id);
	}
	
	
	
	
}
