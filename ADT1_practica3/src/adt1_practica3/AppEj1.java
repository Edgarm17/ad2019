/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vesprada
 */
public class AppEj1 {

    public static void leerArchivo(File archivo) {

        ObjectInputStream ins;
        try {
            ins = new ObjectInputStream(new FileInputStream(archivo));
            Object o1 = ins.readObject();

            while (o1 != null) {
                if (o1 instanceof Vehiculo) {
                    Vehiculo v1 = (Vehiculo) o1;
                    v1.mostrar();
                }

                o1 = ins.readObject();

            }
            ins.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertarVacio(File archivo, ObjectOutputStream out) {
        String marca, modelo, matricula, color;
        float potencia;
        try {

            marca = JOptionPane.showInputDialog(null, "Marca:");
            modelo = JOptionPane.showInputDialog(null, "Modelo:");
            matricula = JOptionPane.showInputDialog(null, "Matricula:");
            potencia = Float.parseFloat(JOptionPane.showInputDialog(null, "Potencia:"));
            color = matricula = JOptionPane.showInputDialog(null, "Color:");

            Vehiculo v = new Vehiculo(marca, modelo, matricula, potencia, color);
            System.out.println("Vehiculo " + v);
            out.writeObject(v);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertarExistente(File archivo) {
        String marca, modelo, matricula, color;
        float potencia;
        try {
            MiObjectOutputStream mois = new MiObjectOutputStream(new FileOutputStream(archivo, true));

            marca = JOptionPane.showInputDialog(null, "Marca:");
            modelo = JOptionPane.showInputDialog(null, "Modelo:");
            matricula = JOptionPane.showInputDialog(null, "Matricula:");
            potencia = Float.parseFloat(JOptionPane.showInputDialog(null, "Potencia:"));
            color = matricula = JOptionPane.showInputDialog(null, "Color:");

            Vehiculo v = new Vehiculo(marca, modelo, matricula, potencia, color);
            System.out.println("Vehiculo " + v);
            mois.writeObject(v);
            mois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner s = new Scanner(System.in);

        int eleccion = 0;
        boolean vacio = false;
        String marca, modelo, matricula, color;
        float potencia;
        File archivo = new File("vehiculo.bin");
        ObjectOutputStream out = null;
        if (!archivo.exists()) {
            archivo.createNewFile();
            out = new ObjectOutputStream(new FileOutputStream(archivo, true));
            vacio = true;
        }
        while (eleccion != 3) {

            eleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion :\n1.Introducir coche\n2.Mostrar coches\n3.Salir"));

            switch (eleccion) {
                case 1:
                    if (vacio) {
                        insertarVacio(archivo, out);
                        vacio = false;
                    } else {
                        insertarExistente(archivo);
                    }

                    break;
                case 2:
                    leerArchivo(archivo);
                case 3:

                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Introduce una opción correcta");
            }

        }
        out.close();
    }

}
