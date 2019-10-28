/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicar;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author vesprada
 */
public class Manejador extends DefaultHandler{
    private String valor = null;

    public Manejador() {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("receta")) {
            
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valor = new String(ch,start,length);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("nombre")) {
            System.out.println("Nombre: "+valor);
        }else if (localName.equals("descripcion")) {
            System.out.println("Descripcion: "+valor);
        }
    }
}
