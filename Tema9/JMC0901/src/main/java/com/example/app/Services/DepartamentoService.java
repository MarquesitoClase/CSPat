package com.example.app.Services;

import java.util.List;

import com.example.app.domain.Departamento;

public interface DepartamentoService {
    public Departamento añadir(Departamento departamento);

    public List<Departamento> obtenerTodos() ;
}
