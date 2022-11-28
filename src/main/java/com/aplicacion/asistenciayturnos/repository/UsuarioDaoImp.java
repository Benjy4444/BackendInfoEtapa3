package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.aplicacion.asistenciayturnos.entity.Turno;
import com.aplicacion.asistenciayturnos.entity.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("from Usuario", Usuario.class);

        /* String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList(); */

        List<Usuario> usuarios = theQuery.getResultList();

        return usuarios;

    }

    @Override
    public Usuario findById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Usuario usuario = currentSession.get(Usuario.class, id);

        //return entityManager.find(Usuario.class, id);

        return usuario;
    }

    @Override
    public void save(Usuario usuario) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(usuario);

        //V2
        //entityManager.merge(usuario);

    }

    @Override
    public void modify(Usuario usuario) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(usuario);

        //V2
        //entityManager.merge(usuario);

    }

    @Override
    public void deleteById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("delete from Usuario where id=:idUsuario");

        theQuery.setParameter("idUsuario", id);

        theQuery.executeUpdate();

    }

}