/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradordemo.demo.service;

import com.ibm.icu.text.RuleBasedNumberFormat;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.proyectointegradordemo.demo.DTO.LiquidacionRequestDTO;
import com.proyectointegradordemo.demo.dao.AlquilerDAO;
import com.proyectointegradordemo.demo.domain.Alquiler;
import com.proyectointegradordemo.demo.DTO.ReciboRequestDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class AlquilerServiceImpl implements AlquilerService{
    @Autowired
    private AlquilerDAO alquilerDAO;
    @Override
public void generarPDF(ReciboRequestDTO request) {
    Optional<Alquiler> optionalAlquiler = alquilerDAO.findById(request.getIdAlquiler());
    if (optionalAlquiler.isPresent()) {
    Alquiler alquiler = optionalAlquiler.get();
    File file = new File(request.getRutaArchivo());
    try (PdfWriter pdfWriter = new PdfWriter(file)) {
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.forLanguageTag("es"), RuleBasedNumberFormat.SPELLOUT);
        String numeroComoTexto = rbnf.format(alquiler.getImporte());

        Paragraph p1 = new Paragraph("Recibí de " + alquiler.getInquilino() +
                " la cantidad de pesos uruguayos " + numeroComoTexto +
                " ($" + alquiler.getImporte() + ") en concepto de alquiler del inmueble sito en " +
                alquiler.getPropiedad().getDireccion() + " correspondiente al mes de "+request.getMes()+".");
        Paragraph p2 = new Paragraph("Fecha de expedición de recibo: " + LocalDate.now());

        document.add(p1);
        document.add(p2);
        document.close();
        System.out.println("PDF creado");
    } catch (FileNotFoundException ex) {
        System.out.println("Archivo no encontrado: " + ex.getMessage());
        throw new RuntimeException("Error al crear el archivo PDF.", ex);
    } catch (IOException ex) {
        System.out.println("Error de E/S: " + ex.getMessage());
        throw new RuntimeException("Error al escribir en el archivo PDF.", ex);
   }
    }
    else{
        throw new RuntimeException("Alquiler no encontrado con id: "+request.getIdAlquiler());
    }
}

    @Override
    @Transactional(readOnly = true)
    public List<Alquiler> getAlquileres() {
        return (List<Alquiler>) alquilerDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Alquiler getAlquiler(int id) {
        return alquilerDAO.findById(id).orElse(null);
    }

    @Override
    public void generarLiquidacion(LiquidacionRequestDTO request) {
        File file = new File(request.getRutaArchivo());
        try (PdfWriter pdfWriter = new PdfWriter(file)) {
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        Paragraph p1 = new Paragraph("Alquiler propiedad ubicada en "+request.getDireccion()+", liquidación mensual "+request.getMes()+":");
        document.add(p1);
        for(String s:request.getDatos()){
            Paragraph p=new Paragraph(s);
            document.add(p);
        }
        document.close();
        System.out.println("PDF creado");
    } catch (FileNotFoundException ex) {
        System.out.println("Archivo no encontrado: " + ex.getMessage());
        throw new RuntimeException("Error al crear el archivo PDF.", ex);
    } catch (IOException ex) {
        System.out.println("Error de E/S: " + ex.getMessage());
        throw new RuntimeException("Error al escribir en el archivo PDF.", ex);
   }
    }
}

