package com.example.app.Excepciones;

public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(){super("No se ha encontrado al empleado buscado."),}
}
