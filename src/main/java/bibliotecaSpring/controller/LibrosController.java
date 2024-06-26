package bibliotecaSpring.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bibliotecaSpring.dtos.LibroDTO;
import bibliotecaSpring.repositories.Autor;
import bibliotecaSpring.servises.LibroService;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(path = "/")
@RestController
public class LibrosController {
	@Autowired
	private LibroService servicio;

	@GetMapping("/saludar/{nombre}")

	public String index(@PathVariable String nombre) {
		return " hola" + nombre;

	}

	@PostMapping("/Addtodos")
	public String responderPost() {
		servicio.insertarDatosInciales();
		return " respuesta de peticion post";
	}

	@PostMapping("/unico")
	public String nuevo(@RequestParam int anio, String autor, String titulo, long isbn) {

		LibroDTO n = new LibroDTO();
		n.setAnio(anio);
		n.setAutor(autor);
		n.setTitulo(titulo);
		n.setISBN(isbn);
		servicio.insertar(n);

		return " respuesta de peticion post";
	}

	@GetMapping("/libros")
	public ArrayList<LibroDTO> listarlibros() {

		return servicio.listalibros();
	}

	@GetMapping("/ISBN/{ISBN}")
	public LibroDTO getISBN(@PathVariable long ISBN) {

		servicio.ISBNLibro2(ISBN);
		return servicio.ISBNLibro1(ISBN);

	}

	@GetMapping("/titulo/{titulo}")
	public LibroDTO getTitulo(@PathVariable String titulo) {
		return servicio.TituloBuscar(titulo);
	}

	@GetMapping("libro_antiguo/{anio}")

	public List<LibroDTO> getAnioPorPath(@PathVariable int anio) {
		return servicio.libroAntiguo(anio);

	}

	@GetMapping("libro_antiguo")
	// public List<Libro> getAnioPorParametro(@RequestParam(defaultValue = "2000")
	// int anio) {
	public List<LibroDTO> getAnioPorParametro(@RequestParam() Optional<Integer> anio) {
		return servicio.libroAntiguo(anio.orElse(2000));

	}

	@PostMapping("/aniadir_autor")
	public Autor crearAutor(@RequestBody Autor autor) {

		return servicio.insertarAutor(autor);

	}
}