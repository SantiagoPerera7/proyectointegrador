/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.domain.Contrato;
import java.util.List;

/**
 *
 * @author santi
 */
public interface ContratoService {
    public List<Contrato> getContratos();
    public Contrato getContrato(int id);
    public Contrato agregarContrato(Contrato contrato);
    public void modificarContrato(Contrato contrato);
    public void eliminarContrato(int id);
    public void modificarContratoParcial(Contrato contrato);
}