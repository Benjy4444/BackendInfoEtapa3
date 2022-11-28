package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EventoDao {
    public List<Evento> findAll();

    public Evento findById(Long id);

    public void save(Evento evento);

    public void modify(Evento evento);

    public void deleteById(Long id);
}
