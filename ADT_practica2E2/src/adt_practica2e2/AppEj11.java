/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica2e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar
 */
public class AppEj11 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        String texto="";
        File archivo = new File("ejercicio11.txt");
        
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            
            //Obrir la conexió
            URL url = new URL(JOptionPane.showInputDialog(f, "Introduce una URL: "));
            URLConnection con = url.openConnection();
            con.connect();
            
            //Llegir html
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            while (br.read() != -1) {
                texto+=br.readLine();
            }
            
            br.close();
            
            PrintWriter pr = new PrintWriter(archivo);
            pr.write(texto);
            
            
            JOptionPane.showMessageDialog(f, "Final");
            
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(f, "Error al leer url");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(f, "Error al conectar");
        }
    }
}
