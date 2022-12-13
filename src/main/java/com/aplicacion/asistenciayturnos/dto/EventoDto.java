package com.aplicacion.asistenciayturnos.dto;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * A DTO for the {@link com.aplicacion.asistenciayturnos.entity.Evento} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDto implements Serializable {
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private Date fecha;
    @Getter @Setter
    private Time hora;
    @Getter @Setter
    private String ubicacion;
    @Getter @Setter
    private String organizacion;



}