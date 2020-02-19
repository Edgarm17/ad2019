package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Libro {


	@Id
	private int isbn;
	@Column
	private String titulo;
	@Column
	private String autor;
	@Column
	private int numejemplares;
	@Column
	private int anyopublicacion;
	@Column
	private String editorial;
	@Column
	private int numpag;
	
	
	public Libro(int isbn, String titulo, String autor, int numejemplares, int anyopublicacion, String editorial,
			int numpag) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numejemplares = numejemplares;
		this.anyopublicacion = anyopublicacion;
		this.editorial = editorial;
		this.numpag = numpag;
	}
	
	public Libro() {};
	
	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getNumejemplares() {
		return numejemplares;
	}


	public void setNumejemplares(int numejemplares) {
		this.numejemplares = numejemplares;
	}


	public int getAnyopublicacion() {
		return anyopublicacion;
	}


	public void setAnyopublicacion(int anyopublicacion) {
		this.anyopublicacion = anyopublicacion;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public int getNumpag() {
		return numpag;
	}


	public void setNumpag(int numpag) {
		this.numpag = numpag;
	}
	



	
	
}
