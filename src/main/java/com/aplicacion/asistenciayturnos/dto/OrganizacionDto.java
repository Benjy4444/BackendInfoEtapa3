package com.aplicacion.asistenciayturnos.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Organizacion} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionDto implements Serializable {
    @Getter @Setter
    private Long cuit;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String direccion;
    @Getter @Setter
    private Integer telefono;
    @Getter @Setter
    private String correo;
}