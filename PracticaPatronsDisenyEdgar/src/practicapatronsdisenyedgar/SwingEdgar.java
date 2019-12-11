/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapatronsdisenyedgar;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author vesprada
 */
public class SwingEdgar extends JFrame implements ActionListener, ItemListener{

    private JMenuBar barra;
    private JMenu biblioteca,salirMenu;
    private JMenuItem socios, libros, prestamos, salir;
    
    
    
    public static void main(String[] args) {
        SwingEdgar swing = new SwingEdgar();
    }
    
    public SwingEdgar(){
        super("Pantalla principal");
        setBounds(200, 200, 1200, 800);
        setBounds(200,200,400,400);
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        crearMenu();
        
        setResizable(true);
        setVisible(true);
    }
    
    public void crearMenu(){
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        biblioteca = new JMenu("Biblioteca");
        salirMenu = new JMenu("Salir");
        
        socios = new JMenuItem("Socios");
        libros = new JMenuItem("Libros");
        prestamos = new JMenuItem("Préstamos");
        salir = new JMenuItem("Salir");
        
        socios.addActionListener(this);
        libros.addActionListener(this);
        prestamos.addActionListener(this);
        salir.addActionListener(this);
        
        biblioteca.add(socios);
        biblioteca.add(libros);
        biblioteca.add(prestamos);
        
        salirMenu.add(salir);
        
        barra.add(biblioteca);
        barra.add(salirMenu);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container contenedor = this.getContentPane();
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
