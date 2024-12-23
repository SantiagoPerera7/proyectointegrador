/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.TipoPropiedad;
import com.proyectointegradordemo.demo.service.TipoPropiedadService;
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
@RequestMapping("/tipospropiedad")
public class TipoPropiedadController {
    @Autowired
    private TipoPropiedadService tipoPropiedadService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
        public ResponseEntity<List<TipoPropiedad>> getTiposPropiedad() {
        List<TipoPropiedad> tiposPropiedad = tipoPropiedadService.getTiposPropiedad();
        return ResponseEntity.ok(tiposPropiedad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoPropiedad(@PathVariable int id) {
        TipoPropiedad t = tipoPropiedadService.getTipoPropiedad(id);
        if (t != null) {
            return ResponseEntity.ok(t);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de propiedad no encontrado con id: " + id);
    }
   @GetMapping("/obtenerTipoPropiedad/{nombre}")
public ResponseEntity<?> getCiudadPorNombre(@PathVariable String nombre) {
    try {
        // Decodificar el nombre recibido
        String nombreDecodificado = URLDecoder.decode(nombre, StandardCharsets.UTF_8.name());

        // Buscar la ciudad
        TipoPropiedad tp = tipoPropiedadService.getTipoPropiedadPorNombre(nombreDecodificado);
        if (tp != null) {
            return ResponseEntity.ok(tp);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tipo de propiedad no encontrado con nombre: " + nombreDecodificado);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error procesando la solicitud: " + e.getMessage());
    }
}
}
