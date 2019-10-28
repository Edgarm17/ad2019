/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica3edgar;

import practicar.MiObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Edgar
 */
public class Libro implements Serializable {

    private String titulo;
    private String autor;
    private String isbn;
    private String anyo;
    private String editorial;
    private String numPags;

    public Libro() {
    }

    public Libro(String titulo, String autor, String isbn, String anyo, String editorial, String numPags) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anyo = anyo;
        this.editorial = editorial;
        this.numPags = numPags;
    }

    public void insertarEnFichero(File fichero) {
        try {

            if (!fichero.exists()) {
                
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
                oos.writeObject(this);
                oos.close();
                
            }else{
                
                MiObjectOutputStream moi = new MiObjectOutputStream(new FileOutputStream(fichero,true));
                moi.writeObject(this);
                moi.close();
                
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("Error de escritura");
        }
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNumPags() {
        return numPags;
    }

    public void setNumPags(String numPags) {
        this.numPags = numPags;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", anyo=" + anyo + ", editorial=" + editorial + ", numPags=" + numPags + '}';
    }
    
    

}
