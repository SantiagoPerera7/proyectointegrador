/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.BarrioDAO;
import com.proyectointegradordemo.demo.domain.Barrio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class BarrioServiceImpl implements BarrioService{

   @Autowired
    private BarrioDAO barrioDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Barrio> getBarrios() {
        return (List<Barrio>) barrioDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Barrio getBarrio(int id) {
        return barrioDAO.findById(id).orElse(null);
    }

    @Override
    public Barrio getBarrioPorNombre(String nombre) {
        return barrioDAO.findByNombre(nombre);
    }
    
}
