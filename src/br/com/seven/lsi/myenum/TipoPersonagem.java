/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.myenum;

/**
 *
 * @author Marcelo
 */
public enum TipoPersonagem {
    
    ENTIDADE("Entidade"),
    SUPER_HEROI("Super Herói"),
    HEROI("Herói"),
    VIGILANTE("Vigilante");
    
    private String tipo;
    
    private TipoPersonagem(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipoPersonagem(){
        return this.tipo;
    }
}
