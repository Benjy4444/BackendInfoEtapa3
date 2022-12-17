package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByDniOrApellido(Long dni, String apellido);

    Optional<Usuario> findByDni(Long usuarioDni);

    <Usuario> Optional<com.aplicacion.asistenciayturnos.entity.Usuario> findByApellido(String usuarioApellido);
}
