package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface TurnoDao extends JpaRepository<Turno, Long> {

    //Turno findByIdorganizacionAndIdevento(Long idOrganizacion, Long idEvento);

    List<Turno> findByIdevento(Long idEvento);
}
