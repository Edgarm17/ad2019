/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1e5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vesprada
 */
public class App5 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        File f = new File("ejercicio4.xml");
        ArrayList<Alumno5> listaAlumnosDAM = new ArrayList<>();
        ArrayList<Alumno5> listaAlumnosASIX = new ArrayList<>();
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(f);
        
        NodeList nl = document.getElementsByTagName("alumne");
        
        
        
        for (int i = 0; i < nl.getLength(); i++) {
            ArrayList<String> atributosAlumno = new ArrayList<>();
            Alumno5 a1 = new Alumno5();
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
            
            if (a1.getCurs().equals("2nDAM")) {
                listaAlumnosDAM.add(a1);
            }else{
                listaAlumnosASIX.add(a1);
            }
           
            
            
        }
        
        System.out.println("ALUMNOS DAM: ");
        
        for (int i = 0; i < listaAlumnosDAM.size(); i++) {
            System.out.println("Alumne "+(i+1));
            System.out.println("Nom: "+listaAlumnosDAM.get(i).getNom());
            System.out.println("Cognom: "+listaAlumnosDAM.get(i).getCognom());
            System.out.println("Curs: "+listaAlumnosDAM.get(i).getCurs());
            System.out.println("ID: "+listaAlumnosDAM.get(i).getId());
            System.out.println("");
        }
        
        System.out.println("********************\n");
        
        System.out.println("ALUMNOS ASIX: ");
        
        for (int i = 0; i < listaAlumnosASIX.size(); i++) {
            System.out.println("Alumne "+(i+1));
            System.out.println("Nom: "+listaAlumnosASIX.get(i).getNom());
            System.out.println("Cognom: "+listaAlumnosASIX.get(i).getCognom());
            System.out.println("Curs: "+listaAlumnosASIX.get(i).getCurs());
            System.out.println("ID: "+listaAlumnosASIX.get(i).getId());
            System.out.println("");
        }
        
    }
}
