package clase.juanmarquez.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Controlador {
    @GetMapping({ "/", "/home", "/index" })
    public String showHome(Model model) {
        model.addAttribute("fecha", "2023");
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
    @GetMapping({ "/", "/home", "/index" })
    public String showHomeUsuario(Model model) {
        model.addAttribute("fecha", "2023");
        return "indexView";
    }
}
