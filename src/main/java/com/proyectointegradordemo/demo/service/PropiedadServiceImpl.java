/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.proyectointegradordemo.demo.dao.ClienteDAO;
import com.proyectointegradordemo.demo.dao.PropiedadDAO;
import com.proyectointegradordemo.demo.domain.Cliente;
import com.proyectointegradordemo.demo.domain.Foto;
import com.proyectointegradordemo.demo.domain.Propiedad;
import com.proyectointegradordemo.demo.exceptions.PropiedadException;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author santi
 */
@Service
public class PropiedadServiceImpl implements PropiedadService {

    @Autowired
    private PropiedadDAO propiedadDAO;
    @Autowired
    private ClienteService clienteService;

    @Override
    @Transactional(readOnly = true)
    public List<Propiedad> getPropiedades() {
        return (List<Propiedad>) propiedadDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propiedad getPropiedad(int id) {
        return propiedadDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Propiedad agregarPropiedad(Propiedad propiedad) {
        propiedad.validar();
        return propiedadDAO.save(propiedad);
    }
    
    @Override
    @Transactional
    public void agregarFotoAPropiedad(Integer id, MultipartFile foto) throws Exception {
        // Validar propiedad
        Propiedad propiedad = getPropiedad(id);
        if (propiedad == null) {
            throw new PropiedadException("Propiedad no encontrada");
        }

        // Guardar archivo
        String nombreArchivo = StringUtils.cleanPath(foto.getOriginalFilename());
        String ruta = "uploads/propiedades/" + id;
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        File archivoDestino = new File(ruta, nombreArchivo);
        foto.transferTo(archivoDestino);

        // Actualizar propiedad con la ruta de la imagen
        propiedad.getFotos().add(new Foto(ruta + "/" + nombreArchivo,propiedad));
        modificarPropiedad(propiedad); // Método para guardar cambios en BD
    }

    @Override
    public void modificarPropiedad(Propiedad nuevaPropiedad) {
        // Buscar la propiedad existente
        Propiedad propiedadExistente = propiedadDAO.findById(nuevaPropiedad.getId())
                .orElseThrow(() -> new PropiedadException("La propiedad con ID " + nuevaPropiedad.getId() + " no existe."));

        // Validar los nuevos datos de la propiedad
        nuevaPropiedad.validar();

        // Actualizar los datos de la propiedad
        propiedadExistente.setDireccion(nuevaPropiedad.getDireccion());
        propiedadExistente.setDescripcion(nuevaPropiedad.getDescripcion());
        propiedadExistente.setCantidadBanios(nuevaPropiedad.getCantidadBanios());
        propiedadExistente.setCantidadAmbientes(nuevaPropiedad.getCantidadAmbientes());
        propiedadExistente.setCantidadCocheras(nuevaPropiedad.getCantidadCocheras());
        propiedadExistente.setBarrio(nuevaPropiedad.getBarrio());
        propiedadExistente.setCiudad(nuevaPropiedad.getCiudad());
        propiedadExistente.setCantidadPlantas(nuevaPropiedad.getCantidadPlantas());
        propiedadExistente.setAceptaMascotas(nuevaPropiedad.isAceptaMascotas());
        propiedadExistente.setTipo(nuevaPropiedad.getTipo());
        propiedadExistente.setMetrosCuadradosTotales(nuevaPropiedad.getMetrosCuadradosTotales());
        propiedadExistente.setMetrosCuadradosEdificados(nuevaPropiedad.getMetrosCuadradosEdificados());
        propiedadExistente.setMetrosCuadradosTerreno(nuevaPropiedad.getMetrosCuadradosTerreno());
        propiedadExistente.setTitularActualUTE(nuevaPropiedad.getTitularActualUTE());
        propiedadExistente.setTitularActualOSE(nuevaPropiedad.getTitularActualOSE());
        propiedadExistente.setTipoTecho(nuevaPropiedad.getTipoTecho());

        // Validar y actualizar propietario si es necesario
        if (nuevaPropiedad.getPropietario() != null) {
        Cliente nuevoPropietario = clienteService.getCliente(nuevaPropiedad.getPropietario().getId());
        propiedadExistente.setPropietario(nuevoPropietario);
    }

        // Actualizar fotos
        if (nuevaPropiedad.getFotos() != null) {
            propiedadExistente.getFotos().clear(); // Limpiar fotos actuales
            for (Foto foto : nuevaPropiedad.getFotos()) {
                propiedadExistente.agregarFoto(foto); // Agregar nuevas fotos
            }
        }

        // Guardar cambios
        propiedadDAO.save(propiedadExistente);
    }

    @Override
    @Transactional
    public void eliminarPropiedad(int id) {
        if (propiedadDAO.existsById(id)) {
            propiedadDAO.deleteById(id);
        } else {
            throw new PropiedadException("La propiedad con ID " + id + " no existe.");
        }
    }

    @Override
    public void modificarPropiedadParcial(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
