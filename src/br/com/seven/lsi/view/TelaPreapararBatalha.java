/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Marcelo
 */
public class TelaPreapararBatalha extends Application {

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.
                load(getClass().getResource("/layouts/prepara_batalha.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Prepare-se para Batalha");
        stage.show();
    }
    
    private void initComponentes(){
        
    }
    
    private void initListeners(){
        
    }
    
    private void initLayout(){
    }
}
