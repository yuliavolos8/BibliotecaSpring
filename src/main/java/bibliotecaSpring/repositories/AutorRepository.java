package bibliotecaSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
	
	
/*	public Autor findByNombre(Autor autor);

	public Autor findByNombreDeAutor(String nombre); */

}
