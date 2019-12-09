/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cliente;
import modelo.ClienteDAO;
import vista.VistaClientes;

/**
 *
 * @author vesprada
 */
public class Controlador {
    
    private ClienteDAO clienteDAO;
    private VistaClientes vistaClientes;

    public Controlador(ClienteDAO cliente, VistaClientes vistaClientes) {
        this.clienteDAO = cliente;
        this.vistaClientes = vistaClientes;
    }

    public Controlador() {
        
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO cliente) {
        this.clienteDAO = cliente;
    }

    public VistaClientes getVistaClientes() {
        return vistaClientes;
    }

    public void setVistaClientes(VistaClientes vistaClientes) {
        this.vistaClientes = vistaClientes;
    }
    
    public void anyadirCliente(){
        Cliente nuevoCliente = new Cliente(vistaClientes.getTfNombre().getText(), vistaClientes.getTfApellido().getText(), vistaClientes.getTfDni().getText());
        clienteDAO.insertarCliente(nuevoCliente);
    }
    
    
   
    
}
