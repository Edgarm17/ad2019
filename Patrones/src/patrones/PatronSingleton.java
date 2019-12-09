/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones;

/**
 *
 * @author vesprada
 */
public class PatronSingleton {
    
    private int puntuacion;
    private int tiempoPartida;
    
    private static PatronSingleton singleton;
    
    private PatronSingleton(int puntuacion, int tiempoPartida){
        this.puntuacion = puntuacion;
        this.tiempoPartida = tiempoPartida;
        System.out.println("Crea patron con puntuacion "+puntuacion+" y tiempo de partida"+tiempoPartida);
    }
    
    public static PatronSingleton crearSingleton(int puntuacion, int tiempoPartida){
        if (singleton == null) {
            singleton = new PatronSingleton(puntuacion, tiempoPartida);
                   
        }else{
            System.out.println("Ya se ha creado el singleton");
        }
        
        return singleton;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getTiempoPartida() {
        return tiempoPartida;
    }

    public void setTiempoPartida(int tiempoPartida) {
        this.tiempoPartida = tiempoPartida;
    }
    
    
    
}
