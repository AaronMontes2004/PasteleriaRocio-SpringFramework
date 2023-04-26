package proyecto.grupo07.idat.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.grupo07.idat.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
	
}
