package com.aplicacion.asistenciayturnos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Evento} entity
 */
@Data
public class EventoDto implements Serializable {
    @Getter @Setter
    private final String nombre;
    @Getter @Setter
    private final Date fecha;
    @Getter @Setter
    private final String ubicacion;
}