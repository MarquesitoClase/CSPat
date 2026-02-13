package com.example.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    CalculosServiceImplements calculosService;

    @GetMapping({ "/", "/home", "/index" })
    public String showHome(@RequestParam(required = false) String usuario, Model model) {
        model.addAttribute("usuario", usuario);

        model.addAttribute("fecha", LocalDate.now());
        return "indexView";
    }

    // Se llaman así a los path variables(este de abajo)
    // http://localhost:9000/calculos/primo/3
    @GetMapping("/primo/{numero}")
    public String showCalculos(@PathVariable Integer numero, Model model) {
        if (calculosService.esPrimoService(numero))
            return ("/esPrimo");
        return ("/noEsPrimo");
    }

    @GetMapping("/primo")
    public ResponseEntity showCalculos2(@RequestParam Integer comprobar, Model model) {
        CalculosServiceImplements cs=new CalculosServiceImplements();
        boolean es;
        String primoS;
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("numero", comprobar.toString());
        if(cs.esPrimoService(comprobar)) es=true;
        else es=false;
        if(es) mapa.put("primo", "true");
        else{mapa.put("primo", "false");}
        return ResponseEntity.ok(mapa);

    }

    @GetMapping("/divisores/{numero}")
    public String Divisores(@PathVariable Integer numero, Model model) {
        ArrayList<Integer> div = calculosService.divisoresService(numero);
        model.addAttribute("listaDivisores", div);
        return "divisoresView";
    }
    // El apartado no lo entiendo.
}
