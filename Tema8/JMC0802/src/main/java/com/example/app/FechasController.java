package com.example.app;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fechas")
public class FechasController {
    
    @PostMapping("/diasHasta")
    public String showFecha(@RequestParam String fechaS, Model model){
        LocalDate fecha=LocalDate.parse(fechaS);
        model.addAttribute("Fecha:", fecha);
        return "fechasView";
    }

}
