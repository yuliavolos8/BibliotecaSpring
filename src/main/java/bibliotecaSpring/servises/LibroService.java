package bibliotecaSpring.servises;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bibliotecaSpring.dtos.LibroDTO;
import bibliotecaSpring.repositories.Autor;
import bibliotecaSpring.repositories.AutorRepository;
import bibliotecaSpring.repositories.Libro;
import bibliotecaSpring.repositories.LibroRespository;

@Service
public class LibroService {

	@Autowired
	private LibroRespository repoLibro;

	@Autowired
	private AutorRepository repoAutor;

	public ArrayList<LibroDTO> listalibros() {
		ArrayList<LibroDTO> libros = new ArrayList<>();

		Autor autor1 = new Autor("ramon Blanco", LocalDate.of(1985, 9, 11));
		LibroDTO lib1 = new LibroDTO(1234567, LocalDate.now(), autor1, "Java");

		Autor autor2 = new Autor("maria casado", LocalDate.of(2000, 1, 1));
		LibroDTO lib2 = new LibroDTO(167800, LocalDate.now(), autor2, "C++");

		Autor autor3 = new Autor("Rebeca casado", LocalDate.of(1967, 1, 1));
		LibroDTO lib3 = new LibroDTO(167806, LocalDate.now(), autor3, "Python");

		Autor autor4 = new Autor("carlos casado", LocalDate.of(2001, 1, 1));
		LibroDTO lib4 = new LibroDTO(167802, LocalDate.now(), autor4, "HTML");

		libros.add(lib1);
		libros.add(lib2);
		libros.add(lib3);
		libros.add(lib4);

		return libros;

	}

//buscamos libro por su ISBN
	public LibroDTO ISBNLibro1(long ISBN) {
		// listalibros();
		List<LibroDTO> libros = listalibros();
		for (LibroDTO libro : libros) {
			long isbn = libro.getISBN();
			if (isbn == ISBN) {
				return libro;
			}
		}
		return null;

	}

	// buscamos libro por si ISBN (segunda forma)
	public LibroDTO ISBNLibro2(long ISBN) {
		// listalibros();
		LibroDTO libroEncontrado = null;
		List<LibroDTO> libros = listalibros();
		for (LibroDTO libro : libros) {
			long isbn = libro.getISBN();
			if (isbn == ISBN) {
				libroEncontrado = libro;
			}
		}
		return libroEncontrado;

	}

// buscamos libro por su titulo
	public LibroDTO TituloBuscar(String t) {
		List<LibroDTO> libros = listalibros();
		for (LibroDTO l : libros) {
			String titulo = l.getTitulo();
			if (titulo.equalsIgnoreCase(t)) {
				return l;
			}
		}
		return null;
	}
// buscamos libros demaciado antiguos
	public List<LibroDTO> libroAntiguo(LocalDate fecha) {
		ArrayList<LibroDTO> librosAntiguos = new ArrayList<>();
		List<LibroDTO> libros = listalibros();
		for (LibroDTO lib : libros) {
			int anio = lib.getFechaDeLanzamiento().getYear();
			if (anio <= fecha.getYear() ){
				librosAntiguos.add(lib);

			}
		}
		return librosAntiguos;
	}

	public void insertar(LibroDTO nuevo) {
		repoLibro.save(to(nuevo));
	}

	public void insertarDatosInciales() {

		Autor autor = new Autor();
		autor.setNombre("Maria Cano");
		autor.setFechaNacimiento(LocalDate.of(1980, 11, 28));
		repoAutor.save(autor);
		ArrayList<LibroDTO> listalibros = listalibros();
		for (LibroDTO dto : listalibros) {

			Libro aInsertar = to(dto);
			repoLibro.save(aInsertar);
		}

		// Mapstruct y el Objectmapper

	}

	public Autor insertarAutor(Autor autor) {
		Autor nuevoAutor = new Autor();
		nuevoAutor.setNombre(autor.getNombre());
		nuevoAutor.setFechaNacimiento(autor.getFechaNacimiento());
		return repoAutor.save(nuevoAutor);

	}

	private Libro to(LibroDTO dto) {

		Libro entidad = new Libro();

		Autor autorEntidad = dto.getAutor();
		autorEntidad.setFechaNacimiento(dto.getAutor().getFechaNacimiento());
		autorEntidad.setNombre(dto.getAutor().getNombre());
		entidad.setAutor(autorEntidad);
		entidad.setFechaLanzamiento(dto.getFechaDeLanzamiento());
		entidad.setISBN(dto.getISBN());
		entidad.setTitulo(dto.getTitulo());

		return entidad;
	}

	public Libro update(LibroDTO libro) {
		LibroDTO actualizadoEntero = new LibroDTO();
		actualizadoEntero.setFechaDeLanzamiento(libro.getFechaDeLanzamiento());
		actualizadoEntero.setAutor(libro.getAutor());
		actualizadoEntero.setTitulo(libro.getTitulo());
		actualizadoEntero.setISBN(libro.getISBN());
		return repoLibro.update(actualizadoEntero);

	}

}