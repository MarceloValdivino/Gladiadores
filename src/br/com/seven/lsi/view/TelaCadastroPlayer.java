
package br.com.seven.lsi.view;

import br.com.seven.lsi.control.BotaoListener;
import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.scenes.SceneTelaInicial;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Girlian
 */
public class TelaCadastroPlayer extends Application{

    private Player p;
    private final Facade facade;
    private static Stage stage;
    private AnchorPane pane;
    private Label lNickName;
    private TextField campoNickName;
    private Button btnSalvar;
    private Button btnCancelar;
    private BotaoListener botaoListener;
    
    public TelaCadastroPlayer(){
        facade= new Facade();
    }

    @Override
    public void start(Stage stage) throws Exception {
        initComponentes();
        initListeners();
        initLayout();
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("/css/tela_cadastro_player.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Cadastro-Player");
        stage.show();
        TelaCadastroPlayer.stage = stage;
    }
    
    public static Stage getStage(){
        return TelaCadastroPlayer.stage;
    }
    
    private void initComponentes(){
        botaoListener = BotaoListener.getInstance();
        pane = new AnchorPane();
        pane.getStyleClass().add("pane");
        lNickName = new Label("Nickname");
        campoNickName = new TextField("Digite seu nickename...");
        campoNickName.setAlignment(Pos.CENTER);
        btnSalvar = new Button("Salvar");
        btnSalvar.getStyleClass().add("botao");
        btnCancelar = new Button("Cancelar");
        btnCancelar.getStyleClass().add("botao");
        pane.getChildren().addAll(lNickName, campoNickName, btnSalvar, btnCancelar);
    }
    
    private void initListeners(){
        btnSalvar.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
               Player p = new Player();
               p.setNome(campoNickName.getText());
               p.setMeusItens(null);
               p.setMeusPersonagens(null);
               facade.salvarPlayer(p);
               TelaCadastroPlayer.stage.close();
               List<Player> players = facade.listarPlayers();
                ObservableList botoes = FXCollections.observableArrayList();
               for(Player player: players){
                   Button b = new Button(player.getNome());
                   b.getStyleClass().add("botao");
                   botaoListener.setBotaoPlayersEvent(b, p);
                   botoes.add(b);
               }
               //TEM  QUE MUDAR O ESTILO DOS BOTOES
               SceneTelaInicial.getListView().setItems(botoes);
            }
        });
        
        btnCancelar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                campoNickName.setText("");
                TelaCadastroPlayer.stage.close();
            }
        });
        
    }
    
    private void initLayout(){
        pane.setPrefSize(320, 180);
        
        lNickName.setLayoutX(pane.getPrefWidth()/2 - 30);
        lNickName.setLayoutY(20);
        
        campoNickName.setLayoutX(pane.getPrefWidth()/2 - 80);
        campoNickName.setLayoutY(45);
        
        btnSalvar.setLayoutX((pane.getPrefWidth()/2) - 30);
        btnSalvar.setLayoutY(80);
        
        btnCancelar.setLayoutX(pane.getPrefWidth()/2 - 37);
        btnCancelar.setLayoutY(110);
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
