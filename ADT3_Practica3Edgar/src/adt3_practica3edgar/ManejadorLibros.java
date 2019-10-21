/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica3edgar;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Edgar
 */
public class ManejadorLibros extends DefaultHandler{
    private ArrayList<Libro> lista = new ArrayList<>();
    private Libro libro = new Libro();
    private String valor = null;

    public ManejadorLibros(ArrayList<Libro> lista) {
        this.lista = lista;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("libro")) {
            libro = new Libro();
            lista.add(libro);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valor = new String(ch,start,length);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("titulo")) {
            libro.setTitulo(valor);
        }else if (localName.equals("autor")) {
            libro.setAutor(valor);
        }else if (localName.equals("anyo")) {
            libro.setAnyo(valor);
        }else if (localName.equals("editorial")) {
            libro.setEditorial(valor);
        }else if (localName.equals("paginas")) {
            libro.setNumPags(qName);
        }else if (localName.equals("isbn")) {
            libro.setIsbn(valor);
        }
    }

    
    
    
    
    
}
