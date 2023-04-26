package proyecto.grupo07.idat.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.Pedido;
import proyecto.grupo07.idat.service.DetallePedidoService;
import proyecto.grupo07.idat.service.PedidoService;
import proyecto.grupo07.idat.service.RecuperarService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private DetallePedidoService detallepedidoService;
	@Autowired
	private RecuperarService recuperarService;
	
	@GetMapping("/ir/{lista}/{lista2}/{user}")
	public String ir(Model model, @PathVariable String lista, @PathVariable String lista2, @PathVariable String user) {
		
		List<Pedido> pedidos = pedidoService.ListarPedidos();
		List<Integer> numeros = new ArrayList<Integer>();
		ArrayList<DetallePedido> detallePedido = new ArrayList<DetallePedido>();
		pedidos.stream().forEach(o->numeros.add(o.getNum_pedido()));
		int numero = 0;
		if (pedidos.isEmpty()) {
			numero = 1;
		}
		else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}
		
		String[] prod = lista.replaceAll("\\[]", "").replaceAll("", "").split(","); //Un contador que == 1 == 2 y que cuando llege a 6 
		String[] costos = lista2.replaceAll("\\[]", "").replaceAll("", "").split(",");
		
		String u = user;
		int idUser = 0;
		
		if(u.length() < 2) {
			System.out.println("USER NO PASÓ");
		} else {
			idUser = recuperarService.recuperarId(u);
			System.out.println("USER SI PASÓ"+idUser);
		}
		
		//PEDIDO
		Date fecha = new Date();
		Pedido pedido = new Pedido();
		pedido.setFecha_emision(fecha);
		pedido.setNum_pedido(numero);
		pedido.setSubtotal(Double.valueOf(costos[0]));
		pedido.setIgv(Double.valueOf(costos[1]));
		pedido.setTotal(Double.valueOf(costos[2]));
		pedido.setId_user(idUser);
		
		pedidoService.guardarPedido(pedido);
		
		DetallePedido dt = new DetallePedido();
		int verificador = 0;
		int LongProd = prod.length;
		for (int i = 0; i < LongProd; i++) {
			if (verificador == 0) {
				dt.setNombre(prod[i]);
				verificador=1;
			} else if (verificador == 1) {
				dt.setCantidad(Integer.valueOf(prod[i]));
				verificador=2;
			} else if (verificador == 2) {
				dt.setPrecio(Double.valueOf(prod[i]));
				verificador =3;
			} else if (verificador == 3) {
				dt.setId_producto(Integer.valueOf(prod[i]));
				detallePedido.add(new DetallePedido(1,dt.getNombre(), Integer.valueOf(dt.getCantidad()),"", Double.valueOf(dt.getPrecio()),fecha,12.20,dt.getEstado() ,Integer.valueOf(dt.getId_producto()), 1));
				verificador = 0;
			}
		}
		
		List<DetallePedido> detalleLista = new ArrayList<DetallePedido>();
		DetallePedido detalle = new DetallePedido();
		int contadorDT = detallePedido.size();
		
		for(int n = 0; n < contadorDT;n++) {
			detalle.setNombre(detallePedido.get(n).getNombre());
			detalle.setCantidad(Integer.valueOf(detallePedido.get(n).getCantidad()));
			String imagen = detallepedidoService.buscarId(Integer.valueOf(detallePedido.get(n).getId_producto())).getImagenProducto();
			detalle.setImagen(imagen);
			detalle.setPrecio(detallePedido.get(n).getPrecio());
			detalle.setFecha_emision(fecha);
			detalle.setTotal(detallePedido.get(n).getPrecio() * detallePedido.get(n).getCantidad());
			detalle.setId_producto(detallePedido.get(n).getId_producto());
			detalle.setId_pedido(numero);
			detalleLista.add(new DetallePedido(0,detalle.getNombre(), detalle.getCantidad(), detalle.getImagen(), 
					detalle.getPrecio(), detalle.getFecha_emision(), detalle.getTotal(),detalle.getEstado(), detalle.getId_producto(),
					detalle.getId_pedido()));
		}
		
		for(DetallePedido x : detalleLista) {
			//System.out.println(x.getNombre());
			detallepedidoService.guardarDetallePedido(x);
		}
		
		System.out.println(detalleLista.size());
		System.out.println(user);
		
		return "redirect:/Pagos";
	}
	
	
	@GetMapping("/irR/{lista}/{lista2}/{user}")
	public String irR(Model model, @PathVariable String lista, @PathVariable String lista2, @PathVariable String user) {
		
		List<Pedido> pedidos = pedidoService.ListarPedidos();
		List<Integer> numeros = new ArrayList<Integer>();
		ArrayList<DetallePedido> detallePedido = new ArrayList<DetallePedido>();
		pedidos.stream().forEach(o->numeros.add(o.getNum_pedido()));
		int numero = 0;
		if (pedidos.isEmpty()) {
			numero = 1;
		}
		else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}
		
		String[] prod = lista.replaceAll("\\[]", "").replaceAll("", "").split(","); //Un contador que == 1 == 2 y que cuando llege a 6 
		String[] costos = lista2.replaceAll("\\[]", "").replaceAll("", "").split(",");
		
		String u = user;
		int idUser = 0;
		
		if(u.length() < 2) {
			System.out.println("USER NO PASÓ");
		} else {
			idUser = recuperarService.recuperarId(u);
			System.out.println("USER SI PASÓ"+idUser);
		}
		
		//PEDIDO
		Date fecha = new Date();
		Pedido pedido = new Pedido();
		pedido.setFecha_emision(fecha);
		pedido.setNum_pedido(numero);
		pedido.setSubtotal(Double.valueOf(costos[0]));
		pedido.setIgv(Double.valueOf(costos[1]));
		pedido.setTotal(Double.valueOf(costos[2]));
		pedido.setId_user(idUser);
		
		pedidoService.guardarPedido(pedido);
		
		DetallePedido dt = new DetallePedido();
		int verificador = 0;
		int LongProd = prod.length;
		for (int i = 0; i < LongProd; i++) {
			if (verificador == 0) {
				dt.setNombre(prod[i]);
				verificador=1;
			} else if (verificador == 1) {
				dt.setCantidad(Integer.valueOf(prod[i]));
				verificador=2;
			} else if (verificador == 2) {
				dt.setPrecio(Double.valueOf(prod[i]));
				verificador =3;
			} else if (verificador == 3) {
				dt.setId_producto(Integer.valueOf(prod[i]));
				detallePedido.add(new DetallePedido(1,dt.getNombre(), Integer.valueOf(dt.getCantidad()),"", Double.valueOf(dt.getPrecio()),fecha,12.20,dt.getEstado(),Integer.valueOf(dt.getId_producto()), 1));
				verificador = 0;
			}
		}
		
		List<DetallePedido> detalleLista = new ArrayList<DetallePedido>();
		DetallePedido detalle = new DetallePedido();
		int contadorDT = detallePedido.size();
		
		for(int n = 0; n < contadorDT;n++) {
			detalle.setNombre(detallePedido.get(n).getNombre());
			detalle.setCantidad(Integer.valueOf(detallePedido.get(n).getCantidad()));
			String imagen = detallepedidoService.buscarId(Integer.valueOf(detallePedido.get(n).getId_producto())).getImagenProducto();
			detalle.setImagen(imagen);
			detalle.setPrecio(detallePedido.get(n).getPrecio());
			detalle.setFecha_emision(fecha);
			detalle.setTotal(detallePedido.get(n).getPrecio() * detallePedido.get(n).getCantidad());
			detalle.setId_producto(detallePedido.get(n).getId_producto());
			detalle.setId_pedido(numero);
			detalleLista.add(new DetallePedido(0,detalle.getNombre(), detalle.getCantidad(), detalle.getImagen(), 
					detalle.getPrecio(), detalle.getFecha_emision(), detalle.getTotal(),detalle.getEstado() ,detalle.getId_producto(),
					detalle.getId_pedido()));
		}
		
		for(DetallePedido x : detalleLista) {
			detallepedidoService.guardarDetallePedido(x);
		}
		
		System.out.println(detalleLista.size());
		System.out.println(user);
		
		return "redirect:/Pagos";
	}
}
