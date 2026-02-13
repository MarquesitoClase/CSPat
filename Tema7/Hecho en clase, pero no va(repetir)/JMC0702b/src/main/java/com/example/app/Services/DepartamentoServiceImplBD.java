package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Repositorios.DepartamentoRepository;
import com.example.app.domain.Departamento;
import com.example.app.domain.Empleado;

@Service
public class DepartamentoServiceImplBD implements DepartamentoService {
    @Autowired
    DepartamentoRepository repositorio;
    
    public Departamento añadir(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public List<Departamento> obtenerTodos() {
        return repositorio.findAll();
    }

    public Departamento obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public void borrar(Departamento departamento) {
        repositorio.delete(departamento); // también es cómodo deleteById(id)
    }

    public Departamento obtenerPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public void añadirEmpleado(Empleado e, Departamento dep){
        e.setDep(dep);
    }

}