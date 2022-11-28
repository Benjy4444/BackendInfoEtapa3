/*
Falta trabajar en:
...búsquedas específicas para cada entidad...
...pedido de claves para modificar y eliminar registros...
...generación de códigos en turnos...
...tema de fecha y hora en el turno... que depende del tipo de evento...
...ver tema de aplicar DTO???...
...ver tema de aplicar ControlerAdvice...
...ver tema de aplicar Swagger...
*/

package com.aplicacion.asistenciayturnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aplicacion.asistenciayturnos")
public class AsistenciayturnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsistenciayturnosApplication.class, args);
	}

}
