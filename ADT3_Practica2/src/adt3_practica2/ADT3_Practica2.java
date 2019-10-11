/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author vesprada
 */
public class ADT3_Practica2 {

    public static void generarArbolRecetario(Document doc, ArrayList<Receta> arrayRecetas) throws TransformerConfigurationException, TransformerException {

        //Element arrel
        Element recetario = doc.createElement("recetario");
        doc.appendChild(recetario);

        for (int i = 0; i < arrayRecetas.size(); i++) {

            //Receta
            Element receta = doc.createElement("receta");
            recetario.appendChild(receta);

            //Atributo
            Attr tipo = doc.createAttribute("tipo");
            tipo.setValue(arrayRecetas.get(i).getTipo());
            receta.setAttributeNode(tipo);

            //nombre
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(arrayRecetas.get(i).getNombre()));
            receta.appendChild(nombre);

            //descripcion
            Element descripcion = doc.createElement("descripcion");
            descripcion.appendChild(doc.createTextNode(arrayRecetas.get(i).getDescripcion()));
            receta.appendChild(descripcion);
            
            //precio
            Element precio = doc.createElement("precio");
            precio.appendChild(doc.createTextNode(Float.toString(arrayRecetas.get(i).getPrecio())));
            receta.appendChild(precio);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        String tipo = arrayRecetas.get(0).getTipo();
        StreamResult result;
        switch (tipo) {
            case "principal":
                result = new StreamResult(new File("principales.xml"));
                transformer.transform(source, result);
                break;
            case "secundario":
                result = new StreamResult(new File("secundarios.xml"));
                transformer.transform(source, result);
                break;
            case "postre":
                result = new StreamResult(new File("postres.xml"));
                transformer.transform(source, result);
                break;
            
        }

        

    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {

        File archivo = new File("exercici2.xml");

//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
        ArrayList<Receta> principales = new ArrayList<>();
        ArrayList<Receta> secundarios = new ArrayList<>();
        ArrayList<Receta> postres = new ArrayList<>();

        try {

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ManejadorRecetas(principales, secundarios, postres));
            reader.parse(new InputSource(new FileInputStream(archivo)));

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            
            //ordernarArrays
            
            principales.sort(new Comparator<Receta>() {
                @Override
                public int compare(Receta o1, Receta o2) {
                    if (o1.getPrecio()>o2.getPrecio()) {
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });
            secundarios.sort(new Comparator<Receta>() {
                @Override
                public int compare(Receta o1, Receta o2) {
                    if (o1.getPrecio()>o2.getPrecio()) {
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });
            postres.sort(new Comparator<Receta>() {
                @Override
                public int compare(Receta o1, Receta o2) {
                    if (o1.getPrecio()>o2.getPrecio()) {
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });
            
            Document document = builder.newDocument();
            generarArbolRecetario(document, principales);

            document = builder.newDocument();
            generarArbolRecetario(document, secundarios);
            
            document = builder.newDocument();
            generarArbolRecetario(document, postres);

        } catch (Exception e) {

            String errorMessage = "Error analizando " + archivo + ": " + e;
            System.err.println(errorMessage);
            e.printStackTrace();

        }
    }

}
