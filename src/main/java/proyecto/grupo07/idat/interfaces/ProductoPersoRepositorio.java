package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proyecto.grupo07.idat.model.ProductoPerso;


public interface ProductoPersoRepositorio extends JpaRepository<ProductoPerso, Long>{
	@Query(value = "SELECT * FROM Producto_Personalizado p WHERE "
			+ "p.nombre LIKE %?1%", nativeQuery = true)
	public List<ProductoPerso> findAll(String palabraClave);
}
