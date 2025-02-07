package bibliotecaSpring.repositories;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name ="libros")
public class Libro {
	@Id

	/*
	@GeneratedValue( generator = "sqLibros")
	@SequenceGenerator(sequenceName = "sqIdLibros", name = "sqLibros", allocationSize = 1)
	*/
	
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id; 

	@Column(unique = true)
	private long ISBN;
	private LocalDate fechaLanzamiento;
	
	
	//private String autor;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Autor autor; 
	
	@Column(length = 50,nullable = false)
	private String titulo;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getISBN() {
		return ISBN;
	}


	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}


	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}


	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
	
	
	

}
