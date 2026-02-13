package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.Services.CuentaService;


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
CommandLineRunner initData(CuentaService cuentaService) {
return args -> {
	//empleadoService.añadir(new Empleado(1L, "E1", "correo@gmail.com", 2000.0, false, Genero.MASCULINO));
};
}
}
