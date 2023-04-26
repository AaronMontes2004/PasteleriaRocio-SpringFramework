package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.IProveedor;
import proyecto.grupo07.idat.model.Proveedor;

@Service
public class ProveedorService {
	
	@Autowired
	public IProveedor data;
	
	public List<Proveedor> listar(String palabra) {
		if (palabra != null) {
			return data.findAll(palabra);
		}
		return data.findAll();
	}

	public Proveedor listarId(int id) {
		return data.findById(id).orElse(null);
	}

	public void save(Proveedor p) {
		data.save(p);
	}

	public void delete(int id) {
		data.deleteById(id);
	}
	
	public List<Proveedor> findAll() {
		
		return data.findAll();
	}
	

}
