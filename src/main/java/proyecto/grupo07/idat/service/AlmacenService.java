package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.IAlmacen;
import proyecto.grupo07.idat.model.Almacen;

@Service
public class AlmacenService {
	
	@Autowired
	private IAlmacen productoRepositorio;
	
	public List<Almacen> listAll(String clave ){
		if (clave != null) {
			return productoRepositorio.findAll(clave);
		}
		return productoRepositorio.findAll();
	}
	
	
	public void save(Almacen producto) {
		productoRepositorio.save(producto);
	}
	
	public Almacen get(Long id_almacen) {
		return productoRepositorio.findById(id_almacen).get();
	}
	
	public void delete (Long id_almacen) {
		productoRepositorio.deleteById(id_almacen);
	}
	
	public List<Almacen> findAll() {
		
		return productoRepositorio.findAll();
	}
}
