package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.DetalleProveedorRepository;
import proyecto.grupo07.idat.model.DetalleProveedor;





@Service
public class DetalleProveedorService {
	
	@Autowired
	private DetalleProveedorRepository detalleProveedorRepositorio;
	
	public List<DetalleProveedor> listAll(String clave){
		if (clave != null) {
			return detalleProveedorRepositorio.findAll(clave);
		}
		return detalleProveedorRepositorio.findAll();
	}
	
	
	public void save(DetalleProveedor proveedor) {
		detalleProveedorRepositorio.save(proveedor);
	}
	
	public DetalleProveedor get(Long id_detalle_proveedor) {
		return detalleProveedorRepositorio.findById(id_detalle_proveedor).get();
	}
	
	public void delete(Long id_detalle_proveedor) {
		detalleProveedorRepositorio.deleteById(id_detalle_proveedor);
	}
	
	public List<DetalleProveedor> findAll() {
		
		return detalleProveedorRepositorio.findAll();
	}
	
	

}
