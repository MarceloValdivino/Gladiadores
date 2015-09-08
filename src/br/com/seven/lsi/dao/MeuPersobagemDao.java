/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import br.com.seven.lsi.model.MeuPersonagem;
import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcelo
 */
public class MeuPersobagemDao extends GenericoDaoImp<MeuPersonagem>implements IMeuPersonagemDao {

    @Override
    public List<MeuPersonagem> listPorPlayer(Player player) {
        EntityManager manager = JPAUtil.getEntityManager();
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.like("player", player));
        return criteria.list();
    }
    
}
