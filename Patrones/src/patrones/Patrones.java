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
public class Patrones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        PatronSingleton patron1 = PatronSingleton.crearSingleton(1, 1);
//        PatronSingleton patron2 = PatronSingleton.crearSingleton(2, 2);
//        
//        System.out.println("Puntuacion patron1 "+patron1.getPuntuacion());
//        System.out.println("Puntuacion patron2 "+patron2.getPuntuacion());
//        
//        patron2.setPuntuacion(5);
//        System.out.println("Puntuacion patron1 "+patron1.getPuntuacion());

        SingletonBBDD singleton = SingletonBBDD.crearSingletonBBDD();
    }
    
}
