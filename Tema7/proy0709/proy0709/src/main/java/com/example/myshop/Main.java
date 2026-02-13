package com.example.myshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Producto;
import com.example.myshop.domain.TipoIva;
import com.example.myshop.services.CategoriaService;
import com.example.myshop.services.ProductoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
		return args -> {
			Categoria cat1 = categoriaService.añadir(new Categoria(0L, "Ordenadores"));
			Categoria cat2 = categoriaService.añadir(new Categoria(0L, "Impresoras"));
			
			productoService.añadir(new Producto(0L, "Asus ChromeBook", true, TipoIva.NORMAL, 10.2, cat2));
			productoService.añadir(new Producto(0L, "Lenovo IdeaPad", true, TipoIva.NORMAL, 10.2, cat2));

			productoService.añadir(new Producto(0L, "Cat1-1", true, TipoIva.NORMAL, 10.2, cat1));
			productoService.añadir(new Producto(0L, "Cat1-2", true, TipoIva.NORMAL, 10.2, cat1));

		};

	}
}
