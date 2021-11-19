package com.veterinaria.servidor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.DetallePedido;
import com.veterinaria.servidor.entity.Pedido;
import com.veterinaria.servidor.entity.Seleccion;
import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.service.PedidoService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091","http://localhost:3000"}, methods = {RequestMethod.GET,RequestMethod.POST})
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_REPARTIDOR"})
	@GetMapping("/detallePedidoById/{codigo}")
	@ResponseBody
	public List<DetallePedido>  detallePedidoById(@PathVariable("codigo") int id) {
		List<DetallePedido> lista=pedidoService.buscaDetallePedidoById(id);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_REPARTIDOR"})
	@GetMapping("/boletaById/{codigo}")
	@ResponseBody
	public List<Seleccion>  boletaById(@PathVariable("codigo") int id) {
		List<Seleccion> lista=pedidoService.buscaBoletaxid(id);
		return lista;
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE", "ROLE_REPARTIDOR"})
	@GetMapping("/pedidoBYID/{id}")
	public Optional<Pedido>  pedidoBYID(@PathVariable("id") int id) {
		Optional<Pedido> pedido=pedidoService.buscaPedidoById(id);
		return pedido;		
	}
	
	@Secured({"ROLE_ADMINISTRADOR", "ROLE_VENDEDOR", "ROLE_CLIENTE"})
	@PostMapping("/procesarCarrito")
	@ResponseBody
	public ResponseEntity<?> procesarCarrito(@RequestBody Seleccion sel,HttpSession session)  {
				
		try {
			List<DetallePedido> detalle = sel.getDetalle();
		    Pedido pedido=new Pedido();
		    Usuario user = new Usuario();
		    System.out.println("Cliente: "+sel.getIdcliente());
		    user.setIdusuario(sel.getIdcliente());
		    pedido.setCliente(user);
		   // pedido.setEstado("PENDIENTE");
		    //pedido.setDetalle(detalle);
		    
		    Pedido objIns=pedidoService.registraPedido(pedido,detalle);
		    //String salida="-1";
		    Map<String, Object> salida = new HashMap<String, Object>();
		    if(objIns!=null) {
		    	salida.put("mensaje", "Registro existoso");
		    }
		    
			return ResponseEntity.ok(objIns);
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Hubo un error en la operacion");
		}
	}
}
