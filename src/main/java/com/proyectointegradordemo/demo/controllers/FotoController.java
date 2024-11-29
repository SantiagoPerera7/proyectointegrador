/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Foto;
import com.proyectointegradordemo.demo.service.FotoService;
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
@RequestMapping("/fotos") 
public class FotoController {
    @Autowired
    private FotoService fotoService;
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Foto>> getFotos() {
        List<Foto> fotos=fotoService.getFotos();
        return ResponseEntity.ok(fotos);
    }

    //@RequestMapping(value="/{id}",method= RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getFoto(@PathVariable int id) {
        Foto f=fotoService.getFoto(id);
        if(f!=null){
            return ResponseEntity.ok(f);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Foto no encontrada con ID "+id);
    }

    @PostMapping
    public ResponseEntity<?> postFoto(@RequestBody Foto foto) {
        Foto fotoGuardada=fotoService.agregarFoto(foto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(fotoGuardada.getId())
                .toUri();
        return ResponseEntity.created(location).body(fotoGuardada);
    }
    //@RequestMapping(method=RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putFoto(@RequestBody Foto foto){
        //boolean seActualizo = clientesService.modificarCliente(cliente);
        //if (seActualizo) {
            return ResponseEntity.noContent().build();
        //}
        //return ResponseEntity.notFound().build();
    }
//    //@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFoto(@PathVariable int id){
        //boolean clienteEncontradoYEliminado=clientesService.eliminarCliente(id);
        //if(clienteEncontradoYEliminado){
            return ResponseEntity.noContent().build();
        //}
        //return ResponseEntity.notFound().build();
    }
//    //@RequestMapping(method=RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchFoto(@RequestBody Foto foto){
        //boolean seModifico= clientesService.modificarClienteParcial(cliente);
        //if(seModifico){
            return ResponseEntity.ok("Foto modificada satisfactoriamente: "+foto.getId());
        //}
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: "+cliente.getId());
    }
}
