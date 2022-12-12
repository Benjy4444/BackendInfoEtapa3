package com.aplicacion.asistenciayturnos.service;

import java.util.List;
import java.util.Optional;

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

    /*
    @Override
    public List<Turno> findByIdorganizacionAndIdevento(Long idOrganizacion, Long idEvento) {
        Optional<Turno> turnoOptional = turnoDao.findByIdorganizacionAndIdevento(idOrganizacion, idEvento);
        return (List<Turno>) turnoOptional.orElse(null);
    }
    */

    @Override
    public void delete(Long turnoId) {
        turnoDao.deleteById(turnoId);
    }

}