package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Repositorios.DepartamentoRepository;
import com.example.app.domain.Departamento;

import jakarta.validation.Valid;
@Service
public class DepartamentoServiceImplBD implements DepartamentoService {
    @Autowired
    DepartamentoRepository repositorio;

    @Override
    public Departamento añadir(@Valid Departamento departamento){
        if(departamento!=null)
        repositorio.save (departamento);
        return departamento;
    }

    @Override
    public List<Departamento> obtenerTodos() {
        return repositorio.findAll();
    }


}
