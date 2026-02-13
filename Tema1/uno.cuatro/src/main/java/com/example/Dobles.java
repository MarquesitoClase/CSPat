package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Dobles extends Habitacion{
    
    public Dobles(int numeroH) {
        super(numeroH);
        this.precioDia=100.0;
        this.tipo="Doble";
        this.ocupada=false;
    }

    @Override
    public void checkIn() {
        this.ocupada=true;
        this.entrada=LocalDate.now();
        if(entrada.getMonthValue()==LocalDate.of(1,4,1).getMonthValue()||
        entrada.getMonthValue()==LocalDate.of(1,7,1).getMonthValue()||
        entrada.getMonthValue()==LocalDate.of(1,8,1).getMonthValue()){
        precioDia*=1.20;
        System.out.println("Se le va a aplicar un suplemento por la fecha en la que ingresa al hotel.");
        }
    }

    @Override
    public void checkOut(int dias) {
        if(this.ocupada==true){
            System.out.println("Lo lamento, esa habitación ya está ocupada");
        }
        else{
    if(entrada.getMonth()==Month.APRIL||entrada.getMonth()==Month.JULY||
    entrada.getMonth()==Month.AUGUST){
        precioDia*=0.8;
        System.out.println("Se le aplicó un descuento del 20% por"+
        " el més en el que ingresó al hotel");
    }
    System.out.println("Tiene que pagar "+precioDia*(entrada.until(LocalDate.now(), ChronoUnit.DAYS)));
}
    }
}