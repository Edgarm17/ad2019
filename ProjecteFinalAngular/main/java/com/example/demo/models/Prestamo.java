package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Prestamo {

	@Id
	private String fprestamo;
	@Column
	private int libro;
	@Column
	private int socio;
	@Column 
	private String fdevolucion;
	
	
	public Prestamo(int libro, int socio, String fprestamo, String fdevolucion) {
		super();
		this.fprestamo = fprestamo;
		this.libro = libro;
		this.socio = socio;
		this.fdevolucion = fdevolucion;
	}
	
	public Prestamo() {}


	public String getFprestamo() {
		return fprestamo;
	}


	public void setFprestamo(String fprestamo) {
		this.fprestamo = fprestamo;
	}


	public int getLibro() {
		return libro;
	}


	public void setLibro(int libro) {
		this.libro = libro;
	}


	public int getSocio() {
		return socio;
	}


	public void setSocio(int socio) {
		this.socio = socio;
	}


	public String getFdevolucion() {
		return fdevolucion;
	}


	public void setFdevolucion(String fdevolucion) {
		this.fdevolucion = fdevolucion;
	}
	
	
	
	
	
}
