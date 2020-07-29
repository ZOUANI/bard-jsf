/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.barid.tp2.dao;

import ma.barid.tp2.service.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.barid.tp2.bean.Compte;

/**
 *
 * @author MoulaYounes
 */
@Stateless
public class CompteDao extends AbstractDao<Compte> {

    @PersistenceContext(unitName = "barid-jsf2PU")
    private EntityManager em;

    public void deleteAll() {
        em.createQuery("DELETE FROM Compte c").executeUpdate(); // insert update delete
    }

    public Compte findByRib(String rib) {
        return (Compte) em.createQuery("SELECT c FROM Compte c WHERE c.rib='" + rib + "'").getSingleResult(); // select = getSingleRes + getMultRes
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteDao() {
        super(Compte.class);
    }

}
