/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import br.com.seven.lsi.model.Player;
import br.com.seven.lsi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcelo
 */
public class PlayerDaoImp extends GenericoDaoImp<Player> implements IPlayerDao {

    @Override
    public List<Player> playerComPersonagem() {
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createNativeQuery("SELECT p.* FROM player p WHERE p.id AND (SELECT COUNT(mp.id) FROM meupersonagem mp WHERE mp.player_id = p.id) > 0;",Player.class);
        return query.getResultList();
    }

    @Override
    public Player getPlayerPorNome(String nome) {
        EntityManager manger = JPAUtil.getEntityManager();
        Criteria c = getCriteria().add(Restrictions.eq("nome", nome));
        return (Player) c.uniqueResult();
    }

}
