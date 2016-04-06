/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Bruna
 */
@Local
public interface GenericDAO<E>{
    public void persist(E e);
    public List<E> find();
    public E findById(long id);
    public void remove(E e);
    public void setEm(EntityManager em);
}
