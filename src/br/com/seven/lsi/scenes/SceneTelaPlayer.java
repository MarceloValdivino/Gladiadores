
package br.com.seven.lsi.scenes;

import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.singletone.PlayerOnline;
import br.com.seven.lsi.view.TelaInventarioHerois;
import br.com.seven.lsi.view.TelaPreapararBatalha;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Girlian
 */
public class SceneTelaPlayer extends Scene{

    private final AnchorPane pane;
    private static Stage stage;
    private ImageView fotoPerfil;
    private AnchorPane paneItens;
    private AnchorPane panePersonagens;
    private AnchorPane paneBatalha;
    private AnchorPane paneStatus;
    private AnchorPane paneFoto;
    private ImageView joias;
    private ImageView gema;
    private ImageView moeda;
    private Label lGemas, lJoias, lMoedas;
    private final Label lx1 = new Label("x");
    private final Label lx2 = new Label("x");
    private final Label lx3 = new Label("x");
    private Label lPlayer;
    private Button botaoIniciarBatalha;
    private Button botaoInventarioHerois;
    
    private final Player player;
    
    public SceneTelaPlayer(Parent root, Player player) {
        super(root);
        pane = (AnchorPane) root;
        this.getStylesheets().add("/css/scene_tela_player.css");
        this.player = player;
        initComponentes();
        initLayout();
        initListeners();
    }
    
    private void initComponentes(){
        paneItens = new AnchorPane();
        panePersonagens = new AnchorPane();
        paneBatalha = new AnchorPane();
        paneStatus = new AnchorPane();
        paneFoto = new AnchorPane();
        
        fotoPerfil = new ImageView();
        gema = new ImageView(new Image("/imagens/gema.png"));
        joias = new ImageView(new Image("/imagens/joias.png"));
        moeda = new ImageView(new Image("/imagens/moeda.png"));
        
        lPlayer = new Label(player.getNome());
        lPlayer.getStyleClass().add("label");
        
        lMoedas = new Label("0");
        lGemas = new Label("0");
        lJoias = new Label("0");
        
        botaoIniciarBatalha = new Button();
        botaoIniciarBatalha.setText("Batalha");
        
        botaoInventarioHerois = new Button();
        botaoInventarioHerois.setText("Inventário Heróis");
        
        lMoedas.getStyleClass().add("label");
        lJoias.getStyleClass().add("label");
        lGemas.getStyleClass().add("label");
        
        lx1.getStyleClass().add("label");
        lx2.getStyleClass().add("label");
        lx3.getStyleClass().add("label");
        
        paneStatus.getChildren().addAll(gema,joias, moeda, lMoedas, lGemas, lJoias, lx1, lx2, lx3);
        paneFoto.getChildren().add(fotoPerfil);
        pane.getChildren().addAll(paneItens, panePersonagens, paneBatalha, paneStatus, paneFoto, lPlayer, botaoIniciarBatalha, botaoInventarioHerois);
        
    }
    
    private void initLayout(){
        pane.setPrefSize(800, 600);
        pane.getStyleClass().add("paneCentral");
        
        paneItens.setPrefSize(180, 440);
        paneItens.getStyleClass().add("pane");
        panePersonagens.setPrefSize(340, 440);
        panePersonagens.getStyleClass().add("pane");
        paneBatalha.setPrefSize(200, 560);
        paneBatalha.getStyleClass().add("pane");
        paneStatus.setPrefSize(340, 100);
        paneStatus.getStyleClass().add("pane");
        paneFoto.setPrefSize(180, 100);
        paneFoto.getStyleClass().add("pane");
        
        paneFoto.setLayoutX(20);
        paneFoto.setLayoutY(20);
        
        paneItens.setLayoutX(paneFoto.getLayoutX());
        paneItens.setLayoutY(paneFoto.getLayoutY() + 120);
        
        panePersonagens.setLayoutX(paneItens.getLayoutX() + 200);
        panePersonagens.setLayoutY(140);
        
        paneBatalha.setLayoutX(panePersonagens.getLayoutX()+360);
        paneBatalha.setLayoutY(20);
        
        paneStatus.setLayoutX(paneFoto.getLayoutX() + 200);
        paneStatus.setLayoutY(20);
        
        botaoIniciarBatalha.setLayoutX(30);
        botaoIniciarBatalha.setLayoutY(30);
        botaoIniciarBatalha.setPrefSize(160, 20);
        
        botaoInventarioHerois.setLayoutX(30);
        botaoInventarioHerois.setLayoutY(80);
        botaoInventarioHerois.setPrefSize(160, 20);
        
        gema.setLayoutX(10);
        gema.setLayoutY(10);
        joias.setLayoutX(10);
        joias.setLayoutY(gema.getLayoutY()+30);
        moeda.setLayoutX(10);
        moeda.setLayoutY(joias.getLayoutY()+30);
        
        lx1.setLayoutX(gema.getLayoutX()+35);
        lx1.setLayoutY(gema.getLayoutY());
        lx2.setLayoutX(joias.getLayoutX()+35);
        lx2.setLayoutY(joias.getLayoutY());
        lx3.setLayoutX(moeda.getLayoutX()+35);
        lx3.setLayoutY(moeda.getLayoutY());
        
        lGemas.setLayoutX(lx1.getLayoutX()+20);
        lJoias.setLayoutX(lx2.getLayoutX()+20);
        lMoedas.setLayoutX(lx3.getLayoutX()+20);
        
        lGemas.setLayoutY(lx1.getLayoutY());
        lJoias.setLayoutY(lx2.getLayoutY());
        lMoedas.setLayoutY(lx3.getLayoutY());
        
        lPlayer.setLayoutX(5);
        lPlayer.setLayoutY(5);
    }
    
    private void initListeners(){
        botaoIniciarBatalha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    initStageInventarioHerois().show();
                } catch (Exception ex) {
                    System.err.println("Ocorre um erro ao tentar iniciar a tela de batalha.");
                    Logger.getLogger(SceneTelaPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        botaoInventarioHerois.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try{
                    initStageInventarioHerois().show();
                } catch (Exception ex){
                    System.err.println("Ocorreu um erro ao tentar iniciar a tela de inventário de heróis.");
                    ex.printStackTrace();
                }
            }
        });
    }

    public Stage initStageInventarioHerois(){
        try {
            Stage stageInventarioHerois = new Stage();
            Parent parent = FXMLLoader.
                    load(getClass().getResource("/layouts/inventario.fxml"));
            Scene scene = new Scene(parent);
            stageInventarioHerois.setScene(scene);
            stageInventarioHerois.setTitle("Inventário/Loja");
            stageInventarioHerois.setResizable(false);
            return stageInventarioHerois;
        } catch (IOException ex) {
            Logger.getLogger(SceneTelaPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
