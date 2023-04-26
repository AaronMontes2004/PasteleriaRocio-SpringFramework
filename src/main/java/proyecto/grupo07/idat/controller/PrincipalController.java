package proyecto.grupo07.idat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.Pedido;
import proyecto.grupo07.idat.service.DetallePedidoService;
import proyecto.grupo07.idat.service.PedidoService;
import proyecto.grupo07.idat.service.RecuperarService;



@Controller
@RequestMapping
public class PrincipalController {
	
	@Autowired
	private RecuperarService recuperarService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallepedidoService;
	
	@GetMapping({"","/","/MenuPrincipal"})
	public String MenuPrincipal() {
		return "/Menu";
	}

	/*INFORMACIÓN*/
	@GetMapping("/contactos")
	public String Contactos() {
		return "contactos";
	}
	
	@GetMapping("/galeria")
	public String Galeria() {
		return "galeria";
	}
	
	@GetMapping("/nosotros")
	public String Nosotros() {
		return "nosotros";
	}
	
	
	@GetMapping("/pedidos")
	public String pedidos (Model model) {
		return "pedidos";
	}
	
	@GetMapping("/politicasdeprivacidad")
	public String PoliticayPrivacidad() {
		return "politicasdeprivacidad";
	}
	
	@GetMapping("/carritodecompras")
	public String carritodecompras() {
		return "carritodecompras";
	}
	
	@GetMapping("/finalizarcompra")
	public String finalizarcompra() {
		return "finalizarcompra";
	}
	
	@GetMapping("/Menu")
	public String Menu() {
		return "/Menu";
	}
	
	
	@GetMapping("/terminosycondiciones")
	public String terminosycondiciones (Model model) {
		return "terminosycondiciones";
		
	}
	
	@GetMapping("/ubicacion")
	public String ubicacion (Model model) {
		return "ubicacion";
		
	}
	
	@GetMapping("/contactosR")
	public String contactosr (Model model) {
		return "contactosR";
		
	}
	
	@GetMapping("/galeriaR")
	public String galeriaR (Model model) {
		return "galeriaR";
		
	}
	
	@GetMapping("/nosotrosR")
	public String nosotrosR (Model model) {
		return "nosotrosR";
		
	}
	
	
	@GetMapping("/carritodecomprasR")
	public String carritodecomprasR (Model model) {
		return "carritodecomprasR";
		
	}
	
	private String usuario;
	
	@GetMapping("/pedidosR")
	public String pedidosR (Model model) {
		if (usuario == null) {
			System.out.println("NO HAY USUARIO REGISTRADO");
			model.addAttribute("listado", null);
			return "pedidosR";
		}
		else {
			int idUser = recuperarService.recuperarId(usuario);
			//usuario = null;
			List<Integer> listadoIdPedido = new ArrayList<Integer>();
			List<Pedido> listadoPed =pedidoService.ListarPedidos();
			List<DetallePedido> listadoDetalle = detallepedidoService.listarDetallesPedido();
			List<DetallePedido> listadetalle = new ArrayList<DetallePedido>();
			listadoPed.stream().filter(x->x.getId_user() == idUser).forEach(x -> listadoIdPedido.add(x.getId_pedido()));
			for(int id : listadoIdPedido) {
				listadoDetalle.stream().filter(x -> x.getId_pedido() == id).forEach(i -> listadetalle.add(i));
			}
	
			model.addAttribute("listado", listadetalle);
			return "pedidosR";
		}
	}
	
	@GetMapping("/pedidosR/{user}")
	public String pedidosUsuario (Model model, @PathVariable("user") String user) {
		usuario = user;
		return "redirect:/pedidosR";
	}
	
	@GetMapping("/finalizarcompraR")
	public String finalizarcompraR (Model model) {
		return "finalizarcompraR";
		
	}
	
	@GetMapping("/terminosycondicionesR")
	public String terminosycondicionesR (Model model) {
		return "terminosycondicionesR";
		
	}
	
	@GetMapping("/politicasdeprivacidadR")
	public String politicasdeprivacidadR (Model model) {
		return "politicasdeprivacidadR";
		
	}
	
	@GetMapping("/ubicacionR")
	public String ubicacionR (Model model) {
		return "ubicacionR";
		
	}
	
	@GetMapping("/index")
	public String indexR (Model model) {
		return "index";
		
	}
	
	@GetMapping("/indexd")
	public String indexDashboard (Model model) {
		return "/SeccionAdministrativa/indexd";
		
	}
	
	@GetMapping("/indexdcompra")
	public String indexDashboardC (Model model) {
		return "/SeccionAdministrativa/indexdcompra";
		
	}
	


	
	
	
	
}
