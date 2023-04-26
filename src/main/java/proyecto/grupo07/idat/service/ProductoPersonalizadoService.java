package proyecto.grupo07.idat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.ProductoPersonalizadoRepository;
import proyecto.grupo07.idat.model.ProductoPersonalizado;

@Service
public class ProductoPersonalizadoService {
	
	@Autowired
	private ProductoPersonalizadoRepository productoPersonalizadoRepository;
	
	public void GuardarProductoPersonalizado(ProductoPersonalizado producto) {
		productoPersonalizadoRepository.save(producto);
	}
}
