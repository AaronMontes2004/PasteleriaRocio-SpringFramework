package proyecto.grupo07.idat.interfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import proyecto.grupo07.idat.model.Empleado;


public interface EmpleadoRepository extends PagingAndSortingRepository<Empleado, Long>{

}
