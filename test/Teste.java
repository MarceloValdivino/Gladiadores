/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Item;
import br.com.seven.lsi.model.Personagem;
import br.com.seven.lsi.myenum.TipoPersonagem;

/**
 *
 * @author Marcelo
 */
public class Teste {

    public static void main(String[] args) {
        Facade facade = new Facade();
        Personagem personagem = new Personagem();

        personagem.setNome("Soldade Invernal");
        personagem.setAtaque(130.0);
        personagem.setDefesa(120.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1450.0);
        personagem.setValorVenda(500.0);
        
        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Maquina de Combate");
        personagem.setAtaque(155.0);
        personagem.setDefesa(110.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1600.0);
        personagem.setValorVenda(650.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Gavião Arqueiro");
        personagem.setAtaque(130.0);
        personagem.setDefesa(100.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.VIGILANTE);
        personagem.setVida(1450.0);
        personagem.setValorVenda(500.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Viuva Negra");
        personagem.setAtaque(115.0);
        personagem.setDefesa(100.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.VIGILANTE);
        personagem.setVida(1200.0);
        personagem.setValorVenda(400.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Demolidor");
        personagem.setAtaque(130.0);
        personagem.setDefesa(100.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.VIGILANTE);
        personagem.setVida(1300.0);
        personagem.setValorVenda(450.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Punho de Ferro");
        personagem.setAtaque(130.0);
        personagem.setDefesa(100.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.VIGILANTE);
        personagem.setVida(1500.0);
        personagem.setValorVenda(500.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Homem Formiga");
        personagem.setAtaque(140.0);
        personagem.setDefesa(130.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1700.0);
        personagem.setValorVenda(600.0);

        facade.salvarPersonagem(personagem);

        personagem.setNome("Homem de Ferro");
        personagem.setAtaque(150.0);
        personagem.setDefesa(150.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.SUPER_HEROI);
        personagem.setVida(1800.0);
        personagem.setValorVenda(750.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Capitão America");
        personagem.setAtaque(120.0);
        personagem.setDefesa(150.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1500.0);
        personagem.setValorVenda(600.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Pantera Negra");
        personagem.setAtaque(170.0);
        personagem.setDefesa(100.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1400.0);
        personagem.setValorVenda(500.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Falcão");
        personagem.setAtaque(120.0);
        personagem.setDefesa(160.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.HEROI);
        personagem.setVida(1400.0);
        personagem.setValorVenda(500.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Visão");
        personagem.setAtaque(170.0);
        personagem.setDefesa(150.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.SUPER_HEROI);
        personagem.setVida(2000.0);
        personagem.setValorVenda(1000.0);

        facade.salvarPersonagem(personagem);

        personagem = new Personagem();
        personagem.setNome("Homem Aranha");
        personagem.setAtaque(120.0);
        personagem.setDefesa(160.0);
        personagem.setHabilidades(null);
        personagem.setItens(null);
        personagem.setTipoPersonagem(TipoPersonagem.SUPER_HEROI);
        personagem.setVida(1500.0);
        personagem.setValorVenda(600.0);

        facade.salvarPersonagem(personagem);

        System.exit(0);
    }
}
