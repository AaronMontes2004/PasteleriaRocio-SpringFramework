package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.RecuperarRepository;
import proyecto.grupo07.idat.model.Usuario;

@Service
public class RecuperarService {
	@Autowired
	private RecuperarRepository data;
	
	public String Recuperacion(String correo) {
		String contra = null;
		System.out.println(correo);
		if (data.findAll(correo).size() < 1) {
			return null;
		}
		else {
			List<Usuario> datos=data.findAll(correo);
			contra = datos.get(0).getPassword();
			return contra;
		}
	}
	
	public int recuperarId(String correo) {
		List<Usuario> datos=data.findAll(correo);
		return Integer.parseInt(datos.get(0).getId().toString());
	}
	
	public Usuario buscarPorId(int id) {
		return data.findById(Long.valueOf(id)).orElse(null);
	}
}
