package com.br.lp3.dao;

import com.br.lp3.entities.InfoUsuario;
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
public class InfoUsuarioDAO implements GenericDAO<InfoUsuario>{
     @PersistenceContext(unitName="Colecionador_LP3PU",type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(InfoUsuario e) {
        em.persist(e);
    }

    @Override
    public List<InfoUsuario> find() {
        return em.createQuery("InfoUsuario.findAll", InfoUsuario.class).getResultList();
    }

    @Override
    public InfoUsuario findById(long id) {
        return em.find(InfoUsuario.class, id);
    }

    @Override
    public void remove(InfoUsuario e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
         this.em = em;
    }

}
