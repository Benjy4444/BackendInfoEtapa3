package com.aplicacion.asistenciayturnos.service;

import java.util.List;

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
    public List<Organizacion> findAll() {
        List<Organizacion> listOrganizaciones= organizacionDao.findAll();
        return listOrganizaciones;
    }

    @Override
    public Organizacion findById(Long id) {
        Organizacion organizacion = organizacionDao.findById(id);
        return organizacion;
    }

    @Override
    public Organizacion findByCuit(Long cuit) {
        List<Organizacion> listOrganizaciones= organizacionDao.findByCuit(cuit);
        return (Organizacion) listOrganizaciones;
    }

    @Override
    public Organizacion findByNombre(String nombre) {
        Organizacion organizacion = organizacionDao.findByNombre(nombre);
        return organizacion;
    }

    @Override
    public void save(Organizacion organizacion) {
        organizacionDao.save(organizacion);
    }

    @Override
    public void modify(Organizacion organizacion) {
        organizacionDao.modify(organizacion);
    }

    @Override
    public void deleteById(Long id) {
        organizacionDao.deleteById(id);
    }

}
