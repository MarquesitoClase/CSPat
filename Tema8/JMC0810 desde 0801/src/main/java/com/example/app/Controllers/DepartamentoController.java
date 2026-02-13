package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.Services.DepartamentoService;
import com.example.app.domain.Departamento;

@Controller
@RequestMapping("/dpto")
public class DepartamentoController {
    DepartamentoService departamentoService;
    @GetMapping("/list")
    public String getDepartamentos(Model model){
        model.addAttribute("ListaDeptos", departamentoService.obtenerTodos());
        return "deptView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("DeptoForm", new Departamento());
        return "deptView";
    }
}
