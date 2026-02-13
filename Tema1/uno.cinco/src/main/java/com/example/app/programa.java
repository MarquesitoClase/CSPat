package com.example.app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * programa
 */
public class programa {

    /**
     * @param args
     */

/*Se que alguna cosa no está justo cómo pedía, pero, no se porqué no era capaz de acerlo
tal cual pedía en el  enunciado, así que creo que alguna cosa está diferente a cómo pedía.*/
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        boolean salir=false;
        int op=5, aEl;
        ArrayList<Domoticos> conjunto = new ArrayList<>(2);
        conjunto.add(new Radio());
        conjunto.add(new Termostato());
        conjunto.add(new Ascensor());
        while(!salir){
            if(op!=0){
            System.out.println("Que desea hacer?\n0->Salir\n1->Subir un dispositivo 1 unidad\n"+
            "2->Bajar un dispositivo una unidad\n3->Resetear un dispositivo.");
            op=Integer.parseInt(Teclado.nextLine());
            System.out.println("Y a que dispositivo quiere realizarlo?\n0->Salir\n1->A la radio\n"+
            "2->Al termostato\n3->Al ascensor?");
            aEl=Integer.parseInt(Teclado.nextLine());
            if(aEl<=4&&op<=4&&aEl>=0&&op>=0){
                if(op==0) System.out.println("");
                else if(op==1)conjunto.get(op).subir();
                else if(op==2)conjunto.get(op).bajar();
                else if(op==3)conjunto.get(op).reset();
            }
            else System.out.println("Esa opcion no se la ofrecí.");
        }
        }
    }
}