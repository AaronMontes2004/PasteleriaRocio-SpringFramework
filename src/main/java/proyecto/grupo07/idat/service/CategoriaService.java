package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.CategoriaRepository;
import proyecto.grupo07.idat.model.Categoria;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository data;
	
	public List<Categoria> listarCategorias() {
		return data.findAll();
	}
}
