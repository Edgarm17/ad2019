package adt3_practica1e4;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
public class App4 {
    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException    {
        File f = new File("ejercicio4.xml");
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(f);
        
        NodeList nl = document.getElementsByTagName("alumne");
        
        
        
        for (int i = 0; i < nl.getLength(); i++) {
            ArrayList<String> atributosAlumno = new ArrayList<>();
            Alumno a1 = new Alumno();
            NodeList n = nl.item(i).getChildNodes();
            
            Element alumno = (Element) nl.item(i);
            
            int id = Integer.parseInt(alumno.getAttribute("id"));
            
            for (int j = 0; j < n.getLength(); j++) {
                if (n.item(j).getNodeType() == 1) {
                    atributosAlumno.add(n.item(j).getTextContent());
                }
            }
            
           a1.setId(id);
           a1.setNom(atributosAlumno.get(0));
           a1.setCognom(atributosAlumno.get(1));
           a1.setCurs(atributosAlumno.get(2));
            
           
            listaAlumnos.add(a1);
            
        }
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println("Alumne "+(i+1));
            System.out.println("Nom: "+listaAlumnos.get(i).getNom());
            System.out.println("Cognom: "+listaAlumnos.get(i).getCognom());
            System.out.println("Curs: "+listaAlumnos.get(i).getCurs());
            System.out.println("ID: "+listaAlumnos.get(i).getId());
            System.out.println("");
        }
        
        
        
    }
}
