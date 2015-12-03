/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.MeuPersonagem;
import br.com.seven.lsi.model.Personagem;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.property.PersonagensProperty;
import br.com.seven.lsi.singletone.PlayerOnline;
import br.com.seven.lsi.util.AlertUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Marcelo
 */
public class TelaPrepararBatalha implements Initializable {

    @FXML
    private ListView<PersonagensProperty> listaHeriosPlayer;

    @FXML
    private Label lbPersonagemDois;

    @FXML
    private Button botaoBatalha;

    @FXML
    private Label playerName;

    @FXML
    private ListView<PersonagensProperty> listaHeroisComputador;

    private Facade facade;
    private ObservableList<PersonagensProperty> obsListaMeusHerois;
    private ObservableList<PersonagensProperty> obsListaCompHerois;
    private Player player;
    private Personagem personagemPlayer;
    private Personagem personagemComputador;
    private long idPersonagemPlayer = 0;
    private long idPersonagemComputador = 0;

    private static Stage stage;

    @FXML
    void iniciarBatalha(ActionEvent event) {
        if (idPersonagemPlayer != 0 && idPersonagemComputador != 0) {
            personagemComputador = facade.buscarPersonagem(idPersonagemComputador);
            personagemPlayer = facade.buscarPersonagem(idPersonagemPlayer);
            boolean choice = AlertUtil.confirmationAlert("Batalha", personagemPlayer.getNome() + " VS " + personagemComputador.getNome(), "Deseja mesmo iniciar a batalha?");
            if (choice) {
                stage.close();
                if (PlayerOnline.getPlayerTwo() != null) {
                    TelaBatalhaMultiplayer.setPersonagemComputador(personagemComputador);
                    TelaBatalhaMultiplayer.setPersonagemPlayer(personagemPlayer);
                    TelaBatalhaMultiplayer.setRound(1);
                    TelaBatalhaMultiplayer.initTelaBatalhaMultiplayer();
                } else {
                    TelaBatalha.setPersonagemComputador(personagemComputador);
                    TelaBatalha.setPersonagemPlayer(personagemPlayer);
                    TelaBatalha.setRound(1);
                    TelaBatalha.initTelaBatalha();
                }

            }
        } else {
            AlertUtil.genericAlert("Seleção", "Escolha de Personagens", "Selecione um personagem para você e um personagem para o computador.", Alert.AlertType.WARNING);
        }
    }

    private void initComponentes() {
        facade = new Facade();
        obsListaCompHerois = FXCollections.observableArrayList();
        obsListaMeusHerois = FXCollections.observableArrayList();
        player = PlayerOnline.getPlayer();
        player = facade.buscarPlayer(player.getId());

        List<Personagem> listaDeAdversarios;
        if (PlayerOnline.getPlayerTwo() != null) {
            lbPersonagemDois.setText(PlayerOnline.getPlayerTwo().getNome());
            listaDeAdversarios = new ArrayList<>();
            for (MeuPersonagem personagem : PlayerOnline.getPlayerTwo().getMeusPersonagens()) {
                listaDeAdversarios.add(personagem.getPersonagem());
            }
        } else {
            listaDeAdversarios = facade.listarPersonagem();
        }
        playerName.setText(PlayerOnline.getPlayer().getNome());

        for (Personagem p : listaDeAdversarios) {
            obsListaCompHerois.add(new PersonagensProperty(p.getId(), p.getNome()));
        }
        for (MeuPersonagem mp : player.getMeusPersonagens()) {
            obsListaMeusHerois.add(new PersonagensProperty(mp.getPersonagem().getId(), mp.getPersonagem().getNome()));
        }
        listaHeroisComputador.setItems(obsListaCompHerois);
        listaHeriosPlayer.setItems(obsListaMeusHerois);

        listaHeroisComputador.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonagensProperty>() {

            @Override
            public void changed(ObservableValue<? extends PersonagensProperty> observable, PersonagensProperty oldValue, PersonagensProperty newValue) {
                idPersonagemComputador = newValue.getId();
            }
        });
        listaHeriosPlayer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonagensProperty>() {

            @Override
            public void changed(ObservableValue<? extends PersonagensProperty> observable, PersonagensProperty oldValue, PersonagensProperty newValue) {
                idPersonagemPlayer = newValue.getId();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComponentes();
    }

    private Stage initTelaBatalha() {
        try {
            Stage stageInventarioHerois = new Stage();
            Parent parent = FXMLLoader.
                    load(getClass().getResource("/layouts/tela_batalha.fxml"));
            Scene scene = new Scene(parent);
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    System.out.println("!!!");
                }
            });
            stageInventarioHerois.setScene(scene);
            stageInventarioHerois.setTitle("Tela Batalha - Round 1");
            stageInventarioHerois.setResizable(false);
            return stageInventarioHerois;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaPrepararBatalha.stage = stage;
    }

    public static void initPreparaBatalha() {
        try {
            Stage stagePreparaBatalha = new Stage();
            Parent parent = FXMLLoader.
                    load(TelaPrepararBatalha.class.getResource("/layouts/prepara_batalha.fxml"));
            Scene scene = new Scene(parent);
            stagePreparaBatalha.setScene(scene);
            stagePreparaBatalha.setTitle("Prepare-se para Batalha");
            stagePreparaBatalha.setResizable(false);
            TelaPrepararBatalha.setStage(stagePreparaBatalha);
            TelaPrepararBatalha.stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
