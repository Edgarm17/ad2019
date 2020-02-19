package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Socio {

	@Id
	private int numsocio;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column 
	private String telefono;
	@Column
	private int edad;
	@Column
	private String falta;
	
	
	public Socio(int numsocio, String nombre, String apellidos, String telefono, int edad, String falta) {
		super();
		this.numsocio = numsocio;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.edad = edad;
		this.falta = falta;
	}
	
	public Socio() {}


	public int getNumsocio() {
		return numsocio;
	}


	public void setNumsocio(int numsocio) {
		this.numsocio = numsocio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getFalta() {
		return falta;
	}


	public void setFalta(String falta) {
		this.falta = falta;
	}
	
	
	
	
}
