package com.aplicacion.asistenciayturnos.repository;

import com.aplicacion.asistenciayturnos.entity.Evento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.aplicacion.asistenciayturnos.entity.Turno;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

@Repository
@Transactional
public class TurnoDaoImp implements TurnoDao{
    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Turno> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Turno> theQuery = currentSession.createQuery("from Turno", Turno.class);

        /* String query = "FROM Turno";
        return entityManager.createQuery(query).getResultList(); */

        List<Turno> turnos = theQuery.getResultList();

        return turnos;

    }

    @Override
    public Turno findById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Turno turno = currentSession.get(Turno.class, id);

        //return entityManager.find(Turno.class, id);

        return turno;
    }

    @Override
    public void save(Turno turno) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(turno);

        //V2
        //entityManager.merge(turno);

    }

    @Override
    public void modify(Turno turno) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(turno);

        //V2
        //entityManager.merge(turno);

    }

    @Override
    public void deleteById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Turno> theQuery = currentSession.createQuery("delete from Turno where id=:idTurno");

        theQuery.setParameter("idTurno", id);

        theQuery.executeUpdate();

    }

}