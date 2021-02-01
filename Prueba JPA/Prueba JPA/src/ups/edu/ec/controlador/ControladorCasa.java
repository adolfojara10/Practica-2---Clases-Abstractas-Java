/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import ups.edu.ec.modelo.Casa;

/**
 *
 * @author User
 */
public class ControladorCasa extends Controlador<Casa> {

    @Override
    public List<Casa> findAll() {
        Query consulta = getEm().createNamedQuery("Casa.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        var lista = findAll();

        if (!lista.isEmpty()) {
            Collections.sort(lista, (Casa f1, Casa f2) -> f1.getCodigo().compareTo(f2.getCodigo()));

            return lista.get(lista.size() - 1).getCodigo();
        } else {
            return 0;
        }
    }

}
