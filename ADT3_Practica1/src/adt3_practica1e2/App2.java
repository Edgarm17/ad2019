package adt3_practica1e2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vesprada
 */
public class App2 {

    public static void main(String[] args) {
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document docNuevo = docBuilder.newDocument();
            
            Element alumnos = docNuevo.createElement("alumnos");

            Element alumno = docNuevo.createElement("alumno");

            Element nombre = docNuevo.createElement("nombre");
            
            Element apellido = docNuevo.createElement("apellido");
            
            Element edad1 = docNuevo.createElement("edad");
            
            
            nombre.setTextContent("Juan");
            apellido.setTextContent("Martí López");
            edad1.setTextContent("18");
            
            alumno.appendChild(nombre);
            alumno.appendChild(apellido);
            alumno.appendChild(edad1);
            alumnos.appendChild(alumno);
            
            alumno = docNuevo.createElement("alumno");
            
            nombre = docNuevo.createElement("nombre");
            
            apellido = docNuevo.createElement("apellido");
            
            edad1 = docNuevo.createElement("edad");
            
            nombre.setTextContent("Amparo");
            apellido.setTextContent("Descals Luna");
            edad1.setTextContent("25");
            alumno.appendChild(nombre);
            alumno.appendChild(apellido);
            alumno.appendChild(edad1);
            alumnos.appendChild(alumno);
            
            

            docNuevo.appendChild(alumnos);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(docNuevo);

            StreamResult result = new StreamResult(new File("ejercicio2.xml"));
            transformer.transform(source, result);
            
            System.out.println("Arxiu creat!");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
