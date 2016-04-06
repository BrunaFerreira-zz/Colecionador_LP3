package com.br.lp3.dao;

import com.br.lp3.entities.Obra;
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
public class ObraDAO implements GenericDAO<Obra>{
     @PersistenceContext(unitName="Colecionador_LP3PU",type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Obra e) {
        em.persist(e);
    }

    @Override
    public List<Obra> find() {
        return em.createQuery("Obra.findAll", Obra.class).getResultList();
    }

    @Override
    public Obra findById(long id) {
        return em.find(Obra.class, id);
    }

    @Override
    public void remove(Obra e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
         this.em = em;
    }

}
