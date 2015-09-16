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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Marcelo
 */
public class TelaInventarioHerois extends Application implements Initializable {

    @FXML
    private Button btInfLoja;

    @FXML
    private AnchorPane paneInventario;

    @FXML
    private Button btnComprar;

    @FXML
    private ListView<PersonagensProperty> listLojaPersonagens;

    @FXML
    private Label lbMoedas;

    private Player player;
    private Facade facade;
    private List<Personagem> listaPersonagens;
    private ObservableList<PersonagensProperty> observableListPersLoja;
    private Long idSelecionado;
    private Personagem personagem;

    public TelaInventarioHerois() {
        this.facade = new Facade();
        player = PlayerOnline.getPlayer();
        listaPersonagens = this.facade.listarPersonagensPlayerNaoTem(player);
        System.out.println("Quantidade de personagens que player nao tem: "+listaPersonagens.size());
        System.out.println("Contrutor - TelaInventarioHerois");
        System.out.println("Player Personagem: " + player.getMeusPersonagens());
        System.out.println("Player Personagem: " + facade.listarMeuPersonagemPorPlayer(player));
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
        player = facade.buscarPlayer(player.getId());
        System.out.println("Chemei o initializate - TelaInventarioHerois");
        lbMoedas.setText(String.valueOf(player.getGemas()));
        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                personagem = facade.buscarPersonagem(idSelecionado);
                boolean choice = AlertUtil.confirmationAlert("Confirmar Compra", "Deseja mesmo comprar esse Personagem?\n" + personagem.getNome(), "Ataque: " + personagem.getAtaque()
                        + "\nDefesa: " + personagem.getDefesa()
                        + "\nValor para compra: " + personagem.getValorVenda());
                if (choice) {
                    if (player.getGemas() >= personagem.getValorVenda()) {
                        player.setGemas((int) (player.getGemas() - personagem.getValorVenda()));
                        System.out.println("Gemas: " + player.getGemas());
                        MeuPersonagem meuPersonagem = new MeuPersonagem();
                        meuPersonagem.setPersonagem(personagem);
                        meuPersonagem.setStatus(true);
                        meuPersonagem.setPlayer(player);
                        player.getMeusPersonagens().add(meuPersonagem);
                        facade.salvarMeuPersonagem(meuPersonagem);
                        facade.atualizarPlayer(player);
                        PersonagensProperty pp = new PersonagensProperty(meuPersonagem.getPersonagem().getId(), meuPersonagem.getPersonagem().getNome());
                        observableListPersLoja.remove(pp);
                        listLojaPersonagens.setItems(observableListPersLoja);
                        lbMoedas.setText(String.valueOf(player.getGemas()));
                        AlertUtil.genericAlert("Comprar Realizada",
                                "Compra de Personagem",
                                "Você acabou de adquirir o personagem " + personagem.getNome() + ".\nAtaque: " + personagem.getAtaque() + "\nDefesa: " + personagem.getDefesa(),
                                Alert.AlertType.INFORMATION);
                    } else {
                        AlertUtil.genericAlert("Compra", "Não foi possível comprar esse personagem.", "Valor do personagem: " + personagem.getValorVenda() + "\nSuas moedas: " + player.getGemas(), Alert.AlertType.WARNING);
                    }
                }
            }
        });

        listLojaPersonagens.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonagensProperty>() {
            @Override
            public void changed(ObservableValue<? extends PersonagensProperty> observable, PersonagensProperty oldValue, PersonagensProperty newValue) {
                idSelecionado = newValue.getId();
            }
        });

        btInfLoja.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                personagem = facade.buscarPersonagem(idSelecionado);
                AlertUtil.genericAlert(personagem.getTipoPersonagem().getTipoPersonagem(), personagem.getNome(), "Ataque: " + personagem.getAtaque()
                        + "\nDefesa: " + personagem.getDefesa()
                        + "\nValor para compra: " + personagem.getValorVenda(),
                        Alert.AlertType.INFORMATION);
            }
        });

        observableListPersLoja = FXCollections.observableArrayList();
        for (Personagem p : listaPersonagens) {
            observableListPersLoja.add(new PersonagensProperty(p.getId(), p.getNome()));
        }
        listLojaPersonagens.setItems(observableListPersLoja);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
