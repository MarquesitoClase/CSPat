package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {
@Autowired
		CalculosService calculoService;
	@Test
	public void EsPrimoTestFalse(){
		for (int i = 4; i < 100; i+=2) {
			assertEquals(false, calculoService.esPrimoService(i));
		}
	}

	@Test
	public void EsPrimoTestFail(){
		assertThrows(RuntimeException.class, () -> {calculoService.esPrimoService(-4);});
	}
}
