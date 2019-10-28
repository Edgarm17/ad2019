package ejercicio2;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionEventos extends DefaultHandler {

    private String aux;

    public GestionEventos() {
       
    }

    @Override
    public void startDocument() {

    }

    @Override
    public void endDocument() {
  
    }

	public void startElement(String uri, String nombre, String qName, Attributes atts) {

       
    }
	
    public void endElement(String uri, String nombre, String qName) {
        
    }


    public void characters(char[] ch, int inicio, int lon) throws SAXException {
        aux = new String(ch, inicio, lon);
    }
}
