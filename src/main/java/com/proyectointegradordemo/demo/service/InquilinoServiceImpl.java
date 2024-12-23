/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.InquilinoDAO;
import com.proyectointegradordemo.demo.domain.Inquilino;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service

public class InquilinoServiceImpl implements InquilinoService{
    @Autowired
    private InquilinoDAO inquilinoDAO;
    @Override
    @Transactional(readOnly=true)
    public List<Inquilino> getInquilinos(){
        return (List<Inquilino>) inquilinoDAO.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public Inquilino getInquilino(int id){
        return inquilinoDAO.findById(id).orElse(null);
    }
}
