package adt_practica2e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
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
        String[] valores;
        String nombreJugador;
        int puntuacion;
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            
            String linea;
            while ((linea = br.readLine())!= null) {
                valores = linea.split(":");
                Jugador j = new Jugador(valores[0],Integer.parseInt(valores[1]));
                listaJugadores.add(j);
            }
            
            br.close();

            System.out.println("Introduce tu nombre: ");
            nombreJugador = s.next();
            System.out.println("Introduce la puntuacion: ");
            puntuacion = s.nextInt();
            
            Jugador nuevo = new Jugador(nombreJugador,puntuacion);
            boolean siRanking = false;
            
            for (int i = 0; i < listaJugadores.size(); i++) {
                if (listaJugadores.get(i).getPuntuacion()<nuevo.getPuntuacion()) {
                    siRanking = true;
                }
            }
            
            listaJugadores.sort(new Comparator<Jugador>() {
                @Override
                public int compare(Jugador o1, Jugador o2) {
                    if (o1.getPuntuacion()>o2.getPuntuacion()) {
                        return -1;
                    }else
                        return 0;
                }
            });
            
            if (siRanking) {
                listaJugadores.remove(listaJugadores.get(listaJugadores.size()-1));
                listaJugadores.add(nuevo);
            }
            
            listaJugadores.sort(new Comparator<Jugador>() {
                @Override
                public int compare(Jugador o1, Jugador o2) {
                    if (o1.getPuntuacion()>o2.getPuntuacion()) {
                        return -1;
                    }else
                        return 0;
                }
            });
            
            
            
            PrintWriter pw = new PrintWriter(archivo);
            
            for (int i = 0; i < listaJugadores.size(); i++) {
                pw.println(listaJugadores.get(i).getNombre()+":"+listaJugadores.get(i).getPuntuacion());
            }


            for (int i = 0; i < listaJugadores.size(); i++) {
                System.out.println(listaJugadores.get(i).getNombre() + " > " + listaJugadores.get(i).getPuntuacion());
            }

            br.close();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppEj9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppEj9.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       
    }
}
