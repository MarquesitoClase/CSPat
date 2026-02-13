package com.example.app.domain;

import java.util.ArrayList;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CuentaCorriente {
    @Id
    String iban;
    String nombre;
    Double saldo;
    ArrayList<Movimiento> movimientos;

    public void hacerMovimiento(Double c){
        this.movimientos.add(new Movimiento(0, c));
        this.saldo+=c;
    }
}
