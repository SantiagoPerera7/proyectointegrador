/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Contrato;
import com.proyectointegradordemo.demo.service.ContratoService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    private ContratoService contratoService;
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Contrato>> getContratos() {
        List<Contrato> contratos=contratoService.getContratos();
        return ResponseEntity.ok(contratos);
    }

    //@RequestMapping(value="/{id}",method= RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getContrato(@PathVariable int id) {
        Contrato c=contratoService.getContrato(id);
        if(c!=null){
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato no encontrado con ID "+id);
    }

    @PostMapping
    public ResponseEntity<?> postContrato(@RequestBody Contrato contrato) {
        Contrato contratoGuardado=contratoService.agregarContrato(contrato);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(contratoGuardado.getId())
                .toUri();
        return ResponseEntity.created(location).body(contratoGuardado);
    }
    //@RequestMapping(method=RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putContrato(@RequestBody Contrato contrato){
        //boolean seActualizo = clientesService.modificarCliente(cliente);
        //if (seActualizo) {
            return ResponseEntity.noContent().build();
        //}
        //return ResponseEntity.notFound().build();
    }
//    //@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContrato(@PathVariable int id){
        //boolean clienteEncontradoYEliminado=clientesService.eliminarCliente(id);
        //if(clienteEncontradoYEliminado){
            return ResponseEntity.noContent().build();
        //}
        //return ResponseEntity.notFound().build();
    }
//    //@RequestMapping(method=RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchContrato(@RequestBody Contrato contrato){
        //boolean seModifico= clientesService.modificarClienteParcial(cliente);
        //if(seModifico){
            return ResponseEntity.ok("Contrato modificado satisfactoriamente: "+contrato.getId());
        //}
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: "+cliente.getId());
    }
}
