
package com.portfolio.msa.Security.Controller;


public class Mensaje {
    
    private String mensaje;
    
    //constructore

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //getter y setter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
