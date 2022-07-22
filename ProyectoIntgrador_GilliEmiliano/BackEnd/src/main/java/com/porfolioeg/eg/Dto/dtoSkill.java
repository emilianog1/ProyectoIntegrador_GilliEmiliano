package com.porfolioeg.eg.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Emiliano
 */

public class dtoSkill {
    @NotBlank
    private String nombreS;
    @NotBlank
    private String porcentajeS;
    
    //Constructores

    public dtoSkill() {
    }

    public dtoSkill(String nombreS, String porcentajeS) {
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
    }
    //Getters & Setters

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(String porcentajeS) {
        this.porcentajeS = porcentajeS;
    }
}
