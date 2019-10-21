/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt4_practica1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author vesprada
 */
public class Avion extends JFrame {

    private final int FILAS_AVION = 3;
    private final int COLUMNAS_AVION = 5;
    private JButton[][] asientos = new JButton[FILAS_AVION][COLUMNAS_AVION];
    private int reservas = 0;

    public Avion() {

        setLayout(new BorderLayout());

        JLabel arriba = new JLabel("AeroLineas Simarro", SwingConstants.CENTER);
        JLabel abajo = new JLabel("Reservas: "+reservas);
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(FILAS_AVION, COLUMNAS_AVION);

        ImageIcon img = new ImageIcon("img/asiento.png");
        for (int i = 0; i < FILAS_AVION; i++) {
            for (int j = 0; j < COLUMNAS_AVION; j++) {
                asientos[i][j] = new JButton();
                asientos[i][j].setIcon(img);
                asientos[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        if (btn.getIcon().toString().equals("img/asiento.png")) {
                            int input = JOptionPane.showConfirmDialog(null, "Estas seguro de reservar el asiento?");
                            if (input == 0) {

                                btn.setIcon(new ImageIcon("img/asientoOcupado.png"));
                                reservas++;
                                abajo.setText("Reservas: "+reservas);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El asiento ya esta reservado");
                        }

                    }
                });
                panel.add(asientos[i][j]);

            }
        }

        panel.setLayout(grid);
        add(panel, BorderLayout.CENTER);
        add(arriba, BorderLayout.NORTH);
        add(abajo,BorderLayout.SOUTH);
        pack();

        setVisible(true);
    }

}
