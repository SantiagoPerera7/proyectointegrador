/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Cliente;
import com.proyectointegradordemo.demo.domain.Propiedad;
import java.util.List;

/**
 *
 * @author santi
 */
public interface PropiedadService {
    public List<Propiedad> getPropiedades();
    public Propiedad getPropiedad(int id);
    public Propiedad agregarPropiedad(Propiedad propiedad);
    public void modificarPropiedad(Cliente cliente);
    public void eliminarPropiedad(int id);
    public void modificarPropiedadParcial(Cliente cliente);
}