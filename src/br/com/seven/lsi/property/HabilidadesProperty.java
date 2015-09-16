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
public class HabilidadesProperty {
    
    private long id;
    private SimpleStringProperty nomeHabil;
   
    public HabilidadesProperty(long id, String nomeHabil){
        this.id = id;
        this.nomeHabil = new SimpleStringProperty(nomeHabil);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SimpleStringProperty getNomeHabil() {
        return nomeHabil;
    }

    public void setNomeHabil(SimpleStringProperty nomeHabil) {
        this.nomeHabil = nomeHabil;
    }
    
    public String toString() {
        return getNomeHabil().getValue();
    }
    
    
}
