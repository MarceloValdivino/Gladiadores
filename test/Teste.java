/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Habilidade;
import br.com.seven.lsi.model.Personagem;
import br.com.seven.lsi.myenum.TipoPersonagem;
import br.com.seven.lsi.view.TelaBatalha;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 *
 * @author Marcelo
 */
public class Teste {

    public static void main(String[] args) {
        
        //Stage stage = TelaBatalha.initTelaBatalha();
        
        
        Facade facade = new Facade();
        
        Personagem personagem = new Personagem();
        
        /*
        A baixo de 50 de dano 0.5 de tempo de recarga
        entre 50 e 80 de dano 0.9 de tempo de recarga
        entre 80 e 100 de dano 1.5 de tempo de recarga
        entre 100 e 110 de dano 1.8 de tempo de recarga
        entre 110 e 125 de dano 2.0 de tempo de recarga
        entre 125 e 150 de dano 2.5 de tempo de recarga
        mais de 150 de dano 3.0 de tempo de recarga
        
        */
        
        personagem.setNome("Soldade Invernal");
        personagem.setAtaque(130.);
        personagem.setDefesa(120.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(500);
        personagem.setImagem("/imagens/soldadoInvernal.jpg");
        // Inserindo habilidade 1
        Habilidade habilidade = new Habilidade();
        habilidade.setDano(100.00);
        habilidade.setNome("Soco de Aço");
        habilidade.setTempoDeRecarga(1.8);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(120.00);
        habilidade.setNome("Rajada de Balas");
        habilidade.setTempoDeRecarga(2.0);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(80.00);
        habilidade.setNome("Sequências Mortal");
        habilidade.setTempoDeRecarga(0.9);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(130.00);
        habilidade.setNome("Golpe Final");
        habilidade.setTempoDeRecarga(2.5);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        
        personagem.setNome("Gavião Arqueiro");
        personagem.setAtaque(110.0);
        personagem.setDefesa(120.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(250);
        personagem.setImagem("/imagens/gaviaoArqueiro.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(100.00);
        habilidade.setNome("Lançar Flecha");
        habilidade.setTempoDeRecarga(1.5);
        habilidade.setValorCompra(100);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(140.00);
        habilidade.setNome("Rajada de Flechas");
        habilidade.setTempoDeRecarga(2.5);
        habilidade.setValorCompra(250);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(120.00);
        habilidade.setNome("Tiro de Pistola");
        habilidade.setTempoDeRecarga(2.0);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(200.00);
        habilidade.setNome("Flecha de Bomba");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(500);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Visão");
        personagem.setAtaque(200.);
        personagem.setDefesa(180.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(800);
        personagem.setImagem("/imagens/visao.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(200.00);
        habilidade.setNome("Rajada Solar");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(100.00);
        habilidade.setNome("Projeção sobre o corpo do inimigo");
        habilidade.setTempoDeRecarga(1.5);
        habilidade.setValorCompra(150);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(80.00);
        habilidade.setNome("Sequências Mortal");
        habilidade.setTempoDeRecarga(0.9);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(278.00);
        habilidade.setNome("Raio Testal");
        habilidade.setTempoDeRecarga(5.0);
        habilidade.setValorCompra(800);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Viuva Negra");
        personagem.setAtaque(120.0);
        personagem.setDefesa(100.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(500);
        personagem.setImagem("/imagens/viuvaNegra.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(120.00);
        habilidade.setNome("Tiro de Pistola");
        habilidade.setTempoDeRecarga(2.0);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(120.00);
        habilidade.setNome("Rajada de Balas");
        habilidade.setTempoDeRecarga(2.0);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(80.00);
        habilidade.setNome("Sequências Mortal");
        habilidade.setTempoDeRecarga(0.9);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(216.00);
        habilidade.setNome("Ferrões da viúva");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(500);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Homem-Aranha");
        personagem.setAtaque(180.0);
        personagem.setDefesa(150.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(860);
        personagem.setImagem("/imagens/homem-Aranha.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(150.00);
        habilidade.setNome("Lançamento de Teia");
        habilidade.setTempoDeRecarga(2.5);
        habilidade.setValorCompra(250);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(180.00);
        habilidade.setNome("Bolinhas de Teias");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(320);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(80.00);
        habilidade.setNome("Sequências  Mortal");
        habilidade.setTempoDeRecarga(0.9);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(299.00);
        habilidade.setNome("Explosão Aracnídea");
        habilidade.setTempoDeRecarga(4.2);
        habilidade.setValorCompra(980);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Falcão");
        personagem.setAtaque(200.0);
        personagem.setDefesa(150.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(800);
        personagem.setImagem("/imagens/falcao.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(159.00);
        habilidade.setNome("Ataque Aéreo");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(200);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(150.00);
        habilidade.setNome("Ataque dos Pássaros");
        habilidade.setTempoDeRecarga(2.5);
        habilidade.setValorCompra(400);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(80.00);
        habilidade.setNome("Sequências  Mortal");
        habilidade.setTempoDeRecarga(0.9);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(300.00);
        habilidade.setNome("Ataque com Asa Vermelha Conjugado");
        habilidade.setTempoDeRecarga(4.5);
        habilidade.setValorCompra(900);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Pantera Negra");
        personagem.setAtaque(230.0);
        personagem.setDefesa(180.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(890);
        personagem.setImagem("/imagens/panteraNegra.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(250.00);
        habilidade.setNome("Garras de Vibranium");
        habilidade.setTempoDeRecarga(3.5);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(300.00);
        habilidade.setNome("Lança de Vibranim");
        habilidade.setTempoDeRecarga(4.2);
        habilidade.setValorCompra(400);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(190.00);
        habilidade.setNome("Sequências  Wakandiana");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(500);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(100.00);
        habilidade.setNome("Rajadas de Golpes");
        habilidade.setTempoDeRecarga(1.5);
        habilidade.setValorCompra(990);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Dr. Estranho");
        personagem.setAtaque(300.0);
        personagem.setDefesa(300.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(950);
        personagem.setImagem("/imagens/drEstranho.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(300.00);
        habilidade.setNome("Atanques Místicos");
        habilidade.setTempoDeRecarga(4.2);
        habilidade.setValorCompra(250);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(350.00);
        habilidade.setNome("Sete sóis de Cannibus");
        habilidade.setTempoDeRecarga(4.5);
        habilidade.setValorCompra(450);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(400.00);
        habilidade.setNome("Sete Anéis de Ragganor");
        habilidade.setTempoDeRecarga(5.2);
        habilidade.setValorCompra(600);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(1000.00);
        habilidade.setNome("Conjurmento das criaturas Criaturas Malígnas");
        habilidade.setTempoDeRecarga(7.0);
        habilidade.setValorCompra(1080);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Máquina de Combate");
        personagem.setAtaque(180.0);
        personagem.setDefesa(150.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(600);
        personagem.setImagem("/imagens/warMachine.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(150.00);
        habilidade.setNome("Rajada de Tiros");
        habilidade.setTempoDeRecarga(2.5);
        habilidade.setValorCompra(250);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(180.00);
        habilidade.setNome("Soco da Máquina");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(320);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(200.00);
        habilidade.setNome("Lança Granada");
        habilidade.setTempoDeRecarga(3.2);
        habilidade.setValorCompra(300);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(320.00);
        habilidade.setNome("Destruição Total");
        habilidade.setTempoDeRecarga(4.2);
        habilidade.setValorCompra(850);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        personagem = new Personagem();

        personagem.setNome("Homem-Formiga");
        personagem.setAtaque(150.0);
        personagem.setDefesa(200.0);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(400);
        personagem.setImagem("/imagens/homem-Formiga.jpg");
        // Inserindo habilidade 1
        habilidade = new Habilidade();
        habilidade.setDano(150.00);
        habilidade.setNome("Ataque Encolhido");
        habilidade.setTempoDeRecarga(2.5);
        habilidade.setValorCompra(250);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 2
        habilidade = new Habilidade();
        habilidade.setDano(180.00);
        habilidade.setNome("Sequencia de Socos");
        habilidade.setTempoDeRecarga(3.0);
        habilidade.setValorCompra(320);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 3
        habilidade = new Habilidade();
        habilidade.setDano(400.00);
        habilidade.setNome("Ataque com Vespa");
        habilidade.setTempoDeRecarga(4.2);
        habilidade.setValorCompra(678);
        personagem.getHabilidades().add(habilidade);
        // Inserindo habilidade 4
        habilidade = new Habilidade();
        habilidade.setDano(380.00);
        habilidade.setNome("Marcha das Formigas");
        habilidade.setTempoDeRecarga(3.8);
        habilidade.setValorCompra(500);
        personagem.getHabilidades().add(habilidade);

        facade.salvarPersonagem(personagem);
        
        System.exit(0);
    }
    
    private static void initFX(JFXPanel jFXPanel){
        try{
            Parent parent = FXMLLoader.
                    load(TelaBatalha.class.getResource("/layouts/tela_batalha.fxml"));
            Scene scene = new Scene(parent);
            jFXPanel.setScene(scene);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
