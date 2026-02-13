package clase.juanmarquez.demo.Controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clase.juanmarquez.demo.FormInfo;
@Controller
public class Controlador {
    /**
     *
     */
    
    @GetMapping({ "/", "/home", "/index"})
    public String showHome(@RequestParam (required=false) String usuario, Model model) {
        model.addAttribute("usuario", usuario);
        
        model.addAttribute("fecha", LocalDate.now());
        return "indexView";
    }
    
    @GetMapping({"/contacta", "/contact"})
    public String showContacta(Model model){
        return "contacta";
    }
    @GetMapping("/productos")
    public String showProductros(Model model){
        return "productos";
    }
    @GetMapping({"/quienes-somos", "/quienes"})
    public String showQuienesSomos(Model model){
        return "quienes-somos";
    }
    @GetMapping("/form")
    public String showFormulario(Model model){
        model.addAttribute ("FormInfo", new FormInfo());
        return "form";
    }
}