package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.Repositorios.CuentaRepository;
import com.example.app.domain.CuentaCorriente;

import jakarta.validation.Valid;
import lombok.NonNull;

public class CuentaServiceImpBD implements CuentaService{
    @Autowired
    CuentaRepository cR;
    @Override
    public void hacerMovimiento(double cantidad,@NonNull String IBANc) {
        CuentaCorriente cuentaMod;
        cuentaMod = cR.findById(IBANc).orElseThrow(()->{throw new RuntimeException("No se ha encontrado la cuenta buscada para modificar.");});
    }

    @Override
    public void añadirCuenta(@Valid @NonNull CuentaCorriente cc) {
        cR.save(cc);
    }

    @Override
    public boolean eliminarCuenta(@Valid  @NonNull CuentaCorriente cc) {
        cR.findById(cc.getIban()).orElseThrow(()->{throw new RuntimeException("La cuenta que desea borrar ya no existe en mis datos.");});
        return true;
    }

    @Override
    public CuentaCorriente buscarCuenta(String IBAN) throws Exception {
        CuentaCorriente dev=null;
        for (int i = 0; i < cR.findAll().size(); i++) {
            if(cR.findAll().get(i).getIban().equals(IBAN)) dev = cR.findAll().get(i);
        }
        if(dev != null) return dev;
        else throw new Exception("Cuenta no encontrada");
    }
}
