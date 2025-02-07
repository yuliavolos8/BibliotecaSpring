package bibliotecaSpring.dtos;

import java.time.LocalDate;

import bibliotecaSpring.repositories.Autor;

public class LibroDTO {

	private long ISBN;
	private LocalDate fechaDeLanzamiento;
	private final static int ANIO_MAX_ANTIGUEDAD = 30;

	private Autor autor;
	private String titulo;

	public LibroDTO(long iSBN, LocalDate fecha, Autor autor, String titulo) {

		this.ISBN = iSBN;
		this.fechaDeLanzamiento = fecha;
		this.autor = autor;
		this.titulo = titulo;
	}

	public LibroDTO() {

	}

//	private Set<Tema> temas;
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor2) {
		this.autor = autor2;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static int getAnioMaxAntiguedad() {
		return ANIO_MAX_ANTIGUEDAD;
	}

	public LocalDate getFechaDeLanzamiento() {
		return fechaDeLanzamiento;
	}

	public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
		this.fechaDeLanzamiento = fechaDeLanzamiento;
	}

}
