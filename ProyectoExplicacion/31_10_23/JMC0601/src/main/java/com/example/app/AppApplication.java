package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.domain.Empleado;
import com.example.app.services.EmpleadoService;


@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		//System.out.println("Llego aquí");
		SpringApplication.run(AppApplication.class, args);
	}

@Bean
CommandLineRunner initData(EmpleadoService empleadoService) {
	return args -> {
	empleadoService.añadir(
	new Empleado(1L, "pepe", "pepe@gmail.com", 1000d));
	empleadoService.añadir(
	new Empleado(2L, "ana", "ana@gmail.com", 2000d));
	};
}
}