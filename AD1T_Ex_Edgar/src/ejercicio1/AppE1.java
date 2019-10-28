/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class AppE1 {

    static Scanner s = new Scanner(System.in);

    public static void menu() {
        System.out.println("1.Añadir jugador");
        System.out.println("2.Mostrar goleadores");
        System.out.println("3.Modificar goles jugador");
        System.out.println("4.Visualizar total goles por equipo");
        System.out.println("5.Salir");
    }

    public static void anyadirJugador(File fichero) {
        String nombre, equipo;
        int goles;

        if (!fichero.exists()) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

                System.out.println("Introduce el nombre del jugador: ");
                nombre = s.next();
                System.out.println("Equipo: ");
                equipo = s.next();
                System.out.println("Goles: ");
                goles = s.nextInt();

                Jugador j = new Jugador(nombre, equipo, goles);
                oos.writeObject(j);

                oos.close();
                System.out.println("Jugador añadido con éxito");

            } catch (FileNotFoundException ex) {
                System.out.println("No se ha encontrado el archivo");
            } catch (IOException ex) {
                System.out.println("Error en el archivo");
            }
        } else {
            try {
                AppendableObjectOutputStream ap = new AppendableObjectOutputStream(new FileOutputStream(fichero, true));
                System.out.println("Introduce el nombre del jugador: ");
                nombre = s.next();
                System.out.println("Equipo: ");
                equipo = s.next();
                System.out.println("Goles: ");
                goles = s.nextInt();

                Jugador j = new Jugador(nombre, equipo, goles);
                ap.writeObject(j);
                ap.close();
                System.out.println("Jugador añadido con éxito");

            } catch (FileNotFoundException ex) {
                System.out.println("No se ha encontrado el archivo");
            } catch (IOException ex) {
                System.out.println("Error en el archivo");
            }
        }
    }

    public static void leerGoleadores(File fichero) {
        String nombreEquipo;
        System.out.println("Nombre del equipo: ");
        nombreEquipo = s.next();
        boolean encontrado = false;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

            if (nombreEquipo.equals("equipos")) {

                Object obj = ois.readObject();

                while (obj != null) {
                    if (obj instanceof Jugador) {
                        Jugador j = new Jugador();
                        j = (Jugador) obj;
                        System.out.println(j.toString());
                    }
                    obj = ois.readObject();
                }

            } else {
                Object obj = ois.readObject();
                while (obj != null) {
                    if (obj instanceof Jugador) {
                        Jugador j = new Jugador();
                        j = (Jugador) obj;
                        if (j.getEquipo().equals(nombreEquipo)) {
                            System.out.println(j.toString());
                            encontrado = true;
                        }
                    }
                    obj = ois.readObject();
                }
            }

            if (!encontrado) {
                System.out.println("No se ha encontrado el equipo");
            }

            ois.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppE1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Final del fichero");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppE1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void modificarGoles(File fichero) {
        int golesASumar;
        String nombre;
        ArrayList<Jugador> jugadores = new ArrayList<>();

        System.out.println("Nombre jugador: ");
        nombre = s.next();
        System.out.println("Goles jornada: ");
        golesASumar = s.nextInt();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

            Object obj = ois.readObject();

            while (obj != null) {
                if (obj instanceof Jugador) {
                    Jugador j = new Jugador();
                    j = (Jugador) obj;
                    if (j.getNombre().equals(nombre)) {
                        j.setGoles(j.getGoles() + golesASumar);
                        jugadores.add(j);
                        System.out.println("Goles modificados");
                    } else {

                        j = (Jugador) obj;
                        jugadores.add(j);
                    }
                }
                obj = ois.readObject();
            }
            
            ois.close();
            
           
            
            

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException ex) {
            System.out.println("Final");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppE1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         fichero.delete();
            
            ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
            for (int i = 0; i < jugadores.size(); i++) {
                oos.writeObject(jugadores.get(i));
            }
            
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(AppE1.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            

    }

    public static void totalGoles(File fichero) {
        String nombreEquipo;
        System.out.println("Introduce el nombre del equipo: ");
        nombreEquipo = s.next();
        int goles = 0;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

            Object obj = ois.readObject();

            while (obj != null) {
                if (obj instanceof Jugador) {
                    Jugador j = new Jugador();
                    j = (Jugador) obj;
                    if (j.getEquipo().equals(nombreEquipo)) {
                        goles += j.getGoles();
                    }
                }
                obj = ois.readObject();
            }

            ois.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppE1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Final del fichero");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppE1.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Goles del " + nombreEquipo + ": " + goles);
    }

    public static void main(String[] args) {
        File fichero = new File("goleadores.dat");
        int eleccion = 0;

        while (eleccion != 5) {
            menu();
            eleccion = s.nextInt();
            switch (eleccion) {
                case 1:
                    anyadirJugador(fichero);
                    break;
                case 2:
                    leerGoleadores(fichero);
                    break;
                case 3:
                    modificarGoles(fichero);
                    break;
                case 4:
                    totalGoles(fichero);
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opcion incorrecta!");
            }
        }
    }

}
