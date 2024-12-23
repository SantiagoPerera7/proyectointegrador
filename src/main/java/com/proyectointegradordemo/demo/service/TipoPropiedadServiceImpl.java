/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.TipoPropiedadDAO;
import com.proyectointegradordemo.demo.domain.TipoPropiedad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class TipoPropiedadServiceImpl implements TipoPropiedadService{
    @Autowired
    private TipoPropiedadDAO tipoPropiedadDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoPropiedad> getTiposPropiedad() {
        return (List<TipoPropiedad>) tipoPropiedadDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoPropiedad getTipoPropiedad(int id) {
        return tipoPropiedadDAO.findById(id).orElse(null);
    }

    @Override
    public TipoPropiedad getTipoPropiedadPorNombre(String nombre) {
        return tipoPropiedadDAO.findByNombre(nombre);
    }
    
}
