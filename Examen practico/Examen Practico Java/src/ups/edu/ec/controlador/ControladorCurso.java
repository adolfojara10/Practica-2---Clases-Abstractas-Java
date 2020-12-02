/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

/**
 *
 * @author User
 */
public class ControladorCurso extends Controlador {

    public ControladorCurso(String ruta) {
        super(ruta);
    }

    @Override
    public int generarID() {
        return getListaGenerica().size() + 1;
    }

}
