package com.example.app.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.domain.Departamento;


public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Departamento findByNombre(String nombre);
}