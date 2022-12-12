package com.aplicacion.asistenciayturnos.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Evento} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionEventoDto extends OrganizacionDto implements Serializable {
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private Date fecha;
    @Getter @Setter
    private String ubicacion;
    @Getter @Setter
    private Boolean tipo;
    @Getter @Setter
    private OrganizacionDto organizacion;

}