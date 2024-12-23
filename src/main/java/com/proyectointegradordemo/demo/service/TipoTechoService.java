/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.TipoTecho;
import java.util.List;

/**
 *
 * @author santi
 */
public interface TipoTechoService {
    public List<TipoTecho> getTiposTecho();
    public TipoTecho getTipoTecho(int id);
    public TipoTecho getTipoTechoPorNombre(String nombre);
}
