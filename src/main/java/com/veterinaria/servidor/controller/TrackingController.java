package com.veterinaria.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.DetallePedidoUsuario;
import com.veterinaria.servidor.entity.Tracking;
import com.veterinaria.servidor.service.TrackingService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@RequestMapping("/tracking")
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091"}, methods = {RequestMethod.GET,RequestMethod.POST})
public class TrackingController {

	@Autowired
	private TrackingService trackingService;
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR"})
	@GetMapping("/listaByCliente/{cliente}")
	@ResponseBody
	public List<Tracking> listaTrackingByCliente(@PathVariable("cliente") int id){
		List<Tracking> lista= trackingService.listaTrackingByCliente(id);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_REPARTIDOR"})
	@GetMapping("/listaByTrabajador/{codigo}")
	@ResponseBody
	public List<Tracking> listaTrackingByTrabajador(@PathVariable("codigo") int id){
		List<Tracking> lista= trackingService.listaTrackingByTrabajador(id);
		return lista;
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@GetMapping("/listaAll")
	@ResponseBody
	public List<Tracking> listaAllTracking(){
		List<Tracking> lista= trackingService.listaAllTracking();
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR"})
	@GetMapping("/buscaByPedido/{codigo}")
	@ResponseBody
	public Optional<Tracking> buscaTrackinByPedido(@PathVariable("codigo") int cod){
		Optional<Tracking> track=trackingService.buscaTrackinByPedido(cod);
		return track;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_CLIENTE", "ROLE_VENDEDOR", "ROLE_REPARTIDOR"})
	@GetMapping("/buscarHistorialPedido/{codigo}")
	@ResponseBody
	public List<DetallePedidoUsuario> buscarHistorialPedido(@PathVariable("codigo") int cod){
		List<DetallePedidoUsuario> historial=trackingService.buscarHistorialPedido(cod);
		return historial;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR"})
	@PutMapping("/asignaTrabajador")
	public ResponseEntity<?> asignaTrabajador(@RequestBody Tracking bean){
		//Optional<Track> option=service.buscaUsuarioPorId(id);
		try {
			trackingService.asignaTrabajador(bean,bean.getTrabajador());
			return Constantes.mensaje(HttpStatus.ACCEPTED, "Excelente", "Se registro correctamente al trabajador");
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", Constantes.MENSAJE_ERROR);
		}
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_REPARTIDOR"})
	@RequestMapping("/registraEntrega")
	public ResponseEntity<?> registraEntrega(@RequestBody Tracking bean){
		try {
			trackingService.registrarEntrega(bean);
			return Constantes.mensaje(HttpStatus.ACCEPTED, "Excelente", "Se registro correctamente la entrega de la venta");
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", Constantes.MENSAJE_ERROR);
		}
	}
	
	
}
