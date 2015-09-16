/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.property;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Marcelo
 */
public class PersonagensProperty {
    
    private Long id;
    private SimpleStringProperty nomePersonagem;
    
    public PersonagensProperty(Long id, String nome){
        this.id = id;
        this.nomePersonagem = new SimpleStringProperty(nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleStringProperty getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(SimpleStringProperty nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    @Override
    public String toString() {
        return getNomePersonagem().getValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonagensProperty other = (PersonagensProperty) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
