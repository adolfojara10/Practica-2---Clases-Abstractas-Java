/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import ups.edu.ec.JPAUtils.JPAUtils;

/**
 *
 * @author User
 * @param <E>
 */
public abstract class Controlador<E> {

    private EntityManager em;
    private Class<E> clase;

    public Controlador() {
        this.em = (EntityManager) JPAUtils.getEmf();

        java.lang.reflect.Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;

        clase = (Class) pt.getActualTypeArguments()[0];
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public boolean create(E objeto) {

        try {

            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public E read(int id) {
        return em.find(clase, id);
    }

    public boolean update(E objeto) {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        return true;

    }

    public boolean delete(E objeto) {
        em.getTransaction().begin();
        if (!em.contains(objeto)) {
            objeto = em.merge(objeto);
        }

        em.remove(objeto);
        em.getTransaction().commit();
        return true;
    }

    /*
    public List<E> findAll() {
        List<E> lista = new ArrayList<>();
        lista = em.createQuery("Select t from " + clase.getSimpleName() + " t").getResultList();
        
        return lista;

    }*/
    public abstract List<E> findAll();
    
    public abstract int getCodigo();

}
