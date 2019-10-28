/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author vesprada
 */
public class Practicar {

    static Scanner s = new Scanner(System.in);

    public static void menu() {
        System.out.println("1.Escribir objetos en fichero binario");
        System.out.println("2.Leer objetos en fichero binario");
        System.out.println("3.Generar xml DOM");
        System.out.println("4.Leer xml DOM");
        System.out.println("5.Leer xml SAX");
        System.out.println("6.Salir");
    }

    public static void op1() throws FileNotFoundException {

        File archivo = new File("fichero.data");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));

            for (int i = 1; i < 10; i++) {

                oos.writeObject(new String("Numero " + i));

            }

            oos.close();

        } catch (IOException ex) {
            System.out.println("");
        }

    }

    public static void op2() {
        File archivo = new File("fichero.data");

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));

            Object obj = ois.readObject();

            while (obj != null) {
                if (obj instanceof String) {
                    System.out.println(obj);
                }
                obj = ois.readObject();
            }

            ois.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Practicar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Final");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Practicar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void op3() throws ParserConfigurationException, IOException {
        File fichero = new File("dom.xml");

        XmlCtrlDom xcd = new XmlCtrlDom();

        Document doc = xcd.instanciarDocument();

        Element root = doc.createElement("biblioteca");

        Element libro = doc.createElement("libro");

        Element autor = doc.createElement("autor");
        Element titulo = doc.createElement("titulo");

        libro.appendChild(autor);
        libro.appendChild(titulo);

        root.appendChild(libro);

        doc.appendChild(root);

        xcd.escribirDocumentAXmlFicheroFormato(doc, fichero);

        System.out.println("Fichero generado");

    }

    public static void op4() throws ParserConfigurationException, IOException, SAXException {
        File fichero = new File("dom.xml");

        if (fichero.exists()) {
            XmlCtrlDom xcd = new XmlCtrlDom();

            Document doc = xcd.instanciarDocument(fichero);

            Element recetario = doc.getDocumentElement();

            NodeList recetas = recetario.getChildNodes();

            for (int i = 0; i < recetas.getLength(); i++) {
                if (recetas.item(i).getNodeType() == 1) {
                    Node receta = (Node) recetas.item(i);
                    System.out.println("Receta " + i);
                    System.out.println(receta.getChildNodes().item(0).getTextContent());
                    System.out.println(receta.getChildNodes().item(1).getTextContent());
                    System.out.println("");
                }

            }
//            NodeList info = root.getChildNodes();
//            
//            Element libro = (Element) info.item(0);
//            
//            NodeList infoLibro = libro.getChildNodes();
//            
//            for (int i = 0; i < infoLibro.getLength(); i++) {
//                System.out.println(infoLibro.item(i).getNodeName());
//            }
        } else {
            System.out.println("No existe el fichero");
        }

    }
    
    public static void op5() throws SAXException, FileNotFoundException, IOException{
        File archivo = new File("dom.xml");
        
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new Manejador());
        reader.parse(new InputSource(new FileInputStream(archivo)));
        
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        int eleccion = 0;

        while (eleccion != 6) {
            menu();
            eleccion = s.nextInt();
            switch (eleccion) {
                case 1:
                    op1();
                    break;
                case 2:
                    op2();
                    break;
                case 3:
                    op3();
                    break;
                case 4:
                    op4();
                    break;
                case 5:
                    op5();
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Elije opcion correcta");
            }
        }
    }

}
