/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.modelo.Docente;

/**
 *
 * @author User
 */
public class ControladorDocente extends Controlador {

    public ControladorDocente(String ruta) {
        super(ruta);
    }

    public Docente login(String correo, String password) {

        var listaDocentes = (List<Docente>) getListaGenerica();
        Docente docente = listaDocentes.stream().filter(docen -> docen.getCorreo().equals(correo)
                && docen.getPassword().equals(password)).findFirst().get();

        if (docente != null) {
            Docente.instance = docente;
            return Docente.instance;
        } else {
            return null;
        }

    }

    @Override
    public int generarID() {
        return getListaGenerica().size() + 1;
    }

}
