package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Suite extends Habitacion{
    
    public Suite(int numeroH) {
        super(numeroH);
        this.precioDia=200.0;
        this.tipo="Suite";
        this.ocupada=false;
    }

    @Override
    public void checkIn() {
        if(this.ocupada==true){
            System.out.println("Lo lamento, esa habitación ya está ocupada");
        }
        else{
            this.entrada=LocalDate.now();
        if(entrada.getMonthValue()==LocalDate.of(1,4,1).getMonthValue()||
        entrada.getMonthValue()==LocalDate.of(1,7,1).getMonthValue()||
        entrada.getMonthValue()==LocalDate.of(1,8,1).getMonthValue()){
        precioDia*=1.20;
        }
    }
    }
    @Override
    public void checkOut(int dias) {
    
    if(LocalDate.now().until(entrada, ChronoUnit.DAYS)>10) precioDia*=0.8;
    System.out.println("Nos tiene que pagar "
    +precioDia*(entrada.until(LocalDate.now(), ChronoUnit.DAYS)));
}

    

}