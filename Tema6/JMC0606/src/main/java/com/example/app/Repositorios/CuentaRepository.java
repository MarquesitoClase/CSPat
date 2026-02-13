package com.example.app.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.domain.CuentaCorriente;

public class CuentaRepository {
    @Repository
public interface EmpleadosRepository extends JpaRepository<CuentaCorriente, String> {

}
}
