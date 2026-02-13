package com.example;

import java.util.ArrayList;
//El checkin funciona mal. Si fuerzo el que sea false por fuera si funciona y no muestra la habitación.
public class Hotel {
    public ArrayList<Habitacion> listaHabitaciones=new ArrayList<Habitacion>();
    public Hotel() {
        for (int numeroH = 1; numeroH < 20; numeroH++) {
            if(numeroH<=3) listaHabitaciones.add(new Lowcost(numeroH));
            else if(numeroH<=13) listaHabitaciones.add(new Dobles(numeroH));
            else listaHabitaciones.add(new Suite(numeroH));
        }
    }
    public void mostrarHabitacionesLibres(){
        System.out.println("Nuestras habitaciones libres son:");
        for (Habitacion habitacion : this.listaHabitaciones) {
            if(!habitacion.ocupada) System.out.println(habitacion);
        }
        
    }
}
