/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica3;

import java.io.File;
import java.io.FileInputStream;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int eleccion = 0;
        String marca,modelo,matricula,color;
        float potencia;
        File archivo = new File("vehiculo.bin");
        
        try {
            
//            if (!archivo.exists()) {
//                archivo.createNewFile();
//            }

            while (eleccion != 3) {
                
                
                

                eleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion :\n1.Introducir coche\n2.Mostrar coches\n3.Salir"));
            
                switch (eleccion) {
                    case 1:
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo,true));
                            // MiObjectOutputStream mois = new MiObjectOutputStream(out);
                        
                            marca = JOptionPane.showInputDialog(null, "Marca:");
                            modelo = JOptionPane.showInputDialog(null, "Modelo:");
                            matricula = JOptionPane.showInputDialog(null, "Matricula:");
                            potencia = Float.parseFloat(JOptionPane.showInputDialog(null, "Potencia:"));
                            color = matricula = JOptionPane.showInputDialog(null, "Color:");

                            Vehiculo v = new Vehiculo(marca,modelo,matricula,potencia,color);
                            System.out.println("Vehiculo " +v);
                            out.writeObject(v);
                            
                            out.close();
                        

                        break;
                    case 2:
                        
                        ObjectInputStream ins = new ObjectInputStream(new FileInputStream(archivo));
                        Vehiculo v1 = (Vehiculo) ins.readObject();
                        
                        while (v1 != null) {
                            v1.mostrar();
                            v1 = (Vehiculo) ins.readObject();
                           
                        }
                        
                        
                    case 3:

                        break;
                    default:
                        throw new AssertionError();
                }
                
                ins.close();
                
            }   
            
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fin");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppEj1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
