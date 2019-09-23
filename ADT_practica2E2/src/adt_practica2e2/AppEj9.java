package adt_practica2e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class AppEj9 {
    public static void main(String[] args) {
        
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        
        Scanner s = new Scanner(System.in);
        File archivo = new File("ejercicio9.txt");
        
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String nombre;
            int puntuacion;
            String linea;
            while ((linea = br.readLine())!= null) {
                System.out.println(linea);
            }
            
            br.close();
                   


            
            String nombreJugador;

//            System.out.println("Introduce tu nombre: ");
//            nombreJugador = s.next();
//            System.out.println("Introduce la puntuacion: ");
//            puntuacion = s.nextInt();
            
            PrintWriter pw = new PrintWriter(archivo);
            
//            pw.write(nombreJugador+" "+puntuacion);
            br.close();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppEj9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppEj9.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       
    }
}
