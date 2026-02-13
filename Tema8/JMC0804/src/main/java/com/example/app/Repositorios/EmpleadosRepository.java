package com.example.app.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.app.domain.*;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Long> {

    Empleado findByNombre(String nombre);
}