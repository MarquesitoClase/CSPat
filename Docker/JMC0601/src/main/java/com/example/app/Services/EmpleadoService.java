package com.example.app.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Empleado;
import com.example.app.domain.Genero;

@Service
public class EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();

    public Empleado añadir(Empleado empleado) {
        repositorio.add(empleado);
        return empleado; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {
        if (repositorio.size() < 1) {
            repositorio.add(new Empleado(1L, "Empleado1", "empleado1@gmail.com", 1111d, true, Genero.MASCULINO));
            repositorio.add(new Empleado(2L, "Empleado2", "empleado2@gmail.com", 2222d, true, Genero.FEMENINO));
            return repositorio;
        } else
            return repositorio;
    }

    public Empleado obtenerPorId(long id) {
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        return null; // debería lanzar excepción si no encontrado
    }

    public Empleado editar(Empleado empleado) {
        int pos = repositorio.indexOf(empleado);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        repositorio.set(pos, empleado); // si lo encuentra, lo sustituye
        return empleado;
    }

    public void borrar(Long id) {
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null) {
            repositorio.remove(empleado); // podría devolver boolean
        }
    }
}