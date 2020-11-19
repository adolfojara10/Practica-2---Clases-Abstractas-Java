/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 * @param <T>
 */
public class Controlador<T> {
    
    private List<T> listaGenerica;

    public Controlador() {
        listaGenerica = new ArrayList<>();
    }
    
    public void create(T objeto){
        listaGenerica.add(objeto);
    }
    
    public void update(T objetoAntiguo, T objetoNuevo){
        int index = listaGenerica.indexOf(objetoAntiguo);
        listaGenerica.set(index, objetoNuevo);
    }
    
    
    
}
