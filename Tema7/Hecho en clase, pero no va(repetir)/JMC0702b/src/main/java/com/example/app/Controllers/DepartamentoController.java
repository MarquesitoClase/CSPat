package com.example.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.Services.DepartamentoService;
import com.example.app.Services.EmpleadoService;
import com.example.app.domain.Departamento;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/depto")
public class DepartamentoController {
    @Autowired
    public DepartamentoService departamentoService;
    @Autowired
    public EmpleadoService empleadoService;    
    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", 0); //new Departamento(0L, "Todos"));
        return "listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("departamentoForm", new Departamento());
        return "departamentoListView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Departamento departamentoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/depto/new";
        departamentoService.añadir(departamentoForm);
        return "departamentoListView";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        departamentoService.borrar(departamentoService.obtenerPorId(id));
        return "redirect:departamentoListView";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento != null) {
            model.addAttribute("departamentoForm", departamento);
            return "departamentoListView";
        } else {
            return "redirect:departamentoListView";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid Departamento departamentoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            departamentoService.editar(departamentoForm);
        return "redirect:departamentoListView";
    }

}