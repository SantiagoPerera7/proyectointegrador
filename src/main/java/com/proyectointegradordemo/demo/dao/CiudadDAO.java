/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.dao;

import com.proyectointegradordemo.demo.domain.Ciudad;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface CiudadDAO extends CrudRepository<Ciudad,Integer>{
    Ciudad findByNombre(String nombre);
}
