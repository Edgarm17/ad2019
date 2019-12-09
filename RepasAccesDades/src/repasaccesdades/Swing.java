/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasaccesdades;

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
public class Swing extends JFrame implements ActionListener, ItemListener{
    
    private JLabel saludo;
    private JButton btn;
    private JTextField texto;
    private JTextArea textoDescripcion;
    private JScrollPane scroll;
    private JComboBox combo;
    
    private JMenuBar barra;
    private JMenu menuColor, opcionSalir;
    private JMenuItem itemColor1, itemColor2, itemColor3;

    public Swing(){
        super("Pantalla Principal");
        setBounds(200,200,400,400);
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        crearLabel();
        crearButton();
        crearTextField();
        crearTextArea();
        crearComboBox();
        crearBarraMenu();
        
        setResizable(true);
        setVisible(true);
        
    }
    
    public void crearBarraMenu(){
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        menuColor = new JMenu("Color");
        barra.add(menuColor);
        
        itemColor1 = new JMenuItem("Rojo");
        itemColor2 = new JMenuItem("Verde");
        itemColor3 = new JMenuItem("Azul");
        
        itemColor1.addActionListener(this);
        itemColor2.addActionListener(this);
        itemColor3.addActionListener(this);
        
        menuColor.add(itemColor1);
        menuColor.add(itemColor2);
        menuColor.add(itemColor3);
        
        opcionSalir = new JMenu("Salir");
        barra.add(opcionSalir);
        opcionSalir.addActionListener(this);
        
    }
    
    public void crearComboBox(){
        combo = new JComboBox();
        combo.setBounds(200, 50, 100, 40);
        for (int i = 0; i < 10; i++) {
            combo.addItem("item "+i);
        }
        combo.addItemListener(this);
        add(combo);
    }
    
    public void crearTextField(){
        texto = new JTextField();
        texto.setBounds(50, 300, 100, 50);
        add(texto);
        
    }
    
    public void crearLabel(){
        saludo = new JLabel();
        saludo.setText("Yeeee");
        saludo.setBounds(50, 50, 100, 50);
        add(saludo);
    }
    
    public void crearButton(){
        btn = new JButton();
        btn.setText("Saludar");
        btn.setBounds(50 , 200, 199, 50);
        btn.addActionListener(this);
        add(btn);
    }
    
    public void crearTextArea(){
        textoDescripcion = new JTextArea();
                
        scroll = new JScrollPane(textoDescripcion);
        scroll.setBounds(300, 50, 70, 100);
        add(scroll);
    }
    
    public static void main(String[] args) {
        Swing swing = new Swing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container contenedor = this.getContentPane();
        if (e.getSource()==btn) {
            saludo.setText("Hola "+texto.getText());
        }else if (e.getSource() == itemColor1) {
            contenedor.setBackground(Color.red);
        }else if (e.getSource() == itemColor2) {
            contenedor.setBackground(Color.green);
        }else if (e.getSource() == itemColor3) {
            contenedor.setBackground(Color.blue);
        }else if (e.getSource() == opcionSalir){
            System.exit(0);
        }
    }
    
    public void itemStateChanged(ItemEvent e){
        
        
        if (e.getSource() == combo) {
            saludo.setText("Hola "+combo.getSelectedItem().toString());
        }
        
        
    }
    
}
