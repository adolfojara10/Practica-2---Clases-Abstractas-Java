/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.Procurador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ups.edu.ec.controlador.exceptions.NonexistentEntityException;
import ups.edu.ec.controlador.exceptions.PreexistingEntityException;
import ups.edu.ec.modelo.Asunto;

/**
 *
 * @author User
 */
public class AsuntoJpaController implements Serializable {

    public AsuntoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AsuntoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Practica_en_clasePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Asunto asunto) throws PreexistingEntityException, Exception {
        if (asunto.getProcuradorCollection() == null) {
            asunto.setProcuradorCollection(new ArrayList<Procurador>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cedulaClienteFk = asunto.getCedulaClienteFk();
            if (cedulaClienteFk != null) {
                cedulaClienteFk = em.getReference(cedulaClienteFk.getClass(), cedulaClienteFk.getCedula());
                asunto.setCedulaClienteFk(cedulaClienteFk);
            }
            Collection<Procurador> attachedProcuradorCollection = new ArrayList<Procurador>();
            for (Procurador procuradorCollectionProcuradorToAttach : asunto.getProcuradorCollection()) {
                procuradorCollectionProcuradorToAttach = em.getReference(procuradorCollectionProcuradorToAttach.getClass(), procuradorCollectionProcuradorToAttach.getCedula());
                attachedProcuradorCollection.add(procuradorCollectionProcuradorToAttach);
            }
            asunto.setProcuradorCollection(attachedProcuradorCollection);
            em.persist(asunto);
            if (cedulaClienteFk != null) {
                cedulaClienteFk.getAsuntoCollection().add(asunto);
                cedulaClienteFk = em.merge(cedulaClienteFk);
            }
            for (Procurador procuradorCollectionProcurador : asunto.getProcuradorCollection()) {
                Asunto oldNumeroAsuntoFkOfProcuradorCollectionProcurador = procuradorCollectionProcurador.getNumeroAsuntoFk();
                procuradorCollectionProcurador.setNumeroAsuntoFk(asunto);
                procuradorCollectionProcurador = em.merge(procuradorCollectionProcurador);
                if (oldNumeroAsuntoFkOfProcuradorCollectionProcurador != null) {
                    oldNumeroAsuntoFkOfProcuradorCollectionProcurador.getProcuradorCollection().remove(procuradorCollectionProcurador);
                    oldNumeroAsuntoFkOfProcuradorCollectionProcurador = em.merge(oldNumeroAsuntoFkOfProcuradorCollectionProcurador);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsunto(asunto.getNumeroExpediente()) != null) {
                throw new PreexistingEntityException("Asunto " + asunto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asunto asunto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asunto persistentAsunto = em.find(Asunto.class, asunto.getNumeroExpediente());
            Cliente cedulaClienteFkOld = persistentAsunto.getCedulaClienteFk();
            Cliente cedulaClienteFkNew = asunto.getCedulaClienteFk();
            Collection<Procurador> procuradorCollectionOld = persistentAsunto.getProcuradorCollection();
            Collection<Procurador> procuradorCollectionNew = asunto.getProcuradorCollection();
            if (cedulaClienteFkNew != null) {
                cedulaClienteFkNew = em.getReference(cedulaClienteFkNew.getClass(), cedulaClienteFkNew.getCedula());
                asunto.setCedulaClienteFk(cedulaClienteFkNew);
            }
            Collection<Procurador> attachedProcuradorCollectionNew = new ArrayList<Procurador>();
            for (Procurador procuradorCollectionNewProcuradorToAttach : procuradorCollectionNew) {
                procuradorCollectionNewProcuradorToAttach = em.getReference(procuradorCollectionNewProcuradorToAttach.getClass(), procuradorCollectionNewProcuradorToAttach.getId());
                attachedProcuradorCollectionNew.add(procuradorCollectionNewProcuradorToAttach);
            }
            procuradorCollectionNew = attachedProcuradorCollectionNew;
            asunto.setProcuradorCollection(procuradorCollectionNew);
            asunto = em.merge(asunto);
            if (cedulaClienteFkOld != null && !cedulaClienteFkOld.equals(cedulaClienteFkNew)) {
                cedulaClienteFkOld.getAsuntoCollection().remove(asunto);
                cedulaClienteFkOld = em.merge(cedulaClienteFkOld);
            }
            if (cedulaClienteFkNew != null && !cedulaClienteFkNew.equals(cedulaClienteFkOld)) {
                cedulaClienteFkNew.getAsuntoCollection().add(asunto);
                cedulaClienteFkNew = em.merge(cedulaClienteFkNew);
            }
            for (Procurador procuradorCollectionOldProcurador : procuradorCollectionOld) {
                if (!procuradorCollectionNew.contains(procuradorCollectionOldProcurador)) {
                    procuradorCollectionOldProcurador.setNumeroAsuntoFk(null);
                    procuradorCollectionOldProcurador = em.merge(procuradorCollectionOldProcurador);
                }
            }
            for (Procurador procuradorCollectionNewProcurador : procuradorCollectionNew) {
                if (!procuradorCollectionOld.contains(procuradorCollectionNewProcurador)) {
                    Asunto oldNumeroAsuntoFkOfProcuradorCollectionNewProcurador = procuradorCollectionNewProcurador.getNumeroAsuntoFk();
                    procuradorCollectionNewProcurador.setNumeroAsuntoFk(asunto);
                    procuradorCollectionNewProcurador = em.merge(procuradorCollectionNewProcurador);
                    if (oldNumeroAsuntoFkOfProcuradorCollectionNewProcurador != null && !oldNumeroAsuntoFkOfProcuradorCollectionNewProcurador.equals(asunto)) {
                        oldNumeroAsuntoFkOfProcuradorCollectionNewProcurador.getProcuradorCollection().remove(procuradorCollectionNewProcurador);
                        oldNumeroAsuntoFkOfProcuradorCollectionNewProcurador = em.merge(oldNumeroAsuntoFkOfProcuradorCollectionNewProcurador);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asunto.getNumeroExpediente();
                if (findAsunto(id) == null) {
                    throw new NonexistentEntityException("The asunto with id " + id + " no longer exists.");
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
            Asunto asunto;
            try {
                asunto = em.getReference(Asunto.class, id);
                asunto.getNumeroExpediente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asunto with id " + id + " no longer exists.", enfe);
            }
            Cliente cedulaClienteFk = asunto.getCedulaClienteFk();
            if (cedulaClienteFk != null) {
                cedulaClienteFk.getAsuntoCollection().remove(asunto);
                cedulaClienteFk = em.merge(cedulaClienteFk);
            }
            Collection<Procurador> procuradorCollection = asunto.getProcuradorCollection();
            for (Procurador procuradorCollectionProcurador : procuradorCollection) {
                procuradorCollectionProcurador.setNumeroAsuntoFk(null);
                procuradorCollectionProcurador = em.merge(procuradorCollectionProcurador);
            }
            em.remove(asunto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asunto> findAsuntoEntities() {
        return findAsuntoEntities(true, -1, -1);
    }

    public List<Asunto> findAsuntoEntities(int maxResults, int firstResult) {
        return findAsuntoEntities(false, maxResults, firstResult);
    }

    private List<Asunto> findAsuntoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asunto.class));
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

    public Asunto findAsunto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asunto.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsuntoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asunto> rt = cq.from(Asunto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
