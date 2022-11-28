package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Turno;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TurnoDao {
    public List<Turno> findAll();

    public Turno findById(Long id);

    public void save(Turno turno);

    public void modify(Turno turno);

    public void deleteById(Long id);

}
