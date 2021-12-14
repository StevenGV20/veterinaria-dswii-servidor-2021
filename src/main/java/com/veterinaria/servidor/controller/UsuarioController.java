package com.veterinaria.servidor.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.veterinaria.servidor.entity.Opcion;
import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.service.UsuarioService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091","http://localhost:3000","http://localhost:19000","http://localhost:19001","http://localhost:19002"}, methods = {RequestMethod.GET,RequestMethod.POST, 
		RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@ResponseBody
	@PostMapping(path = "/login")
	public Usuario login(@RequestBody Usuario bean){
		return service.login(bean);
	}
	
	/*@ResponseBody
	@PostMapping(path = "/iniciarSesion")
	public Usuario login(@RequestBody Usuario bean,  HttpSession session){
		UserDetails objsalida = (UserDetails) session.getAttribute("objUsuario");
		List<Opcion> lstOpciones = service.traerEnlacesDeUsuario(bean.getIdusuario());
		Usuario objUsusarioLogeado = service.buscaUsuarioPorCorreo(objsalida.getUsername());
		
		session.setAttribute("objUsuario", objUsusarioLogeado);
		session.setAttribute("objMenus", lstOpciones);
		return service.login(bean);
	}
	*/
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR", "ROLE_VETERINARIO"})
	@ResponseBody
	@GetMapping(value = "/traerEnlaces/{id}")
	public List<Opcion> traerEnlaces(@PathVariable("id") Integer id){
		return service.traerEnlacesDeUsuario(id);
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping(value="/listaUsuarios")
	@ResponseBody
	public List<Usuario> listaUsuarios(){
		List<Usuario> lista= service.listaUsuario();
		return lista;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping(value="/listaPersonalTrabajo")
	@ResponseBody
	public List<Usuario> listaPersonalTrabajo(){
		List<Usuario> lista= service.listaPersonalTrabajo();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR", "ROLE_VETERINARIO"})
	@GetMapping(value="/listaUsuarioByRol")
	@ResponseBody
	public List<Usuario> listaUsuarioByRol(int cod){
		List<Usuario> lista= service.listaUsuarioPorRol(cod);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR", "ROLE_VETERINARIO"})
	@GetMapping(value="/buscaUsuarioXID")
	@ResponseBody
	public Optional<Usuario> buscaUsuarioXID(int id){
		Optional<Usuario> usuario= service.buscaUsuarioPorId(id);
		return usuario;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@PostMapping(path="/registrarUsuario")
	public ResponseEntity<?> registraUsuario(@RequestBody Usuario obj) {
		try {
			List<Usuario> verific=service.verificarRegistro(obj);
			if(!verific.isEmpty()) {
				return Constantes
						.mensaje(HttpStatus.BAD_REQUEST, "Error", "Este Usuario ya existe. Revise sus datos por favor");
			}else {
				String passwordBcrypt = passwordEncoder.encode(obj.getPassword());
				obj.setPassword(passwordBcrypt); 
				System.out.println("CLAVE ENCRIPTADA"+obj.getPassword());
				return ResponseEntity.ok(service.registraUsuario(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes
					.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error al realizar la operacion.");
		}
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR", "ROLE_VETERINARIO"})
	@PutMapping(path="/actualizaUsuario")
	public  ResponseEntity<?>  actualizaUsuario(@RequestBody Usuario obj) {
		try {
			/*List<Usuario> verific=service.verificarRegistro(obj);
			if(!verific.isEmpty()) {
				return Constantes
						.mensaje(HttpStatus.BAD_REQUEST, "Error", "Este Usuario ya existe. Revise sus datos por favor");
			}else {*/
				String passwordBcrypt = passwordEncoder.encode(obj.getPassword());
				obj.setPassword(passwordBcrypt);
				return ResponseEntity.ok(service.registraUsuario(obj));
			//}
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes
					.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error al realizar la operacion.");
		}
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@DeleteMapping(path="/eliminaUsuario")
	public ResponseEntity<?> eliminaUsuario(int id) {
		try {
			service.eliminaUsuario(id);
			return Constantes
					.mensaje(HttpStatus.ACCEPTED, "Bien", "Se elimino correctamente al usuario.");
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes
					.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error al realizar la operacion. "
							+ "Asegurese de que el usuario no se relacione con algun registro.");
		}
	}
	
	
}
