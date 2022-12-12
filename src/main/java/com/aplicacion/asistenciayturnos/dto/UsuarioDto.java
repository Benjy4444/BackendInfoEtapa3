package com.aplicacion.asistenciayturnos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Usuario} entity
 */
@Data
public class UsuarioDto implements Serializable {
    @Getter @Setter
    private final Long dni;
    @Getter @Setter
    private final String nombre;
    @Getter @Setter
    private final String apellido;
    @Getter @Setter
    private final String direccion;
    @Getter @Setter
    private final Long telefono;
    @Getter @Setter
    private final String correo;
}