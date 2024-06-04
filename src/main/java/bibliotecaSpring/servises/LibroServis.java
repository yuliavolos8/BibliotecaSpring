package bibliotecaSpring.servises;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import bibliotecaSpring.dtos.Libro;
@Servis
public class LibroServis {

	public ArrayList<Libro> listalibros() {
		ArrayList<Libro> libros = new ArrayList<>();
		Libro lib1 = new Libro(1234567, 1996, " Java", " Ramon Blanco");
		Libro lib2 = new Libro(167800, 2000, " C++", " maria casado");
		Libro lib3 = new Libro(167806, 20020, " Python", " Rebeca casado");
		Libro lib4 = new Libro(167802, 2001, " HTML", "carlos casado");

		libros.add(lib1);
		libros.add(lib2);
		libros.add(lib3);
		libros.add(lib4);
		
		return libros;

	}

	public Libro ISBNLibro1(long ISBN) {
		// listalibros();
		List<Libro> libros = listalibros();
		for (Libro libro : libros) {
			long isbn = libro.getISBN();
			if (isbn == ISBN) {
				return libro;
			}
		}
		return null;

	}

	public Libro ISBNLibro2(long ISBN) {
		// listalibros();
		Libro libroEncontrado = null;
		List<Libro> libros = listalibros();
		for (Libro libro : libros) {
			long isbn = libro.getISBN();
			if (isbn == ISBN) {
				libroEncontrado = libro;
			}
		}
		return libroEncontrado;

	}
}