package com.example.app.Repositorios;

import org.springframework.stereotype.Repository;

import com.example.app.domain.Departamento;

@Repository
public  class DepartamentoRepository extends JpaRepository<Departamento, Long> {

    public void save(Departamento departamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
