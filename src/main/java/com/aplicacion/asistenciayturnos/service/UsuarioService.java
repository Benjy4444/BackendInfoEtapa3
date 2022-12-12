package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Turno;
import com.aplicacion.asistenciayturnos.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsuarioService {
    Usuario create(Usuario usuario);

    Usuario update(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(Long usuarioId);

    void delete(Long usuarioId);

    Usuario findByDniOrApellido(Long usuarioDni, String usuarioApellido);

}
