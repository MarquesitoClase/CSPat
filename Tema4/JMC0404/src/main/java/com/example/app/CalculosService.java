package com.example.app;

import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CalculosService {
static Random r=new Random();
    /**
     * @param al
     * @return
     */
    public static Integer calcularNNumero(Set al){
        int nNumeroAl=r.nextInt(100);
        while(al.contains(nNumeroAl)) nNumeroAl=r.nextInt(100);
        return nNumeroAl;
    }
}
