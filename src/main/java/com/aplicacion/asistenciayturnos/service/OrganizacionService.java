package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface OrganizacionService {

    Organizacion create(Organizacion organizacion);

    Organizacion update(Organizacion organizacion);

    List<Organizacion> findAll();

    Organizacion findById(Long organizacionId);

    void delete(Long organizacionId);

    Organizacion findByCuitOrNombre(Long organizacionCuit, String organizacionNombre);

    Organizacion findByCuit(Long organizacionCuit);

    Organizacion findByNombre(String organizacionNombre);
}
