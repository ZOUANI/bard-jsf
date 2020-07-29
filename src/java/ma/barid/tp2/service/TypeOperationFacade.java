/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.barid.tp2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ma.barid.tp2.bean.TypeOperation;
import ma.barid.tp2.dao.TypeOperationDao;

/**
 *
 * @author MoulaYounes
 */
@Stateless
public class TypeOperationFacade {

    @EJB
    private TypeOperationDao typeOperationDao;

    public void create(TypeOperation entity) {
        typeOperationDao.create(entity);
    }

    public void edit(TypeOperation entity) {
        typeOperationDao.edit(entity);
    }

    public void remove(TypeOperation entity) {
        typeOperationDao.remove(entity);
    }

    public TypeOperation find(Object id) {
        return typeOperationDao.find(id);
    }

    public List<TypeOperation> findAll() {
        return typeOperationDao.findAll();
    }

    public List<TypeOperation> findRange(int[] range) {
        return typeOperationDao.findRange(range);
    }

    public int count() {
        return typeOperationDao.count();
    }
}
