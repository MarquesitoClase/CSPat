package clase.juanmarquez.demo.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clase.juanmarquez.demo.FormInfo;
import clase.juanmarquez.demo.domain.Categoria;
import clase.juanmarquez.demo.domain.Producto;
import clase.juanmarquez.demo.domain.TipoIva;
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
    
    @GetMapping("/productos")
    public String showProductros(Model model){
        model.addAttribute("Producto 1", new Producto(1L, "Nintendo Switch", false, TipoIva.normal, 30, 260));
        model.addAttribute("Producto 2", new Producto(2L, "XboxOne", false, TipoIva.normal, 30, 330));
        model.addAttribute("Producto 3", new Producto(3L, "PS5", false, TipoIva.normal, 30, 340));
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
    @GetMapping("/categorias")
    public String showCategorias(Model model){
        ArrayList<Categoria> categorias=new ArrayList<Categoria>();
        categorias.add(new Categoria(1L, "Accion"));
        categorias.add(new Categoria(2L, "Aventura"));
        model.addAttribute("Categorias",  categorias);
        return "categorias";
    }
    @GetMapping({"/contacta", "/contact"})
    public String showContacta(Model model){
        return "contacta";
    }
}