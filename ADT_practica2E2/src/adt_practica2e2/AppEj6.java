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
public class AppEj6 {

    public static boolean compareFileContent(File archivo1, File archivo2) {
        boolean iguales = false;
        String texto1 = "";
        String texto2 = "";
        int caracter;

        try {

            FileReader fr1 = new FileReader(archivo1);
            BufferedReader br1 = new BufferedReader(fr1);

            while ((caracter = br1.read()) != -1) {
                texto1 += Character.toString((char) caracter);
            }

            FileReader fr2 = new FileReader(archivo2);
            BufferedReader br2 = new BufferedReader(fr2);

            while ((caracter = br2.read()) != -1) {
                texto2 += Character.toString((char) caracter);
            }

            if (texto1.equals(texto2)) {
                iguales = true;
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("Error");
        }

        return iguales;
    }

    public static void main(String[] args) {

        File archivo1 = new File("ejercicio6.txt");
        File archivo2 = new File("ejercicio6copia.txt");

        if (compareFileContent(archivo1, archivo2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

    }

}
