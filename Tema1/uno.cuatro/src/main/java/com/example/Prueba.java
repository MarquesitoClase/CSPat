package com.example;

/**
 * Prueba
 */
public class Prueba {

    public static void main(String[] args) {
        Hotel h1=new Hotel();
        h1.listaHabitaciones.get(1).ocupada=true;
        h1.mostrarHabitacionesLibres();
    }

}