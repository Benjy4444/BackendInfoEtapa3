package com.aplicacion.asistenciayturnos.service;

import java.util.List;
import java.util.Optional;

import com.aplicacion.asistenciayturnos.repository.EventoDao;
import com.aplicacion.asistenciayturnos.service.EventoService;
import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Turno;
import com.aplicacion.asistenciayturnos.repository.TurnoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TurnoServiceImp implements TurnoService {

    @Autowired
    private TurnoDao turnoDao;

    //@Autowired
    //private EventoDao eventoDao;

    //@Autowired
    //private EventoService eventoService;

    @Override
    public Turno create(Turno turno) {
        return turnoDao.save(turno);
    }

    @Override
    public Turno update(Turno turno) {
        return turnoDao.save(turno);
    }

    @Override
    public List<Turno> findAll() {
        return turnoDao.findAll();
    }

    @Override
    public Turno findById(Long turnoId) {
        Optional<Turno> turnoOptional = turnoDao.findById(turnoId);
        return turnoOptional.orElse(null);
    }


    /* Esta búsqueda no funciona... por la estructura de la tabla???
    @Override
    public List<Turno> findByIdorganizacionAndIdevento(Long idOrganizacion, Long idEvento) {
        List<Turno> turnos = (List<Turno>) turnoDao.findByIdorganizacionAndIdevento(idOrganizacion, idEvento);
        return turnos;
    }
    */


    //@Override
    //public List<Turno> findByIdevento(Long idEvento) {
        //Optional<Evento> evento = eventoDao.findById(idEvento);
        //Long idEventoBuscar = evento.getId();
        //List<Turno> turnos = (List<Turno>) turnoDao.findByIdevento(idEvento);
        //return null; //turnos;
    //}

    @Override
    public void delete(Long turnoId) {
        turnoDao.deleteById(turnoId);
    }

}