package com.example.app.Services;

import java.util.List;

import com.example.app.domain.Empleado;


public interface EmpleadoService {

    public Empleado añadir(Empleado empleado) ;
//
    public List<Empleado> obtenerTodos() ;
//
    public Empleado obtenerPorId(long id) ;
//
    public Empleado obtenerPorNombre(String nombre) throws Exception ;
//
    public Empleado editar(Empleado empleado);
//
    public void borrar(Long id);
//
}