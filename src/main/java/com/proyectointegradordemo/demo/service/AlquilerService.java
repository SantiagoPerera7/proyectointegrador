/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.DTO.LiquidacionRequestDTO;
import com.proyectointegradordemo.demo.domain.Alquiler;
import com.proyectointegradordemo.demo.DTO.ReciboRequestDTO;
import java.util.List;

/**
 *
 * @author santi
 */
public interface AlquilerService {
    public List<Alquiler> getAlquileres();
    public Alquiler getAlquiler(int id);
    public void generarPDF(ReciboRequestDTO request);
    public void generarLiquidacion(LiquidacionRequestDTO request);
}

