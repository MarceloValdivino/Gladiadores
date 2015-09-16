/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.property;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fagundes
 */
public class ItemProperty {

    private Long id;
    private SimpleStringProperty nomeItem;
    
    public ItemProperty(Long id, String nomeItem){
        this.id = id;
        this.nomeItem = new SimpleStringProperty(nomeItem);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleStringProperty getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(SimpleStringProperty nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public String toString() {
        return getNomeItem().getValue();
    }
}
    