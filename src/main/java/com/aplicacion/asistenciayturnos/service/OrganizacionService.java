package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrganizacionService {
    List<Organizacion> findAll();

    Organizacion findById(Long organizacionId);

    Organizacion findByCuit(Long organizacionCuit);

    Organizacion findByNombre(String organizacionNombre);

    void save(Organizacion organizacion);

    void deleteById(Long organizacionId);

    void modify(Organizacion organizacion);

}
