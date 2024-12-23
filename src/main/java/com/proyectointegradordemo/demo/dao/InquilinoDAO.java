/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.dao;

import com.proyectointegradordemo.demo.domain.Inquilino;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface InquilinoDAO extends CrudRepository<Inquilino,Integer>{
    
}
