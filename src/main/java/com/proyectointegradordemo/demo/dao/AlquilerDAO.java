/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.dao;

import com.proyectointegradordemo.demo.domain.Alquiler;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface AlquilerDAO extends CrudRepository<Alquiler,Integer>{
    
}
