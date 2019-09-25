/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica3;

import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vesprada
 */
public class Vehiculo implements Serializable{
    private String marca;
    private String modelo;
    private String matricula;
    private float potencia;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String matricula, float potencia, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.potencia = potencia;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public void mostrar() {
        JOptionPane.showMessageDialog(null, "El vehículo tiene la marca "+marca+
                                    ",su modelo es "+modelo+", la matricula "+matricula+", la potencia "+potencia+
                                    ", y su color es "+color);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", potencia=" + potencia + ", color=" + color + '}';
    }
    
    
    
    
}
