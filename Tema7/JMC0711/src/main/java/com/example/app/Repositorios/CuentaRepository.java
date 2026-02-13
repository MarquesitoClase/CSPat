package com.example.app.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.domain.CuentaCorriente;


public interface CuentaRepository extends JpaRepository <CuentaCorriente, String> {

}