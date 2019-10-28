package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vesprada
 */
public class AppE2 {
    
    public static ArrayList<Libro> mapearLibros(File fichero){
        ArrayList<Libro> prestamos = new ArrayList<>();
        XmlCtrlDom xcd = new XmlCtrlDom();
        String isbn="";
        String autor="";
        String editorial = "";
        String titulo = "";
        

        try {
            Document doc = xcd.instanciarDocument(fichero);

            Element root = doc.getDocumentElement();

            NodeList lista = doc.getElementsByTagName("prestamo");
            Node prestamo = lista.item(0);

            NodeList libros = prestamo.getChildNodes();

            for (int i = 0; i < libros.getLength(); i++) {
                if (libros.item(i).getNodeType() == 1) {
                    Node libro = libros.item(i);
                    int anyo=0;
                    isbn = libro.getAttributes().item(0).getTextContent();

                    NodeList info = libro.getChildNodes();
                    for (int j = 0; j < info.getLength(); j++) {
                        if (info.item(j).getNodeType() == 1) {
                            Node elemento = info.item(j);
                            
                            switch (elemento.getNodeName()) {
                                case "titulo":
                                    titulo = elemento.getTextContent();
                                    break;
                                case "autor":
                                    autor = elemento.getTextContent();
                                    break;
                                case "anyo":
                                    anyo = Integer.parseInt(elemento.getTextContent());
                                    break;
                                case "editorial":
                                    editorial = elemento.getTextContent();
                                    break;
                                
                            }
                        }
                    }
                    Libro l = new Libro(isbn,titulo,autor,editorial,anyo);
                    prestamos.add(l);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AppE2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppE2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(AppE2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prestamos;
    }
    
    public static void imprimirLibrosOrdenados(ArrayList<Libro> lista){
        lista.sort(new Comparator<Libro>() {
            @Override
            public int compare(Libro o1, Libro o2) {
                if (o1.getAnyo()>o2.getAnyo()) {
                    return -1;
                }else{
                    return 0;
                }
                    
            }
        });
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString()); 
        }
    }

    public static void main(String[] args) {
        File fichero = new File("libroXML.xml");
        
        
        
        imprimirLibrosOrdenados(mapearLibros(fichero));
    }
}
