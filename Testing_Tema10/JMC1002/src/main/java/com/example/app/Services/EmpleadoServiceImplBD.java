package com.example.app.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Repositorios.EmpleadosRepository;
import com.example.app.domain.Empleado;

import lombok.NonNull;

@Service
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadosRepository repositorio;
    public Empleado añadir (@NonNull Empleado empleado) {
    return repositorio.save (empleado);
    }
    /**
     * @return
     */
    
    public Empleado editar (@NonNull Empleado empleado) {
    return repositorio.save (empleado);
    }
    public void borrar(@NonNull Long id) {
    repositorio.deleteById (id);
    }
    @Override
    public List<Empleado> obtenerTodos() { 
        List<Empleado> repo = repositorio.findAll();
        List<Empleado> empleadosActivos = new ArrayList<>();
        for (Empleado empleado : repo) {
            if(empleado.isEnActivo()) empleadosActivos.add(empleado);
            System.out.println(empleado);
        }
        return empleadosActivos;
     }

    public Empleado obtenerPorId (long id) {
    return repositorio.findById(id).orElse(null);
    /*
     findById de JpaRepository devuelve un Optional. Para simplificar,
     y que el servicio siga devolviendo un Empleado y no Optional<Empleado>,
     hacemos que si no lo encuentra devuelva null.
    */
    }
    
    @Override
    public Empleado obtenerPorNombre(String nombre) throws Exception{
        return repositorio.findByNombre(nombre);
    }

    }