/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1e1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author vesprada
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("ejercicio1.xml");
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(f);
            
            Element rootElement = document.getDocumentElement();
            
            NodeList lista = document.getElementsByTagName("prestamo");
           
            Element prestamo = (Element) lista.item(0);
            
            Element libro = document.createElement("libro");
            
            Element titulo = document.createElement("titulo");
            Text textoTitulo = document.createTextNode("Acces a Dades");
            titulo.appendChild(textoTitulo);
            
            Element autor = document.createElement("autor");
            Text textoAutor = document.createTextNode("Edgar");
            autor.appendChild(textoAutor);
            
            Element anyo = document.createElement("anyo");
            Text textoAnyo = document.createTextNode("2019");
            anyo.appendChild(textoAnyo);
            
            Element editorial = document.createElement("editorial");
            Text textoEditorial = document.createTextNode("Simarro");
            editorial.appendChild(textoEditorial);
            
            libro.setAttribute("id", "asdf1234");
            
            
            libro.appendChild(titulo);
            libro.appendChild(autor);
            libro.appendChild(anyo);
            libro.appendChild(editorial);
            
            prestamo.appendChild(libro);
            
            
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("ejercicio1.xml"));
            trans.transform(source, result);

            System.out.println("Fichero modificado.");
            
            
            
            
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
