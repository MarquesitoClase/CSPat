package com.example.app;

public class Radio extends Domoticos{
    public double dial=88.0;
    boolean estado=true;
    @Override
    public boolean subir() {
        if(dial<104.0){
            dial+=0.1;
            System.out.println("Mi dial ahora es: "+dial);
        return true;
    }
    System.out.println("Mi dial no cambió. Es "+dial);
        return false;
}

    @Override
    public boolean bajar() {
        if(dial>88.0){
            dial-=0.1;
            System.out.println("Mi dial ahora es: "+dial);
            return true;
        }
        System.out.println("Mi dial no cambió. Es "+dial);
        return false;
    }

    @Override
    public void reset() {
        dial=88.0;
    }

    @Override
    String verEstado() {
        return "Soy una radio, y mi estado es "+estado;
    }

}
