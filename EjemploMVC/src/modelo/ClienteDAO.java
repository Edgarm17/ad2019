/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author vesprada
 */
public class ClienteDAO {
    
    public void insertarCliente(Cliente cliente){
        SingletonCustom singletonBBDD = SingletonCustom.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("INSERT INTO cliente VALUES (NULL,'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getNif()+"')");
            System.out.println("Cliente insertado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public Cliente obtenerCliente(int id){
        return new Cliente();
    }
    
    public void modificarCliente(Cliente cliente){
        
    }
    
    public void eliminarCliente(Cliente cliente){
        
    }
    
}
