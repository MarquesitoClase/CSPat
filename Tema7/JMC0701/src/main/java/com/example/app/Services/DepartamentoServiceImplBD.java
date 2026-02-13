package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.Repositorios.DepartamentoRepository;
import com.example.app.domain.Departamento;

public class DepartamentoServiceImplBD {
    @Autowired
    DepartamentoRepository repositorio;
    public Departamento añadir (Departamento departamento) {
         repositorio.save(departamento);
         return departamento;
    }
}
