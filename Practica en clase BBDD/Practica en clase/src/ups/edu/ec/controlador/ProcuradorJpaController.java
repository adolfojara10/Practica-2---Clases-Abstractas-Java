/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ups.edu.ec.controlador.exceptions.NonexistentEntityException;
import ups.edu.ec.modelo.Asunto;
import ups.edu.ec.modelo.Procurador;

/**
 *
 * @author User
 */
public class ProcuradorJpaController implements Serializable {

    public ProcuradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProcuradorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Practica_en_clasePU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Procurador procurador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asunto numeroAsuntoFk = procurador.getNumeroAsuntoFk();
            if (numeroAsuntoFk != null) {
                numeroAsuntoFk = em.getReference(numeroAsuntoFk.getClass(), numeroAsuntoFk.getNumeroExpediente());
                procurador.setNumeroAsuntoFk(numeroAsuntoFk);
            }
            em.persist(procurador);
            if (numeroAsuntoFk != null) {
                numeroAsuntoFk.getProcuradorCollection().add(procurador);
                numeroAsuntoFk = em.merge(numeroAsuntoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Procurador procurador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Procurador persistentProcurador = em.find(Procurador.class, procurador.getId());
            Asunto numeroAsuntoFkOld = persistentProcurador.getNumeroAsuntoFk();
            Asunto numeroAsuntoFkNew = procurador.getNumeroAsuntoFk();
            if (numeroAsuntoFkNew != null) {
                numeroAsuntoFkNew = em.getReference(numeroAsuntoFkNew.getClass(), numeroAsuntoFkNew.getNumeroExpediente());
                procurador.setNumeroAsuntoFk(numeroAsuntoFkNew);
            }
            procurador = em.merge(procurador);
            if (numeroAsuntoFkOld != null && !numeroAsuntoFkOld.equals(numeroAsuntoFkNew)) {
                numeroAsuntoFkOld.getProcuradorCollection().remove(procurador);
                numeroAsuntoFkOld = em.merge(numeroAsuntoFkOld);
            }
            if (numeroAsuntoFkNew != null && !numeroAsuntoFkNew.equals(numeroAsuntoFkOld)) {
                numeroAsuntoFkNew.getProcuradorCollection().add(procurador);
                numeroAsuntoFkNew = em.merge(numeroAsuntoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = procurador.getId();
                if (findProcurador(id) == null) {
                    throw new NonexistentEntityException("The procurador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Procurador procurador;
            try {
                procurador = em.getReference(Procurador.class, id);
                procurador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procurador with id " + id + " no longer exists.", enfe);
            }
            Asunto numeroAsuntoFk = procurador.getNumeroAsuntoFk();
            if (numeroAsuntoFk != null) {
                numeroAsuntoFk.getProcuradorCollection().remove(procurador);
                numeroAsuntoFk = em.merge(numeroAsuntoFk);
            }
            em.remove(procurador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Procurador> findProcuradorEntities() {
        return findProcuradorEntities(true, -1, -1);
    }

    public List<Procurador> findProcuradorEntities(int maxResults, int firstResult) {
        return findProcuradorEntities(false, maxResults, firstResult);
    }

    private List<Procurador> findProcuradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Procurador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Procurador findProcurador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Procurador.class, id);
        } finally {
            em.close();
        }
    }

    public int getProcuradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Procurador> rt = cq.from(Procurador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Procurador findByCedula(String cedula) {
        var procuradores = this.findProcuradorEntities();

        for (Procurador p : procuradores) {
            if (p.getCedula().equals(cedula)) {
                return p;

            }
        }

        return null;
    }

    public List<Procurador> findCedulaCliente(String cedula) {

        var listaEncuentro = new ArrayList<Procurador>();
        var procuradores = this.findProcuradorEntities();

        procuradores.stream().filter(p -> (p.getNumeroAsuntoFk().getCedulaClienteFk().getCedula().equals(cedula))).forEachOrdered(p -> {
            listaEncuentro.add(p);
        });

        return listaEncuentro;
    }

    public List<Procurador> findNumeroAsunto(int id) {

        var listaEncuentro = new ArrayList<Procurador>();
        var procuradores = this.findProcuradorEntities();

        procuradores.stream().filter(p -> (p.getNumeroAsuntoFk().getNumeroExpediente() == id)).forEachOrdered(p -> {
            listaEncuentro.add(p);
        });

        return listaEncuentro;
    }

    public List<Procurador> findListaProcuradorCedula(String cedula) {

        var listaEncuentro = new ArrayList<Procurador>();
        var procuradores = this.findProcuradorEntities();

        procuradores.stream().filter(p -> (p.getCedula().equals(cedula))).forEachOrdered(p -> {
            listaEncuentro.add(p);
        });

        return listaEncuentro;
    }
}
