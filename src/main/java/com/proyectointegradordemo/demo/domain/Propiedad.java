/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectointegradordemo.demo.exceptions.PropiedadException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author santi
 */
@Entity
@Table(name="propiedad")
public class Propiedad {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_propiedad")
    private Integer id;
    @Column(name = "direccion_propiedad")
    private String direccion;
    @Column(name = "descripcion_propiedad")
    private String descripcion;
//    @Column(name = "cantidadbanios_propiedad")
//    private Integer cantidadBanios;
//    @Column(name = "cantidadambientes_propiedad")
//    private Integer cantidadAmbientes;
//    @Column(name = "cantidadcocheras_propiedad")
//    private Integer cantidadCocheras;
//    @Column(name = "barrio_propiedad")
//    private String barrioPropiedad;
//    @Column(name = "ciudad_propiedad")
//    private String ciudadPropiedad;
//    @Column(name = "cantidadplantas_propiedad")
//    private Integer cantidadPlantasPropiedad;
//    @Column(name = "aceptamascotas_propiedad")
//    private boolean aceptaMascotas;
//    @Column(name = "tipo_propiedad")
//    private String tipo;
//    @Column(name = "importealquiler_propiedad")
//    private Integer importeAlquiler;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    public Cliente propietario;
    public Propiedad(){
    }
    public Propiedad(String direccion, String descripcion, Cliente propietario){
        this.direccion=direccion;
        this.descripcion=descripcion;
        this.propietario=propietario;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
    public void validar() throws PropiedadException{
        if(direccion.isEmpty()||direccion==null){
            throw new PropiedadException("La dirección de la propiedad no puede ser nula");
        }
        if(descripcion.isEmpty()||descripcion==null){
            throw new PropiedadException("La descripción de la propiedad no puede ser nula");
        }
        if(propietario==null){
            throw new PropiedadException("La propiedad debe tener asignado un propietario");
        }
    }
    @Override
    public String toString(){
        return this.descripcion+" - "+this.direccion;
    }
}
