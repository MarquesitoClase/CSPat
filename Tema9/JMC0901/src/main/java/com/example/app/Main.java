package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.app.Services.DepartamentoService;
import com.example.app.Services.EmpleadoService;
import com.example.app.Services.UsuarioService;
import com.example.app.domain.Departamento;
import com.example.app.domain.Empleado;
import com.example.app.domain.Genero;
import com.example.app.domain.Rol;
import com.example.app.domain.Usuario;

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
	CommandLineRunner initData(PasswordEncoder passwordEncoder, EmpleadoService empleadoService,
			DepartamentoService departamentoService, UsuarioService usuarioService) {
		return args -> {
			departamentoService.añadir(new Departamento(0, "Desarrollo", "Crear nuevos programas.", null));
			empleadoService.añadir(new Empleado(null, "Pedro", "Pedro21@gmail.com", 1800.0, true, Genero.MASCULINO,
					departamentoService.obtenerTodos().get(0)));
			Usuario admin = new Usuario(null, "admin", passwordEncoder.encode("1234"), Rol.ADMIN);
			usuarioService.añadir(admin);
		};
	}
}
