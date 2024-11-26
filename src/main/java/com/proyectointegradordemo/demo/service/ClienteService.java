/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Cliente;
import com.proyectointegradordemo.demo.domain.Propiedad;
import java.util.List;

/**
 *
 * @author santi
 */
public interface ClienteService {
    public List<Cliente> getClientes();
    public Cliente getCliente(int id);
    public Cliente agregarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public void eliminarCliente(int id);
    public void modificarClienteParcial(Cliente cliente);
}
