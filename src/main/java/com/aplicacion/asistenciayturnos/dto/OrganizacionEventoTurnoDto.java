package com.aplicacion.asistenciayturnos.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Turno} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionEventoTurnoDto extends OrganizacionEventoDto implements Serializable {
    @Getter @Setter
    private String codigo;
    @Getter @Setter
    private Date fecha;
    @Getter @Setter
    private Time hora;
    @Getter @Setter
    private Boolean activo;
    @Getter @Setter
    private EventoDto evento;
    @Getter @Setter
    private OrganizacionDto organizacion;
    @Getter @Setter
    private List<UsuarioDto> usuarios;
}