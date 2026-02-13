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
			
			departamentoService.añadir(new Departamento(0L, "Investigación"));
			departamentoService.añadir(new Departamento(0L, "Desarrollo"));
			empleadoService.añadir(new Empleado(0L, "pepe", "pepe@gmail.com",
					1500d, true, Genero.MASCULINO, departamentoService.obtenerPorId(1)));
			empleadoService.añadir(new Empleado(0L, "ana", "ana@gmail.com",
					2000d, true, Genero.FEMENINO, departamentoService.obtenerPorId(0)));
		};
	}
}
