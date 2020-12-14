/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.modelo.Vehiculo;

/**
 *
 * @author User
 */
public class ControladorVehiculo extends Controlador {

    public ControladorVehiculo(String ruta) {
        super(ruta);
    }

    public int generarCodigo() {
        int codigo = 0;
        for (Vehiculo c : (List<Vehiculo>) getListaGenerica()) {
            codigo = c.getCodigo();
        }

        return codigo + 1;
    }

}
