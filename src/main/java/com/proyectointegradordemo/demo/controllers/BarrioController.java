/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Barrio;
import com.proyectointegradordemo.demo.service.BarrioService;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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
@RequestMapping("/barrios")
public class BarrioController {
    @Autowired
    private BarrioService barrioService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
        public ResponseEntity<List<Barrio>> getBarrios() {
        List<Barrio> barrios = barrioService.getBarrios();
        return ResponseEntity.ok(barrios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBarrio(@PathVariable int id) {
        Barrio b = barrioService.getBarrio(id);
        if (b != null) {
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barrio no encontrado con id: " + id);
    }
   @GetMapping("/obtenerBarrio/{nombre}")
public ResponseEntity<?> getBarrioPorNombre(@PathVariable String nombre) {
    try {
        // Decodificar el nombre recibido
        String nombreDecodificado = URLDecoder.decode(nombre, StandardCharsets.UTF_8.name());

        // Buscar la ciudad
        Barrio b = barrioService.getBarrioPorNombre(nombreDecodificado);
        if (b != null) {
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Barrio no encontrado con nombre: " + nombreDecodificado);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error procesando la solicitud: " + e.getMessage());
    }
}
}

