/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Ciudad;
import java.util.List;

/**
 *
 * @author santi
 */
public interface CiudadService {
    public List<Ciudad> getCiudades();
    public Ciudad getCiudad(int id);
    public Ciudad getCiudadPorNombre(String nombre);
}
