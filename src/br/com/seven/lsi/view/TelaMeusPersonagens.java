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
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Marcelo
 */
public class TelaMeusPersonagens implements Initializable {

    @FXML
    private Button btInfLoja;

    @FXML
    private AnchorPane paneInventario;

    @FXML
    private ListView<PersonagensProperty> listMeusPersonagens;

    @FXML
    private Button btnVender;

    @FXML
    private Label lbMoedas;

    private Player player;
    private Long idSelecionado;
    private Personagem personagem;
    private Facade facade;
    private ObservableList<PersonagensProperty> obsListMeusHerois;

    @FXML
    private void venderHeroi(ActionEvent event) {
        personagem = facade.buscarPersonagem(idSelecionado);
        int reembolso = (int) (personagem.getValorVenda() * 0.8);
        boolean choice = AlertUtil.confirmationAlert("Vender", "Deseja mesmo vender esse Heróis?", "Nome: " + personagem.getVida()
                + "\nAtaque: " + personagem.getAtaque()
                + "\nDefesa: " + personagem.getDefesa()
                + "\nValor de venda:" + reembolso);
        if (choice) {
            player.setGemas(player.getGemas() + reembolso);
            MeuPersonagem mp = facade.buscarMeuPersonagemPorPlayerEPersonagem(player, personagem);
            mp.setStatus(false);
            facade.atualizarMeuPersonagem(mp);
            System.out.println("MeuPersongem: " + mp.getPersonagem().getNome());
            System.out.println("Quantidade de meus personagens antes de remover: " + player.getMeusPersonagens().size());
            System.out.println("Quantidade de meus personagens: " + player.getMeusPersonagens().size());
            PersonagensProperty pp = new PersonagensProperty(personagem.getId(), personagem.getNome());
            obsListMeusHerois.remove(pp);
            listMeusPersonagens.setItems(obsListMeusHerois);
            facade.removerMeuPersonagem(mp);
            lbMoedas.setText(String.valueOf(player.getGemas()));

            AlertUtil.genericAlert("Venda", "Personagem vendido com sucesso!", "Valor de reembolso: " + reembolso, Alert.AlertType.CONFIRMATION);
        }
    }

    @FXML
    private void informacoesHeroi(ActionEvent event) {
        personagem = facade.buscarPersonagem(idSelecionado);
        int reembolso = (int) (personagem.getValorVenda() * 0.8);
        AlertUtil.genericAlert("Informações", personagem.getNome(), "Tipo: " + personagem.getTipoPersonagem().getTipoPersonagem()
                + "\nAtaque: " + personagem.getAtaque()
                + "\nDefesa: " + personagem.getDefesa()
                + "\nVida: " + personagem.getVida()
                + "\nValor de reembolso: " + reembolso, Alert.AlertType.INFORMATION);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = new Facade();

        player = facade.buscarPlayer(PlayerOnline.getPlayer().getId());
        player.setMeusPersonagens(facade.listarMeuPersonagemPorPlayer(player));

        lbMoedas.setText(String.valueOf(player.getGemas()));

        listMeusPersonagens.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonagensProperty>() {
            @Override
            public void changed(ObservableValue<? extends PersonagensProperty> observable, PersonagensProperty oldValue, PersonagensProperty newValue) {
                idSelecionado = newValue.getId();
            }
        });
        obsListMeusHerois = FXCollections.observableArrayList();
        for (MeuPersonagem mp : player.getMeusPersonagens()) {
            if (mp.getStatus()) {
                System.out.println("Personagem: "+mp.getPersonagem().getNome());
                obsListMeusHerois.add(new PersonagensProperty(mp.getPersonagem().getId(), mp.getPersonagem().getNome()));
            }
        }
        listMeusPersonagens.setItems(obsListMeusHerois);
    }

}
