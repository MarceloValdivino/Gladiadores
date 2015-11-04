/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.model;

import br.com.seven.lsi.myenum.TipoPersonagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcelo
 */
@Entity
public class Personagem implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private TipoPersonagem tipoPersonagem;
    private Double vida;
    private Double defesa;
    private Double ataque;
    private int valorVenda;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Habilidade> habilidades;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private String imagem;
    
    public Personagem(){
        habilidades = new ArrayList<>();
        itens = new ArrayList<>();
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

    public int getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(int valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
