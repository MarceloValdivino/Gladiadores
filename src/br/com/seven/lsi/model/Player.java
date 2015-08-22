/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcelo
 */
@Entity
public class Player implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany
    private List<Item> meusItens;
    @OneToMany
    private List<Personagem> personagems;
    @OneToMany
    private List<Habilidade> minhasHabilidades;
    private int gemas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getMeusItens() {
        return meusItens;
    }

    public void setMeusItens(List<Item> meusItens) {
        this.meusItens = meusItens;
    }

    public List<Personagem> getPersonagems() {
        return personagems;
    }

    public void setPersonagems(List<Personagem> personagems) {
        this.personagems = personagems;
    }

    public List<Habilidade> getMinhasHabilidades() {
        return minhasHabilidades;
    }

    public void setMinhasHabilidades(List<Habilidade> minhasHabilidades) {
        this.minhasHabilidades = minhasHabilidades;
    }

    public int getGemas() {
        return gemas;
    }

    public void setGemas(int gemas) {
        this.gemas = gemas;
    }
    
    
}
