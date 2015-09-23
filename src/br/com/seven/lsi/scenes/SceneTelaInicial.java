package br.com.seven.lsi.scenes;

import br.com.seven.lsi.control.BotaoListener;
import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.view.TelaCadastroPlayer;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Girlian
 */
public class SceneTelaInicial extends Scene {

    private final AnchorPane pane;
    private static ListView<Button> players;
    private Hyperlink linkCriarNovo;
    private ObservableList<Button> listaPlayers;
    private Facade facade;
    private ImageView icone;
    private BotaoListener botaoListener;

    public SceneTelaInicial(Parent root) {
        super(root);
        this.getStylesheets().add("/css/tela_inicial.css");
        pane = (AnchorPane) root;
        initComponentes();
        initLayout();
        initListeners();
    }

    private void initComponentes() {
        botaoListener = BotaoListener.getInstance();
        //FACHADA PARA LISTAR TODOS OS PLAYERS CADASTRADOS
        facade = new Facade();
        //INICIALIZANDO OS COMPONENTES - LISTA DE BOTÕES CADA UM COM O NOME DE UM USUÁRIO
        //QUANDO CLICADO O BOTÃO ABRIRÁ A TELA DE CADA USUÁRIO
        listaPlayers = FXCollections.observableArrayList();
        List<Player> lista = facade.listarPlayers();
        players = new ListView<>(listaPlayers);
        initPlayers(lista);
        linkCriarNovo = new Hyperlink("Criar Novo");
        icone = new ImageView(new Image("/imagens/icone.png"));
        //background = new ImageView(new Image("/imagens/background.jpg"));
        pane.getChildren().addAll(players, linkCriarNovo, icone);
        players.setMaxSize(100, 160);
        pane.getStyleClass().add("pane");
        players.getStyleClass().add("players");
    }

    private void initPlayers(List<Player> lista) {
        lista.stream().forEach((p) -> {
            if (p.isStatus()) {
                Button b = new Button(p.getNome());
                b.getStyleClass().add("botao");
                botaoListener.setBotaoPlayersEvent(b, p);
                listaPlayers.add(b);
            }
        });
        players.setItems(listaPlayers);
    }

    private void initLayout() {
        pane.setPrefSize(800, 600);

        icone.setLayoutX(pane.getPrefWidth() - 50);
        linkCriarNovo.setLayoutX(30);
        linkCriarNovo.setLayoutY(300);
    }

    private void initListeners() {
        linkCriarNovo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    new TelaCadastroPlayer().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static ListView<Button> getListView() {
        return SceneTelaInicial.players;
    }
}
