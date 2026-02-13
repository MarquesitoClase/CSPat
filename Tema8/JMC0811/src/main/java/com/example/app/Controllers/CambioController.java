package com.example.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.Services.CambioService;
import com.example.app.dto.CambioData;

import jakarta.validation.Valid;



@Controller
public class CambioController {
    @Autowired
    public CambioService cambioService;

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("formInfo", new CambioData());
        return "indexView";
    }

    @PostMapping("/cambioMoneda")
    public String calcularImporteCambiado(
        @Valid CambioData formInfo,
        BindingResult bindingResult,
        Model model) {
         //   System.out.println("Llegue a /cambioMoneda");
            /*
             * Esto imprime, así que llega. Saca:
             * Llegue a /cambioMoneda
             * /latest?from=null&to=null
             * 
             * Y el lugar del error pone este
             * Error has been observed at the following site(s):
	         * __checkpoint ⇢ 404 NOT_FOUND from GET https://api.frankfurter.app/latest [DefaultWebClient]
             * en la propia web rota.
             */
            if(bindingResult.hasErrors()){
                System.out.println("Entre en .haserrors");
                return "/";
            }
            Double importeCambiado = cambioService.calcularImporteCambiado(formInfo.getMonedaOrigen(),formInfo.getMonedadestino(),10.0);
            model.addAttribute("importeCambiado", importeCambiado);
            return "resultView";
    }
    
    
}

