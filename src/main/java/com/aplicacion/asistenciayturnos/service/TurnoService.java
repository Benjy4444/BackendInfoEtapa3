package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Turno;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TurnoService {
    Turno create(Turno turno);

    Turno update(Turno turno);

    List<Turno> findAll();

    Turno findById(Long turnoId);

    void delete(Long turnoId);

    //List<Turno> findByIdorganizacionAndIdevento(Long idOrganizacion, Long idEvento);

}
