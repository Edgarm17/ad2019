/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica3edgar;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
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
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Edgar
 */
public class ADT3_Practica3Edgar {

    static Scanner s = new Scanner(System.in);

    public static void menu() {
        String menu = "1. Insertar libro\n2.Generar XML - DOM\n3.Generar XML - XStream\n4.Visualizar libros - SAX\n"
                + "5.Visualizar libros - DOM\n6.Salir";
        System.out.println(menu);
    }

    public static void insertarLibro(File fichero) {

        String titulo, autor, isbn, anyo, editorial, paginas;

        System.out.println("Titulo: ");
        titulo = s.next();
        System.out.println("Autor: ");
        autor = s.next();
        System.out.println("ISBN: ");
        isbn = s.next();
        System.out.println("Año: ");
        anyo = s.next();
        System.out.println("Editorial: ");
        editorial = s.next();
        System.out.println("Páginas: ");
        paginas = s.next();
        Libro l = new Libro(titulo, autor, isbn, anyo, editorial, paginas);
        l.insertarEnFichero(fichero);
    }

    public static ArrayList<Libro> leerLibrosDeArchivo(File fichero) {
        if (fichero.exists()) {
            ArrayList<Libro> lista = new ArrayList<>();

            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
                Object obj = ois.readObject();

                while (obj != null) {
                    if (obj instanceof Libro) {
                        Libro leido = (Libro) obj;
                        lista.add(leido);
                    }
                    obj = ois.readObject();
                }
                ois.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Archivo no encontrado");
            } catch (IOException ex) {
                System.out.println("Lectura finalizada");
            } catch (ClassNotFoundException ex) {
                System.out.println("Objecto no encontrado");
            }

            return lista;
        } else {
            System.out.println("Todavía no hay libros en el archivo");
            return null;
        }

    }

    public static void generarXMLdom(ArrayList<Libro> lista) throws ParserConfigurationException, TransformerConfigurationException, TransformerConfigurationException {
        if (lista.size() > 0) {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element biblioteca = doc.createElement("biblioteca");
            for (int i = 0; i < lista.size(); i++) {
                Libro actual = lista.get(i);

                Element libro = doc.createElement("libro");

                Element titulo = doc.createElement("titulo");
                titulo.setTextContent(actual.getTitulo());

                Element autor = doc.createElement("autor");
                autor.setTextContent(actual.getAutor());

                Element isbn = doc.createElement("isbn");
                isbn.setTextContent(actual.getIsbn());

                Element anyo = doc.createElement("anyo");
                anyo.setTextContent(actual.getAnyo());

                Element editorial = doc.createElement("editorial");
                editorial.setTextContent(actual.getEditorial());

                Element numPags = doc.createElement("paginas");
                numPags.setTextContent(actual.getNumPags());

                libro.appendChild(titulo);
                libro.appendChild(autor);
                libro.appendChild(isbn);
                libro.appendChild(anyo);
                libro.appendChild(editorial);
                libro.appendChild(numPags);

                biblioteca.appendChild(libro);
            }
            doc.appendChild(biblioteca);

            TransformerFactory transFactory = TransformerFactory.newInstance();

            Transformer idTransform;
            try {
                idTransform = transFactory.newTransformer();
                idTransform.setOutputProperty(OutputKeys.METHOD, "xml");
                idTransform.setOutputProperty(OutputKeys.INDENT, "yes");
                Source input = new DOMSource(doc);
                Result output = new StreamResult(new FileOutputStream("bibliotecaDOM.xml"));
                idTransform.transform(input, output);
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(ADT3_Practica3Edgar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ADT3_Practica3Edgar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(ADT3_Practica3Edgar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Creación del XML con DOM realizada con éxito");
        } else {
            System.out.println("No puedes generar el xml sin ningun libro");
        }

    }

    public static void generarXMLsax(ArrayList<Libro> lista) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document doc = builder.newDocument();
        Element biblioteca = doc.createElement("biblioteca");

        for (int i = 0; i < lista.size(); i++) {
            Libro actual = lista.get(i);

            Element libro = doc.createElement("libro");

            Element titulo = doc.createElement("titulo");
            titulo.setTextContent(actual.getTitulo());

            Element autor = doc.createElement("autor");
            autor.setTextContent(actual.getAutor());

            Element isbn = doc.createElement("isbn");
            isbn.setTextContent(actual.getIsbn());

            Element anyo = doc.createElement("anyo");
            anyo.setTextContent(actual.getAnyo());

            Element editorial = doc.createElement("editorial");
            editorial.setTextContent(actual.getEditorial());

            Element numPags = doc.createElement("paginas");
            numPags.setTextContent(actual.getNumPags());

            libro.appendChild(titulo);
            libro.appendChild(autor);
            libro.appendChild(isbn);
            libro.appendChild(anyo);
            libro.appendChild(editorial);
            libro.appendChild(numPags);

            biblioteca.appendChild(libro);
        }
        doc.appendChild(biblioteca);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File("bibliotecaSAX.xml"));
        transformer.transform(source, result);

        System.out.println("Archivo XML con SAX generado con éxito!");

    }

    public static void generarXMLxstream(ArrayList<Libro> lista) {
        XStream xstream = new XStream(new DomDriver());
        for (int i = 0; i < lista.size(); i++) {
            Libro l = lista.get(i);
            String xml = xstream.toXML(l);
            System.out.println(xml);
        }
    }

    public static void visualizarLibrosSAX() throws SAXException, FileNotFoundException, IOException {
        ArrayList<Libro> lista = new ArrayList<>();
        File archivo = new File("bibliotecaSAX.xml");

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new ManejadorLibros(lista));
        reader.parse(new InputSource(new FileInputStream(archivo)));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }

    }

    public static void visualizarLibrosDOM() throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
        File fichero = new File("bibliotecaDOM.xml");

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new FileInputStream(fichero)));

        Element raiz = doc.getDocumentElement();

        NodeList libros = raiz.getChildNodes();

        for (int i = 0; i < libros.getLength(); i++) {
            Node libro = libros.item(i);
            NodeList info = libro.getChildNodes();
            for (int j = 0; j < info.getLength(); j++) {
                if (info.item(j).getNodeType() == 1) {
                    System.out.println(info.item(j).getNodeName() + ": " + info.item(j).getTextContent());
                }

            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        ArrayList<Libro> lista = new ArrayList<>();
        File fichero = new File("biblioteca.dat");
        int eleccion = 0;
        while (eleccion != 7) {
            menu();
            eleccion = s.nextInt();
            switch (eleccion) {
                case 1:
                    insertarLibro(fichero);
                    break;
                case 2:
                    lista = leerLibrosDeArchivo(fichero);
                    generarXMLdom(lista);
                    break;
                case 3:
                    lista = leerLibrosDeArchivo(fichero);
                    generarXMLsax(lista);
                    break;
                case 4:
                    visualizarLibrosSAX();
                    break;
                case 5:
                    visualizarLibrosDOM();
                    break;
                case 6:
                    generarXMLxstream(lista);
                    break;
                case 7:

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

}
