package proyecto.grupo07.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Pedido")
public class PedidoVentaController {

	@GetMapping("/consultapedidosventa")
	public String PedidoVenta() {
		return "/SeccionAdministrativa/consultapedidosventa";
	}
}
