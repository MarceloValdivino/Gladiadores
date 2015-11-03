/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.seven.lsi.view;

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.scenes.SceneTelaPlayer;
import br.com.seven.lsi.util.AlertUtil;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Girlian
 */
public class TelaMinhaConta extends Application{

    private Pane pane;
    private Pane paneImagem;
    private Label nome;
    private Label status;
    private Image imagem;
    private Button editar;
    private Button desativarAtivar;
    private Player player;
    private Facade facade;
    private static Stage stage;
    private Label lnome;
    
    public TelaMinhaConta(Label lnome, Player p){
        player = p;
        this.lnome = lnome;
    }
    
    private void initComponents(){
        this.facade = new Facade();
        this.pane = new Pane();
        this.paneImagem = new Pane();
        this.nome = new Label(player.getNome());
        this.status = new Label();
        this.desativarAtivar = new Button();
        if(player.isStatus()){
            status.setText("ativo");
            desativarAtivar.setText("desativar");
        }else{
            status.setText("desativado");
            desativarAtivar.setText("ativar");
        }
        editar = new Button("Editar");
        
        pane.getChildren().addAll(paneImagem, nome, status, desativarAtivar, editar);
    }
    
    public void initLayout(){
        pane.setPrefSize(480, 320);
        paneImagem.setPrefSize(40, 100);
        paneImagem.setLayoutX(30);
        paneImagem.setLayoutY(20);
        
        nome.setLayoutX(30);
        nome.setLayoutY(paneImagem.getLayoutY()+30);
        status.setLayoutX(30);
        status.setLayoutY(nome.getLayoutY()+30);
        editar.setLayoutX(30);
        editar.setLayoutY(status.getLayoutY()+30);
        desativarAtivar.setLayoutX(30);
        desativarAtivar.setLayoutY(editar.getLayoutY()+30);
    }
    
    public void initListeners(){
        if(player.isStatus()){
            desativarAtivar.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    player.desativar();
                    facade.atualizarPlayer(player);
                    stage.close();
                    
                }
            });
        }else{
            desativarAtivar.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    player.ativar();
                    facade.atualizarPlayer(player);
                    stage.close();
                }
            });
        }
        
        editar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                List<String> entradas = new ArrayList<>();
                entradas.add("Novo nome:");
                List<String> respostas = AlertUtil.inputAlert(entradas, "Editar Player", "You shall not pass!");
                player.setNome(respostas.get(0));
                facade.atualizarPlayer(player);
                nome.setText(player.getNome());
                lnome.setText(player.getNome());
            }
        });
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initLayout();
        initListeners();
        stage = new Stage();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Minha conta");
        stage.show();
        TelaMinhaConta.stage = stage;
    }

}
