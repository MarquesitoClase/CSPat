package clase.juanmarquez.demo;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class PrimerController {
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

    @GetMapping({"/quienes-somos", "/quienes", "/AboutUs"})
    public String showAboutUs(FormInfo2 formInfo2, Model model){
        ArrayList<String> empleados=new ArrayList<>(Arrays.asList("Pepe", "Ana", "Juana"));
        model.addAttribute("Empleados", empleados);
        model.addAttribute("formInfo2", new FormInfo2());
        return "AboutUs";
    }
    @PostMapping({"/quienes-somos", "/quienes", "/AboutUs"})
    public String showAboutUsSelec(FormInfo2 formInfo2, Model model){
        ArrayList<String> empleados=new ArrayList<>(Arrays.asList("Pepe", "Ana", "Juana"));
        model.addAttribute("Empleados", empleados);
        model.addAttribute("formInfo2", new FormInfo2());
        model.addAttribute("empleadoDelMes", formInfo2.getNombreEmpleado());
        return "AboutUs";
    }
    

    //formularios
    @GetMapping ("/multiplicar")
    public String showMultiplicar (Model model){
        model.addAttribute("formImfo", new FormInfo());
        return "multiplicaView";
    }

}
