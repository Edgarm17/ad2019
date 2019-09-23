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
import java.io.PrintWriter;

/**
 *
 * @author Edgar
 */
public class AppEj3 {

    public static void main(String[] args) {
        File archivo = new File("Ejercicio3.txt");
        File archivoCopia = new File("Ejercicio3Copia.txt");

        try {

            if (!archivoCopia.exists()) {
                archivoCopia.createNewFile();
            }

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            PrintWriter pw = new PrintWriter(archivoCopia);

            int caracter;

            while ((caracter = br.read()) != -1) {

                if ((char) caracter == 'a') {
                    pw.print((char) Character.toUpperCase(caracter));
                    System.out.print((char) Character.toUpperCase(caracter));
                } else {
                    pw.print((char) caracter);
                    System.out.print((char) caracter);
                }

            }
            br.close();
            pw.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("Error");
        }

    }
}
