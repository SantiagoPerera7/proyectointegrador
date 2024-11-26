/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.domain;

import com.proyectointegradordemo.demo.exceptions.UsuarioException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author santi
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID=1L;
    public Usuario(){
        
    }
    public Usuario(String nombreUsuario,String contrasena){
        this.usuario=nombreUsuario;
        this.password=contrasena;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    
    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getId(){
        return idusuario;
    }
    
    public void validar() throws UsuarioException{
        if(usuario==null||usuario.isEmpty()){
            throw new UsuarioException("El nombre de usuario no puede ser vacío");
        }
        if(password==null||password.isEmpty()){
            throw new UsuarioException("La contraseña no puede ser vacía");
        }
    }
}
