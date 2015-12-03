/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import br.com.seven.lsi.model.Player;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IPlayerDao extends IGenericoDao<Player> {
    
    public List<Player> playerComPersonagem();
    
    public Player getPlayerPorNome(String nome);
}
