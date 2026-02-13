package com.example.app.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.domain.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
   
}