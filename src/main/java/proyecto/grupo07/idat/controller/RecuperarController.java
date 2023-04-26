package proyecto.grupo07.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import proyecto.grupo07.idat.service.EmailService;
import proyecto.grupo07.idat.service.RecuperarService;

@Controller
public class RecuperarController {
	
	@Autowired
	private RecuperarService service;
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/RecuperacionDeContrasena")
	public String IndiceRecuperar(Model model) {
		return "/RecuperarContrasena";
	}
	
	@GetMapping("/Recuperar")
	public String recuperarContra(Model model, @Param("correo") String correo) {
		String contra = service.Recuperacion(correo);
		if (contra == null) {
			return "redirect:/RecuperacionDeContrasena";
		}
		else {
			emailService.sendEmail(correo, "Recuperación de cuenta", "Su contraseña es: "+contra);
			return "redirect:/login";
		}
	}
}
