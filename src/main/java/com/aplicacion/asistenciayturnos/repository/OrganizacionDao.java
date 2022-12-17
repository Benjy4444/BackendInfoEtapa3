package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface OrganizacionDao extends JpaRepository<Organizacion, Long> {
    Organizacion findByCuitOrNombre(Long cuit, String nombre);

    Optional<Object> findByCuit(Long organizacionCuit);

    Optional<Object> findByNombre(String organizacionNombre);
}
