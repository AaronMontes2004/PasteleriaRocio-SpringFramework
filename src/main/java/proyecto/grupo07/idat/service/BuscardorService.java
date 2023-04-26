package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.BuscadorRepository;
import proyecto.grupo07.idat.model.Producto;

@Service
public class BuscardorService {
	@Autowired
	private BuscadorRepository data;
	
	public List<Producto> ListarBuscador(String buscar){
		return data.findAll(buscar);
	}
}
