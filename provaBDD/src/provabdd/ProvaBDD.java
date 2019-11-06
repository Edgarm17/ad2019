/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provabdd;

import java.sql.*;

/**
 *
 * @author vesprada
 */
public class ProvaBDD {

    /**
     * @param args the command line arguments
     */
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
        
        String sql = "INSERT INTO articulos (nombre,precio,stock,descripcion) VALUES('Bicicleta',45.00, 5, 'BHH');";
        
        Statement sentencia = conexion.createStatement();
        
        int filas = sentencia.executeUpdate(sql); //Devuelve las filas afectadas
        
        //4. Procesar los resultados
        
        System.out.println("Filas afectadas: "+filas);
        
        //5. Cerrar conexiones
        
        sentencia.close();
        conexion.close();
        
    }
    
}
