/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Collections;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import ups.edu.ec.modelo.Persona;

/**
 *
 * @author User
 */
public class ControladorPersona extends Controlador<Persona> {

    public Persona findByCedula(String cedula) {

        try {
            Query consulta = getEm().createNamedQuery("Persona.findByCedula");
            consulta.setParameter("cedula", cedula);
            Persona p = (Persona) consulta.getSingleResult();
            return p;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Persona> findAll() {
        Query consulta = getEm().createNamedQuery("Persona.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        var lista = findAll();

        Collections.sort(lista, (Persona p1, Persona p2) -> p1.getCodigo() - p2.getCodigo());

        if (!lista.isEmpty()) {
            return lista.get(lista.size() - 1).getCodigo();
        } else {
            return 0;
        }
    }

}
