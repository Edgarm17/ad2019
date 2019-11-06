/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provaSelect;

import java.sql.*;

/**
 *
 * @author vesprada
 */
public class NewClass {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        /*  
        
        -Statement -> SIN PARAMETROS
        -PreparedStatement -> PARAMETROS E / ??
        -CallableStatement -> PARAMETROS E/S/-> PROCEDIMIENTOS
        
        -executeQuery(...) -> SELECT
        -executeUpdate(...) -> INSERT,DELETE,UPDATE,DLL
        -execute() -> Método generico
        */
        
        
        
        //1. Cargar el driver
        
        Class.forName("com.mysql.jdbc.Driver");
        
        //2. Establecer la conexion
        
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/adt4_ejemplo0", "root", "");
        
        //3. Enviar sentencias
        
        String sql = "UPDATE articulos SET stock = ? WHERE id = ?;";
        
        PreparedStatement sentencia =conexion.prepareStatement(sql);
        sentencia.setInt(1, 100);
        sentencia.setInt(2, 1);
        
        int filas = sentencia.executeUpdate(); //Devuelve las filas afectadas
        
        //4. Procesar los resultados
        
        System.out.println("Filas afectadas: "+filas);
        
        //5. Cerrar conexiones
        
        sentencia.close();
        conexion.close();
        
    }
    
}
