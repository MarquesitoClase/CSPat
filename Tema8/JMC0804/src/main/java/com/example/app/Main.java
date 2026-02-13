package com.example.app;

import java.util.ArrayList;

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
	empleadoService.añadir(new Empleado(1L, "E1", "correo@gmail.com", 2000.0, false, Genero.MASCULINO));
	empleadoService.añadir(new Empleado(2L, "E2", "correo@gmail.com", 2000.0, false, Genero.FEMENINO));
	ArrayList<Empleado> Trabajadores1=new ArrayList<>();
	ArrayList<Empleado> Trabajadores2=new ArrayList<>();
	Trabajadores1.add(empleadoService.obtenerPorId(1L));
	Trabajadores2.add(empleadoService.obtenerPorId(2L));
	departamentoService.añadir(new Departamento(1L, "Informatica", "Desarrollar software", Trabajadores1));
	departamentoService.añadir(new Departamento(2L, "Desarrollo Hardware", "Crear nuevos componentes de ordenador",
	Trabajadores2));
};
}
}
