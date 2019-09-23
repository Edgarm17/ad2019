/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica2e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class AppEj7 {
    
    public static void main(String[] args) {
        
        File archivo = new File("ejercicio7.txt");
        
        try {
            
            FileReader fis = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fis);
            
            String palabras[];
            int numPalabras;
            
            int media;
            String texto="";

            int caracter;
            
            while((caracter = br.read()) != -1){
                texto+=Character.toString((char) caracter);
                
            }
            
            palabras = texto.split(" ");
            numPalabras = palabras.length;
            
            for (int j = 0; j < palabras.length; j++) {
                int vocales=0;
                for (int x = 0; x < palabras[j].length(); x++) {
                    if (palabras[j].charAt(x) == 'a' || palabras[j].charAt(x) == 'e' || palabras[j].charAt(x) == 'i' || palabras[j].charAt(x) == 'o' || palabras[j].charAt(x) == 'u') {
                        vocales++;
                    }
                    
                }
                media = vocales / numPalabras;
                System.out.println("Media palabra "+(j+1)+": "+"Vocales("+vocales+") / Palabras("+numPalabras+") = "+media);
            }
            
            
           
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppEj7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppEj7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
