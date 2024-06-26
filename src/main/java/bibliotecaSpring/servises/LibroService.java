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
		LibroDTO lib1 = new LibroDTO(1234567, 1985, " Ramon Blanco", "Java");
		LibroDTO lib2 = new LibroDTO(167800, 2000, " maria casado", "C++");
		LibroDTO lib3 = new LibroDTO(167806, 1967, " Rebeca casado", " Python");
		LibroDTO lib4 = new LibroDTO(167802, 2001, "carlos casado", " HTML");

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

	public List<LibroDTO> libroAntiguo(int anioParametro) {
		ArrayList<LibroDTO> librosAntiguos = new ArrayList<>();
		List<LibroDTO> libros = listalibros();
		for (LibroDTO lib : libros) {
			int anio = lib.getAnio();
			if (anio <= anioParametro) {
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

		Autor byNombre = repoAutor.findByNombre(dto.getAutor());

		entidad.setAutor(byNombre);
		entidad.setFechaLanzamiento(LocalDate.of(dto.getAnio(), 1, 1));
		entidad.setISBN(dto.getISBN());
		entidad.setTitulo(dto.getTitulo());

		return entidad;
	}


}