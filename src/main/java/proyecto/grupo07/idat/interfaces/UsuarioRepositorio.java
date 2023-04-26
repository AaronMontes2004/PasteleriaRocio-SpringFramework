package proyecto.grupo07.idat.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import proyecto.grupo07.idat.model.Usuario;



@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
	@Query(value = "SELECT * FROM usuarios u WHERE u.nombre LIKE %?1%", nativeQuery = true)
	public List<Usuario> findAll(String palabra);
}
