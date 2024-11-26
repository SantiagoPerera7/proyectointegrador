/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.controllers;

import com.proyectointegradordemo.demo.DTO.LoginDTO;
import com.proyectointegradordemo.demo.dao.UsuarioDAO;
import com.proyectointegradordemo.demo.domain.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santi
 */
@RestController
public class LoginController {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody Usuario usuario) {
        // Busca el usuario en la base de datos
        Optional<Usuario> usuarioExistente = usuarioDAO.findByUsuario(usuario.getUsuario());

        if (usuarioExistente.isPresent()) {
            // Verifica si la contraseña es correcta
            if (usuarioExistente.get().getPassword().equals(usuario.getPassword())) {
                 Usuario usuarioResponse = usuarioExistente.get(); //esta correcto obtener esto o es lo mismo hacerlo directo?
                 LoginDTO loginDTO = new LoginDTO("Login exitoso");
                return ResponseEntity.ok(loginDTO);
            } else {
                LoginDTO loginDTO = new LoginDTO("Contraseña incorrecta");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginDTO);
            }
        } else {
            LoginDTO loginDTO = new LoginDTO("Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginDTO); 
        }
    }
}
