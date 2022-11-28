package com.aplicacion.asistenciayturnos.service;

import com.aplicacion.asistenciayturnos.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsuarioService {
    List<Usuario> findAll();

    Usuario findById(Long usuarioId);

    void save(Usuario usuario);

    void deleteById(Long usuarioId);

    void modify(Usuario usuario);

}
