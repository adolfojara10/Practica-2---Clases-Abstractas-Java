/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import javax.persistence.Query;
import ups.edu.ec.modelo.Casino;

/**
 *
 * @author User
 */
public class ControladorCasino extends Controlador<Casino> {

    @Override
    public List<Casino> findAll() {
        Query consulta = getEm().createNamedQuery("Casino.findAll");
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        return 1;
    }

}
