/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.GarantiaDAO;
import com.proyectointegradordemo.demo.domain.Garantia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class GarantiaServiceImpl implements GarantiaService{

   @Autowired
    private GarantiaDAO garantiaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Garantia> getGarantias() {
        return (List<Garantia>) garantiaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Garantia getGarantia(int id) {
        return garantiaDAO.findById(id).orElse(null);
    }
    
}
