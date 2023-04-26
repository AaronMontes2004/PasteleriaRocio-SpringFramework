package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proyecto.grupo07.idat.model.Almacen;

public interface IAlmacen extends JpaRepository<Almacen, Long> {
	@Query(value="SELECT * FROM almacen a WHERE a.insumos LIKE %?1%", nativeQuery = true)
	public List<Almacen> findAll(String clave);
}
