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
import ups.edu.ec.modelo.Vehiculo;

/**
 *
 * @author User
 */
public class ControladorVehiculo extends Controlador<Vehiculo>{

    @Override
    public List<Vehiculo> findAll() {
        Query consulta = getEm().createNamedQuery("Vehiculo.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getLongitud() {
        EntityManager em = getEm();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    }
    
}
