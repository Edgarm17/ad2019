/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplomvc;

import controlador.ControladorClientes;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.SingletonCustom;
import vista.VistaClientes;

/**
 *
 * @author vesprada
 */
public class EjemploMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        SingletonCustom singleton = SingletonCustom.crearSingletonBBDD();
//        
        ClienteDAO cdao = new ClienteDAO();
//        cdao.insertarCliente(new Cliente("Alex","Cipote","20545877C"));

        VistaClientes vista = new VistaClientes();
        ControladorClientes controlador = new ControladorClientes();
        
        controlador.setVistaClientes(vista);
        controlador.setClienteDAO(cdao);
        
        vista.setControlador(controlador);
        vista.setVisible(true);
    }
    
}
