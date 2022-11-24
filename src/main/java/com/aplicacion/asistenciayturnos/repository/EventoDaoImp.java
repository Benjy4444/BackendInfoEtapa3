package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

@Repository
@Transactional
public class EventoDaoImp implements EventoDao{
    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Evento> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Evento> theQuery = currentSession.createQuery("from Evento", Evento.class);

        /* String query = "FROM Evento";
        return entityManager.createQuery(query).getResultList(); */

        List<Evento> eventos = theQuery.getResultList();

        return eventos;

    }

    @Override
    public Evento findById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Evento evento = currentSession.get(Evento.class, id);

        //return entityManager.find(Evento.class, id);

        return evento;
    }

    @Override
    public void save(Evento evento) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(evento);

        //V2
        //entityManager.merge(evento);

    }

    @Override
    public void modify(Evento evento) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(evento);

        //V2
        //entityManager.merge(evento);

    }

    @Override
    public void deleteById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Evento> theQuery = currentSession.createQuery("delete from Evento where id=:idEvento");

        theQuery.setParameter("idEvento", id);

        theQuery.executeUpdate();

    }

}