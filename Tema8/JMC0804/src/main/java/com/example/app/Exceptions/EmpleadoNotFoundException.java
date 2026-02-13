package com.example.app.Exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(Long id) {
    super("No se puede encontrar empleado con ID: " + id);
    }
    }