package com.aplicacion.asistenciayturnos.service;

import java.util.List;

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
    public List<Turno> findAll() {
        List<Turno> listTurnos= turnoDao.findAll();
        return listTurnos;
    }

    @Override
    public Turno findById(Long id) {
        Turno turno = turnoDao.findById(id);
        return turno;
    }

    @Override
    public void save(Turno turno) {turnoDao.save(turno);
    }

    @Override
    public void modify(Turno turno) {turnoDao.modify(turno);
    }

    @Override
    public void deleteById(Long id) {turnoDao.deleteById(id);
    }

}