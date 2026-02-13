package com.example;

import java.time.LocalDate;

public abstract class Habitacion {
    public abstract void checkIn();
    public abstract void checkOut(int dias);
    protected double precioDia;
    protected String tipo;
    protected int numeroH;
    protected LocalDate entrada;
    public boolean ocupada;
    public Habitacion() {
    }
    public Habitacion(int numeroH) {
        this.numeroH = numeroH;
    }
    @Override
    public String toString() {
        return "Habitacion [precioDia=" + precioDia + ", tipo=" + tipo + ", numeroH=" + numeroH + ", entrada=" + entrada
                + ", ocupada=" + ocupada + "]";
    }

}
