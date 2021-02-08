/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import ups.edu.ec.modelo.Cliente;

/**
 *
 * @author User
 */
public class ControladorCliente extends Controlador<Cliente> {

    @Override
    public List<Cliente> findAll() {
        Query consulta = getEm().createNamedQuery("Cliente.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        var lista = findAll();
        Collections.sort(lista, (Cliente c1, Cliente c2) -> c1.getCodigo().compareTo(c2.getCodigo()));

        if (!lista.isEmpty()) {
            return lista.get(lista.size()-1).getCodigo();
        } else {
            return 0;
        }
    }

}
