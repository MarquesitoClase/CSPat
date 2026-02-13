package com.example.app.Services;

import com.example.app.domain.CuentaCorriente;


public interface CuentaService {
    public void hacerMovimiento(double cantidad, String IBANc);
    public void añadirCuenta(CuentaCorriente cc);
    public boolean eliminarCuenta(CuentaCorriente cc) throws Exception;
    public CuentaCorriente buscarCuenta(String IBAN) throws Exception;
}
