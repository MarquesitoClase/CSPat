package com.example.app.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.app.domain.Empleado;


public interface EmpleadosRepository extends JpaRepository<Empleado, Long> {
    Empleado findByNombre(String nombre) throws Exception;
        @Query("select e from Empleado e where e.id=(select max(e2.id) from Empleado e2)")
            Empleado obtenerMaxIdEmpleado();
        
}