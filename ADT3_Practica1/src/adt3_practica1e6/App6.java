/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1e6;

import adt3_practica1e5.Alumno5;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
public class App6 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        File f = new File("ejercicio4.xml");
        ArrayList<Alumno6> listaAlumnosDAM = new ArrayList<>();
        ArrayList<Alumno6> listaAlumnosASIX = new ArrayList<>();
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(f);
        
        NodeList nl = document.getElementsByTagName("alumne");
        
        
        
        for (int i = 0; i < nl.getLength(); i++) {
            ArrayList<String> atributosAlumno = new ArrayList<>();
            Alumno6 a1 = new Alumno6();
            NodeList n = nl.item(i).getChildNodes();
            
            Element alumno = (Element) nl.item(i);
            
            int id = Integer.parseInt(alumno.getAttribute("id"));
            float nota = (float) (Math.random() * (10 - 0) + 0);
            float notaRound =  (float) ((float)Math.round(nota * 100d) / 100d);
            
            for (int j = 0; j < n.getLength(); j++) {
                if (n.item(j).getNodeType() == 1) {
                    atributosAlumno.add(n.item(j).getTextContent());
                }
            }
            
           a1.setId(id);
           a1.setNom(atributosAlumno.get(0));
           a1.setCognom(atributosAlumno.get(1));
           a1.setCurs(atributosAlumno.get(2));
           
           a1.setNota(notaRound);
            
            if (a1.getCurs().equals("2nDAM")) {
                listaAlumnosDAM.add(a1);
            }else{
                listaAlumnosASIX.add(a1);
            }
           
            
            
        }
        
        listaAlumnosDAM.sort(new Comparator<Alumno6>() {
            @Override
            public int compare(Alumno6 o1, Alumno6 o2) {
                if (o1.getNota()>o2.getNota()) {
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        
        listaAlumnosASIX.sort(new Comparator<Alumno6>() {
            @Override
            public int compare(Alumno6 o1, Alumno6 o2) {
                if (o1.getNota()>o2.getNota()) {
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        
        System.out.println("ALUMNOS DAM: ");
        
        for (int i = 0; i < listaAlumnosDAM.size(); i++) {
            System.out.println("Alumne "+(i+1));
            System.out.println("Nom: "+listaAlumnosDAM.get(i).getNom());
            System.out.println("Cognom: "+listaAlumnosDAM.get(i).getCognom());
            System.out.println("Curs: "+listaAlumnosDAM.get(i).getCurs());
            System.out.println("ID: "+listaAlumnosDAM.get(i).getId());
            System.out.println("Nota: "+listaAlumnosDAM.get(i).getNota());

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
            System.out.println("Nota: "+listaAlumnosASIX.get(i).getNota());
            System.out.println("");
        }
    }
}
