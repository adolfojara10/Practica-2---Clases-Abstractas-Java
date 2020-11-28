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
public class ControladorMatrimonio extends Controlador{

    public ControladorMatrimonio(String ruta) {
        super(ruta);
    }

    @Override
    public int generarID() {
        if (super.getListaGenerica().isEmpty()) {
            return 1;
        } else {
            return (super.getListaGenerica().size() + 1);
        }
    }
    
    
}
