package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Excepciones.EmpleadoNotFoundException;
import com.example.app.Repositorios.EmpleadosRepository;
import com.example.app.domain.Empleado;

import jakarta.validation.Valid;


@Service
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadosRepository repositorio;
    
    @Override
    public Empleado añadir (@Valid Empleado empleado ) {
    if(empleado!=null)
    return repositorio.save (empleado);
    else return null;
    }

    public Empleado editar (Empleado empleado) {
        if(empleado!=null)
        return repositorio.save (empleado);
        else return null;
    }
    
    public void borrar(Long id) {
    if(id!=null)
        if(repositorio.existsById(id))
            repositorio.deleteById (id);
    }

    @Override
    public List<Empleado> obtenerTodos() { return repositorio.findAll (); }

    public Empleado obtenerPorId (long id ) {
    return repositorio.findById(id).orElse(null);
    // findById de JpaRepository devuelve un Optional. Para simplificar,
    // y que el servicio siga devolviendo Empleado y no Optional<Empleado>
    // hacemos que si no lo encuentra devuelva null.
    }
    
    @Override
    public Empleado obtenerPorNombre(String nombre) throws Exception{
        for(int index = 0; index<repositorio.findAll().size();index++){
            if(repositorio.findAll().get(index).getNombre().equals(nombre)) return repositorio.findAll().get(index);
        }
        throw new EmpleadoNotFoundException();
    }
    }