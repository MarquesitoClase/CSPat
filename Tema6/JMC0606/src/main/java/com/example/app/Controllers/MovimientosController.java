package com.example.app.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.Services.CuentaService;
import com.example.app.domain.CuentaCorriente;
import com.example.app.domain.Movimiento;

public class MovimientosController {
            public CuentaService cuentaService;
    @GetMapping("/mostrarCuentas")
    public List<CuentaCorriente> showList() {
      return cuentaService;   
    }
}
