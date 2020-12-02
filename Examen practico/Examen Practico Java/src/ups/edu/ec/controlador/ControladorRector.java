/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.modelo.Rector;

/**
 *
 * @author User
 */
public class ControladorRector extends Controlador {

    public ControladorRector(String ruta) {
        super(ruta);
    }

    public Rector login(String correo, String password) {
        var listaRector = (List<Rector>) getListaGenerica();

        Rector rector = listaRector.stream().filter(rec -> rec.getCorreo().equals(correo) && 
                rec.getPassword().equals(password)).findAny().get();

        if (rector != null) {
            return Rector.getInstance();
        } else {
            return null;
        }
    }

    @Override
    public int generarID() {
        return 1;
    }

}
