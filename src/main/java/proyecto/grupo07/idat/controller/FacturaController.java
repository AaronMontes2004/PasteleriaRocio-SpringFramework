package proyecto.grupo07.idat.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.Empleado;
import proyecto.grupo07.idat.model.Pedido;
import proyecto.grupo07.idat.model.Usuario;
import proyecto.grupo07.idat.service.DetallePedidoService;
import proyecto.grupo07.idat.service.PedidoService;
import proyecto.grupo07.idat.service.RecuperarService;

@Controller
@RequestMapping
public class FacturaController {
	
	@Autowired
	private RecuperarService recuperarService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping("/EmitirFactura/{id}")
	public String prueba(Model model, @PathVariable("id") int id) {
		Usuario usuario = recuperarService.buscarPorId(id);
		List<Pedido> pedidos = pedidoService.ListarPedidos();
		List<Pedido> pedidosDelUsuario = new ArrayList<>();
		List<DetallePedido> detallePedidos = detallePedidoService.listarDetallesPedido();
		List<DetallePedido> detallePedidosDelUsuario = new ArrayList<>();
		List<Integer> idPedidoDelUsuario = new ArrayList<>();
		Pedido UltimoPedido = new Pedido();
		List<DetallePedido> UltimosDetallesDelPedido = new ArrayList<>();
		
		pedidos.stream().filter(x->x.getId_user() == id).forEach(i->pedidosDelUsuario.add(i));
		
		for(Pedido pedido : pedidosDelUsuario) {
			detallePedidos.stream().filter(x -> x.getId_pedido() == pedido.getId_pedido()).forEach(i->detallePedidosDelUsuario.add(i));
		}
		
		pedidosDelUsuario.stream().forEach(x->idPedidoDelUsuario.add(x.getId_pedido()));
		int idultimaCompra = Collections.max(idPedidoDelUsuario);
		
		for (Pedido p : pedidosDelUsuario) {
			if (p.getId_pedido() == idultimaCompra) {
				UltimoPedido.setId_pedido(p.getId_pedido());
				UltimoPedido.setFecha_emision(p.getFecha_emision());
				UltimoPedido.setNum_pedido(p.getNum_pedido());
				UltimoPedido.setSubtotal(p.getSubtotal());
				UltimoPedido.setIgv(p.getIgv());
				UltimoPedido.setTotal(p.getTotal());
				UltimoPedido.setId_user(p.getId_user());
				break;
			}
		}
		
		detallePedidosDelUsuario.stream().filter(x->x.getId_pedido() == idultimaCompra).forEach(i->UltimosDetallesDelPedido.add(i));
		
		for (DetallePedido dt : UltimosDetallesDelPedido) {
			System.out.println(dt.getNombre());
		}
		
		System.out.println("El valor máximo es: "+UltimoPedido.getId_pedido());
		model.addAttribute("usuario", usuario);
		model.addAttribute("pedido", UltimoPedido);
		model.addAttribute("detallepedido", UltimosDetallesDelPedido);
		return "/SeccionAdministrativa/EmitirFactura"; //En el form mismo poner un ruteo con el id 
	}
	
	@GetMapping("/llenar")
	public String volver(Model model) {
		return "redirect:/EmitirFactura";
	}
}
