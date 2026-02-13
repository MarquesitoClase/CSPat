package com.example.app;

/**
 * DDomoticos
 */
//nombre-> dispositivos domóticos
public abstract class Domoticos {
    abstract boolean subir();
    abstract boolean bajar();
    abstract void reset();
    abstract String verEstado();
}