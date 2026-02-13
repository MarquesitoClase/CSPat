package com.example;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Hotel h1=new Hotel();
        int elec;
        Scanner Teclado=new Scanner(System.in);
        boolean seguir=true;
        System.out.println("Bienvenido a nuestra gestoría.");
        while(seguir){
            menu();
            elec=Integer.parseInt(Teclado.nextLine());
            switch (elec) {
                case 1:
                    h1.mostrarHabitacionesLibres();
                    break;
                case 2:
                    System.out.println("Y en que número de habitación desea hacer checkin?");
                    h1.listaHabitaciones.get(Integer.parseInt(Teclado.nextLine())-1).checkIn();
                    break;
                case 3:
                    System.out.println("Y en que número de habitación desea hacer checkout?");
                    Habitacion elegida=h1.listaHabitaciones.get(Integer.parseInt(Teclado.nextLine()));
                    System.out.println("Necesito saber también cuantos días la ocupó");
                    elegida.checkOut(Integer.parseInt(Teclado.nextLine()));
                    break;
                case 4:
                    System.out.println("Adios.");
                    seguir=false;
                    break;
                default: System.out.println("Esa opción no se la dí");
                    break;
            }
        }
        
    }
    public static void menu(){
        System.out.println("Que desea hacer?\n"+
        "1->Consultar las habiitaciones libres del hotel.\n"+
        "2->Hacer checkin de una habitación libre.\n"+
        "3->Hacer checkOut de una habitación ocupada\n."+
        "4->Salir.");

    }
}
