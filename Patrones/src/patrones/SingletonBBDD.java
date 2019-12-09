/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones;

import java.sql.*;

/**
 *
 * @author vesprada
 */
public class SingletonBBDD {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String BD = "adt4_ejemplo2";
    private String LOGIN = "root";
    private String PASSWORD = "";
    private String URL = "jdbc:mysql://localhost/" + BD;
    
    private static SingletonBBDD singleton;
    private Connection conexion;
    
    private SingletonBBDD(){
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error conexion "+e.getMessage());
        }
        
        
    }
    
    public static SingletonBBDD crearSingletonBBDD(){
        if (singleton == null) {
            singleton = new SingletonBBDD();
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
