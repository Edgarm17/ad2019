package adt3_ejemplos;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App01 {

    public static void main(String[] args) {

        try {

            // Para conseguir una instancia del analizador DOM a través de
            // JAXP usamos las clases DocumentBuilder y DocumentBuilderFactory
            // W3C - Clase no abstracta
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // W3C - Especificación de la clase para poder instaciar estruturas DOM
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Representa el documento XML en dom
            Document document = db.parse(new File("ejemplo1.xml"));

            NodeList list = document.getElementsByTagName("titulo");

            int i = 0;
            while (i < list.getLength()) {
                Node n = list.item(i);

                System.out.println("Título de la receta " + i
                        + ": " + n.getFirstChild().getNodeValue());

                i++;
            }

        } catch (Exception e) {
            System.out.println("Error en la lectura: " + e.toString());
        }

    }

}
