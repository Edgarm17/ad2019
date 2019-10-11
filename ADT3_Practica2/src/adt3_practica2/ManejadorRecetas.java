/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica2;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author vesprada
 */
public class ManejadorRecetas extends DefaultHandler {

    private ArrayList<Receta> principales;
    private ArrayList<Receta> secundarios;
    private ArrayList<Receta> postre;
    private Receta receta;
    private String valor = null;

    public ManejadorRecetas(ArrayList<Receta> principales,ArrayList<Receta> secundarios,ArrayList<Receta> postre) {
        this.principales = principales;
        this.secundarios = secundarios;
        this.postre = postre;
    }
    

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        valor = null;

        if (localName.equals("receta")) {
            receta = new Receta();
            String tipo = attributes.getValue("tipo");
            receta.setTipo(tipo);
            
            
            switch (receta.getTipo()) {
                case "principal":
                    principales.add(receta);
                    break;
                case "secundario":
                    secundarios.add(receta);
                    break;
                case "postre":
                    postre.add(receta);
                    break;
            }
            
            
            
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valor = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("nombre")) {
            receta.setNombre(valor);
        } else if (localName.equals("descripcion")) {
            receta.setDescripcion(valor);
        } else if(localName.equals("precio")){
            receta.setPrecio(Float.parseFloat(valor));
        }
        
        
        
    }

}
