/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.FotoDAO;
import com.proyectointegradordemo.demo.domain.Foto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class FotoServiceImpl implements FotoService{
    @Autowired
    private FotoDAO fotoDAO;
    @Override
    @Transactional(readOnly=true)
    public List<Foto> getFotos(){
        return (List<Foto>) fotoDAO.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public Foto getFoto(int id){
        return fotoDAO.findById(id).orElse(null);
    }
    @Override
    @Transactional
        public Foto agregarFoto(Foto foto){
        return fotoDAO.save(foto);
    }
    @Override
    public void modificarFoto(Foto foto){
    }
    @Override
    @Transactional
    public void eliminarFoto(int id){
        fotoDAO.deleteById(id);
    }
    @Override
    public void modificarFotoParcial(Foto foto){
    }
}
