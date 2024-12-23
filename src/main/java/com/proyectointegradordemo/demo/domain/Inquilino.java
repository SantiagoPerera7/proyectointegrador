/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectointegradordemo.demo.exceptions.ClienteException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "inquilino")
public class Inquilino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inquilino")
    private Integer id;
    @Column(name = "nombre_inquilino")
    private String nombre;
    @Column(name = "apellido_inquilino")
    private String apellido;
    @Column(name = "direccion_inquilino")
    private String direccion;
    //@OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonBackReference("inquilino-alquileres")
    //private List<Alquiler> alquileres = new ArrayList<>();


    public Inquilino() {
    }

    public Inquilino(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void validar() throws ClienteException {
        if (nombre == null || nombre.isEmpty()) {
            throw new ClienteException("El nombre del cliente no puede ser vacío");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new ClienteException("El apellido del cliente no puede ser vacío");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new ClienteException("La dirección del cliente no puede ser vacía");
        }
    }
    //public List<Alquiler> getAlquileres() {
    //    return alquileres;
    //}

    //public void setAlquileres(List<Alquiler> alquileres) {
    //    this.alquileres = alquileres;
    //}

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " - " + this.direccion;
    }
}
