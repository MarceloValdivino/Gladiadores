/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.factory;

import br.com.seven.lsi.dao.HabilidadeDaoImp;
import br.com.seven.lsi.dao.IHabilidadeDao;
import br.com.seven.lsi.dao.IItemDao;
import br.com.seven.lsi.dao.IMeuPersonagemDao;
import br.com.seven.lsi.dao.IPersonagemDao;
import br.com.seven.lsi.dao.IPlayerDao;
import br.com.seven.lsi.dao.ItemDaoImp;
import br.com.seven.lsi.dao.MeuPersobagemDaoImp;
import br.com.seven.lsi.dao.PersonagemDaoImp;
import br.com.seven.lsi.dao.PlayerDaoImp;

/**
 *
 * @author Marcelo
 */
public class FactoryDao {
    
    public static IHabilidadeDao getHabilidadeDao(){
        return new HabilidadeDaoImp();
    }
    
    public static IItemDao getItemDao(){
        return new ItemDaoImp();
    }
    
    public static IPersonagemDao getPersonagemDao(){
        return new PersonagemDaoImp();
    }
    
    public static IPlayerDao getPlayerDao(){
        return new PlayerDaoImp();
    }
    
    public static IMeuPersonagemDao getMeuPersonagemDao(){
        return new MeuPersobagemDaoImp();
    }
}
