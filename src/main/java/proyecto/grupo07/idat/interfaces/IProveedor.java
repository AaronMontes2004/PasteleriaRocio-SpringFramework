package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proyecto.grupo07.idat.model.Proveedor;

public interface IProveedor extends JpaRepository<Proveedor, Integer> {
	
	@Query(value="SELECT * FROM proveedor p WHERE p.Nombre_Proveedor LIKE %?1%"
			/*+" OR p.Telefono_Proveedor LIKE %?1%"
			+" OR p.Direccion_Proveedor LIKE %?1%"
			+" OR p.id_proveedor LIKE %?1%"*/, nativeQuery = true)
	public List<Proveedor> findAll(String palabra);
}
