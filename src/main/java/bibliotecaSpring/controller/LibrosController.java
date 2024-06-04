package bibliotecaSpring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bibliotecaSpring.dtos.Libro;
import bibliotecaSpring.servises.LibroServis;

@RequestMapping(path = "/")
@RestController
public class LibrosController {
	@Autowired	
	private LibroServis servicio;

	@GetMapping("saludar")

	public String index() {
		return " hola";

	}

	@PostMapping
	public String responderPost() {
		return " respuesta de peticion post";
	}

	@GetMapping
	public ArrayList<Libro> listarlibros() {

		return servicio.listalibros();
	}

	@GetMapping("/ISBN/{ISBN}")
	public Libro getISBN(@PathVariable long ISBN) {

		servicio.ISBNLibro2(ISBN);
		return servicio.ISBNLibro1(ISBN);

	}
}
