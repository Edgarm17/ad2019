/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vesprada
 */
public class SingletonCustom {
    
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String BD = "ejemploMVC";
    private String LOGIN = "root";
    private String PASSWORD = "";
    private String URL = "jdbc:mysql://localhost/" + BD;
    
    private static SingletonCustom singleton;
    private Connection conexion;
    
    private SingletonCustom(){
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error conexion "+e.getMessage());
        }
        
        
    }
    
    public static SingletonCustom crearSingletonBBDD(){
        if (singleton == null) {
            singleton = new SingletonCustom();
        }
        
        return singleton;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void desconectar(){
        try {
            singleton.conexion.close();
            System.out.println("Desconectado");
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
}
