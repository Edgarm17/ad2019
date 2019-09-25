/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica2e2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar
 */
public class AppEj10 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        JFrame f = new JFrame();
        File archivo = new File("ejercicio10.data");

        String matricula, marca, modelo;
        double cantDeposito;

        int eleccion = 0;

        try {

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            while (eleccion != 3) {
                eleccion = Integer.parseInt(JOptionPane.showInputDialog(f, "Selecciona una opcion :\n1.Introducir coche\n2.Mostrar coches\n3.Salir"));

                switch (eleccion) {
                    case 1:
                        FileOutputStream fis = new FileOutputStream(archivo,true);
                        DataOutputStream out = new DataOutputStream(fis);
                        matricula = JOptionPane.showInputDialog(f, "Matricula:");
                        marca = JOptionPane.showInputDialog(f, "Marca:");
                        cantDeposito = Double.parseDouble(JOptionPane.showInputDialog(f, "Cantidad del deposito:"));
                        modelo = JOptionPane.showInputDialog(f, "Modelo:");

                        out.writeChars(matricula+"\n");
                        out.writeChars(marca+"\n");
                        out.writeDouble(cantDeposito);
                        out.writeChar('\t');
                        out.writeChars(modelo+"\n");
                        
                        out.close();
                        break;
                    case 2:
                        DataInputStream in = new DataInputStream(new FileInputStream(archivo));
                        while (in.read() != -1) {
                            matricula = in.readLine();
                            marca = in.readLine();
                            cantDeposito = in.readDouble();
                            modelo = in.readLine();
                            JOptionPane.showMessageDialog(f, "El vehículo tiene la matrícula "+matricula+
                                    ",su marca es "+marca+", el tamaño del deposito es de "+cantDeposito+" litros"+
                                    ", y su modelo es "+modelo);
                        }
                        in.close();
                        break;
                    case 3:
                        break;
                    default:
                        JOptionPane.showMessageDialog(f, "Ha elegido una opción incorrecta");
                }
            }
            
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(f, "Error al crear el archivo");
        }

    }

}
