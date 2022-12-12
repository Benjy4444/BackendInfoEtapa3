package com.aplicacion.asistenciayturnos.service;

import java.util.List;
import java.util.Optional;

import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Turno;
import com.aplicacion.asistenciayturnos.entity.Usuario;
import com.aplicacion.asistenciayturnos.repository.TurnoDao;
import com.aplicacion.asistenciayturnos.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario findById(Long usuarioId) {
        Optional<Usuario> usuarioOptional = usuarioDao.findById(usuarioId);
        return usuarioOptional.orElse(null);
    }

    @Override
    public Usuario findByDniOrApellido(Long usuarioDni, String usuarioApellido) {
        Optional<Usuario> usuarioOptional = usuarioDao.findByDniOrApellido(usuarioDni, usuarioApellido);
        return usuarioOptional.orElse(null);
    }

    @Override
    public void delete(Long usuarioId) {
        usuarioDao.deleteById(usuarioId);
    }

}