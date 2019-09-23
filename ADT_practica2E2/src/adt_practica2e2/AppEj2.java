/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica2e2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edgar
 */
public class AppEj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo = new File("Ejercicio2.png");
        File archivoCopia = new File("Ejercicio2Copia.png");
        boolean eof = false;
        FileInputStream fis;
        FileOutputStream fos;

        try {
            fis = new FileInputStream(archivo);
            fos = new FileOutputStream(archivoCopia);

            if (!archivoCopia.exists()) {
                archivoCopia.createNewFile();
            }

            while (!eof) {
                int ent = fis.read();

                if (ent == -1) {
                    eof = true;
                } else {
                    System.out.println("Byte: " + ent);
                    fos.write(ent);
                }
            }
            System.out.println("final");
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.err.println("Error");
        }
    }

}
