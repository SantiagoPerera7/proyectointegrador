/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.ClienteDAO;
import com.proyectointegradordemo.demo.domain.Cliente;
import com.proyectointegradordemo.demo.domain.Propiedad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service

public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDAO clienteDAO;
    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes(){
        return (List<Cliente>) clienteDAO.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(int id){
        return clienteDAO.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public Cliente agregarCliente(Cliente cliente){
        if (cliente.getPropiedades() != null) {
        for (Propiedad propiedad : cliente.getPropiedades()) {
            propiedad.setPropietario(cliente); // Asignamos el cliente como propietario de la propiedad
        }
        }
        return clienteDAO.save(cliente);
    }
    @Override
    public void modificarCliente(Cliente cliente){
    }
    @Override
    @Transactional
    public void eliminarCliente(int id){
        clienteDAO.deleteById(id);
    }
    @Override
    public void modificarClienteParcial(Cliente cliente){
    }
}
