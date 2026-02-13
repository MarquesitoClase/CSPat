package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.CuentaCorriente;


@Controller
public class CuentaController {
    @GetMapping("/verCuenta/{IBAN}")
    
}
