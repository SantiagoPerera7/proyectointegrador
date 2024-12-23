/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.DTO.LiquidacionRequestDTO;
import com.proyectointegradordemo.demo.domain.Alquiler;
import com.proyectointegradordemo.demo.DTO.ReciboRequestDTO;
import com.proyectointegradordemo.demo.service.AlquilerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping("/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }
    
    @GetMapping
    public ResponseEntity<List<Alquiler>> getAlquileres() {
        List<Alquiler> propiedades = alquilerService.getAlquileres();
        return ResponseEntity.ok(propiedades);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAlquiler(@PathVariable int id) {
        Alquiler a = alquilerService.getAlquiler(id);
        if (a != null) {
            return ResponseEntity.ok(a);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alquiler no encontrado con ID " + id);
    }

    @PostMapping(value = "/generarPDF", consumes = "application/json")
public ResponseEntity<String> generarPDF(@RequestBody ReciboRequestDTO alquilerRequest) {
    try {
        // Llama al servicio para generar el PDF
         alquilerService.generarPDF(alquilerRequest);
        return ResponseEntity.ok("PDF generado correctamente.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al generar el PDF: " + e.getMessage());
    }
}

@PostMapping(value = "/generarLiquidacion", consumes = "application/json")
public ResponseEntity<String> generarLiquidacion(@RequestBody LiquidacionRequestDTO request) {
    try {
        // Llama al servicio para generar el PDF
         alquilerService.generarLiquidacion(request);
        return ResponseEntity.ok("PDF generado correctamente.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al generar el PDF: " + e.getMessage());
    }
}
}
