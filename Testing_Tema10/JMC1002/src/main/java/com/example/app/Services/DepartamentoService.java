package com.example.app.Services;

import java.util.List;

import com.example.app.domain.Departamento;





public interface DepartamentoService {
    
    public Departamento añadir(Departamento dep);

    public List<Departamento> obtenerTodos();

    public Departamento obtenerPorNDep(int nDep);

    public Departamento obtenerPorNombre(String nombreBuscar);

    public void borrar(Departamento departamento);

    public Departamento Editar(Departamento depEd);
}
