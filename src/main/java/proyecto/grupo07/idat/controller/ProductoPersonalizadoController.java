package proyecto.grupo07.idat.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.Pedido;
import proyecto.grupo07.idat.model.ProductoPersonalizado;
import proyecto.grupo07.idat.service.DetallePedidoService;
import proyecto.grupo07.idat.service.PedidoService;
import proyecto.grupo07.idat.service.ProductoPersonalizadoService;
import proyecto.grupo07.idat.service.ProductoService;
import proyecto.grupo07.idat.service.RecuperarService;

@Controller
public class ProductoPersonalizadoController {
	@Autowired
	private ProductoPersonalizadoService servicePP;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private RecuperarService recuperarService;
	
	@PostMapping("/GuardarPersonalizado")
	public String GuardarPersonalizado(@Valid ProductoPersonalizado productoPersonalizado,Model model){
		List<Pedido> pedidos = pedidoService.ListarPedidos();
		List<Integer> numeros = new ArrayList<Integer>();
		pedidos.stream().forEach(o->numeros.add(o.getNum_pedido()));
		int numero = 0;
		if (pedidos.isEmpty()) {
			numero = 1;
		}
		else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}
		Date date = new Date();
		productoPersonalizado.setFecha(date);
		Pedido pedido = new Pedido();
		pedido.setFecha_emision(date);
		pedido.setNum_pedido(numero);
		pedido.setSubtotal(productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad());
		pedido.setIgv((productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad())*0.18);
		pedido.setTotal((productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad())+((productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad())*0.18));
		pedidoService.guardarPedido(pedido);
		DetallePedido detallePedido = new DetallePedido();
		detallePedido.setNombre(productoPersonalizado.getNombre());
		detallePedido.setCantidad(productoPersonalizado.getCantidad());
		detallePedido.setImagen(productoPersonalizado.getImagen());
		detallePedido.setPrecio(productoPersonalizado.getPrecio());
		detallePedido.setFecha_emision(date);
		detallePedido.setTotal(productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad());
		detallePedido.setId_producto(productoService.BuscarPorNombre(productoPersonalizado.getNombre()));
		detallePedido.setId_pedido(numero);
		detallePedidoService.guardarDetallePedido(detallePedido);
		servicePP.GuardarProductoPersonalizado(productoPersonalizado);
		return "redirect:/Pagos";
	}
	
	@PostMapping("/GuardarPersonalizadoU")
	public String GuardarPersonalizadoU(@Valid ProductoPersonalizado productoPersonalizado,Model model, @Param("user") String user){
		List<Pedido> pedidos = pedidoService.ListarPedidos();
		List<Integer> numeros = new ArrayList<Integer>();
		pedidos.stream().forEach(o->numeros.add(o.getNum_pedido()));
		int numero = 0;
		if (pedidos.isEmpty()) {
			numero = 1;
		}
		else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}
		Date date = new Date();
		productoPersonalizado.setFecha(date);
		Pedido pedido = new Pedido();
		pedido.setFecha_emision(date);
		pedido.setNum_pedido(numero);
		pedido.setSubtotal(productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad());
		pedido.setIgv((productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad())*0.18);
		pedido.setTotal((productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad())+((productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad())*0.18));
		pedido.setId_user(recuperarService.recuperarId(user));
		pedidoService.guardarPedido(pedido);
		DetallePedido detallePedido = new DetallePedido();
		detallePedido.setNombre(productoPersonalizado.getNombre());
		detallePedido.setCantidad(productoPersonalizado.getCantidad());
		detallePedido.setImagen(productoPersonalizado.getImagen());
		detallePedido.setPrecio(productoPersonalizado.getPrecio());
		detallePedido.setFecha_emision(date);
		detallePedido.setTotal(productoPersonalizado.getPrecio() * productoPersonalizado.getCantidad());
		detallePedido.setId_producto(productoService.BuscarPorNombre(productoPersonalizado.getNombre()));
		detallePedido.setId_pedido(numero);
		detallePedidoService.guardarDetallePedido(detallePedido);
		servicePP.GuardarProductoPersonalizado(productoPersonalizado);
		return "redirect:/Pagos";
	}
}
