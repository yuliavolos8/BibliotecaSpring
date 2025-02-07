package bibliotecaSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bibliotecaSpring.dtos.LibroDTO;

public interface LibroRespository  extends CrudRepository<Libro, Long>{

public	Libro update(LibroDTO actualizadoEntero);

}
