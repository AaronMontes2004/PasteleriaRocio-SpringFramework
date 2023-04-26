package proyecto.grupo07.idat.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.grupo07.idat.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
