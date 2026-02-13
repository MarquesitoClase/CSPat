package com.example.app.Services;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.app.Repositorios.EmpleadosRepository;
import com.example.app.domain.Empleado;
import com.example.app.domain.Genero;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoServiceTest {
    
    @InjectMocks
    EmpleadoServiceImplBD empleadoervice;

    @Mock
    EmpleadosRepository empleadosRepository;

    @Test
    public void obtenerTodosTest(){
       List<Empleado> mockList = new ArrayList<>();
       mockList.add(new Empleado(1L, "pepe", "mail@example.com", 800d, true, Genero.MASCULINO));
       mockList.add(new Empleado(2L, "pepe", "mail@example.com", 800d, false, Genero.MASCULINO));
       mockList.add(new Empleado(3L, "pepe", "mail@example.com", 800d, false, Genero.MASCULINO));
       
       when (empleadosRepository.findAll()).thenReturn(mockList);
       List<Empleado> empList = empleadoervice.obtenerTodos();
       assertEquals(1, empList.size());
       assertEquals(true, mockList.get(0).isEnActivo());
    }
}