package com.aplicacion.asistenciayturnos.service;

import java.util.List;

import com.aplicacion.asistenciayturnos.entity.Usuario;
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
    public List<Usuario> findAll() {
        List<Usuario> listUsuarios = usuarioDao.findAll();
        return listUsuarios;
    }

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = usuarioDao.findById(id);
        return usuario;
    }

    @Override
    public void save(Usuario usuario) {usuarioDao.save(usuario);
    }

    @Override
    public void modify(Usuario usuario) {usuarioDao.modify(usuario);
    }

    @Override
    public void deleteById(Long id) {usuarioDao.deleteById(id);
    }

}