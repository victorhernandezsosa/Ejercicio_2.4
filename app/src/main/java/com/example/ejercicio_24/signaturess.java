package com.example.ejercicio_24;

import android.graphics.Bitmap;

public class signaturess {

    private Bitmap firma;
    private String descripcion;

    public signaturess(Bitmap firma, String descripcion) {
        this.firma = firma;
        this.descripcion = descripcion;
    }

    public signaturess() {
    }

    public Bitmap getFirma() {
        return firma;
    }

    public void setFirma(Bitmap firma) {
        this.firma = firma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
