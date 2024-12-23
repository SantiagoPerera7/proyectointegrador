/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Garantia;
import java.util.List;

/**
 *
 * @author santi
 */
public interface GarantiaService {
    public List<Garantia> getGarantias();
    public Garantia getGarantia(int id);
}
