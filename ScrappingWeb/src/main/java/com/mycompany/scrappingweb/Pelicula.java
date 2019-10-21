/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scrappingweb;

import java.io.IOException;
import java.io.Serializable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Edgar
 */
public class Pelicula implements Serializable{
    private String url;
    private String titulo,anyo,pais,director,sinopsis;
    
    
    

    public Pelicula(String url) throws IOException {
        this.url = url;
        Document doc =  Jsoup.connect(url).get();
        
        this.titulo = doc.getElementsByAttributeValue("itemprop", "name").first().text();
        this.anyo = doc.getElementsByAttributeValue("itemprop", "datePublished").first().text();
        this.pais = doc.getElementById("country-img").child(0).attr("title");
        this.director = doc.getElementsByAttributeValue("itemprop", "director").first().child(0).child(0).text();
        this.sinopsis = doc.getElementsByAttributeValue("itemprop", "description").first().text();
    }
    
    public void mostrarDatos(){
        System.out.println("Titulo: "+titulo);
        System.out.println("Año: "+anyo);
        System.out.println("Pais: "+pais);
        System.out.println("Director: "+director);
        System.out.println("Sinopsis: "+sinopsis.substring(0, 100)+"...");
        System.out.println("");
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    
}
