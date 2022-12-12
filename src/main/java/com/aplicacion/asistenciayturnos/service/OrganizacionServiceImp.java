package com.aplicacion.asistenciayturnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.asistenciayturnos.repository.OrganizacionDao;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganizacionServiceImp implements OrganizacionService {

    @Autowired
    private OrganizacionDao organizacionDao;

    @Override
    public Organizacion create(Organizacion organizacion) {
        return organizacionDao.save(organizacion);
    }

    @Override
    public Organizacion update(Organizacion organizacion) {
        return organizacionDao.save(organizacion);
    }

    @Override
    public List<Organizacion> findAll() {
        return organizacionDao.findAll();
    }

    @Override
    public Organizacion findById(Long organizacionId) {
        Optional<Organizacion> organizacionOptional = organizacionDao.findById(organizacionId);
        return organizacionOptional.orElse(null);
    }

    @Override
    public Organizacion findByCuitOrNombre(Long organizacionCuit, String organizacionNombre) {
        Optional<Organizacion> organizacionOptional = organizacionDao.findByCuitOrNombre(organizacionCuit, organizacionNombre);
        return organizacionOptional.orElse(null);
    }

    @Override
    public void delete(Long organizacionId) {
        organizacionDao.deleteById(organizacionId);
    }

}
