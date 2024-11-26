/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.PropiedadDAO;
import com.proyectointegradordemo.demo.domain.Cliente;
import com.proyectointegradordemo.demo.domain.Propiedad;
import com.proyectointegradordemo.demo.exceptions.PropiedadException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class PropiedadServiceImpl implements PropiedadService {

    @Autowired
    private PropiedadDAO propiedadDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Propiedad> getPropiedades() {
        return (List<Propiedad>) propiedadDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propiedad getPropiedad(int id) {
        return propiedadDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Propiedad agregarPropiedad(Propiedad propiedad) {
        return propiedadDAO.save(propiedad);
    }

    @Override
    public void modificarPropiedad(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public void eliminarPropiedad(int id) {
        if (propiedadDAO.existsById(id)) {
            propiedadDAO.deleteById(id);
        } else {
            throw new PropiedadException("La propiedad con ID " + id + " no existe.");
        }
    }

    @Override
    public void modificarPropiedadParcial(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
