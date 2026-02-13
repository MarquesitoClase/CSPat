package com.example.app;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Controlador {
    Random random = new Random();
    public Set <Integer> lista = new LinkedHashSet<>();

    @GetMapping({"/", "/list", ""})
    public String showList(Model model){
        model.addAttribute("cantidadTotal", lista.size());
        model.addAttribute("listaNumeros", lista);
        return "listView";
    }
    
    @GetMapping("/new")
    public String showNew(){
        lista.add(CalculosService.calcularNNumero(lista));
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id){
        lista.remove(id);
        return "redirect:/list";
    }
}
