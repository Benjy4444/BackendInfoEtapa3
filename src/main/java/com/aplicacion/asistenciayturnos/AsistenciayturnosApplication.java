package com.aplicacion.asistenciayturnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("com.aplicacion.asistenciayturnos")
public class AsistenciayturnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsistenciayturnosApplication.class, args);
	}

}
