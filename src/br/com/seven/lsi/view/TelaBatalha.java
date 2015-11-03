/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.view;

import br.com.seven.lsi.facade.Facade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    private static Stage stage;

    private Facade facade;

    // Quantidade de vida de cada personagem
    private double vidaPersonagemComputador;
    private double vidaPersonagemPlayer;
    // Vida total computador e vida total player
    private double VIDA_TOTAL_PERSONAGEM_COMPUTADOR;
    private double VIDA_TOTAL_PERSONAGEM_PLAYER;
    // Tempo de espera de cada habilidade
    private double tempoHabilidadeUmPlayer;
    private double tempoHabilidadeDoisPlayer;
    private double tempoHabilidadeTresPlayer;
    private double tempoHabilidadeQuatroPlayer;
    // Dano de cada habilidade
    private double danoHabilidadeUmPlayer;
    private double danoHabilidadeDoisPlayer;
    private double danoHabilidadeTresPlayer;
    private double danoHabilidadeQuatroPlayer;

    @FXML
    void teclaPresionada(ActionEvent event) {
        System.out.println("Precionei uma tecla!");
    }
    
    @FXML
    void usarPoderUm(ActionEvent event) {
        iniciarEsperaPoderUm();
        inserirDanoHabilidade(danoHabilidadeUmPlayer);
    }

    @FXML
    void usarPoderDois(ActionEvent event) {
        iniciarEsperaPoderDois();
        inserirDanoHabilidade(danoHabilidadeDoisPlayer);
    }

    @FXML
    void usarPoderTres(ActionEvent event) {
        iniciarEsperaPoderTres();
        inserirDanoHabilidade(danoHabilidadeTresPlayer);
    }

    @FXML
    void usarPoderQuatro(ActionEvent event) {
        iniciarEsperaPoderQuatro();
        inserirDanoHabilidade(danoHabilidadeQuatroPlayer);
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
        tempoHabilidadeUmPlayer = 1.0;
        tempoHabilidadeDoisPlayer = 2.0;
        tempoHabilidadeTresPlayer = 3.0;
        tempoHabilidadeQuatroPlayer = 4.0;
        // Dano de cada habilidade do personagem do player.
        danoHabilidadeUmPlayer = 5.0;
        danoHabilidadeDoisPlayer = 10.0;
        danoHabilidadeTresPlayer = 15.0;
        danoHabilidadeQuatroPlayer = 25.0;
        // A quantidade de cada vida de cada personagem deve ser recuperada do banco.
        vidaPersonagemComputador = 150.0;
        vidaPersonagemPlayer = 120.0;
        // A quantidade total de vida do personagem
        VIDA_TOTAL_PERSONAGEM_COMPUTADOR = vidaPersonagemComputador;
        VIDA_TOTAL_PERSONAGEM_PLAYER = vidaPersonagemPlayer;
    }

    public static Stage getStage(Stage stage) {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaBatalha.stage = stage;
    }

    private void iniciarEsperaPoderUm() {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        }).start();
    }

    private void iniciarEsperaPoderDois() {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        }).start();
    }

    private void iniciarEsperaPoderTres() {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        }).start();
    }

    private void iniciarEsperaPoderQuatro() {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        }).start();
    }

    private void inserirDanoHabilidade(double danoHabilidade) {
        vidaPersonagemComputador -= danoHabilidade;
        double percentualDeVida = calcularPercentualDeVida(vidaPersonagemComputador, VIDA_TOTAL_PERSONAGEM_COMPUTADOR);
        if (vidaPersonagemComputador <= 0) {
            vidaPersonagemComputador = 0;
            pBarVidaComputador.setProgress(0.0);
        } else {
            pBarVidaComputador.setProgress(percentualDeVida);
        }
    }

    private double calcularPercentualDeVida(double vidaPersonagem, double dano) {
        return (((vidaPersonagemComputador * 100) / VIDA_TOTAL_PERSONAGEM_COMPUTADOR) / 100);
    }
}
