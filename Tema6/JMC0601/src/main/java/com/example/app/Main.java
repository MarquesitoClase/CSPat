package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.Services.EmpleadoService;
import com.example.app.domain.Empleado;
import com.example.app.domain.Genero;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	public void comandLineRuner(EmpleadoService empleadoService){
		empleadoService.añadir(new Empleado(1L, "Empleado1", "empleado1@gmail.com", 1111d, true, Genero.MASCULINO));
		empleadoService.añadir(new Empleado(2L, "Empleado2", "empleado2@gmail.com", 2222d, true, Genero.FEMENINO));
	}

}
