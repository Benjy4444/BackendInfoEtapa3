package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Organizacion;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrganizacionDao {
    List<Organizacion> findAll();

    Organizacion findById(Long id);

    List<Organizacion> findByCuit(Long cuit);

    Organizacion findByNombre(String nombre);

    void save(Organizacion organizacion);

    void modify(Organizacion organizacion);

    void deleteById(Long id);

}
