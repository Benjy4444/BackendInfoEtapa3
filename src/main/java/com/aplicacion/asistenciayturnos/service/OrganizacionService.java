package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrganizacionService {
    public List<Organizacion> findAll();

    public Organizacion findById(Long organizacionId);

    public void save(Organizacion organizacion);

    public void deleteById(Long organizacionId);

    public void modify(Organizacion organizacion);
}
