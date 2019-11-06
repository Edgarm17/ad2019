/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova3;
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
        
        String sql = "SELECT nombre,precio,stock FROM articulos;";
        
        Statement sentencia = conexion.createStatement();
        
        ResultSet filas = sentencia.executeQuery(sql); //Devuelve las filas afectadas
        
        //4. Procesar los resultados
        
        while (filas.next()) {
            String nombre = filas.getString("nombre");
            float precio = filas.getFloat("precio");
            int stock = filas.getInt("stock");
            
            System.out.println("FILA: " + nombre + " " + precio + " " + stock);
        }
        
        //5. Cerrar conexiones
        
        sentencia.close();
        conexion.close();
        
    }
}
