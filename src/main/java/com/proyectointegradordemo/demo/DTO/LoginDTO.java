/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.DTO;

import com.proyectointegradordemo.demo.domain.Usuario;

/**
 *
 * @author Ulx
 */
public class LoginDTO {
    
    private String mensaje;

    // Constructor
    public LoginDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getters y setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
