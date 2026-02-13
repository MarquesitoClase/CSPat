package com.example;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        ArrayList<Persona> personas=new ArrayList<>();;
        Persona p1=new Persona("32799591G", "Chiqui", 52),
        p3=new Persona("11111111A", "Inventado1", 11),
        p2=new Persona("54153598Y", "Juan Luis", 24),
        p4=new Persona("22222222B", "Inventado2", 22),
        p5=new Persona("33333333C", "Inventado3", 33),
        p6=new Persona("44444444D", "Inventado4", 44);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);
        System.out.println("La mayor edad es: "+edadMayor(personas));
    }
    public static int edadMayor(ArrayList<Persona> personas){
        int dev=0, contador;
        for (contador=0;contador<personas.size();contador++){
            if (personas.get(contador).getEdad()>dev) {
                dev=personas.get(contador).getEdad();
            }
        }
        return dev;
    }
/*
• Método al que se le pasa un ArrayList de Persona y devuelve la edad del mayor.
• Método al que se le pasa un ArrayList de Persona y devuelve la edad media.
• Método al que se le pasa un ArrayList de Persona y devuelve el nombre del mayor.
• Método al que se le pasa un ArrayList de Persona y devuelve la Persona mayor.
• Método al que se le pasa un ArrayList de Persona y devuelve todos los mayores de edad.
• Método al que se le pasa un ArrayList de Persona y devuelve todos los que tienen una edad
mayor o igual a la media.
     */
}