
package br.com.seven.lsi.view;

import br.com.seven.lsi.scenes.SceneTelaInicial;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Girlian
 */
public class SplashScene extends Application{
    private static Stage stage;
    private AnchorPane pane;
    private ImageView splash1;
    private ImageView splash2;
    private ImageView titleSplash;
    private Background bk;
    private SequentialTransition st;
    private MediaPlayer player;
    //CENA PARA TROCAR QUANDO ACABAR A SPLASH SCENE
    private Scene telaInicial;
    
    @Override
    public void start(Stage stage) throws Exception {
        initComponentes();
        initLayout();
        initSons();
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("/css/splash_scene.css");
        stage.setScene(scene);
        stage.show();
        SplashScene.stage = stage;
        initTransitions();
    }
    
    private void initComponentes(){
        pane = new AnchorPane();
        pane.setPrefSize(800, 600);
        pane.getStyleClass().add("pane");
        initImagens();
        pane.getChildren().addAll(splash1, splash2, titleSplash);
        telaInicial = new SceneTelaInicial(new AnchorPane());
    }
    
    private void initLayout(){
        splash1.setLayoutX(pane.getPrefWidth()/2 - 240);
        splash1.setLayoutY(pane.getPrefHeight()/2 - 160);
        
        splash2.setLayoutX(pane.getPrefWidth()/2 - 240);
        splash2.setLayoutY(pane.getPrefHeight()/2 - 160);
        
        titleSplash.setLayoutX(pane.getPrefWidth()/2 -140);
        titleSplash.setLayoutY(pane.getPrefHeight()/2 - 30);
    }
    
    private void initListeners(){
        
    }
    
    private void initImagens(){
        splash1 = new ImageView(new Image("/imagens/astra.png"));
        splash2 = new ImageView(new Image("/imagens/logo.png"));
        titleSplash = new ImageView(new Image("/imagens/tituloSplash.png"));
    }
    
    private void initTransitions(){
        st = new SequentialTransition();
        //TRANSIÇÕES PARALELAS PARA FAZER DESAPARECER AS IMAGENS A PRINCIPIO
        FadeTransition t1 = new FadeTransition(Duration.millis(10), splash1);
        FadeTransition t2 = new FadeTransition(Duration.millis(10), splash2);
        FadeTransition t3 = new FadeTransition(Duration.millis(10), titleSplash);
        t1.setFromValue(1.0); t1.setToValue(0.0);
        t2.setFromValue(1.0); t2.setToValue(0.0);
        t3.setFromValue(1.0); t3.setToValue(0.0);
        
        ParallelTransition pt = new ParallelTransition(t1, t2, t3);
        
        pt.play();
        //TRANSIÇÕES SEQUENCIAIS PARA FAZER A SPLASH SCENE ACONTECER DE VERDADE
        FadeTransition transition1 = new FadeTransition(Duration.millis(2000), splash1);
        transition1.setFromValue(0.0);
        transition1.setToValue(1.0);
        transition1.setAutoReverse(true);
        transition1.setCycleCount(2);
        
        FadeTransition transition2 = new FadeTransition(Duration.millis(2000), titleSplash);
        transition2.setFromValue(0.0);
        transition2.setToValue(1.0);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(2);
        
        FadeTransition transition3 = new FadeTransition(Duration.millis(2000), splash2);
        transition3.setFromValue(0.0);
        transition3.setToValue(1.0);
        transition3.setAutoReverse(true);
        transition3.setCycleCount(2);
        
        st.getChildren().addAll(transition1, transition2, transition3);
        st.play();
        player.play();
        st.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try{
                    Media media = new Media(SplashScene.class.getResource(""
                            + "/sons/musica_tela_inicial.mp3").toExternalForm());
                    player = new MediaPlayer(media);
                    player.play();
                    SplashScene.stage.setScene(telaInicial);
                }catch(Exception e){
                    System.out.println("ERRO AO ABRIR A TELA DE LOGIN");
                }
            }
        });
    }
    
    private void initSons(){
        Media media = new Media(SplashScene.class.getResource("/sons/intro.wav").toExternalForm());
        player = new MediaPlayer(media);
    }
    
    public static Stage getStage(){
        return SplashScene.stage;
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
