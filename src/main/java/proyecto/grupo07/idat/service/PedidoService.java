package proyecto.grupo07.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo07.idat.interfaces.PedidoRepository;
import proyecto.grupo07.idat.model.Pedido;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> ListarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public void guardarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
}
