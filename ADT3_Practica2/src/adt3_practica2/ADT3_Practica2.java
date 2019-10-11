/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author vesprada
 */
public class ADT3_Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        
        File archivo = new File("ejercicio1.xml");
        
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
        ArrayList<Receta> principales = new ArrayList<>();
        ArrayList<Receta> secundarios = new ArrayList<>();
        ArrayList<Receta> postres = new ArrayList<>();
        
        try{
            
            
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ManejadorRecetas(principales,secundarios,postres));
            reader.parse(new InputSource(new FileInputStream(archivo)));
            
            System.out.println("Principales: ");
            for (int i = 0; i < principales.size(); i++) {
                principales.get(i).toString();
            }
            System.out.println("");
            System.out.println("Secundarios: ");
            for (int i = 0; i < secundarios.size(); i++) {
                secundarios.get(i).toString();
            }
            System.out.println("");
            System.out.println("Postres: ");
            for (int i = 0; i < postres.size(); i++) {
                postres.get(i).toString();
            }
        } catch (Exception e) {
            
            String errorMessage = "Error analizando "+archivo+": "+ e;
            System.err.println(errorMessage);
            e.printStackTrace();
            
        } 
    }
    
}
