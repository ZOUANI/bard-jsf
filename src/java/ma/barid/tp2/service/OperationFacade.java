/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.barid.tp2.service;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ma.barid.tp2.bean.Compte;
import ma.barid.tp2.bean.Operation;
import ma.barid.tp2.dao.OperationDao;

/**
 *
 * @author MoulaYounes
 */
@Stateless
public class OperationFacade {

    @EJB
    private CompteFacade compteFacade;

    @EJB
    private OperationDao operationDao;

    public int deleteByCompteRib(String rib) {
        return operationDao.deleteByCompteRib(rib);
    }

    public List<Operation> findByCompteRib(String rib) {
        return operationDao.findByCompteRib(rib);
    }

    public int save(Operation operation) {
        Compte loadedCompte = compteFacade.findByRib(operation.getCompte().getRib());
        if (loadedCompte == null) {
            return -1;
        } else if (operation.getTypeOperation().getCode().equals("C") && operation.getMontant() > loadedCompte.getSolde()) {
            return -2;
        } else {
            double nvSolde = 0d;
            if (operation.getTypeOperation().getCode().equals("C")) {
                nvSolde = loadedCompte.getSolde() - operation.getMontant();
            } else if (operation.getTypeOperation().getCode().equals("D")) {
                nvSolde = loadedCompte.getSolde() + operation.getMontant();
            }
            operation.setDateOperation(new Date());
            loadedCompte.setSolde(nvSolde);
            operationDao.create(operation);
            compteFacade.edit(loadedCompte);
            return 1;

        }
    }

    public void create(Operation entity) {
        operationDao.create(entity);
    }

    public void edit(Operation entity) {
        operationDao.edit(entity);
    }

    public void remove(Operation entity) {
        operationDao.remove(entity);
    }

    public Operation find(Object id) {
        return operationDao.find(id);
    }

    public List<Operation> findAll() {
        return operationDao.findAll();
    }

    public List<Operation> findRange(int[] range) {
        return operationDao.findRange(range);
    }

    public int count() {
        return operationDao.count();
    }

}
