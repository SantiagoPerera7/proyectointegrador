//*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package com.proyectointegradordemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

///**
// *
// * @author santi
// */
@Entity
@Table(name = "alquiler")
public class Alquiler implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Integer id;
    @Column(name = "exoneraIRPF_alquiler")
    private Boolean exoneraIRPF;
    @OneToOne
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id_propiedad", unique = true)
    @JsonManagedReference("propiedad-alquiler")
    private Propiedad propiedad;
    @OneToOne
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato", unique = true)
    @JsonManagedReference("contrato-alquiler")
    private Contrato contrato;
    @Column(name = "importe_alquiler")
    private Double importe;
    @ManyToOne
    @JoinColumn(name = "id_garantia")
    private Garantia tipoGarantia;
    @ManyToOne
    @JoinColumn(name = "id_inquilino")
    private Inquilino inquilino;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference("cliente-alquileres")
    private Cliente propietario;
    public Alquiler(){
        
    }
    public Alquiler(Boolean exoneraIRPF,Propiedad propiedad, Contrato contrato, Double importe, Garantia tipoGarantia,Inquilino inquilino
            //, Cliente propietario
    ){
        this.exoneraIRPF=exoneraIRPF;
        this.propiedad=propiedad;
        this.contrato=contrato;
        this.importe=importe;
        this.tipoGarantia=tipoGarantia;
        this.inquilino=inquilino;
        //this.propietario=propietario;
    }
        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    //public Cliente getPropietario() {
    //    return propietario;
    //}

    //public void setPropietario(Cliente propietario) {
    //    this.propietario = propietario;
    //}
    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }
    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    public Boolean getExoneraIRPF() {
        return exoneraIRPF;
    }

    public void setExoneraIRPF(Boolean exoneraIRPF) {
        this.exoneraIRPF = exoneraIRPF;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    public Garantia getTipoGarantia() {
        return tipoGarantia;
    }

    public void setTipoGarantia(Garantia tipoGarantia) {
        this.tipoGarantia = tipoGarantia;
    }
    public Integer calcularIRPF(){
        return 100;
    }
    public Integer calcularIVA(){
        return 200;
    }
    public Integer calcularComision(){
        return 300;
    }
    public Integer calcularGastoTotalMensual(){
        return this.getImporte().intValue()+this.calcularIRPF()+this.calcularIVA()+this.calcularComision();
    }
    @Override
    public String toString(){
        return "Dirección: "+this.getPropiedad().getDireccion()+" - Inquilino: "+this.getInquilino().getNombre()+" "+this.getInquilino().getApellido();
    }
}

