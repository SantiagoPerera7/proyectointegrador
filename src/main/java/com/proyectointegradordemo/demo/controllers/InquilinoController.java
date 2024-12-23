/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Inquilino;
import com.proyectointegradordemo.demo.service.InquilinoService;
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
@RequestMapping("/inquilinos")
public class InquilinoController {
    @Autowired
    private InquilinoService inquilinoService;
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Inquilino>> getInquilinos() {
        List<Inquilino> inquilinos=inquilinoService.getInquilinos();
        return ResponseEntity.ok(inquilinos);
    }

    //@RequestMapping(value="/{id}",method= RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getInquilino(@PathVariable int id) {
        Inquilino i=inquilinoService.getInquilino(id);
        if(i!=null){
            return ResponseEntity.ok(i);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inquilino no encontrado con ID "+id);
    }
}
