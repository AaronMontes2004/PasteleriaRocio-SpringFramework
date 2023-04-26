package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.DetPedidoRepositorio;
import proyecto.grupo07.idat.model.DetallePedido;

@Service
public class DetPedidoServicio {
	@Autowired
	private DetPedidoRepositorio detPedidoRepositorio;
	
	public List<DetallePedido> listAll(String palabraClave){
		if(palabraClave != null) {
			return detPedidoRepositorio.findAll(palabraClave);
		}
		return detPedidoRepositorio.findAll();
	}
	
	public void save(DetallePedido detallespedido) {
		detPedidoRepositorio.save(detallespedido);
	}
	
	public DetallePedido get(int id) {
		return detPedidoRepositorio.findById(id).get();
	}
	
	public void delete(int id) {
		detPedidoRepositorio.deleteById(id);
	}
	
	public List<DetallePedido> findAll() {
		
		return detPedidoRepositorio.findAll();
	}

}
