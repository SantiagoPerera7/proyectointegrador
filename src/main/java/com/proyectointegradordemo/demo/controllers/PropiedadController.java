/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Propiedad;
import com.proyectointegradordemo.demo.exceptions.PropiedadException;
import com.proyectointegradordemo.demo.service.PropiedadService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Propiedad>> getPropiedades() {
        List<Propiedad> propiedades = propiedadService.getPropiedades();
        return ResponseEntity.ok(propiedades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPropiedad(@PathVariable int id) {
        Propiedad p = propiedadService.getPropiedad(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propiedad no encontrada con ID " + id);
    }

    @PostMapping
    public ResponseEntity<?> postPropiedad(@RequestBody Propiedad propiedad) {
        Propiedad propiedadGuardada = propiedadService.agregarPropiedad(propiedad);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(propiedadGuardada.getId())
                .toUri();
        return ResponseEntity.created(location).body(propiedadGuardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePropiedad(@PathVariable int id) {
        Propiedad propiedad = propiedadService.getPropiedad(id);
        if (propiedad != null) {
            propiedadService.eliminarPropiedad(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Propiedad eliminada con ID " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propiedad no encontrada con ID " + id);
    }
}
