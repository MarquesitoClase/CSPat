package com.example.app.Exceptions;

public class EmptyDepartamentoException extends RuntimeException{
    public EmptyDepartamentoException() {
        super("No hay departamentos en el sistema");
    }
}
