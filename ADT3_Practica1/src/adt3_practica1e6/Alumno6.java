/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1e6;


/**
 *
 * @author vesprada
 */
public class Alumno6 {
    private int id;
    private String nom;
    private String cognom;
    private String curs;
    private float nota;

    public Alumno6(int id, String nom, String cognom, String curs) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.curs = curs;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Alumno6() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }
    
    
    
}
