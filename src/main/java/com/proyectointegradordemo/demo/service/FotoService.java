/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Foto;
import java.util.List;

/**
 *
 * @author santi
 */
public interface FotoService {
    public List<Foto> getFotos();
    public Foto getFoto(int id);
    public Foto agregarFoto(Foto foto);
    public void modificarFoto(Foto foto);
    public void eliminarFoto(int id);
    public void modificarFotoParcial(Foto foto);
}
