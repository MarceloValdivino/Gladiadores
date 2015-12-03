/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.singletone;

import br.com.seven.lsi.model.Player;

/**
 *
 * @author Marcelo
 */
public class PlayerOnline {

    private static PlayerOnline instance = null;
    private static Player player;
    private static Player playerTwo;
    
    private PlayerOnline(){
    }
    
    public static PlayerOnline getInstance(){
        if(instance == null){
            instance = new PlayerOnline();
        }
        return instance;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        PlayerOnline.player = player;
    }    

    public static Player getPlayerTwo() {
        return playerTwo;
    }

    public static void setPlayerTwo(Player playerTwo) {
        PlayerOnline.playerTwo = playerTwo;
    }
}
