/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.barid.tp2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.barid.tp2.bean.Compte;
import ma.barid.tp2.dao.CompteDao;

/**
 *
 * @author MoulaYounes
 */
@Stateless
public class CompteFacade {

    @EJB
    private CompteDao compteDao;

    @EJB
    private OperationFacade operationFacade;

    public List<Compte> findAll() {
        return compteDao.findAll();
    }

    public void edit(Compte entity) {
        compteDao.edit(entity);
    }

    public Compte findByRib(String rib) {
        return compteDao.findByRib(rib);
    }

    public void initBd() {
        for (int i = 1; i < 11; i++) {
            Compte c = new Compte("C-" + i, i * 100d);
            compteDao.create(c);
        }
    }

    public void deleteAll() {
        compteDao.deleteAll();
    }

    public void create(Compte entity) {
        compteDao.create(entity);
    }

    public Compte find(Object id) {
        return compteDao.find(id);
    }

    public void remove(Compte entity) {
        operationFacade.deleteByCompteRib(entity.getRib());
        compteDao.remove(entity);

    }

    public int count() {
        return compteDao.count();
    }

}
