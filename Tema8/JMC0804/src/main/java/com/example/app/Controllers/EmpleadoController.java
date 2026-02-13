package com.example.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app.Exceptions.EmpleadoNotFoundException;
import com.example.app.Exceptions.EmptyEmpleadosException;
import com.example.app.Services.EmpleadoService;
import com.example.app.domain.Empleado;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> getList() {
        List<Empleado> listaEmpleados;
        try {
            listaEmpleados = empleadoService.obtenerTodos();
        } catch (EmptyEmpleadosException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return listaEmpleados;
    }

    @GetMapping("/empleado/{id}")
    public Empleado getOneElement(@PathVariable Long id) {
        try {
            return empleadoService.obtenerPorId(id);
        } catch (EmpleadoNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<?> showPost(@Valid @RequestBody Empleado nuevoEmpleado) {
        nuevoEmpleado = empleadoService.añadir(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> showEdit(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id) {
        if (empleadoService.obtenerPorId(id) == null)
            return ResponseEntity.notFound().build();
        if (id != editEmpleado.getId()) {
            ResponseEntity.notFound().build();
        }
        empleadoService.editar(editEmpleado);
        return ResponseEntity.status(HttpStatus.OK).body(editEmpleado);
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<?> Delete(@PathVariable long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El empleado a borrar no existe.");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/porNombre")
    public Empleado encontrarPorNombre(@RequestParam String nombre, Model model) throws Exception {
        model.addAttribute("listaEmpleados", empleadoService.obtenerPorNombre(nombre));
            try{
                return empleadoService.obtenerPorNombre(nombre);
            }catch(EmpleadoNotFoundException ex){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
            }
    }
}