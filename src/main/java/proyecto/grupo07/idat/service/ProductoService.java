package proyecto.grupo07.idat.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.IProducto;
import proyecto.grupo07.idat.model.Producto;

@Service
public class ProductoService {

	@Autowired 
	private IProducto data;
	
	public List<Producto> listar(String palabra) {
		if (palabra != null) {
			return data.findAll(palabra);
		}
		return data.findAll();
	}

	public Producto listarId(int id) {
		return data.findById(id).orElse(null);
	}

	public void save(Producto p) {
		data.save(p);
	}
	
	public void delete(int id) {
		data.deleteById(id);
	}
	
	public int BuscarPorNombre(String nombre) {
		return data.BuscarIdPorNombre(nombre).get(0).getIdProducto();
	}
}
