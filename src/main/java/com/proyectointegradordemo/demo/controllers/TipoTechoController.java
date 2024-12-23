/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.TipoTecho;
import com.proyectointegradordemo.demo.service.TipoTechoService;
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
@RequestMapping("/tipostecho")
public class TipoTechoController {

    @Autowired
    private TipoTechoService tipoTechoService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
        public ResponseEntity<List<TipoTecho>> getTiposTecho() {
        List<TipoTecho> tiposTecho = tipoTechoService.getTiposTecho();
        return ResponseEntity.ok(tiposTecho);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoTecho(@PathVariable int id) {
        TipoTecho t = tipoTechoService.getTipoTecho(id);
        if (t != null) {
            return ResponseEntity.ok(t);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de techo no encontrado con id: " + id);
    }
    @GetMapping("/nombre/{nombre}")
        public ResponseEntity<?> getTipoTechoPorNombre(@PathVariable String nombre) {
            TipoTecho t = tipoTechoService.getTipoTechoPorNombre(nombre);
            if (t != null) {
                return ResponseEntity.ok(t);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de techo no encontrado con nombre: " + nombre);
    }
}
