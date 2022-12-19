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

    List<Turno> findByEventoIdevento(Long idEvento);

    List<Turno> findByEventoIdeventoAndEventoOrganizacionIdorganizacion(Long idEvento, Long idOrganizacion);

    Turno findByCodigo(String turnoCodigo);

    List<Turno> findByEventoNombreAndEventoOrganizacionCuit(String nombreEvento, Long cuitOrganizacion);

    List<Turno> findByEventoNombre(String nombreEvento);
}
