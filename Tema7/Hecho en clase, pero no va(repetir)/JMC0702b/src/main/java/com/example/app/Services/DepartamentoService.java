package com.example.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Departamento;

@Service
public interface DepartamentoService {

    Departamento añadir(Departamento departamento);

    List<Departamento> obtenerTodos();

    Departamento obtenerPorId(long id);

    Departamento editar(Departamento departamento);

    void borrar(Departamento departamento);

    Departamento obtenerPorNombre(String nombre);
}
