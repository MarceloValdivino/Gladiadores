/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.MeuPersonagem;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.singletone.PlayerOnline;
import br.com.seven.lsi.util.AlertUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author fagundes
 */
public class TelaModoOpcao implements Initializable {

    private static Stage stage;
    private Facade facade;

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
        facade = new Facade();
        initListeners();
    }

    private void initListeners() {
        paneModo.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER: {
                        iniciarBatalhar();
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
    private ToggleGroup dificuldade;

    @FXML
    private RadioButton optionNormal;

    @FXML
    private RadioButton optionHard;

    @FXML
    private RadioButton optionMultiplayer;

    @FXML
    private Pane paneModo;

    @FXML
    private ToggleGroup modo;

    @FXML
    private RadioButton optionEasy;

    @FXML
    void btnVoltar(ActionEvent event) {

    }

    @FXML
    void btnLutar(ActionEvent event) {
        iniciarBatalhar();
    }

    private void iniciarBatalhar() {
        System.out.println("Modo: "+(modo.getToggles().indexOf(modo.getSelectedToggle())));
        switch (modo.getToggles().indexOf(modo.getSelectedToggle())) {
            case -1: {
                AlertUtil.genericAlert("Modo de Game", "Por favor, selecione um modo de jogo", "", Alert.AlertType.WARNING);
            }
            break;
                // Modo Arcade
            case 1: {
                // AlertUtil.confirmationAlert("Modo Arcade", "Modo Arcade ainda não está pronto!", "Estamos terminando o modo arcade, quando estiver pronto você poderá jogar.\nEnquanto isso jogue com um amigo.");
                
            }
            break;
                // Modo Multiplayer
            case 0: {
                List<Player> players = facade.listarPlayersComPersonagens();
                for(Player p : players){
                    System.out.println("Player: "+p.getNome());
                }
                players.remove(PlayerOnline.getPlayer());
                if (players.size() > 0) {
                    String[] choices = new String[players.size()];
                    for (int i = 0; i < choices.length; i++) {
                        choices[i] = players.get(i).getNome();
                    }
                    String choice = AlertUtil.choiceAlert(choices, "Modo Multiplayer", "Selecione um amigo para jogar com você\n(Apenas amigos com personagens podem ser selecionados.)", "Amigo: ");
                    Player playerTwo = facade.buscarPlayer(choice);
                    PlayerOnline.setPlayerTwo(playerTwo);
                    TelaModoOpcao.stage.close();
                    TelaPrepararBatalha.initPreparaBatalha();
                } else {
                    AlertUtil.genericAlert("Modo Multiplayer", "Problema ao iniciar Game.", "Não há nenhum amigo cadastrado para jogar.", Alert.AlertType.INFORMATION);
                }
            }
            break;
        }

    }
}
