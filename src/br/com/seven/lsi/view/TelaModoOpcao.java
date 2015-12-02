/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author fagundes
 */
public class TelaModoOpcao implements Initializable {

    private static Stage stage;

    public static void initOpcaoModo() {
        try {
            Stage stageTelaModoOpcao = new Stage();
            Parent parent = FXMLLoader.
                    load(TelaModoOpcao.class.getResource("/layouts/tela_modo.fxml"));
            Scene scene = new Scene(parent);
            stageTelaModoOpcao.setScene(scene);
            stage = stageTelaModoOpcao;
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaModoOpcao.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initListeners();
    }

    private void initListeners() {
        paneModo.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER: {
                        System.out.println("Iniciar!!!");
                    }
                    break;
                    case ESCAPE: {
                        TelaModoOpcao.stage.close();
                    }
                    break;
                }
            }
        });
    }

    @FXML
    private RadioButton optionVeryHard;

    @FXML
    private RadioButton opitionArcade;

    @FXML
    private Pane paneDificuldade;

    @FXML
    private RadioButton optionHeavenandHell;

    @FXML
    private RadioButton optionNormal;

    @FXML
    private RadioButton optionHard;

    @FXML
    private RadioButton optionMultiplayer;

    @FXML
    private Pane paneModo;

    @FXML
    private RadioButton optionEasy;

    @FXML
    void optionEasy(ActionEvent event) {

    }

    @FXML
    void optionNormal(ActionEvent event) {

    }

    @FXML
    void optionHard(ActionEvent event) {

    }

    @FXML
    void optionVeryHard(ActionEvent event) {

    }

    @FXML
    void optionHeavenandHell(ActionEvent event) {

    }

    @FXML
    void btnVoltar(ActionEvent event) {

    }

    @FXML
    void btnLutar(ActionEvent event) {

    }

}
