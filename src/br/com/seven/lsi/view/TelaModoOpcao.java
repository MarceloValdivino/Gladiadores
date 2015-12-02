/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author fagundes
 */
public class TelaModoOpcao implements Initializable {
    
    
    
    
    
    private static Stage stage; 
    
    private Stage opcaoModo() {
        try {
            Stage stageInventarioHerois = new Stage();
            Parent parent = FXMLLoader.
                    load(getClass().getResource("/layouts/tela_modo.fxml"));
            Scene scene = new Scene(parent);    
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaModoOpcao.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
