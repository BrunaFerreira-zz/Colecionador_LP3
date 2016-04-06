package com.br.lp3.dao;

import com.br.lp3.entities.Usuario;
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
public class UsuarioDAO implements GenericDAO<Usuario>{
     @PersistenceContext(unitName="Colecionador_LP3PU",type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Usuario e) {
        em.persist(e);
    }

    @Override
    public List<Usuario> find() {
        return em.createQuery("Usuario.findAll", Usuario.class).getResultList();
    }

    @Override
    public Usuario findById(long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public void remove(Usuario e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
         this.em = em;
    }

}
