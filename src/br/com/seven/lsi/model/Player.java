/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Item> meusItens;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MeuPersonagem> meusPersonagens;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Habilidade> minhasHabilidades;
    private int gemas;
    
    public Player(){
        meusItens = new ArrayList<>();
        meusPersonagens = new ArrayList<>();
        minhasHabilidades = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Basic
    public List<MeuPersonagem> getMeusPersonagens() {
        return meusPersonagens;
    }

    public void setMeusPersonagens(List<MeuPersonagem> meusPersonagens) {
        this.meusPersonagens = meusPersonagens;
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
