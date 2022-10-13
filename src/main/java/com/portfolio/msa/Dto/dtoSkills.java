
package com.portfolio.msa.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
     
    @NotBlank
    private String imgS;
    @NotBlank
    private String nombreS;
    private int porcentajeS;

    public dtoSkills() {
    }

    public dtoSkills(String imgS, String nombreS, int porcentajeS) {
        this.imgS = imgS;
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
    }

    public String getImgS() {
        return imgS;
    }

    public void setImgS(String imgS) {
        this.imgS = imgS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }   
}
