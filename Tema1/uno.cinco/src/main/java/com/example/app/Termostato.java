package com.example.app;

import java.time.LocalDate;

/**
 * Termostato
 */
public class Termostato extends Domoticos{
    LocalDate fechaURevision=null;
    String estado="correctamente";
    int Temperatura;
    public Termostato() {
        this.Temperatura=20;
    }

    void revisar() {
        fechaURevision=LocalDate.now();
    }

    @Override
    boolean subir() {
    if(this.Temperatura<80){
        this.Temperatura+=1;
        return true;
    }
    return false;
}

    @Override
    boolean bajar() {
        if(this.Temperatura>0){
            this.Temperatura-=1;
            System.out.println("La temperatura ahora es: "+Temperatura);
        return true;
        }
        System.out.println("La temperatura no cambio.");
        return false;
    }

    @Override
    void reset() {
        this.Temperatura=20;
    }

    @Override
    String verEstado() {
        return "Soy el Termostato y funciono "+estado;
    }
}