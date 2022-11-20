package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Organizacion;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrganizacionDao {
    public List<Organizacion> findAll();

    public Organizacion findById(Long id);

    public void save(Organizacion organizacion);

    public void modify(Organizacion organizacion);

    public void deleteById(Long id);
}
