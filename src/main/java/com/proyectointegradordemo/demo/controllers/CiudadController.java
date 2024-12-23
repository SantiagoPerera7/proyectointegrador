/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Ciudad;
import com.proyectointegradordemo.demo.service.CiudadService;
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
@RequestMapping("/ciudades")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
        public ResponseEntity<List<Ciudad>> getCiudades() {
        List<Ciudad> ciudades = ciudadService.getCiudades();
        return ResponseEntity.ok(ciudades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCiudad(@PathVariable int id) {
        Ciudad c = ciudadService.getCiudad(id);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ciudad no encontrada con id: " + id);
    }
   @GetMapping("/obtenerCiudad/{nombre}")
public ResponseEntity<?> getCiudadPorNombre(@PathVariable String nombre) {
    try {
        // Decodificar el nombre recibido
        String nombreDecodificado = URLDecoder.decode(nombre, StandardCharsets.UTF_8.name());

        // Buscar la ciudad
        Ciudad c = ciudadService.getCiudadPorNombre(nombreDecodificado);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ciudad no encontrada con nombre: " + nombreDecodificado);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error procesando la solicitud: " + e.getMessage());
    }
}
}
