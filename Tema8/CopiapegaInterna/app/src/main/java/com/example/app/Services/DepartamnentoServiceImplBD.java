package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Exceptions.DepartamentoNotFoundException;
import com.example.app.Exceptions.EmptyDepartamentoException;
import com.example.app.Repositorios.DepartamentoRepository;
import com.example.app.domain.Departamento;

@RestController
public class DepartamnentoServiceImplBD implements DepartamentoService{
    @Autowired
    DepartamentoRepository repositorio;

    @Override
    public Departamento añadir(Departamento dep) {
       return repositorio.save(dep);
    }

    @Override
    public List<Departamento> obtenerTodos() {
       List<Departamento> lista = repositorio.findAll();
        if(lista.isEmpty())
          throw new EmptyDepartamentoException();
        return lista;
    }


    @Override
    public Departamento obtenerPorNombre(String nombreBuscar) {
        return repositorio.findByNombre(nombreBuscar);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Departamento Editar(Departamento depEd) {
        return repositorio.save(depEd);
    }

    @Override
    public Departamento obtenerPorId(Long Id) {
        Departamento departamento = repositorio.findById(Id)
            .orElseThrow(() -> new DepartamentoNotFoundException(Id));
        return departamento;
    }

    @Override
    public void borrar(Departamento departamento) {
        repositorio.delete(departamento);
    }
}
