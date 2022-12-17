package com.aplicacion.asistenciayturnos.service;

import java.util.List;
import java.util.Optional;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.repository.EventoDao;
import com.aplicacion.asistenciayturnos.repository.OrganizacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventoServiceImp implements EventoService {

    @Autowired
    private EventoDao eventoDao;

    @Override
    public Evento create(Evento evento) {
        return eventoDao.save(evento);
    }

    @Override
    public Evento update(Evento evento) {
        return eventoDao.save(evento);
    }

    @Override
    public List<Evento> findAll() {
        return eventoDao.findAll();
    }

    @Override
    public Evento findById(Long eventoId) {
        Optional<Evento> eventoOptional = eventoDao.findById(eventoId);
        return eventoOptional.orElse(null);
    }

    @Override
    public void delete(Long eventoId) {
        eventoDao.deleteById(eventoId);
    }

    @Override
    public Evento findByNombre(String eventoNombre) {
        Optional<Evento> eventoOptional = eventoDao.findByNombre(eventoNombre);
        return eventoOptional.orElse(null);
    }
}
