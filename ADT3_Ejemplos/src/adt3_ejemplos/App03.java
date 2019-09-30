package adt3_ejemplos;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class App03 {

    public static void main(String[] args) {
        // ESCRITURA EN DOM
        try {
            // 1.- Creamos una instancia DOM a partir del fichero 
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("ejemplo3.xml"));


            // 2.- Creamos un nuevo nodo para el arbol DOM  
            // Primero creamos la etiqueta (Element)
            Element nuevoElement = document.createElement("pasta");  
            // Añadimos atributos
            nuevoElement.setAttribute("dificultad", "facil");  
 
            // Añadimos contenido
            //nuevoElement.setTextContent("Pasta con aceite y ajo");  
            Text texto = document.createTextNode("Pasta con aceite y ajo");
            nuevoElement.appendChild(texto);

            // 3.- Indicamos el padre del nuevo nodo creado anteriormente
            Element elementRaiz = document.getDocumentElement();
            elementRaiz.appendChild(nuevoElement);

            // 4.- Pasamos el árbol DOM a fichero XML 
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("ejemplo3.xml"));
            trans.transform(source, result);

            System.out.println("Fichero modificado.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
