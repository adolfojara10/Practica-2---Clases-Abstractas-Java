/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import ups.edu.ec.modelo.Apuesta;

/**
 *
 * @author User
 */
public class ControladorApuesta extends Controlador<Apuesta> {

    public List<Apuesta> findByCodigoCliente(int codigo) {

        var listaTodos = findAll();
        List<Apuesta> lista = new ArrayList<>();

        listaTodos.stream().filter(ap -> (ap.getCodigoClienteFk().getCodigo() == codigo)).forEachOrdered(ap -> {
            lista.add(ap);
        });

        return lista;

    }

    public List<Apuesta> findByNumeroApuesta(int codigo) {
        Query consulta = getEm().createNamedQuery("Apuesta.findByCodigo");
        consulta.setParameter("codigo", codigo);

        return consulta.getResultList();
    }

    public int numeroPartida() {
        var lista = findAll();

        if (lista.isEmpty()) {
            return 0;
        } else {
            Collections.sort(lista, (Apuesta ap1, Apuesta ap2) -> ap1.getId().compareTo(ap2.getId()));
            return lista.get(lista.size() - 1).getCodigo();
        }
    }

    @Override
    public List<Apuesta> findAll() {
        Query consulta = getEm().createNamedQuery("Apuesta.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        var lista = findAll();
        Collections.sort(lista, (Apuesta c1, Apuesta c2) -> c1.getCodigo().compareTo(c2.getCodigo()));
        return lista.get(lista.size()).getCodigo();
    }

}
