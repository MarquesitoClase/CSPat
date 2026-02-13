package com.example.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Empleado;
import com.example.app.exeptions.NotFoundException;
import com.example.app.services.EmpleadoService;

import jakarta.validation.Valid;

@Controller
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;
    
    @GetMapping("/")
    public String getAll(@RequestParam (required=false) Integer op, Model model){
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        return "listView";
    }

    @GetMapping("/nuevo")
    public String getNew(Model model){
        model.addAttribute("empleadoForm", new Empleado());
        return "newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String getNewSubmit(Empleado empleado, Model model){
        empleadoService.añadir(empleado);
        return "redirect:/";
    }

    @GetMapping("/editar{id}")
    public String getEdit(@PathVariable Long id, Model model){
        Empleado empleadoForm;
        try{
            empleadoForm = empleadoService.obtenerPorId(id);
        }catch(NotFoundException e){
            return "redirect:/?op=2";
        }
        model.addAttribute("empleadoForm", empleadoForm);
        return "editFormView";
    }

    @GetMapping("editar/submit")
    public String getEditSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult, Model model){
        
            if(bindingResult.hasErrors()) return "redirect://?op=4";
            EmpleadoService.editar(empleadoForm);
            return "redirect:/?op=3";
        }

    @GetMapping("/borrar/{id}")
    public String getDelete(@PathVariable Long id, Model model){
        try{
            empleadoService.borrar(id);
        } catch(NotFoundException e){
            return "redirect:/";
        }
        return "/redirect:/";
    }

}
