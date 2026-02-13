package com.example.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Empleado;

@Service
public interface EmpleadoService {
Empleado añadir (Empleado empleado);
public List<Empleado> obtenerTodos();;
public Empleado obtenerPorId(long id);
public Empleado editar (Empleado empleado);
public void borrar (Long id);
public Empleado obtenerPorNombre(String nombre) throws Exception;
}