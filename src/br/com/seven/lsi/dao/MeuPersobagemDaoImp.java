/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import br.com.seven.lsi.model.MeuPersonagem;
import br.com.seven.lsi.model.Personagem;
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
public class MeuPersobagemDaoImp extends GenericoDaoImp<MeuPersonagem>implements IMeuPersonagemDao {

    @Override
    public List<MeuPersonagem> listPorPlayer(Player player) {
        EntityManager manager = JPAUtil.getEntityManager();
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.like("player", player)).add(Restrictions.eq("status", true));
        return criteria.list();
    }

    @Override
    public MeuPersonagem buscarPorPlayerEPersonagem(Long idPlayer, Long idPersonagem) {
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createNativeQuery("SELECT mp.* FROM meupersonagem mp WHERE mp.personagem_id = :idPersonagem AND mp.player_id = :idPlayer AND mp.status = 1", MeuPersonagem.class);
        query.setParameter("idPlayer", idPlayer);
        query.setParameter("idPersonagem", idPersonagem);
        MeuPersonagem meupersonagem = (MeuPersonagem) query.getSingleResult();
        manager.close();
        return meupersonagem;
    }
    
}
