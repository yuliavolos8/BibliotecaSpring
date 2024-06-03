package bibliotecaSpring.dtos;

public class Libro {

	private long ISBN;
	private int anio;
	private final static int ANIO_MAX_ANTIGUEDAD = 30;

	private String autor;
	private String titulo;

	public Libro(long iSBN, int anio, String autor, String titulo) {
		super();
		ISBN = iSBN;
		this.anio = anio;
		this.autor = autor;
		this.titulo = titulo;
	}

	public Libro() {

	}

//	private Set<Tema> temas;
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

}
