/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.barid.tp2.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.barid.tp2.bean.Operation;

/**
 *
 * @author MoulaYounes
 */
@Stateless
public class OperationDao extends AbstractDao<Operation> {

    @PersistenceContext(unitName = "barid-jsf2PU")
    private EntityManager em;

    public List<Operation> findByCompteRib(String rib) {
        return em.createQuery("SELECT op FROM Operation op WHERE op.compte.rib='" + rib + "'").getResultList();
    }

    public int deleteByCompteRib(String rib) {
        return em.createQuery("DELETE FROM Operation op WHERE op.compte.rib='" + rib + "'").executeUpdate();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperationDao() {
        super(Operation.class);
    }

}
