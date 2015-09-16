/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seven.lsi.dao;

import br.com.seven.lsi.model.Personagem;
import br.com.seven.lsi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class PersonagemDaoImp extends GenericoDaoImp<Personagem> implements IPersonagemDao {

    @Override
    public List<Personagem> listarPersonagensPlayerNaoTem(Long idPlayer) {
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createNativeQuery("SELECT p.* FROM personagem p WHERE p.id NOT IN (SELECT per.id FROM personagem per, meupersonagem mp WHERE mp.personagem_id = per.id AND mp.player_id = :idPlayer AND mp.status = 1)", Personagem.class);
        query.setParameter("idPlayer", idPlayer);
        List<Personagem> personagens = query.getResultList();
        manager.close();
        return personagens;
    }
    
}
