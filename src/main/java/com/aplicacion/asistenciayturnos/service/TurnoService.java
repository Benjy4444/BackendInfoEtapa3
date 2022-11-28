package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Turno;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TurnoService {
    List<Turno> findAll();

    Turno findById(Long turnoId);

    void save(Turno turno);

    void deleteById(Long turnoId);

    void modify(Turno turno);

}
