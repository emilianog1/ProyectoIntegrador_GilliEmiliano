/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioeg.eg.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Emiliano
 */
public class dtoPersona {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String apellidoP;
    private String descripcionP;
    private String tituloP;
    private String imagenP;
    
    //Constructores
    public dtoPersona() {
    }

    public dtoPersona(String nombreP, String apellidoP, String descripcionP, String tituloP, String imagenP) {
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.descripcionP = descripcionP;
        this.tituloP = tituloP;
        this.imagenP = imagenP;
    }
    //Getters & Setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }
    
    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    
    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getTituloP() {
        return tituloP;
    }

    public void setTituloP(String tituloP) {
        this.tituloP = tituloP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }
    
    
}
