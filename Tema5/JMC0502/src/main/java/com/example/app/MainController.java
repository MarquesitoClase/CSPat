package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/myForm")
    public String showForm(Model model){
        model.addAttribute("formInfo", new FormInfo());
        return "formView";
    }
    @PostMapping("myForm/submit")
    public String showMyFormSubmit(@ModelAttribute FormInfo formInfo){
        formInfo.setNombre(formInfo.getNombre().toUpperCase());
        return "formSubmitView";
    }
    
}
