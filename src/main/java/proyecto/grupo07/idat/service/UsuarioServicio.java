package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import proyecto.grupo07.idat.controlador.dto.UsuarioRegistroDTO;
import proyecto.grupo07.idat.model.Usuario;



public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios(String palabra);
	
	public void EliminarUsuario(int id);
}
