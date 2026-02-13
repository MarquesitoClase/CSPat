package com.example.app;

import java.util.ArrayList;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.PathVariable;

public interface CalculosService {
    public boolean showCalculosService(Integer numeroPrimo);
    public boolean esPrimoService(Integer num);
    public double calcularHipotenusaService(double cat1, double cat2) throws Exception;
    public  ArrayList<Integer> divisoresService(int num);
    public TreeSet<Integer> sinRepetidosService(@PathVariable int hasta);
    public ArrayList<Integer> Divisores(@PathVariable int num);
}
