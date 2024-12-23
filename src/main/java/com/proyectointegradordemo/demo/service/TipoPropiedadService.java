/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.TipoPropiedad;
import java.util.List;

/**
 *
 * @author santi
 */
public interface TipoPropiedadService {
    public List<TipoPropiedad> getTiposPropiedad();
    public TipoPropiedad getTipoPropiedad(int id);
    public TipoPropiedad getTipoPropiedadPorNombre(String nombre);
}
