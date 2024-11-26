/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    @Column(name = "nombre_cliente")
    private String nombre;
    @Column(name = "apellido_cliente")
    private String apellido;
    @Column(name = "direccion_cliente")
    private String direccion;
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Propiedad> propiedades = new ArrayList<>();
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Contrato> contratos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
        contrato.setCliente(this);
    }

    public void eliminarContrato(Contrato contrato) {
        contratos.remove(contrato);
        contrato.setCliente(null);
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

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public void agregarPropiedad(Propiedad p) {
        propiedades.add(p);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " - " + this.direccion;
    }
}
