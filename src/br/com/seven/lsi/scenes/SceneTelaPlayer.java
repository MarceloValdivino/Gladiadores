package br.com.seven.lsi.scenes;

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Habilidade;
import br.com.seven.lsi.model.Item;
import br.com.seven.lsi.model.MeuPersonagem;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.property.HabilidadesProperty;
import br.com.seven.lsi.property.ItemProperty;
import br.com.seven.lsi.property.PersonagensProperty;
import br.com.seven.lsi.singletone.PlayerOnline;
import br.com.seven.lsi.view.TelaMinhaConta;
import br.com.seven.lsi.view.TelaModoOpcao;
import br.com.seven.lsi.view.TelaPrepararBatalha;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Girlian
 */
public class SceneTelaPlayer extends Scene {

    private final AnchorPane pane;
    private static Stage stage;
    private ImageView fotoPerfil;
    private AnchorPane paneItens;
    private AnchorPane panePersonagens;
    private AnchorPane paneHabilidades;
    private AnchorPane paneStatus;
    private AnchorPane paneFoto;
    private ListView<ItemProperty> listaDeItens;
    private ObservableList<ItemProperty> obsListItens;
    private List<Item> itensPlayer;

    private ListView<PersonagensProperty> listaDePersonagem;
    private ObservableList<PersonagensProperty> obsListPers;
    private List<MeuPersonagem> personaPlayer;

    private ListView<HabilidadesProperty> listaDeHabilidades;
    private ObservableList<HabilidadesProperty> obsListHabil;
    private List<Habilidade> habilPlayer;

    private ImageView joias;
    private ImageView gema;
    private ImageView moeda;
    private Label lGemas, lJoias, lMoedas;
    private final Label lx1 = new Label("x");
    private final Label lx2 = new Label("x");
    private final Label lx3 = new Label("x");
    private Label lPlayer;
    private Button botaoLojaDeHerois;
    private Button botaoMeuHerois;
    private Button botaoMinhaConta;
    private Button botaoTelaBatalha;
    private Button botaoModoGame;

    private Player player;
    
    private Facade facade;

    public SceneTelaPlayer(Parent root, Player player) {
        super(root);
        pane = (AnchorPane) root;
        this.getStylesheets().add("/css/scene_tela_player.css");
        this.player = player;
        initComponentes();
        initLayout();
        initListeners();
    }

    private void initComponentes() {
        
        facade = new Facade();
        paneItens = new AnchorPane();
        panePersonagens = new AnchorPane();
        paneHabilidades = new AnchorPane();
        paneStatus = new AnchorPane();
        paneFoto = new AnchorPane();

        fotoPerfil = new ImageView();
        gema = new ImageView(new Image("/imagens/gema.png"));
        joias = new ImageView(new Image("/imagens/joias.png"));
        moeda = new ImageView(new Image("/imagens/moeda.png"));

        lPlayer = new Label(player.getNome());
        lPlayer.getStyleClass().add("label");

        lMoedas = new Label("0");
        lGemas = new Label(String.valueOf(player.getGemas()));
        lJoias = new Label("0");

        botaoLojaDeHerois = new Button();
        botaoLojaDeHerois.setText("Loja de Heróis");

        botaoMeuHerois = new Button();
        botaoMeuHerois.setText("Meus Heróis");
        
        botaoMinhaConta = new Button();
        botaoMinhaConta.setText("Minha Conta");
        
        botaoTelaBatalha = new Button();
        botaoTelaBatalha.setText("Batalha");
        
        botaoModoGame = new Button();
        botaoModoGame.setText("Escolher Jogo");

        itensPlayer = player.getMeusItens();
        obsListItens = FXCollections.observableArrayList();
        for(Item i : itensPlayer){
            obsListItens.add(new ItemProperty(i.getId(), i.getNome()));
        }
        listaDeItens = new ListView<>();
        listaDeItens.setItems(obsListItens);
        
        personaPlayer = facade.listarMeuPersonagemPorPlayer(player);
        obsListPers = FXCollections.observableArrayList();
        for (MeuPersonagem p : personaPlayer) {
            obsListPers.add(new PersonagensProperty(p.getId(), p.getPersonagem().getNome()));
        }
        listaDePersonagem = new ListView<>();
        listaDePersonagem.setItems(obsListPers);

        habilPlayer = player.getMinhasHabilidades();
        obsListHabil = FXCollections.observableArrayList();
        for (Habilidade h : habilPlayer) {
            obsListHabil.add(new HabilidadesProperty(h.getId(), h.getNome()));
        }
        listaDeHabilidades = new ListView<>();
        listaDeHabilidades.setItems(obsListHabil);

        lMoedas.getStyleClass().add("label");
        lJoias.getStyleClass().add("label");
        lGemas.getStyleClass().add("label");

        lx1.getStyleClass().add("label");
        lx2.getStyleClass().add("label");
        lx3.getStyleClass().add("label");

        paneStatus.getChildren().addAll(gema, joias, moeda, lMoedas, lGemas, lJoias, lx1, lx2, lx3);
        paneFoto.getChildren().add(fotoPerfil);
        pane.getChildren().addAll(paneItens, panePersonagens, paneHabilidades, paneStatus, paneFoto, 
                lPlayer, botaoLojaDeHerois, botaoMeuHerois, botaoMinhaConta, botaoTelaBatalha, botaoModoGame);

    }

    private void initLayout() {
        pane.setPrefSize(800, 600);
        pane.getStyleClass().add("paneCentral");

        paneItens.setPrefSize(170, 440);
        paneItens.getStyleClass().add("pane");
        listaDeItens.setPrefSize(180, 420);
        paneItens.getChildren().addAll(listaDeItens);

        panePersonagens.setPrefSize(340, 440);
        panePersonagens.getStyleClass().add("pane");
        listaDePersonagem.setPrefSize(350, 420);
        panePersonagens.getChildren().addAll(listaDePersonagem);

        paneHabilidades.setPrefSize(200, 560);
        paneHabilidades.getStyleClass().add("pane");
        listaDeHabilidades.setPrefSize(210, 540);
        paneHabilidades.getChildren().addAll(listaDeHabilidades);

        paneStatus.setPrefSize(340, 100);
        paneStatus.getStyleClass().add("pane");
        paneFoto.setPrefSize(180, 100);
        paneFoto.getStyleClass().add("pane");

        paneFoto.setLayoutX(20);
        paneFoto.setLayoutY(20);

        listaDeItens.setLayoutX(10);
        listaDeItens.setLayoutY(10);
        paneItens.setLayoutX(paneFoto.getLayoutX());
        paneItens.setLayoutY(paneFoto.getLayoutY() + 120);

        listaDePersonagem.setLayoutX(10);
        listaDePersonagem.setLayoutY(10);
        panePersonagens.setLayoutX(paneItens.getLayoutX() + 200);
        panePersonagens.setLayoutY(140);

        listaDeHabilidades.setLayoutX(10);
        listaDeHabilidades.setLayoutY(10);
        paneHabilidades.setLayoutX(panePersonagens.getLayoutX() + 360);
        paneHabilidades.setLayoutY(20);

        paneStatus.setLayoutX(paneFoto.getLayoutX() + 200);
        paneStatus.setLayoutY(20);

        botaoLojaDeHerois.setLayoutX(30);
        botaoLojaDeHerois.setLayoutY(80);
        botaoLojaDeHerois.setPrefSize(160, 20);

        botaoMeuHerois.setLayoutX(30);
        botaoMeuHerois.setLayoutY(30);
        botaoMeuHerois.setPrefSize(160, 20);
        
        botaoMinhaConta.setLayoutX(30);
        botaoMinhaConta.setLayoutY(130);
        
        botaoTelaBatalha.setLayoutX(450);
        botaoTelaBatalha.setLayoutY(30);
        
        botaoModoGame.setLayoutX(450);
        botaoModoGame.setLayoutY(80);

        gema.setLayoutX(10);
        gema.setLayoutY(10);
        joias.setLayoutX(10);
        joias.setLayoutY(gema.getLayoutY() + 30);
        moeda.setLayoutX(10);
        moeda.setLayoutY(joias.getLayoutY() + 30);

        lx1.setLayoutX(gema.getLayoutX() + 35);
        lx1.setLayoutY(gema.getLayoutY());
        lx2.setLayoutX(joias.getLayoutX() + 35);
        lx2.setLayoutY(joias.getLayoutY());
        lx3.setLayoutX(moeda.getLayoutX() + 35);
        lx3.setLayoutY(moeda.getLayoutY());

        lGemas.setLayoutX(lx1.getLayoutX() + 20);
        lJoias.setLayoutX(lx2.getLayoutX() + 20);
        lMoedas.setLayoutX(lx3.getLayoutX() + 20);

        lGemas.setLayoutY(lx1.getLayoutY());
        lJoias.setLayoutY(lx2.getLayoutY());
        lMoedas.setLayoutY(lx3.getLayoutY());

        lPlayer.setLayoutX(5);
        lPlayer.setLayoutY(5);
    }

    private void initListeners() {
        botaoLojaDeHerois.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    initStageLojaHerois().show();
                } catch (Exception ex) {
                    System.err.println("Ocorreu um erro ao tentar iniciar a tela de inventário de heróis.");
                    ex.printStackTrace();
                }
            }
        });
        botaoMeuHerois.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    initStageMeusHerois().show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        botaoMinhaConta.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    new TelaMinhaConta(lPlayer, player).start(new Stage());
                } catch (Exception ex) {
                    System.out.println("erro ao abrir minha conta");
                }
            }
        });
        
        botaoTelaBatalha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerOnline.setPlayerTwo(null);
                TelaPrepararBatalha.initPreparaBatalha();
            }
        });
        botaoModoGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaModoOpcao.initOpcaoModo();
            }
        });
    }

    public Stage initStageLojaHerois() {
        try {
            Stage stageInventarioHerois = new Stage();
            Parent parent = FXMLLoader.
                    load(getClass().getResource("/layouts/inventario.fxml"));
            Scene scene = new Scene(parent);
            stageInventarioHerois.setScene(scene);
            stageInventarioHerois.setTitle("Loja");
            stageInventarioHerois.setResizable(false);
            return stageInventarioHerois;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Stage initStageMeusHerois() {
        try {
            Stage stageInventarioHerois = new Stage();
            Parent parent = FXMLLoader.
                    load(getClass().getResource("/layouts/meuspersonagens.fxml"));
            Scene scene = new Scene(parent);
            stageInventarioHerois.setScene(scene);
            stageInventarioHerois.setTitle("Meus Heróis");
            stageInventarioHerois.setResizable(false);
            return stageInventarioHerois;
        } catch (IOException ex) {
            Logger.getLogger(SceneTelaPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SceneTelaPlayer.stage = stage;
    }
    
    public void atualizarPlayer(Player p){
        player = p;
    }
    
    public void atualizarLabels(){
        
    }
}
