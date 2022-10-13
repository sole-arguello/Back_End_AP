
package com.portfolio.msa.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String imgS;
    private String nombreS;
    private int porcentajeS;

    public Skills() {
    }

    public Skills(String imgS, String nombreS, int porcentajeS) {
        this.imgS = imgS;
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

