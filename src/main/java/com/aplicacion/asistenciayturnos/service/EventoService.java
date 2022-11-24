package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Evento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EventoService {
    public List<Evento> findAll();

    public Evento findById(Long eventoId);

    public void save(Evento evento);

    public void deleteById(Long eventoId);

    public void modify(Evento evento);
}
