package com.example.app.Repositorios;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.app.domain.CuentaCorriente;
import com.example.app.domain.Movimiento;

@Repository
public interface MovimientosRepository {
    List<Movimiento> findByCuenta(CuentaCorriente cuenta);
}