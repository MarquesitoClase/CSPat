package com.example.app;

public class Ascensor extends Domoticos {
    int planta = 0;
    String estado = "correctamente.";

    @Override
    boolean subir() {
        if (planta < 8) {
            planta += 1;
            System.out.println("Estoy en la planta "+planta);
            return true;
        }
        System.out.println("Estoy en la planta "+planta);
        return false;
    }

    @Override
    void reset() {
        this.planta = 0;
        System.out.println("Volví a la planta baja.");
    }

    @Override
    String verEstado() {
        return "Soy un Ascensor y funciono " + estado;
    }

    @Override
    boolean bajar() {
        if (this.planta > 0) {
            planta = planta - 1;
            return true;
        }
        return false;
    }
}
