package clase.juanmarquez.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Controlador {
    @GetMapping({ "/", "/home" })
    public String showHome(Model model) {
        return "indexView";
    }
    @GetMapping({"/contacta", "/contact"})
    public String showContacta(Model model){
        return "contacta";
    }
    
}
