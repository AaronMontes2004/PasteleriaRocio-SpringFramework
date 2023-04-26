package proyecto.grupo07.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import proyecto.grupo07.idat.model.Producto;
import proyecto.grupo07.idat.service.BuscardorService;

@Controller
public class BuscadorController {
	
	@Autowired
	private BuscardorService servicio;
	
	@GetMapping("/Buscar")
	public String ListadoBuscador(Model model, @Param("buscar") String buscar) {
		List<Producto> productos = servicio.ListarBuscador(buscar);
		if (Integer.valueOf(buscar.length()) < 1) {
			System.out.println("El campo esta vacio");
			return "/BuscadorErroneo";
		}
		
		else if (productos.toArray().length < 1) {
			System.out.println("No hay datos para mostrar");
			model.addAttribute("mensaje", "No hay resultados para '"+buscar+"'");
			return "/BuscadorErroneo";
		}
		
		else {
			model.addAttribute("productosEncontrados", productos);
			return "/BuscadorDeProductos";
		}
	}
}
