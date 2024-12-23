/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Barrio;
import java.util.List;

/**
 *
 * @author santi
 */
public interface BarrioService {
    public List<Barrio> getBarrios();
    public Barrio getBarrio(int id);
    public Barrio getBarrioPorNombre(String nombre);
}
