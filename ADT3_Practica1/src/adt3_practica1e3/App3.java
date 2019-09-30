/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1e3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Edgar
 */
public class App3 {

    static Scanner s = new Scanner(System.in);

    public static void visualizarXml(Document doc) {

        try {
            Element rootElement = doc.getDocumentElement();
            XmlCtrlDom x = new XmlCtrlDom();
            x.escribirDocumentAXmlPantalla(doc);
        } catch (TransformerException ex) {
            Logger.getLogger(App3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void verLibrosPrestados(Document doc) throws XPathExpressionException {
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expr = xpath.compile("//prestamo/libro");
        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nl.getLength(); i++) {
            System.out.println("Libro " + (i + 1));
            NodeList n = nl.item(i).getChildNodes();
            for (int j = 0; j < n.getLength(); j++) {
                System.out.println(n.item(j).getNodeName() + ":" + n.item(j).getTextContent().trim());
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static void verLibrosEnVenta(Document doc) throws XPathExpressionException {
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expr = xpath.compile("//venta/libro");
        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nl.getLength(); i++) {
            System.out.println("Libro " + (i + 1));
            NodeList n = nl.item(i).getChildNodes();
            for (int j = 0; j < n.getLength(); j++) {

                System.out.println(n.item(j).getNodeName() + ":" + n.item(j).getTextContent().trim());

            }
            System.out.println("");

        }
    }

    public static void insertarLibroPrestado(Document doc) throws TransformerConfigurationException, TransformerException {


        NodeList lista = doc.getElementsByTagName("prestamo");
        
        Element prestamo = (Element) lista.item(0);

        Element libro = doc.createElement("libro");

        Element titulo = doc.createElement("titulo");
        Element autor = doc.createElement("autor");
        Element anyo = doc.createElement("anyo");
        Element editorial = doc.createElement("editorial");

        System.out.println("Titulo: ");
        titulo.setTextContent(s.next());

        System.out.println("Autor: ");
        autor.setTextContent(s.next());

        System.out.println("Año: ");
        anyo.setTextContent(s.next());

        System.out.println("Editorial: ");
        editorial.setTextContent(s.next());

        libro.appendChild(titulo);
        libro.appendChild(autor);
        libro.appendChild(anyo);
        libro.appendChild(editorial);

        prestamo.appendChild(libro);

        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("ejercicio3.xml"));
        trans.transform(source, result);

        System.out.println("Libro añadido!.");

    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException {

        File f = new File("ejercicio3.xml");

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(f);

        int eleccion = 0;

        while (eleccion != 5) {
            System.out.println("");
            System.out.println("**********MENÚ PRINCIPAL***********");
            System.out.println("1.Visualizar XML\n2.Listar libros prestados\n3.Listar libros en venta");
            System.out.println("4.Añadir nuevo libro prestado\n5.Salir");
            eleccion = s.nextInt();

            switch (eleccion) {
                case 1:
                    visualizarXml(document);
                    break;
                case 2:
                    verLibrosPrestados(document);
                    break;
                case 3:
                    verLibrosEnVenta(document);
                    break;
                case 4:
                    insertarLibroPrestado(document);
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Elige una opción correcta!");
            }

        }

    }
}
