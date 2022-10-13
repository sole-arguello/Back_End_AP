
package com.portfolio.msa.Dto;

import javax.validation.constraints.NotBlank;

public class dtoRedes {

    @NotBlank
    private String imgRed;
    @NotBlank
    private String linkRed;

    public dtoRedes() {
    }

    public dtoRedes(String imgRed, String linkRed) {
        this.imgRed = imgRed;
        this.linkRed = linkRed;
    }

    public String getImgRed() {
        return imgRed;
    }

    public void setImgRed(String imgRed) {
        this.imgRed = imgRed;
    }

    public String getLinkRed() {
        return linkRed;
    }

    public void setLinkRed(String linkRed) {
        this.linkRed = linkRed;
    }
}
