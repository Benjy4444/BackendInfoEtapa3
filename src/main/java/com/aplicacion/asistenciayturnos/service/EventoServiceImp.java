package com.aplicacion.asistenciayturnos.service;

import java.util.List;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.repository.EventoDao;
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
    public List<Evento> findAll() {
        List<Evento> listEventos= eventoDao.findAll();
        return listEventos;
    }

    @Override
    public Evento findById(Long id) {
        Evento evento = eventoDao.findById(id);
        return evento;
    }

    @Override
    public void save(Evento evento) {eventoDao.save(evento);
    }

    @Override
    public void modify(Evento evento) {eventoDao.modify(evento);
    }

    @Override
    public void deleteById(Long id) {eventoDao.deleteById(id);
    }

}
