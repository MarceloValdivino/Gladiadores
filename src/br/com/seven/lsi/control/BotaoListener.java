/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.seven.lsi.control;

import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.scenes.SceneTelaPlayer;
import br.com.seven.lsi.view.SplashScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Girlian
 */
public class BotaoListener {
    private static BotaoListener instance = null;
    
    private BotaoListener(){
        
    }
    
    public static BotaoListener getInstance(){
        if(instance == null){
            instance = new BotaoListener();
        }
        return instance;
    }
    
    public void setBotaoPlayersEvent(Button b, Player p){
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                SplashScene.getStage().setScene(new SceneTelaPlayer(new AnchorPane(), p));
            }
        });
        
    }
}
