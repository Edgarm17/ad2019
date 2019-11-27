package com.mycompany.scrappingweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Edgar
 */
public class App {
    
    public static void obtenerPaginasPeliculas(String url,ArrayList<String> listaPaginas) throws IOException{
        Document doc =  Jsoup.connect(url).get();
        
        Elements cartelera = doc.getElementsByClass("movie-poster");
        for(Element nodo : cartelera){
            listaPaginas.add(nodo.child(2).attr("href"));
            
        }
    }
    
    public static void sacarInfoPeliculas(ArrayList<String> listaPaginas, ArrayList<Pelicula> peliculas) throws IOException{
        for (int i = 0; i < listaPaginas.size(); i++) {
            Pelicula p = new Pelicula(listaPaginas.get(i));
            peliculas.add(p);
        }
    }
    
    public static void escribirPeliculasEnFichero(File fichero, ArrayList<Pelicula> peliculas) throws IOException{
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        
        for (int i = 0; i < peliculas.size(); i++) {
            oos.writeObject(peliculas.get(i));
        }
        
        oos.close();
    }
    
    public static void leerPeliculasFichero(File fichero){
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            Object pelicula = ois.readObject();
            
            while (pelicula!=null) {
                if (pelicula instanceof Pelicula) {
                    ((Pelicula) pelicula).mostrarDatos();
                }
                pelicula = ois.readObject();
            }
            
            ois.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Lectura finalizada");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<String> listaPaginas = new ArrayList<>();
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String url = "https://www.filmaffinity.com/es/cat_new_th_es.html";
        File archivo = new File("datosPeliculas.dat");
        
        obtenerPaginasPeliculas(url,listaPaginas);
        
        sacarInfoPeliculas(listaPaginas,peliculas);
        
        escribirPeliculasEnFichero(archivo,peliculas);
        leerPeliculasFichero(archivo);
        
    }
}
