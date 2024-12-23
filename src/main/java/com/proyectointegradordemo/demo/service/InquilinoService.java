/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Inquilino;
import java.util.List;

/**
 *
 * @author santi
 */
public interface InquilinoService {
    public List<Inquilino> getInquilinos();
    public Inquilino getInquilino(int id);
}
