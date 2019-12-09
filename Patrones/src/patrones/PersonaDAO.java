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
public class PersonaDAO {
    
    public void insertarPersona(Persona persona){
        SingletonBBDD singletonBBDD = SingletonBBDD.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("INSERT INTO");
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public Persona obtenerPersona(int id){
        return new Persona();
    }
    
    public void modificarPersona(Persona persona){
        
    }
    
    public void eliminarPersona(Persona persona){
        
    }
    
    public void delete(){
        
    }
    
}
