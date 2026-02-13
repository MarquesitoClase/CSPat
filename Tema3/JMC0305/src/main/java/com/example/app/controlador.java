package com.example.app;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controlador {
    @GetMapping({ "/", "/home", "/index"})
    public String showHome(@RequestParam (required=false) String usuario, Model model) {
        model.addAttribute("usuario", usuario);
        
        model.addAttribute("fecha", LocalDate.now());
        return "indexView";
    }
    @GetMapping("/calculos/{numeroPrimo}")
    public String showCalculos(@PathVariable Integer numeroPrimo, Model model){
        boolean es=true;
        for(int con=2; con<numeroPrimo/2; con++){
            if(numeroPrimo%con==0) es=false;
        }
        if(es) model.addAttribute("resultadoPrimo", "si");
        else model.addAttribute("resultadoPrimo", "no");
        return "esPrimo";
    }
    
    @GetMapping("/primo")
    public String showCalculos2(@RequestParam Integer numero, Model model){
        String dev="Es un número primo.";
        for(int con=2;con<=(numero/2);con++){
            if((numero%con)==0){
                dev="No es un número primo.";
            }
    }
    model.addAttribute("dev", dev);
    return "esPrimo";
}
}
