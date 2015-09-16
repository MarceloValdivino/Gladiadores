/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import br.com.seven.lsi.util.JPAUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Marcelo
 */
public class GenericoDaoImp<T> implements IGenericoDao<T> {

    private Class clazz;
    
    public GenericoDaoImp(){
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Override
    public void save(T o) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    @Override
    public T getObject(Long id) {
        EntityManager manager = JPAUtil.getEntityManager();
        return (T) manager.find(clazz, id);
    }

    @Override
    public List<T> list() {
        EntityManager manager = JPAUtil.getEntityManager();
        Session session = (Session) manager.getDelegate();
        Criteria criteria = session.createCriteria(clazz);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void remove(T o) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    @Override
    public void update(T o) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
    
    @Override
    public Criteria getCriteria(){
        EntityManager manager = JPAUtil.getEntityManager();
        try{
            return ((Session) manager.getDelegate()).createCriteria(clazz);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
