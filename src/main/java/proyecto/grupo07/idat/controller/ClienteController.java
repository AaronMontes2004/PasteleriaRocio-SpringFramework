package proyecto.grupo07.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.grupo07.idat.model.Usuario;
import proyecto.grupo07.idat.service.UsuarioServicio;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/ConsultaDeClientes")
	public String ConsultaDeClientes(Model model, @Param("palabra") String palabra){
		List<Usuario> listado = usuarioServicio.listarUsuarios(palabra);
		model.addAttribute("clientes", listado);
		model.addAttribute("palabra", palabra);
		return "/SeccionAdministrativa/ConsultaDeClientes";
	}
	
	@GetMapping("/EliminarCliente/{id}")
	public String EliminarCliente(Model model, @PathVariable int id){
		usuarioServicio.EliminarUsuario(id);
		return "redirect:/Cliente/ConsultaDeClientes";
	}
}
