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
import ma.barid.tp2.bean.TypeOperation;

/**
 *
 * @author MoulaYounes
 */
@Stateless
public class TypeOperationDao extends AbstractDao<TypeOperation> {

    @PersistenceContext(unitName = "barid-jsf2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeOperationDao() {
        super(TypeOperation.class);
    }
    
}
