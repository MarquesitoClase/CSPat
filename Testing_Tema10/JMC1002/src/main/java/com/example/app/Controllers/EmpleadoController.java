package com.example.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Services.EmpleadoService;
import com.example.app.domain.Empleado;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;
    @GetMapping("/empleados")
    public List<Empleado> showList() {
      return empleadoService.obtenerTodos();   
    }
    @GetMapping("/empleado")
    public ResponseEntity<?> showOne(@PathVariable Long id) {
      List<Empleado> lista = empleadoService.obtenerTodos();
       return ResponseEntity.ok(lista);
    }
    @PostMapping("/empleado")
    public ResponseEntity<?> showPost(@Valid @RequestBody Empleado nuevoEmpleado) {
        nuevoEmpleado= empleadoService.añadir(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
    }
    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> showEdit(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id) {
        if(empleadoService.obtenerPorId(id)==null) return ResponseEntity.notFound().build();
        if (id != editEmpleado.getId()) {
            ResponseEntity.notFound().build();
        }
        empleadoService.editar(editEmpleado);
        return ResponseEntity.status(HttpStatus.OK).body(editEmpleado);
    }
    @PostMapping("/editar/submit")
    public String showEditSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoService.editar(empleadoForm);
            return "redirect:/list";
        }
        @GetMapping("/borrar/{id}")
        public String showDelete(@PathVariable long id) {
            empleadoService.borrar(id);
            return "redirect:/list";
        }
        @GetMapping("/porNombre")
        public String encontrarPorNombre(@RequestParam String nombre, Model model) throws Exception {
            model.addAttribute("listaEmpleados", empleadoService.obtenerPorNombre(nombre));
            return "mostrarEmpleado";
        }
        
}