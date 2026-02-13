package com.example.app.Exceptions;

public class DepartamentoNotFoundException extends RuntimeException {
    public DepartamentoNotFoundException(Long id){
    super("No se puede encontrar el departamento con ID: "+id);
    }
}
