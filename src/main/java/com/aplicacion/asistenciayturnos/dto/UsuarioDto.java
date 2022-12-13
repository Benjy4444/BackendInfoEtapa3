package com.aplicacion.asistenciayturnos.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Usuario} entity
 */
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {
    @Getter @Setter
    private Long dni;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private String direccion;
    @Getter @Setter
    private Long telefono;
    @Getter @Setter
    private String correo;
}