/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ups.edu.ec.modelo.EnumEstadoSitio;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class ControladorSitio extends Controlador<Sitio> {

    //private List<Sitio> listaSitios;
    public ControladorSitio() {
        //listaSitios = new ArrayList<>();
        //crearSitios();
    }

    public void crearSitios() {
        for (int i = 1; i <= 50; i++) {
            Sitio sitio = new Sitio();
            sitio.setCodigo(i);
            sitio.setEstado(EnumEstadoSitio.DESOCUPADO.toString());
            sitio.setPrecio(BigDecimal.valueOf(0.25));
            create(sitio);
            //listaSitios.add(sitio);
        }
    }

    public void cambiarAEstadoOcupado(Sitio sitio) {
        sitio.setEstado(EnumEstadoSitio.OCUPADO.toString());
        update(sitio);

    }

    public void cambiarAEstadoContratado(Sitio sitio) {

        sitio.setEstado(EnumEstadoSitio.CONTRATADO.toString());
        update(sitio);

    }

    public void cambiarAEstadoDesocupado(Sitio sitio) {
        sitio.setEstado(EnumEstadoSitio.DESOCUPADO.toString());
        update(sitio);

    }

    public Sitio encontrarSitioDesocupado() {

        var lista = findAll();

        Collections.sort(lista, (Sitio s1, Sitio s2) -> s1.getCodigo().compareTo(s2.getCodigo()));

        for (Sitio si : lista) {
            if (si.getEstado().equals(EnumEstadoSitio.DESOCUPADO.toString())) {
                return si;
            }
        }
        return null;
    }

    @Override
    public List<Sitio> findAll() {
        Query consulta = getEm().createNamedQuery("Sitio.findAll");
        var lista = consulta.getResultList();
        Collections.sort(lista, (Sitio s1, Sitio s2) -> s1.getCodigo().compareTo(s2.getCodigo()));
        
        return lista;
        
    }

    @Override
    public int getLongitud() {
        EntityManager em = getEm();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sitio> rt = cq.from(Sitio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    }

}
