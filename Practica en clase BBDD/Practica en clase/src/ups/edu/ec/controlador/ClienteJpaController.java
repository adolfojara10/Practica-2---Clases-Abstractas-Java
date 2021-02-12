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
import ups.edu.ec.modelo.Asunto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ups.edu.ec.controlador.exceptions.IllegalOrphanException;
import ups.edu.ec.controlador.exceptions.NonexistentEntityException;
import ups.edu.ec.controlador.exceptions.PreexistingEntityException;
import ups.edu.ec.modelo.Cliente;

/**
 *
 * @author User
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ClienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Practica_en_clasePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getAsuntoCollection() == null) {
            cliente.setAsuntoCollection(new ArrayList<Asunto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Asunto> attachedAsuntoCollection = new ArrayList<Asunto>();
            for (Asunto asuntoCollectionAsuntoToAttach : cliente.getAsuntoCollection()) {
                asuntoCollectionAsuntoToAttach = em.getReference(asuntoCollectionAsuntoToAttach.getClass(), asuntoCollectionAsuntoToAttach.getNumeroExpediente());
                attachedAsuntoCollection.add(asuntoCollectionAsuntoToAttach);
            }
            cliente.setAsuntoCollection(attachedAsuntoCollection);
            em.persist(cliente);
            for (Asunto asuntoCollectionAsunto : cliente.getAsuntoCollection()) {
                Cliente oldCedulaClienteFkOfAsuntoCollectionAsunto = asuntoCollectionAsunto.getCedulaClienteFk();
                asuntoCollectionAsunto.setCedulaClienteFk(cliente);
                asuntoCollectionAsunto = em.merge(asuntoCollectionAsunto);
                if (oldCedulaClienteFkOfAsuntoCollectionAsunto != null) {
                    oldCedulaClienteFkOfAsuntoCollectionAsunto.getAsuntoCollection().remove(asuntoCollectionAsunto);
                    oldCedulaClienteFkOfAsuntoCollectionAsunto = em.merge(oldCedulaClienteFkOfAsuntoCollectionAsunto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getCedula()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getCedula());
            Collection<Asunto> asuntoCollectionOld = persistentCliente.getAsuntoCollection();
            Collection<Asunto> asuntoCollectionNew = cliente.getAsuntoCollection();
            List<String> illegalOrphanMessages = null;
            for (Asunto asuntoCollectionOldAsunto : asuntoCollectionOld) {
                if (!asuntoCollectionNew.contains(asuntoCollectionOldAsunto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Asunto " + asuntoCollectionOldAsunto + " since its cedulaClienteFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Asunto> attachedAsuntoCollectionNew = new ArrayList<Asunto>();
            for (Asunto asuntoCollectionNewAsuntoToAttach : asuntoCollectionNew) {
                asuntoCollectionNewAsuntoToAttach = em.getReference(asuntoCollectionNewAsuntoToAttach.getClass(), asuntoCollectionNewAsuntoToAttach.getNumeroExpediente());
                attachedAsuntoCollectionNew.add(asuntoCollectionNewAsuntoToAttach);
            }
            asuntoCollectionNew = attachedAsuntoCollectionNew;
            cliente.setAsuntoCollection(asuntoCollectionNew);
            cliente = em.merge(cliente);
            for (Asunto asuntoCollectionNewAsunto : asuntoCollectionNew) {
                if (!asuntoCollectionOld.contains(asuntoCollectionNewAsunto)) {
                    Cliente oldCedulaClienteFkOfAsuntoCollectionNewAsunto = asuntoCollectionNewAsunto.getCedulaClienteFk();
                    asuntoCollectionNewAsunto.setCedulaClienteFk(cliente);
                    asuntoCollectionNewAsunto = em.merge(asuntoCollectionNewAsunto);
                    if (oldCedulaClienteFkOfAsuntoCollectionNewAsunto != null && !oldCedulaClienteFkOfAsuntoCollectionNewAsunto.equals(cliente)) {
                        oldCedulaClienteFkOfAsuntoCollectionNewAsunto.getAsuntoCollection().remove(asuntoCollectionNewAsunto);
                        oldCedulaClienteFkOfAsuntoCollectionNewAsunto = em.merge(oldCedulaClienteFkOfAsuntoCollectionNewAsunto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cliente.getCedula();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Asunto> asuntoCollectionOrphanCheck = cliente.getAsuntoCollection();
            for (Asunto asuntoCollectionOrphanCheckAsunto : asuntoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Asunto " + asuntoCollectionOrphanCheckAsunto + " in its asuntoCollection field has a non-nullable cedulaClienteFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
