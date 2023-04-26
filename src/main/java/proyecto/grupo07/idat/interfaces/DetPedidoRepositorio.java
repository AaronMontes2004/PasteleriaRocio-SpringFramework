package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proyecto.grupo07.idat.model.DetallePedido;

public interface DetPedidoRepositorio extends JpaRepository<DetallePedido, Integer>{

	@Query(value="SELECT * FROM Detalle_Pedido d WHERE"
			+ " CONCAT(d.nombre, d.Fecha)"
			+ " LIKE %?1%", nativeQuery = true)
	public List<DetallePedido> findAll(String palabraClave);
	
}
