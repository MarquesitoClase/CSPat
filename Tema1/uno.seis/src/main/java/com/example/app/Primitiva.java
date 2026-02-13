package com.example.app;

import java.util.ArrayList;
import java.util.Random;

public class Primitiva {
    ArrayList<Integer> primitiva = new ArrayList<Integer>();
    public Primitiva() {
        
        Random r = new Random(49);
        while (primitiva.size() != 6) {
            int añadir = r.nextInt();
            if (!primitiva.contains(añadir))
                primitiva.add(añadir);
        }
    }
    public int comprobarAciertos(ArrayList<Integer> apuesta){
        int aciertos=0;
        for (int i = 0; i < 6; i++) {
            if(this.primitiva.contains(apuesta.get(i))) aciertos++;
        }
        return aciertos;
    }
}
