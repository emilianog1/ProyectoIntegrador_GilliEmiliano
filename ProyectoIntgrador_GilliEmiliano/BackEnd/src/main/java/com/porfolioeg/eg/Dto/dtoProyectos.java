package com.porfolioeg.eg.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Emiliano
 */

public class dtoProyectos {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    
    //Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
    }
    //Getters & Setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
}
