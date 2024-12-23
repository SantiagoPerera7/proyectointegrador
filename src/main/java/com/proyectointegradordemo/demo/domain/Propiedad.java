/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proyectointegradordemo.demo.exceptions.PropiedadException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "cantidadbanios_propiedad")
    private Integer cantidadBanios;
    @Column(name = "cantidadambientes_propiedad")
    private Integer cantidadAmbientes;
    @Column(name = "cantidadcocheras_propiedad")
    private Integer cantidadCocheras;
    @ManyToOne
    @JoinColumn(name = "id_barrio")
    private Barrio barrio;
    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;
    @Column(name = "cantidadplantas_propiedad")
    private Integer cantidadPlantas;
    @Column(name = "cantidaddormitorios_propiedad")
    private Integer cantidadDormitorios;
    @Column(name = "aceptamascotas_propiedad")
    private boolean aceptaMascotas;
    @ManyToOne
    @JoinColumn(name = "id_tipopropiedad")
    private TipoPropiedad tipo;
    @Column(name = "metroscuadradostotales_propiedad")
    private Double metrosCuadradosTotales;
    @Column(name = "metroscuadradosedificados_propiedad")
    private Double metrosCuadradosEdificados;
    @Column(name = "metroscuadradosterreno_propiedad")
    private Double metrosCuadradosTerreno;
    @Column(name = "titularactualute_propiedad")
    private String titularActualUTE;
    @Column(name = "titularactualose_propiedad")
    private String titularActualOSE;
    @ManyToOne
    @JoinColumn(name = "id_tipotecho") // Define la clave foránea en la tabla "propiedad"
    private TipoTecho tipoTecho;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference("cliente-propiedad")
    public Cliente propietario;
    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("propiedad-fotos")
    private List<Foto> fotos = new ArrayList<>();
    @OneToOne(mappedBy = "propiedad")
    @JsonBackReference("propiedad-alquiler")
    private Alquiler alquiler;
    public Propiedad(){
    }
    public Propiedad(String direccion, String descripcion, Cliente propietario, TipoPropiedad tipo, Barrio barrio,
            Ciudad ciudad, Integer cantidadAmbientes, Integer cantidadPlantas, Integer cantidadBanios, Integer cantidadDormitorios,
            Double metrosCuadradosTotales, Double metrosCuadradosEdificados, Double metrosCuadradosTerreno,
            String titularActualUTE,String titularActualOSE, TipoTecho tipoTecho, Integer cantidadCocheras, Boolean aceptaMascotas){
        this.direccion=direccion;
        this.descripcion=descripcion;
        this.propietario=propietario;
        this.tipo=tipo;
        this.barrio=barrio;
        this.ciudad=ciudad;
        this.cantidadAmbientes=cantidadAmbientes;
        this.cantidadPlantas=cantidadPlantas;
        this.cantidadBanios=cantidadBanios;
        this.cantidadDormitorios=cantidadDormitorios;
        this.metrosCuadradosTotales=metrosCuadradosTotales;
        this.metrosCuadradosEdificados=metrosCuadradosEdificados;
        this.metrosCuadradosTerreno=metrosCuadradosTerreno;
        this.titularActualUTE=titularActualUTE;
        this.titularActualOSE=titularActualOSE;
        this.tipoTecho=tipoTecho;
        this.cantidadCocheras=cantidadCocheras;
        this.aceptaMascotas=aceptaMascotas;
    }
    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
        public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public void agregarFoto(Foto foto) {
        foto.setPropiedad(this); // Establecer la relación bidireccional
        this.fotos.add(foto);
    }

    public void eliminarFoto(Foto foto) {
        foto.setPropiedad(null); // Romper la relación bidireccional
        this.fotos.remove(foto);
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
    public Integer getCantidadBanios() {
        return cantidadBanios;
    }

    public void setCantidadBanios(Integer cantidadBanios) {
        this.cantidadBanios = cantidadBanios;
    }

    public Integer getCantidadAmbientes() {
        return cantidadAmbientes;
    }

    public void setCantidadAmbientes(Integer cantidadAmbientes) {
        this.cantidadAmbientes = cantidadAmbientes;
    }

    public Integer getCantidadCocheras() {
        return cantidadCocheras;
    }

    public void setCantidadCocheras(Integer cantidadCocheras) {
        this.cantidadCocheras = cantidadCocheras;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCantidadPlantas() {
        return cantidadPlantas;
    }

    public void setCantidadPlantas(Integer cantidadPlantas) {
        this.cantidadPlantas = cantidadPlantas;
    }

    public boolean isAceptaMascotas() {
        return aceptaMascotas;
    }

    public void setAceptaMascotas(boolean aceptaMascotas) {
        this.aceptaMascotas = aceptaMascotas;
    }

    public TipoPropiedad getTipo() {
        return tipo;
    }

    public void setTipo(TipoPropiedad tipo) {
        this.tipo = tipo;
    }

    public Double getMetrosCuadradosTotales() {
        return metrosCuadradosTotales;
    }

    public void setMetrosCuadradosTotales(Double metrosCuadradosTotales) {
        this.metrosCuadradosTotales = metrosCuadradosTotales;
    }

    public Double getMetrosCuadradosEdificados() {
        return metrosCuadradosEdificados;
    }

    public void setMetrosCuadradosEdificados(Double metrosCuadradosEdificados) {
        this.metrosCuadradosEdificados = metrosCuadradosEdificados;
    }

    public Double getMetrosCuadradosTerreno() {
        return metrosCuadradosTerreno;
    }

    public void setMetrosCuadradosTerreno(Double metrosCuadradosTerreno) {
        this.metrosCuadradosTerreno = metrosCuadradosTerreno;
    }

    public String getTitularActualUTE() {
        return titularActualUTE;
    }

    public void setTitularActualUTE(String titularActualUTE) {
        this.titularActualUTE = titularActualUTE;
    }

    public String getTitularActualOSE() {
        return titularActualOSE;
    }

    public void setTitularActualOSE(String titularActualOSE) {
        this.titularActualOSE = titularActualOSE;
    }

    public TipoTecho getTipoTecho() {
        return tipoTecho;
    }

    public void setTipoTecho(TipoTecho tipoTecho) {
        this.tipoTecho = tipoTecho;
    }
    public void validar() throws PropiedadException{
        if(descripcion.isEmpty()||descripcion==null){
            throw new PropiedadException("La descripción de la propiedad no puede ser nula");
        }
        if(direccion.isEmpty()||direccion==null){
            throw new PropiedadException("La dirección de la propiedad no puede ser nula");
        }
        if(tipo==null){
            throw new PropiedadException("Debe seleccionar un tipo de propiedad");
        }
        if(barrio==null){
            throw new PropiedadException("El barrio de la propiedad no puede ser nulo");
        }
        if(ciudad==null){
            throw new PropiedadException("La ciudad de la propiedad no puede ser nula");
        }
        if(propietario==null){
            throw new PropiedadException("La propiedad debe tener asignado un propietario");
        }
        if(cantidadAmbientes<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de ambientes");
        }
        if(cantidadPlantas<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de plantas");
        }
        if(cantidadBanios<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de banños");
        }
        if(metrosCuadradosTotales<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de metros cuadrados totales");
        }
        if(metrosCuadradosEdificados<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de metros cuadrados edificados");
        }
        if(metrosCuadradosTerreno<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de metros cuadrados de terreno");
        }
        if(titularActualUTE.isEmpty()||titularActualUTE==null){
            throw new PropiedadException("El titular actual de UTE no puede ser nulo");
        }
        if(titularActualOSE.isEmpty()||titularActualUTE==null){
            throw new PropiedadException("El titular actual de OSE no puede ser nulo");
        }
        if(tipoTecho==null){
            throw new PropiedadException("El tipo de techo no puede ser nulo");
        }
        if(cantidadCocheras<0){
            throw new PropiedadException("Ingrese un valor válido de cantidad de cocheras");
        }
//        if(fotos.isEmpty()){
//            throw new PropiedadException("Debe ingresar fotos para la propiedad");
//        }
    }
    @Override
    public String toString(){
        return this.descripcion+" - "+this.direccion;
    }
}
