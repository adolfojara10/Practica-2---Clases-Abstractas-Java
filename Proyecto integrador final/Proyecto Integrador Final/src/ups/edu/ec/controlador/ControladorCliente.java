/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ups.edu.ec.modelo.Cliente;

/**
 *
 * @author User
 */
public class ControladorCliente extends Controlador<Cliente>{
    
    
    
    public Cliente findByCedula(String cedula) {
        Query consulta = getEm().createNamedQuery("Cliente.findByCedula");
        consulta.setParameter("cedula", cedula);
        return (Cliente) consulta.getSingleResult();
    }

    @Override
    public List<Cliente> findAll() {
        Query consulta = getEm().createNamedQuery("Cliente.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getLongitud() {
        EntityManager em = getEm();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    
    }
    
    
    
}
