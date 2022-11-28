package com.aplicacion.asistenciayturnos.repository;
import com.aplicacion.asistenciayturnos.entity.Organizacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OrganizacionDaoImp implements OrganizacionDao{
    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Organizacion> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Organizacion> theQuery = currentSession.createQuery("from Organizacion", Organizacion.class);

        /* String query = "FROM Organizacion";
        return entityManager.createQuery(query).getResultList(); */

        List<Organizacion> organizaciones = theQuery.getResultList();

        return organizaciones;

    }

    @Override
    public Organizacion findById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Organizacion organizacion = currentSession.get(Organizacion.class, id);

        //return entityManager.find(Organizacion.class, id);

        return organizacion;
    }

    @Override
    public List<Organizacion> findByCuit(Long cuit) {

        Session currentSession = entityManager.unwrap(Session.class);

        //Organizacion organizacion = currentSession.get(Organizacion.class, cuit);

        //return entityManager.find(Organizacion.class, id);

        Query<Organizacion> theQuery = currentSession.createQuery("from Organizacion where elcuit like: cuitbuscado", Organizacion.class);
        //query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        theQuery.setParameter( "cuitbuscado", "%" + cuit + "%");
        //"SELECT * FROM TblPerson" + "WHERE name like :vname and id > :vid" , Person.class ).setParameter( "vname", "J%" ).setParameter( "vid", 5 ).list();
        List<Organizacion> organizaciones = theQuery.getResultList();

        return organizaciones;
    }

    @Override
    public Organizacion findByNombre(String nombre) {

        Session currentSession = entityManager.unwrap(Session.class);

        Organizacion organizacion = currentSession.get(Organizacion.class, nombre);

        //return entityManager.find(Organizacion.class, id);

        return organizacion;
    }

    @Override
    public void save(Organizacion organizacion) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(organizacion);

        //V2
        //entityManager.merge(organizacion);

    }

    @Override
    public void modify(Organizacion organizacion) {

        //V1
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(organizacion);

        //V2
        //entityManager.merge(organizacion);

    }

    @Override
    public void deleteById(Long id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Organizacion> theQuery = currentSession.createQuery("delete from Organizacion where id=:idOrganizacion");

        theQuery.setParameter("idOrganizacion", id);

        theQuery.executeUpdate();

    }

}