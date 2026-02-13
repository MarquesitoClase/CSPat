package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Repositorios.DepartamentoRepository;
import com.example.app.domain.Departamento;

@Service
public class DepartamnentoServiceImplBD implements DepartamentoService{
    @Autowired
    DepartamentoRepository departamentoRepository;

    public Departamento añadir(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public Departamento editar(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public void borrar(Long id) {
        departamentoRepository.deleteById (id);
        }

        @Override
        public List<Departamento> obtenerTodos(){return departamentoRepository.findAll();}

        public Departamento obtenerPorId(Long id){
            return departamentoRepository.findById(id).orElse(null);
        }

        @Override
        public Departamento obtenerPorNombre(String nombreBuscar) throws Exception{
            return departamentoRepository.findByNombre(nombreBuscar);
        }

        @Override
        public Departamento obtenerPorNDep(int nDep) {
            return departamentoRepository.findAll().get(nDep);
        }

        @Override
        public void borrar(Departamento departamento) {
            departamentoRepository.delete(departamento);
        }

        @Override
        public Departamento Editar(Departamento depEd) {
            return departamentoRepository.save(depEd);
        }
    }
