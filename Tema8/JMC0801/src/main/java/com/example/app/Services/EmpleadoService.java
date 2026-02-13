package com.example.app.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Excepciones.EmpleadoNotFoundException;
import com.example.app.Repositorios.EmpleadosRepository;
import com.example.app.domain.Empleado;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadosRepository empleadosRepository;
    public Empleado añadir(Empleado empleado){
        return empleadosRepository.save(empleado);
    }
    public List<Empleado> obtenerTodos(){
        return empleadosRepository.findAll();
    }
    public Empleado obtenerPorId(long id) throws EmpleadoNotFoundException{
        for(Empleado empleado:empleadosRepository.findAll()){
            if(empleado.getId()==id) return empleado;
        }
        throw new EmpleadoNotFoundException();
    }
    public List<Empleado> obtenerPorNombre(String nombre) throws EmpleadoNotFoundException{
        ArrayList<Empleado> coincidentes = new ArrayList<>();
        for(Empleado empleado:empleadosRepository.findAll()){
            if(empleado.getNombre().equals(nombre)) coincidentes.add(empleado);
        }
        return coincidentes;
    }
    public void borrar(Long id){
        empleadosRepository.deleteById(id);
}
}