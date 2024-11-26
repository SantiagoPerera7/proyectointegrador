/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.domain.Cliente;
import com.proyectointegradordemo.demo.domain.Propiedad;
import com.proyectointegradordemo.demo.service.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clientesService;
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes=clientesService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    //@RequestMapping(value="/{id}",method= RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getCliente(@PathVariable int id) {
        Cliente c=clientesService.getCliente(id);
        if(c!=null){
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID "+id);
    }

    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Cliente cliente) {
        Cliente clienteGuardado=clientesService.agregarCliente(cliente);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteGuardado.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteGuardado);
    }
    //@RequestMapping(method=RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Cliente cliente){
        //boolean seActualizo = clientesService.modificarCliente(cliente);
        //if (seActualizo) {
            return ResponseEntity.noContent().build();
        //}
        //return ResponseEntity.notFound().build();
    }
//    //@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){
        //boolean clienteEncontradoYEliminado=clientesService.eliminarCliente(id);
        //if(clienteEncontradoYEliminado){
            return ResponseEntity.noContent().build();
        //}
        //return ResponseEntity.notFound().build();
    }
//    //@RequestMapping(method=RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Cliente cliente){
        //boolean seModifico= clientesService.modificarClienteParcial(cliente);
        //if(seModifico){
            return ResponseEntity.ok("Cliente modificado satisfactoriamente: "+cliente.getId());
        //}
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: "+cliente.getId());
    }
}
