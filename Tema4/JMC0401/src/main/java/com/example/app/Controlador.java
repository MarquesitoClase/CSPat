package com.example.app;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculos")
public class Controlador {

    @Autowired 
    CalculosService calculosService;
    
   
    @GetMapping({ "/", "/home", "/index"})
    public String showHome(@RequestParam (required=false) String usuario, Model model) {
        model.addAttribute("usuario", usuario);
        
        model.addAttribute("fecha", LocalDate.now());
        return "indexView";
    }
    
    //Se llaman así a los path variables(este de abajo) 
    //http://localhost:9000/calculos/primo/3
    @GetMapping("/primo/{numero}")
    public String showCalculos(@PathVariable Integer numero, Model model){
        if(calculosService.esPrimoService(numero)) return("/esPrimo");
        return("/noEsPrimo");
    }
    
    @GetMapping("/primo")
    public String showCalculos2(@RequestParam Integer primo, Model model){
        boolean es=true;
        for(int con=2;con<=(primo/2);con++){
            if((primo%con)==0){
                es=false;
            }
    }
    if(es) return "esPrimo";
    else return "noEsPrimo";
}


    @GetMapping("/divisores/{numero}")
    public String Divisores(@PathVariable Integer numero, Model model){
        ArrayList<Integer> div=calculosService.divisoresService(numero);
        model.addAttribute("listaDivisores", div);
        return "divisoresView";
    }
    //El apartado  no lo entiendo.
}
