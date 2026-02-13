package com.example.app.exeptions;

public class NotFoundException extends Exception{
    public NotFoundException(String msg){
        super(msg);
    }
    public NotFoundException(){
        super("Empleado no encontrado");
    }
}
