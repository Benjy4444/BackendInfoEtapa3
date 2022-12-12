package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EventoService {
    Evento create(Evento evento);

    Evento update(Evento evento);

    List<Evento> findAll();

    Evento findById(Long eventoId);

    void delete(Long eventoId);

}
