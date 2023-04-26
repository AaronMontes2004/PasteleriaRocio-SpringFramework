package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyecto.grupo07.idat.model.Usuario;

public interface RecuperarRepository extends JpaRepository<Usuario, Long>{
	@Query(value="SELECT * FROM usuarios u WHERE u.email = :correo",nativeQuery = true)
	public List<Usuario> findAll(@Param("correo") String correo);
}