package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import com.aplicacion.asistenciayturnos.entity.Usuario;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UsuarioDao {
    public List<Usuario> findAll();

    public Usuario findById(Long id);

    public void save(Usuario usuario);

    public void modify(Usuario usuario);

    public void deleteById(Long id);

}
