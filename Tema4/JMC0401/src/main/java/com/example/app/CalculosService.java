package com.example.app;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalculosService {

    public boolean showCalculosService(Integer numeroPrimo) {
        boolean es = true;
        for (int con = 2; con < numeroPrimo / 2; con++) {
            if (numeroPrimo % con == 0)
                es = false;
        }
        return es;
    }

    public boolean esPrimoService(@RequestParam Integer numero) {
        boolean dev = true;
        for (int con = 2; con <= (numero / 2); con++) {
            if ((numero % con) == 0) {
                dev = false;
            }
        }
        return dev;
    }

    public double calcularHipotenusaService(double cat1, double cat2) throws Exception {

        if (cat1 < 0 || cat2 < 0)
            throw new Exception(new Errores().errores[0]);
        return Math.sqrt(cat2 * cat1);
    }

    public ArrayList<Integer> divisoresService(int num) {
        ArrayList<Integer> divisores = new ArrayList<Integer>();
        
        for (int d = 1; d <= num / 2; d++) {
            if (num % d == 0)
                divisores.add(d);
        }
        divisores.add(num);
        return divisores;
    }


    /**
     * @return
     */

    public TreeSet<Integer> sinRepetidosService(@PathVariable int hasta) {
        Random r = new Random(100);
        TreeSet<Integer> sinRepetidos = new TreeSet<Integer>();
        while (sinRepetidos.size() != hasta) {
            sinRepetidos.add(r.nextInt(hasta));
        }
        return sinRepetidos;
    }

    public ArrayList<Integer> Divisores(@PathVariable int num) {
        ArrayList<Integer> dev=new ArrayList<>();
        for (int i = 0; i < num / 2; i++) {
            if (num % i == 0)
                dev.add(i);
        }
        return dev;
    }
}
