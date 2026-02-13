package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.Services.DepartamentoService;
import com.example.app.Services.EmpleadoService;
import com.example.app.domain.Departamento;
import com.example.app.domain.Empleado;
import com.example.app.domain.Genero;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService, DepartamentoService departamentoService) {
		return args -> {
			
			departamentoService.añadir(new Departamento(1L, "Investigación"));
			departamentoService.añadir(new Departamento(2L, "Desarrollo"));

			empleadoService.añadir(new Empleado(1L, "Ana", "Ana3@gmail.com",
					950d, true, Genero.FEMENINO, departamentoService.obtenerTodos().get(1)));
			empleadoService.añadir(new Empleado(0L, "Pepe", "pepe@gmail.com",
					1000d, true, Genero.MASCULINO, departamentoService.obtenerTodos().get(0)));
			
		};
	}
}
