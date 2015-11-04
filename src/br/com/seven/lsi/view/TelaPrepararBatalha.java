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
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author Marcelo
 */
public class TelaPrepararBatalha implements Initializable {

    @FXML
    private ListView<PersonagensProperty> listaHeriosPlayer;

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
                Stage stageTelaBatalha = initTelaBatalha();
                stageTelaBatalha.show();
                TelaBatalha.setStage(stageTelaBatalha);
                TelaBatalha.setRound(3);
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

        playerName.setText(PlayerOnline.getPlayer().getNome());
        for (Personagem p : facade.listarPersonagem()) {
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
}
