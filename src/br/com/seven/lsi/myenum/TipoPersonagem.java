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
    
    ENTIDADE(1),
    SUPER_HEROI(2),
    HEROI(3),
    VIGILANTE(4);
    
    private int tipo;
    
    private TipoPersonagem(int tipo){
        this.tipo = tipo;
    }
    
    public int getTipoPersonagem(){
        return this.tipo;
    }
}
