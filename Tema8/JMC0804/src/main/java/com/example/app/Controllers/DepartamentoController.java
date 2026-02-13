package com.example.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app.Exceptions.DepartamentoNotFoundException;
import com.example.app.Services.DepartamentoService;
import com.example.app.domain.Departamento;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;
    @GetMapping("/departamentos")
    public List<Departamento> getDepartamentos(Model model){
        return departamentoService.obtenerTodos();
    }

    @GetMapping("/departamento/{id}")
    public Departamento getOneElement(@PathVariable Long id){
        try{
            return departamentoService.obtenerPorId(id);
        }catch(DepartamentoNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
    
    @PostMapping("/nuevoDepartamento")
    public ResponseEntity<?> nuevo(@Valid @RequestBody Departamento nuevoDep) {
        nuevoDep = departamentoService.añadir(nuevoDep);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDep);
    }
    
}
