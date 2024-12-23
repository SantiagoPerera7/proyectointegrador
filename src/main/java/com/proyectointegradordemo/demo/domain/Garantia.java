/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "garantia")
public class Garantia implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_garantia")
    private Integer id;
    @Column(name = "nombre_garantia")
    private String nombre;
    //@OneToMany(mappedBy = "tipoGarantia", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonBackReference("garantia-alquileres")
    //private List<Alquiler> alquileres;
    public Garantia(){
    
    }
    public Garantia(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public List<Alquiler> getAlquileres() {
    //    return alquileres;
    //}

    //public void setAlquileres(List<Alquiler> alquileres) {
    //    this.alquileres = alquileres;
    //}
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}
