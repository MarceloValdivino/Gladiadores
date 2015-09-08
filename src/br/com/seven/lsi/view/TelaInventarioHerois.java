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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Marcelo
 */
public class TelaInventarioHerois extends Application implements Initializable {

    @FXML
    private AnchorPane paneInventario;
    @FXML
    private ListView<PersonagensProperty> listMeusPersonagens;
    @FXML
    private ListView<PersonagensProperty> listLojaPersonagens;
    @FXML
    private Button btnComprar;
    @FXML
    private Button btnVender;
    @FXML
    private Button btInfMeusPersonagens;
    @FXML
    private Button btInfLoja;
    private Player player;
    private Facade facade;
    private List<Personagem> listaPersonagens;
    private ObservableList<PersonagensProperty> observableListPersLoja;
    private ObservableList<PersonagensProperty> observableListPersPlayer;
    private Long idSelecionado;
    private Personagem personagem;

    public TelaInventarioHerois() {
        this.facade = new Facade();
        listaPersonagens = this.facade.listarPersonagem();
        player = PlayerOnline.getPlayer();
        System.out.println("Contrutor - TelaInventarioHerois");
        System.out.println("Player Personagem: "+player.getMeusPersonagens());
        System.out.println("Player Personagem: "+facade.listarMeuPersonagemPorPlayer(player));
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Chamei o start - TelaInventarioHerois");
        Parent parent = FXMLLoader.
                load(getClass().getResource("/layouts/inventario.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Inventário/Loja");
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Chemei o initializate - TelaInventarioHerois");
        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                personagem = facade.buscarPersonagem(idSelecionado);
                boolean choice = AlertUtil.confirmationAlert("Confirmar Compra", "Deseja mesmo comprar esse Personagem?\n" + personagem.getNome(), "Ataque: " + personagem.getAtaque() + "\nDefesa: " + personagem.getDefesa());
                if (choice) {
                    MeuPersonagem meuPersonagem = new MeuPersonagem();
                    meuPersonagem.setPersonagem(personagem);
                    meuPersonagem.setPlayer(player);
                    player.getMeusPersonagens().add(meuPersonagem);
                    facade.salvarMeuPersonagem(meuPersonagem);
                    facade.atualizarPlayer(player);
                    AlertUtil.genericAlert("Comprar Realizada", 
                            "Compra de Personagem", 
                            "Você acabou de adquirir o personagem " + personagem.getNome() + ".\nAtaque: " + personagem.getAtaque() + "\nDefesa: " + personagem.getDefesa(), 
                            Alert.AlertType.INFORMATION);
                    observableListPersPlayer.add(new PersonagensProperty(personagem.getId(), personagem.getNome()));
                    listMeusPersonagens.setItems(observableListPersPlayer);
                }
            }
        });

        btInfLoja.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                personagem = facade.buscarPersonagem(idSelecionado);
                AlertUtil.genericAlert(personagem.getTipoPersonagem().getTipoPersonagem(), personagem.getNome(), "Ataque: " + personagem.getAtaque() + "\nDefesa: " + personagem.getDefesa(), Alert.AlertType.INFORMATION);
            }
        });
        btInfMeusPersonagens.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                personagem = facade.buscarPersonagem(idSelecionado);
                AlertUtil.genericAlert(personagem.getTipoPersonagem().getTipoPersonagem(), personagem.getNome(), "Ataque: " + personagem.getAtaque() + "\nDefesa: " + personagem.getDefesa(), Alert.AlertType.INFORMATION);
            }
        });

        observableListPersLoja = FXCollections.observableArrayList();
        for (Personagem p : listaPersonagens) {
            observableListPersLoja.add(new PersonagensProperty(p.getId(), p.getNome()));
        }

        listLojaPersonagens.setItems(observableListPersLoja);
        listLojaPersonagens.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonagensProperty>() {
            @Override
            public void changed(ObservableValue<? extends PersonagensProperty> observable, PersonagensProperty oldValue, PersonagensProperty newValue) {
                idSelecionado = newValue.getId();
            }
        });
        
        observableListPersPlayer = FXCollections.observableArrayList();
        
        for(MeuPersonagem mp : facade.listarMeuPersonagemPorPlayer(player)){
            listaPersonagens.add(mp.getPersonagem());
            observableListPersPlayer.add(new PersonagensProperty(mp.getPersonagemm().getId(), mp.getPersonagem().getNome()));
        }
        
        listMeusPersonagens.setItems(observableListPersPlayer);
        listMeusPersonagens.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonagensProperty>() {
            @Override
            public void changed(ObservableValue<? extends PersonagensProperty> observable, PersonagensProperty oldValue, PersonagensProperty newValue) {
                idSelecionado = newValue.getId();
            }
        });
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
