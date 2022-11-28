package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Evento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EventoService {
    List<Evento> findAll();

    Evento findById(Long eventoId);

    void save(Evento evento);

    void deleteById(Long eventoId);

    void modify(Evento evento);

}
