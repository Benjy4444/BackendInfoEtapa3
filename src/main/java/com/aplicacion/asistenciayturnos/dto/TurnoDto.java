package com.aplicacion.asistenciayturnos.dto;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Usuario;
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
public class TurnoDto implements Serializable {
    @Getter @Setter
    private Date fecha;
    @Getter @Setter
    private Time hora;
    @Getter @Setter
    private String organizacion;
    @Getter @Setter
    private String evento;
    @Getter @Setter
    private String usuario;

}