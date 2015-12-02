/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Personagem;
import br.com.seven.lsi.util.AlertUtil;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.JFXPanel;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JFrame;

public class TelaBatalha implements Initializable {

    @FXML
    private Button btnPoderUm;

    @FXML
    private Label lbNomeJogador;

    @FXML
    private ImageView imgComputer;

    @FXML
    private ProgressBar pBarPoderQuatComp;

    @FXML
    private Label lbTercHabilidadeCompBar;

    @FXML
    private Label llbPoderDoisBotao;

    @FXML
    private Label lbSegHabilidadeBar;

    @FXML
    private Label lbQuartHabilidadeCompBar;

    @FXML
    private Button btnItemUm;

    @FXML
    private ProgressBar pBarPoderTres;

    @FXML
    private ProgressBar pBarPoderQuatro;

    @FXML
    private Label lbPriHabilidadeBar;

    @FXML
    private Label lbQuarHabilidadeBar;

    @FXML
    private ProgressBar pBarPoderTerComp;

    @FXML
    private ProgressBar pBarPoderUmComp;

    @FXML
    private Label lbSegHabilidadeCompBar;

    @FXML
    private Button btnItemQuatro;

    @FXML
    private ProgressBar pBarPoderUm;

    @FXML
    private Button btnItemDois;

    @FXML
    private ListView<?> lViewItens;

    @FXML
    private ProgressBar pBarVidaPlayer;

    @FXML
    private Button btnItemTres;

    @FXML
    private Label lbPoderQuatroBotao;

    @FXML
    private Label lbPoderUmBotao;

    @FXML
    private ProgressBar pBarPoderDoisComp;

    @FXML
    private Button btnPoderDois;

    @FXML
    private Button btnPoderTres;

    @FXML
    private Button btnPoderQuatro;

    @FXML
    private Label lbPoderTresBotao;

    @FXML
    private ImageView imgPlayer;

    @FXML
    private ProgressBar pBarPoderDois;

    @FXML
    private Label lbTerHabilidadeBar;

    @FXML
    private Label lbPriHabilidadeCompBar;

    @FXML
    private Label lbTempoBatalha;

    @FXML
    private Label lbNomeComputador;

    @FXML
    private ProgressBar pBarVidaComputador;

    @FXML
    private AnchorPane panePrincipal;

    // Stage dessa tela
    private static Stage stage;
    // Personagem selecionado pelo player para ele
    private static Personagem personagemPlayer;
    // Personagem selecionado pelo player para o computador
    private static Personagem personagemComputador;
    // Qual o round que está a batalha
    private static Integer round;
    // Se ativo = true = jogo rolando, se ativo = false = round terminou.
    private boolean ativo;

    private Facade facade;

    private Scene scene;

    // Quantidade de vida de cada personagem
    private double vidaPersonagemComputador;
    private double vidaPersonagemPlayer;
    // Vida total computador e vida total player
    private double VIDA_TOTAL_PERSONAGEM_COMPUTADOR;
    private double VIDA_TOTAL_PERSONAGEM_PLAYER;
    // Tempo de espera de cada habilidade do player
    private double tempoHabilidadeUmPlayer;
    private double tempoHabilidadeDoisPlayer;
    private double tempoHabilidadeTresPlayer;
    private double tempoHabilidadeQuatroPlayer;
    // Tempo de espera de cada habilidade do personagem
    private double tempoHabilidadeUmComputador;
    private double tempoHabilidadeDoisComputador;
    private double tempoHabilidadeTresComputador;
    private double tempoHabilidadeQuatroComputador;
    // Dano de cada habilidade player
    private double danoHabilidadeUmPlayer;
    private double danoHabilidadeDoisPlayer;
    private double danoHabilidadeTresPlayer;
    private double danoHabilidadeQuatroPlayer;
    // Dano de cada habilidade computador
    private double danoHabilidadeUmComputador;
    private double danoHabilidadeDoisComputador;
    private double danoHabilidadeTresComputador;
    private double danoHabilidadeQuatroComputador;
    // Informa quando um poder do computador está disponível para usar
    // Se poder = true = liberado para usar do cantrario nao pode
    private boolean poderUm;
    private boolean poderDois;
    private boolean poderTres;
    private boolean poderQuatro;
    // Tempo de batalha
    private int tempoDeBatalha;

    public TelaBatalha() {
    }

    @FXML
    void teclaPresionada(ActionEvent event) {
    }

    @FXML
    void usarPoderUm(ActionEvent event) {
        usarHabilidadeUm();
    }

    public void usarHabilidadeUm() {
        iniciarEsperaPoderUmPlayer();
        inserirDanoHabilidadePlayer(danoHabilidadeUmPlayer);
    }

    @FXML
    void usarPoderDois(ActionEvent event) {
        usarHabilidadeDois();
    }

    public void usarHabilidadeDois() {
        iniciarEsperaPoderDoisPlayer();
        inserirDanoHabilidadePlayer(danoHabilidadeDoisPlayer);
    }

    @FXML
    void usarPoderTres(ActionEvent event) {
        usarHabilidadeTres();
    }

    public void usarHabilidadeTres() {
        iniciarEsperaPoderTresPlayer();
        inserirDanoHabilidadePlayer(danoHabilidadeTresPlayer);
    }

    @FXML
    void usarPoderQuatro(ActionEvent event) {
        usarHabilidadeQuatro();
    }

    public void usarHabilidadeQuatro() {
        iniciarEsperaPoderQuatroPlayer();
        inserirDanoHabilidadePlayer(danoHabilidadeQuatroPlayer);
    }

    @FXML
    void usarItemUm(ActionEvent event) {

    }

    @FXML
    void usarItemDois(ActionEvent event) {

    }

    @FXML
    void usarItemTres(ActionEvent event) {

    }

    @FXML
    void usarItemQuatro(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Inicia a facade
        facade = new Facade();
        // Todas as habilidades podem ser usadas no inicio
        pBarPoderUm.setProgress(1.0);
        pBarPoderDois.setProgress(1.0);
        pBarPoderTres.setProgress(1.0);
        pBarPoderQuatro.setProgress(1.0);
        // Todas as habilidades podem ser usadas no inicio
        pBarPoderUmComp.setProgress(1.0);
        pBarPoderDoisComp.setProgress(1.0);
        pBarPoderTerComp.setProgress(1.0);
        pBarPoderQuatComp.setProgress(1.0);
        // Vida de cada personagem deve está cheia
        pBarVidaPlayer.setProgress(1.0);
        pBarVidaComputador.setProgress(1.0);
        // Tempo para recarga de cada habilidade do personagem do player, deve ser recuperado do banco.
        tempoHabilidadeUmPlayer = personagemPlayer.getHabilidades().get(0).getTempoDeRecarga();
        tempoHabilidadeDoisPlayer = personagemPlayer.getHabilidades().get(1).getTempoDeRecarga();
        tempoHabilidadeTresPlayer = personagemPlayer.getHabilidades().get(2).getTempoDeRecarga();
        tempoHabilidadeQuatroPlayer = personagemPlayer.getHabilidades().get(3).getTempoDeRecarga();
        // Tempo para recarga de cada habilidade do personagem do computador, deve ser recuperado do banco.
        tempoHabilidadeUmComputador = personagemComputador.getHabilidades().get(0).getTempoDeRecarga();
        tempoHabilidadeDoisComputador = personagemComputador.getHabilidades().get(1).getTempoDeRecarga();
        tempoHabilidadeTresComputador = personagemComputador.getHabilidades().get(2).getTempoDeRecarga();
        tempoHabilidadeQuatroComputador = personagemComputador.getHabilidades().get(3).getTempoDeRecarga();
        // Tempo de duração da batalha
        tempoDeBatalha = 100;
        // Dano de cada habilidade do personagem do player.
        danoHabilidadeUmPlayer = personagemPlayer.getHabilidades().get(0).getDano();
        danoHabilidadeDoisPlayer = personagemPlayer.getHabilidades().get(1).getDano();
        danoHabilidadeTresPlayer = personagemPlayer.getHabilidades().get(2).getDano();
        danoHabilidadeQuatroPlayer = personagemPlayer.getHabilidades().get(3).getDano();
        // Dano de cada habilidade do personagem do computador.
        danoHabilidadeUmComputador = personagemComputador.getHabilidades().get(0).getDano();
        danoHabilidadeDoisComputador = personagemComputador.getHabilidades().get(1).getDano();
        danoHabilidadeTresComputador = personagemComputador.getHabilidades().get(2).getDano();
        danoHabilidadeQuatroComputador = personagemComputador.getHabilidades().get(3).getDano();
        // A quantidade de cada vida de cada personagem deve ser recuperada do banco.
        vidaPersonagemComputador = personagemComputador.getVida();
        vidaPersonagemPlayer = personagemPlayer.getVida();
        // A quantidade total de vida do personagem
        VIDA_TOTAL_PERSONAGEM_COMPUTADOR = vidaPersonagemComputador;
        VIDA_TOTAL_PERSONAGEM_PLAYER = vidaPersonagemPlayer;

        // Imagens do personagens
        imgComputer.setImage(new Image(getClass().getResource(personagemComputador.getImagem()).toString()));
        imgPlayer.setImage(new Image(getClass().getResource(personagemPlayer.getImagem()).toString()));

        // Inserindo as informações nos labels
        lbNomeComputador.setText(personagemComputador.getNome());
        lbNomeJogador.setText(personagemPlayer.getNome());
        // Nome das habilidades do personagem player
        lbPriHabilidadeBar.setText(personagemPlayer.getHabilidades().get(0).getNome());
        lbSegHabilidadeBar.setText(personagemPlayer.getHabilidades().get(1).getNome());
        lbTerHabilidadeBar.setText(personagemPlayer.getHabilidades().get(2).getNome());
        lbQuarHabilidadeBar.setText(personagemPlayer.getHabilidades().get(3).getNome());
        // Nome das habilidades do personagem computador
        lbPriHabilidadeCompBar.setText(personagemComputador.getHabilidades().get(0).getNome());
        lbSegHabilidadeCompBar.setText(personagemComputador.getHabilidades().get(1).getNome());
        lbTercHabilidadeCompBar.setText(personagemComputador.getHabilidades().get(2).getNome());
        lbQuartHabilidadeCompBar.setText(personagemPlayer.getHabilidades().get(3).getNome());

        lbPoderUmBotao.setText(personagemPlayer.getHabilidades().get(0).getDano().toString());
        llbPoderDoisBotao.setText(personagemPlayer.getHabilidades().get(1).getDano().toString());
        lbPoderTresBotao.setText(personagemPlayer.getHabilidades().get(2).getDano().toString());
        lbPoderQuatroBotao.setText(personagemPlayer.getHabilidades().get(3).getDano().toString());
        // O jogo foi iniciado
        ativo = true;
        initUsarPoderesComputador();
        initTempoDeBatalha();
        initEsperas();
        initInteligenciaArtificial();
        scene = panePrincipal.getScene();
        panePrincipal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q: {
                        usarHabilidadeUm();
                    }
                    break;
                    case W: {
                        usarHabilidadeDois();
                        break;
                    }
                    case E: {
                        usarHabilidadeTres();
                        break;
                    }
                    case R: {
                        usarHabilidadeQuatro();
                        break;
                    }
                }
            }
        });
    }

    private void initListener() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q: {
                        usarHabilidadeUm();
                    }
                    break;
                }
            }
        });
    }

    public static Stage getStage(Stage stage) {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaBatalha.stage = stage;
    }

    public static Integer getRound() {
        return round;
    }

    public static void setRound(Integer round) {
        TelaBatalha.round = round;
    }

    private void iniciarEsperaPoderUmPlayer() {
        Task t = new Task() {

            @Override
            protected Object call() throws Exception {
                try {
                    boolean esperando = true;
                    btnPoderUm.setDisable(esperando);
                    pBarPoderUm.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeUmPlayer * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderUm.setProgress(pBarPoderUm.getProgress() + valor);
                        if (pBarPoderUm.getProgress() >= 1.0) {
                            esperando = false;
                        }
                    }
                    btnPoderUm.setDisable(esperando);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderDoisPlayer() {
        Task t = new Task() {

            @Override
            protected Object call() throws Exception {
                try {
                    boolean esperando = true;
                    btnPoderDois.setDisable(esperando);
                    pBarPoderDois.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeDoisPlayer * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderDois.setProgress(pBarPoderDois.getProgress() + valor);
                        if (pBarPoderDois.getProgress() >= 1.0) {
                            esperando = false;
                        }
                    }
                    btnPoderDois.setDisable(esperando);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderTresPlayer() {
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    boolean esperando = true;
                    btnPoderTres.setDisable(esperando);
                    pBarPoderTres.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeTresPlayer * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderTres.setProgress(pBarPoderTres.getProgress() + valor);
                        if (pBarPoderTres.getProgress() >= 1.0) {
                            esperando = false;
                        }
                    }
                    btnPoderTres.setDisable(esperando);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderQuatroPlayer() {
        Task t = new Task() {

            @Override
            protected Object call() throws Exception {
                try {
                    boolean esperando = true;
                    btnPoderQuatro.setDisable(esperando);
                    pBarPoderQuatro.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeQuatroPlayer * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderQuatro.setProgress(pBarPoderQuatro.getProgress() + valor);
                        if (pBarPoderQuatro.getProgress() >= 1.0) {
                            esperando = false;
                        }
                    }
                    btnPoderQuatro.setDisable(esperando);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderUmComputador() {
        Task t = new Task() {

            @Override
            protected Object call() throws Exception {
                try {
                    poderUm = false;
                    boolean esperando = true;
                    pBarPoderUmComp.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeUmComputador * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderUmComp.setProgress(pBarPoderUmComp.getProgress() + valor);
                        if (pBarPoderUmComp.getProgress() >= 1.0) {
                            esperando = false;
                            poderUm = true;
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderDoisComputador() {
        Task t= new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    poderDois = false;
                    boolean esperando = true;
                    pBarPoderDoisComp.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeDoisComputador * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderDoisComp.setProgress(pBarPoderDoisComp.getProgress() + valor);
                        if (pBarPoderDoisComp.getProgress() >= 1.0) {
                            esperando = false;
                            poderDois = true;
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderTresComputador() {
        Task t = new Task(){

            @Override
            protected Object call() throws Exception {
                try {
                    poderTres = false;
                    boolean esperando = true;
                    pBarPoderTerComp.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeTresComputador * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderTerComp.setProgress(pBarPoderTerComp.getProgress() + valor);
                        if (pBarPoderTerComp.getProgress() >= 1.0) {
                            esperando = false;
                            poderTres = true;
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }  
        };
        new Thread(t).start();
    }

    private void iniciarEsperaPoderQuatroComputador() {
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    poderQuatro = false;
                    boolean esperando = true;
                    pBarPoderQuatComp.setProgress(0.0);
                    double valor = (2 / (tempoHabilidadeQuatroComputador * 1000));
                    while (esperando) {
                        Thread.sleep(1);
                        pBarPoderQuatComp.setProgress(pBarPoderQuatComp.getProgress() + valor);
                        if (pBarPoderQuatComp.getProgress() >= 1.0) {
                            esperando = false;
                            poderQuatro = true;
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void inserirDanoHabilidadePlayer(double danoHabilidade) {
        vidaPersonagemComputador -= (danoHabilidade - personagemComputador.getDefesa());
        if (vidaPersonagemComputador < 0) {
            pBarVidaComputador.setProgress(0.0);
            ativo = false;
            TelaBatalha.stage.setOpacity(0.99);
            if (round == 3) {
                AlertUtil.genericAlert("Round - " + round, "VENDEDOR!!!", "Muito bem, você conseguiu ganhar a batalha!", Alert.AlertType.INFORMATION);
                round = 1;
                TelaBatalha.stage.close();
            } else {
                boolean continuar = AlertUtil.confirmationAlert("Fim do Round - " + round, "VOCÊ GANHOU UM ROUND!", "Deseja continuar a batalha, partir para o ROUND: " + (round + 1) + "?");
                round++;
                if (continuar) {
                    TelaBatalha.stage.close();
                    initTelaBatalha();
                } else {
                    TelaBatalha.stage.close();
                }
            }
        } else {
            double percentualDeVida = calcularPercentualDeVida(vidaPersonagemComputador, VIDA_TOTAL_PERSONAGEM_COMPUTADOR);
            pBarVidaComputador.setProgress(percentualDeVida);
        }
    }

    private void inserirDanoHabilidadeComputador(double danoHabilidade) {
        vidaPersonagemPlayer -= -(danoHabilidade - personagemPlayer.getDefesa());
        if (vidaPersonagemPlayer <= 0) {
            pBarVidaPlayer.setProgress(0.0);
            ativo = false;
            if (round == 3) {
                AlertUtil.genericAlert("Round - " + round, "PERDEDOR!!!", "Muito bem, você conseguiu ganhar a batalha!", Alert.AlertType.INFORMATION);
                round = 1;
                TelaBatalha.stage.close();
            } else {
                boolean continuar = AlertUtil.confirmationAlert("Fim do Round - " + round, "VOCÊ PERDEU UM ROUND!", "Deseja continuar a batalha, partir para o ROUND: " + (round + 1) + "?");
                round++;
                if (continuar) {
                    TelaBatalha.stage.close();
                    initTelaBatalha();
                } else {
                    TelaBatalha.stage.close();
                }
            }
        } else {
            double percentualDeVida = calcularPercentualDeVida(vidaPersonagemPlayer, VIDA_TOTAL_PERSONAGEM_PLAYER);
            pBarVidaPlayer.setProgress(percentualDeVida);
        }
    }

    private double calcularPercentualDeVida(double vidaPersonagem, double vidaTotal) {
        return (((vidaPersonagem * 100) / vidaTotal) / 100);
    }

    private void initTempoDeBatalha() {
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                lbTempoBatalha.setText(String.valueOf(tempoDeBatalha));
                while (tempoDeBatalha > 0 && ativo) {
                    tempoDeBatalha--;
                    Platform.runLater(() -> {
                        lbTempoBatalha.setText(String.valueOf(tempoDeBatalha));
                    });
                    Thread.sleep(1000);
                }

                return null;
            }
        };
        new Thread(t).start();
    }

    public static Personagem getPersonagemPlayer() {
        return personagemPlayer;
    }

    public static void setPersonagemPlayer(Personagem personagemPlayer) {
        TelaBatalha.personagemPlayer = personagemPlayer;
    }

    public static Personagem getPersonagemComputador() {
        return personagemComputador;
    }

    public static void setPersonagemComputador(Personagem personagemComputador) {
        TelaBatalha.personagemComputador = personagemComputador;
    }

    public static void initTelaBatalha() {
        try {
            Stage stageTelaBatalha = new Stage();
            Parent parent = FXMLLoader.
                    load(TelaBatalha.class.getResource("/layouts/tela_batalha.fxml"));
            Scene scene = new Scene(parent);
            stageTelaBatalha.setScene(scene);
            stageTelaBatalha.setTitle("Tela Batalha - Round " + round);
            stageTelaBatalha.setResizable(false);
            stageTelaBatalha.show();
            TelaBatalha.stage = stageTelaBatalha;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initEsperas() {
        iniciarEsperaPoderUmPlayer();
        iniciarEsperaPoderDoisPlayer();
        iniciarEsperaPoderTresPlayer();
        iniciarEsperaPoderQuatroPlayer();
        iniciarEsperaPoderUmComputador();
        iniciarEsperaPoderDoisComputador();
        iniciarEsperaPoderTresComputador();
        iniciarEsperaPoderQuatroComputador();
    }

    private void initInteligenciaArtificial() {
        Task t = new Task() {

            @Override
            protected Object call() throws Exception {
                while (ativo) {
                    try {
                        Thread.sleep(500);
                        usarPoderUmComputador();
                        Thread.sleep(500);
                        usarPoderDoisComputador();
                        Thread.sleep(500);
                        usarPoderTresComputador();
                        Thread.sleep(500);
                        usarPoderQuatroComputador();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                return null;
            }
        };
        new Thread(t).start();
    }

    private void usarPoderUmComputador() {
        // Inicia o poder um do computador
        if (ativo && poderUm) {
            Task t = new Task() {
                @Override
                protected Object call() throws Exception {
                    inserirDanoHabilidadeComputador(danoHabilidadeUmComputador);
                    iniciarEsperaPoderUmComputador();
                    return null;
                }
            };
            new Thread(t).start();
        }
    }

    private void usarPoderDoisComputador() {
        // Inicia o poder dois do computador
        if (ativo && poderDois) {
            Task t = new Task() {

                @Override
                protected Object call() throws Exception {
                    inserirDanoHabilidadeComputador(danoHabilidadeDoisComputador);
                    iniciarEsperaPoderDoisComputador();
                    return null;
                }
            };
            new Thread(t).start();
        }
    }

    private void usarPoderTresComputador() {
        // Inicia o poder tres do computador
        if (ativo && poderTres) {
            Task t = new Task() {

                @Override
                protected Object call() throws Exception {
                    inserirDanoHabilidadeComputador(danoHabilidadeTresComputador);
                    iniciarEsperaPoderTresComputador();
                    return null;
                }
            };
            new Thread(t).start();
        }
    }

    private void usarPoderQuatroComputador() {
        // Inicia o poder quatro do computador
        if (ativo && poderQuatro) {
            Task t = new Task() {

                @Override
                protected Object call() throws Exception {
                    inserirDanoHabilidadeComputador(danoHabilidadeQuatroComputador);
                    iniciarEsperaPoderQuatroComputador();
                    return null;
                }
            };
            new Thread(t).start();
        }
    }

    private void initUsarPoderesComputador() {
        poderUm = true;
        poderDois = true;
        poderTres = true;
        poderQuatro = true;
    }
}
