/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.TipoTechoDAO;
import com.proyectointegradordemo.demo.domain.TipoTecho;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class TipoTechoServiceImpl implements TipoTechoService{
    @Autowired
    private TipoTechoDAO tipoTechoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoTecho> getTiposTecho() {
        return (List<TipoTecho>) tipoTechoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoTecho getTipoTecho(int id) {
        return tipoTechoDAO.findById(id).orElse(null);
    }

    @Override
    public TipoTecho getTipoTechoPorNombre(String nombre) {
        return tipoTechoDAO.findByNombre(nombre);
    }
    
}
