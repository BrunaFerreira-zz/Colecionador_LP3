package com.br.lp3.dao;

import com.br.lp3.entities.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Bruna
 */
@Stateless
public class AutorDAO implements GenericDAO<Autor>{
     @PersistenceContext(unitName="Colecionador_LP3PU",type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Autor e) {
        em.persist(e);
    }

    @Override
    public List<Autor> find() {
        return em.createQuery("Autor.findAll", Autor.class).getResultList();
    }

    @Override
    public Autor findById(long id) {
        return em.find(Autor.class, id);
    }

    @Override
    public void remove(Autor e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
         this.em = em;
    }

}
