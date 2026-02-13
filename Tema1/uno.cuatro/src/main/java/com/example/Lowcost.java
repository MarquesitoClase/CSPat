package com.example;

import java.time.LocalDate;

public class Lowcost extends Habitacion{
    
    public Lowcost(int numeroH) {
        super(numeroH);
        this.precioDia=50.0;
        this.tipo="Lowcost";
        this.ocupada=false;
    }

    @Override
    public void checkIn() {
        if(this.ocupada==true){
            System.out.println("Lo lamento, esa habitación ya está ocupada");
        }
        else{
        this.entrada=LocalDate.now();
        this.ocupada=true;
        }
    }

    @Override
    public void checkOut(int dias) {
        System.out.println("ha de pagar"+this.precioDia*dias);
    }


}
