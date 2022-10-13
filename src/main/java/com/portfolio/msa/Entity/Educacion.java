
package com.portfolio.msa.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String imgE;
    private String institucionE;
    private String tituloE;
    private int anioE;
    private String condicionE;

    public Educacion() {
    }

    public Educacion(String imgE, String institucionE, String tituloE, int anioE, String condicionE) {
        this.imgE = imgE;
        this.institucionE = institucionE;
        this.tituloE = tituloE;
        this.anioE = anioE;
        this.condicionE = condicionE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    public String getInstitucionE() {
        return institucionE;
    }

    public void setInstitucionE(String institucionE) {
        this.institucionE = institucionE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }

    public int getAnioE() {
        return anioE;
    }

    public void setAnioE(int anioE) {
        this.anioE = anioE;
    }

    public String getCondicionE() {
        return condicionE;
    }

    public void setCondicionE(String condicionE) {
        this.condicionE = condicionE;
    }
  }    

