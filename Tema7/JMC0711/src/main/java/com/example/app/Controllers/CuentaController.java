package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.Services.CuentaService;
import com.example.app.domain.CuentaCorriente;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CuentaController {
     public CuentaService cuentaService;
     CuentaCorriente cuenta;
    @GetMapping("/mostrarCuentas")
    public String mostrarTodas(Model model){
      model.addAttribute("Cuentas", cuentaService);
      return "verTodas";
    }

    @GetMapping("/verCuenta/{IBAN}")
    public String mostrarUna(Model model, String IBANVer) throws Exception{
        cuenta = cuentaService.buscarCuenta(IBANVer);
        model.addAttribute("cuenta", cuenta);
        return "verCuenta";
    }
    @GetMapping("/basica")
    public String mostrarBasica() {
        return "basica";
    }
    
}
