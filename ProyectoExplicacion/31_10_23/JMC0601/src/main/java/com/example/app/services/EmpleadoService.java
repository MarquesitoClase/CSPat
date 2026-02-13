package com.example.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Empleado;
import com.example.app.exeptions.NotFoundException;

public class EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();
    
    @GetMapping("/")
    public List<Empleado> obtenerTodos(@RequestParam (required=false) Integer op, Model model){
        return repositorio;
    }
    public Empleado añadir(Empleado empleado){
        repositorio.add(empleado);
        return empleado;
    }

    public void Editar()

    public Empleado obtenerPorId(long id) throws NotFoundException{
        for (int i = 0; i < repositorio.size(); i++) {
            for (Empleado empleado : repositorio) {
                if(empleado.getId()==id) return empleado;
            }
        }
        return new Empleado(-1L, "No encontrado", "NoEncontrado@Empleado", 0d);
    }

    

    public void borrar(Long id) throws NotFoundException{

    }
}
