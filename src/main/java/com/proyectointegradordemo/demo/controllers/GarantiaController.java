/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Garantia;
import com.proyectointegradordemo.demo.service.GarantiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping("/garantias")
public class GarantiaController {
    @Autowired
    private GarantiaService garantiaService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
        public ResponseEntity<List<Garantia>> getGarantias() {
        List<Garantia> garantias = garantiaService.getGarantias();
        return ResponseEntity.ok(garantias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGarantia(@PathVariable int id) {
        Garantia g = garantiaService.getGarantia(id);
        if (g != null) {
            return ResponseEntity.ok(g);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Garantía no encontrada con ID "+id);
    }
}