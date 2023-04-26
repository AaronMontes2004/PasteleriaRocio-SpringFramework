package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.ProductoPersoRepositorio;
import proyecto.grupo07.idat.model.ProductoPerso;



@Service
public class ProductoPersoServicio {
	@Autowired
	private ProductoPersoRepositorio productoPersoRepositorio;
	
	public List<ProductoPerso> listAll(String palabraClave){
		if(palabraClave != null) {
			return productoPersoRepositorio.findAll(palabraClave);
		}
		return productoPersoRepositorio.findAll();
	}
	public void save(ProductoPerso productoPerso) {
		productoPersoRepositorio.save(productoPerso);
	}
	
	public ProductoPerso get(Long id) {
		return productoPersoRepositorio.findById(id).get();
	}
	public void delete(Long id) {
		productoPersoRepositorio.deleteById(id);
	}
	
  public List<ProductoPerso> findAll() {
		
		return productoPersoRepositorio.findAll();
	}
}
