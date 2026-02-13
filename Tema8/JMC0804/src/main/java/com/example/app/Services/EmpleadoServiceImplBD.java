package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Exceptions.EmpleadoNotFoundException;
import com.example.app.Exceptions.EmptyEmpleadosException;
import com.example.app.Repositorios.EmpleadosRepository;
import com.example.app.domain.Empleado;

@Service
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadosRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerTodos() {
        List<Empleado> lista = repositorio.findAll();
        if (lista.isEmpty())
            throw new EmptyEmpleadosException();
        return lista;
    }

    public Empleado obtenerPorId(long id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException(id));
        return empleado;
    }

    @Override
    public Empleado obtenerPorNombre(String nombre) throws Exception {
        return repositorio.findByNombre(nombre);
    }

}