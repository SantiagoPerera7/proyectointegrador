/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.CiudadDAO;
import com.proyectointegradordemo.demo.domain.Ciudad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class CiudadServiceImpl implements CiudadService{

   @Autowired
    private CiudadDAO ciudadDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Ciudad> getCiudades() {
        return (List<Ciudad>) ciudadDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ciudad getCiudad(int id) {
        return ciudadDAO.findById(id).orElse(null);
    }

    @Override
    public Ciudad getCiudadPorNombre(String nombre) {
        return ciudadDAO.findByNombre(nombre);
    }
    
}
