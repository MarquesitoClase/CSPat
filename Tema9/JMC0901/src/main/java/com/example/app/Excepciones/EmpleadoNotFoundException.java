package com.example.app.Excepciones;

public class EmpleadoNotFoundException extends Exception{
    public EmpleadoNotFoundException(){
        super("Ese empleado no está en nuestra base de datos.");
    }
}
