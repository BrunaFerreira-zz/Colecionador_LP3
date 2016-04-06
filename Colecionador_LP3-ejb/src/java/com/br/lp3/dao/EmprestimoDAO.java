package com.br.lp3.dao;

import com.br.lp3.entities.Emprestimo;
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
public class EmprestimoDAO implements GenericDAO<Emprestimo>{
     @PersistenceContext(unitName="Colecionador_LP3PU",type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Emprestimo e) {
        em.persist(e);
    }

    @Override
    public List<Emprestimo> find() {
        return em.createQuery("Emprestimo.findAll", Emprestimo.class).getResultList();
    }

    @Override
    public Emprestimo findById(long id) {
        return em.find(Emprestimo.class, id);
    }

    @Override
    public void remove(Emprestimo e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
         this.em = em;
    }

}
