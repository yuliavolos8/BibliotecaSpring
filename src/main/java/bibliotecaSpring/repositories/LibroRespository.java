package bibliotecaSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibroRespository  extends CrudRepository<Libro, Long>{

}
