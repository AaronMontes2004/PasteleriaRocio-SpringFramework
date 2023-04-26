package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto.grupo07.idat.model.Producto;

public interface IProducto extends JpaRepository<Producto,Integer>{
	@Query(value="SELECT * FROM producto p WHERE p.Nombre_Producto LIKE %?1%"
			/*+" OR p.Precio_Producto LIKE %?1%"
			+" OR p.Fecha_Vencimiento LIKE %?1%"
			+" OR p.Descripcion LIKE %?1%"
			+" OR p.Stock LIKE %?1%"
			+" OR p.Precio_IGV LIKE %?1%"*/, nativeQuery = true)
	public List<Producto> findAll(String palabra);
	
	@Query(value="SELECT * FROM producto p WHERE p.Nombre_Producto = :nombre",nativeQuery = true)
	public List<Producto> BuscarIdPorNombre(@Param("nombre") String nombre);
}
