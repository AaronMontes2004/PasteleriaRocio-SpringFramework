package proyecto.grupo07.idat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import proyecto.grupo07.idat.controlador.dto.MailRequest;
import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.Pedido;
import proyecto.grupo07.idat.model.Usuario;
import proyecto.grupo07.idat.service.DetallePedidoService;
import proyecto.grupo07.idat.service.EmailServiceFactura;
import proyecto.grupo07.idat.service.PedidoService;
import proyecto.grupo07.idat.service.RecuperarService;

@SpringBootApplication
@RestController
public class Proyecto2022Grupo07Application {

	@Autowired
	private EmailServiceFactura emailService;
	
	@Autowired
	private RecuperarService recuperarService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping("/sendingEmail/{id}")
	public ModelAndView sendEmail(@PathVariable("id") int id, RedirectAttributes attribute) {
		System.out.println(id);
		MailRequest request =new MailRequest();
		request.setName("Pasteleria Rocio");
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Lima, Perú");
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
		
		request.setTo(usuario.getEmail());
		request.setSubject("Factura de compra numero "+UltimoPedido.getNum_pedido());
		
		model.put("fecha", UltimoPedido.getFecha_emision());
		model.put("lista", UltimosDetallesDelPedido);
		model.put("pedido", UltimoPedido);
		model.put("nombre", usuario.getNombre() + " " + usuario.getApellido());
		
		attribute.addFlashAttribute("mensajeFactura", "La factura se envió con éxito");
		
		return emailService.sendEmail(request, model);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Proyecto2022Grupo07Application.class, args);
	}

}
