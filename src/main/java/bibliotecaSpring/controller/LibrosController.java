package bibliotecaSpring.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bibliotecaSpring.dtos.LibroDTO;
import bibliotecaSpring.repositories.Autor;
import bibliotecaSpring.repositories.Libro;
import bibliotecaSpring.servises.LibroService;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(path = "/")
@RestController
public class LibrosController {
	@Autowired
	private LibroService servicio;

	@GetMapping("/saludar/{nombre}")

	public String index(@PathVariable String nombre) {
		return " hola  " + nombre + "!!";

	}

	@PostMapping("/Addtodos")
	public String responderPost() {
		servicio.insertarDatosInciales();
		return " respuesta de peticion post";
	}

	@PostMapping("/unico")
	public String nuevo(@RequestParam LocalDate fecha, Autor autor, String titulo, long isbn) {

		LibroDTO n = new LibroDTO();
		n.setFechaDeLanzamiento(fecha);
		n.setAutor(autor);
		n.setTitulo(titulo);
		n.setISBN(isbn);
		servicio.insertar(n);

		return " respuesta de peticion post";
	}


	@PutMapping
	public ResponseEntity<Libro> putLibro(@RequestBody LibroDTO libro) {
		Libro libroActualizado = servicio.update(libro);
		return new ResponseEntity<>(libroActualizado, HttpStatus.CREATED);
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
	public List<LibroDTO> getAnioPorPath(@PathVariable String anio) {
	    LocalDate fecha = LocalDate.of(Integer.parseInt(anio), 1, 1);
	    return servicio.libroAntiguo(fecha);
	}

	@GetMapping("libro_antiguo")
	public List<LibroDTO> getAnioPorParametro(@RequestParam() Optional<Integer> anio) {
	    LocalDate fecha = LocalDate.of(anio.orElse(2000), 1, 1);
	    return servicio.libroAntiguo(fecha);
	}

}