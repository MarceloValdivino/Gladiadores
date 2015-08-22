/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IGenericoDao<T> {

    public void save(T o);

    public T getObject(Long id);

    public List<T> list();

    public void remove(T o);

    public void update(T o);
}
