package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.DetallePedidoRepository;
import proyecto.grupo07.idat.interfaces.IProducto;
import proyecto.grupo07.idat.model.Almacen;
import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.Producto;

@Service
public class DetallePedidoService {
	@Autowired
	private DetallePedidoRepository detallepedidoRepository;
	
	@Autowired
	private IProducto productoRepository;
	
	public void guardarDetallePedido (DetallePedido detallepedido) {
		detallepedidoRepository.save(detallepedido);
	}
	
	public Producto buscarId(int id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	
	public Producto get(Integer id_detalle_pedido) {
		return productoRepository.findById(id_detalle_pedido).get();
	}
	
	
	
	public List<DetallePedido> listarDetallesPedido(){
		return detallepedidoRepository.findAll();
	}
}
