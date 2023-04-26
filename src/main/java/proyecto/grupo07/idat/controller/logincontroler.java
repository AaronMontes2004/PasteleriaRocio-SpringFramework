package proyecto.grupo07.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class logincontroler {
	
	@GetMapping("/login")
	public String login (Model model) {
		return "login";
		
	}
	
	@GetMapping("/loginadmin")
	public String loginadmin (Model model) {
		return "loginadmin";
		
	}
	
	
	
}
