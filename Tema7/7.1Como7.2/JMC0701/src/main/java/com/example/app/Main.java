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

	/**
	 * @param empleadoService
	 * @param departamentoService
	 * @return
	 */
@Bean
CommandLineRunner initData(EmpleadoService empleadoService, DepartamentoService departamentoService) {
return args -> {
empleadoService.añadir(new Empleado(1L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO));
//id autogenerado, nombre y función
departamentoService.añadir(new Departamento(1L, "Investigación", "Descubrir nuevos productos"));
};
}
}
