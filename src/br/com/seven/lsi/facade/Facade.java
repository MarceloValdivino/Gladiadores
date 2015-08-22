/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.facade;

import br.com.seven.lsi.dao.IHabilidadeDao;
import br.com.seven.lsi.dao.IItemDao;
import br.com.seven.lsi.dao.IPersonagemDao;
import br.com.seven.lsi.dao.IPlayerDao;
import br.com.seven.lsi.factory.FactoryDao;
import br.com.seven.lsi.model.Habilidade;
import br.com.seven.lsi.model.Item;
import br.com.seven.lsi.model.Personagem;
import br.com.seven.lsi.model.Player;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Facade {

    IHabilidadeDao habilidadeDao;
    IItemDao itemDao;
    IPersonagemDao personagemDao;
    IPlayerDao playerDao;

    public Facade() {
        this.habilidadeDao = FactoryDao.getHabilidadeDao();
        this.itemDao = FactoryDao.getItemDao();
        this.personagemDao = FactoryDao.getPersonagemDao();
        this.playerDao = FactoryDao.getPlayerDao();
    }
    
    public void salvarHabilidade(Habilidade habilidade){
        habilidadeDao.save(habilidade);
    }
    
    public Habilidade buscarHabilidade(Long id){
        return habilidadeDao.getObject(id);
    }
    
    public void removerHabilidade(Habilidade habilidade){
        habilidadeDao.remove(habilidade);
    }
    
    public List<Habilidade> listarHabilidades(){
        return habilidadeDao.list();
    }

    public void salvarItem(Item item){
        itemDao.save(item);
    }
    
    public Item buscarItem(Long id){
        return itemDao.getObject(id);
    }
    
    public void removerItem(Item item){
        itemDao.remove(item);
    }
    
    public List<Item> listarItens(){
        return itemDao.list();
    }
    
    public void salvarPersonagem(Personagem personagem){
        personagemDao.save(personagem);
    }
    
    public Personagem buscarPersonagem(Long id){
        return personagemDao.getObject(id);
    }
    
    public void removerPersonagem(Personagem personagem){
        personagemDao.remove(personagem);
    }
    
    public List<Personagem> listarPersonagem(){
        return personagemDao.list();
    }
    
    public void salvarPlayer(Player player){
        playerDao.save(player);
    }
    
    public Player buscarPlayer(Long id){
        return playerDao.getObject(id);
    }
    
    public void removerPlayer(Player player){
        playerDao.remove(player);
    }
    
    public List<Player> listarPlayers(){
        return playerDao.list();
    }
}
