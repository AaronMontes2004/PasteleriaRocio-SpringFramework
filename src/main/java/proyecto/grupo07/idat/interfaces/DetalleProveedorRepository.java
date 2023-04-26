package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proyecto.grupo07.idat.model.DetalleProveedor;




public interface DetalleProveedorRepository extends JpaRepository<DetalleProveedor, Long> {
	
	@Query(value="SELECT * FROM detalle_proveedor a WHERE a.fecha_compra_insumos LIKE %?1%"
			+" OR a.nombre_insumos LIKE %?1%"
			, nativeQuery = true)
	public List<DetalleProveedor> findAll(String clave);

}
