package proyecto.grupo07.idat.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.grupo07.idat.model.ProductoPersonalizado;

public interface ProductoPersonalizadoRepository extends JpaRepository<ProductoPersonalizado, Integer> {
	
}
