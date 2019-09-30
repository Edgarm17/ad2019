package adt3_ejemplos;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App02 {


    public static String getNodo(Element elem, String etiqueta) {
        // NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        // Node valornodo = (Node) nodo.item(0);
        NodeList nodo = elem.getElementsByTagName(etiqueta);
        Node valornodo = (Node) nodo.item(0).getFirstChild();
        return valornodo.getNodeValue();
    }

    public static void main(String[] args) {
        // LECTURA EN DOM
        try {
            // Para conseguir una instancia del analizador DOM a través de
            // JAXP usamos las clases DocumentBuilder y DocumentBuilderFactory
            // W3C - Clase no abstracta
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // W3C - Especificación de la clase para poder instaciar estruturas DOM
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Representa el documento XML en dom
            Document document = db.parse(new File("ejemplo2.xml"));

            NodeList list = document.getElementsByTagName("alumno");
            int i = 0;
            while (i < list.getLength()) {
                Node alumno = list.item(i);
                if (alumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) alumno;
                    System.out.println("== ALUMNO ==");
                    System.out.print(getNodo(elemento, "nombre"));
                    System.out.print(" " + getNodo(elemento, "apellido"));
                    System.out.print(" - " + getNodo(elemento, "edad") + "\n");
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura: " + e.toString());
        }
    }
    
}
