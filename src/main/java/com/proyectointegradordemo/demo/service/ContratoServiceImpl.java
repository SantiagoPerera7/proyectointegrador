/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.ContratoDAO;
import com.proyectointegradordemo.demo.domain.Contrato;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class ContratoServiceImpl implements ContratoService{
    @Autowired
    private ContratoDAO contratoDAO;
    @Override
    @Transactional(readOnly=true)
    public List<Contrato> getContratos(){
        return (List<Contrato>) contratoDAO.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public Contrato getContrato(int id){
        return contratoDAO.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public Contrato agregarContrato(Contrato contrato){
        return contratoDAO.save(contrato);
    }
    @Override
    public void modificarContrato(Contrato contrato){
    }
    @Override
    @Transactional
    public void eliminarContrato(int id){
        contratoDAO.deleteById(id);
    }
    @Override
    public void modificarContratoParcial(Contrato contrato){
    }
}
