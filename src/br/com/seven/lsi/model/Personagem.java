/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.model;

import br.com.seven.lsi.myenum.TipoPersonagem;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Personagem {

    private Long id;
    private String nome;
    private TipoPersonagem tipoPersonagem;
    private Double vida;
    private Double defesa;
    private Double ataque;
    private List<Habilidade> habilidades;
    private List<Item> itens;

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

    public TipoPersonagem getTipoPersonagem() {
        return tipoPersonagem;
    }

    public void setTipoPersonagem(TipoPersonagem tipoPersonagem) {
        this.tipoPersonagem = tipoPersonagem;
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public Double getDefesa() {
        return defesa;
    }

    public void setDefesa(Double defesa) {
        this.defesa = defesa;
    }

    public Double getAtaque() {
        return ataque;
    }

    public void setAtaque(Double ataque) {
        this.ataque = ataque;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
            
    
}
