/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.modelo.Telefono;

/**
 *
 * @author Adolfo
 * @param <T>
 */
public abstract class Controlador<T> {

    private List<T> listaGenerica;

    public Controlador() {
        listaGenerica = new ArrayList<>();
    }

    public boolean create(T objetoCrear) {
        if (!listaGenerica.contains(objetoCrear)) {
            return listaGenerica.add(objetoCrear);
        }
        return false;
    }

    public T read(T objetoBuscar) {
        if (listaGenerica.contains(objetoBuscar)) {
            return (T) listaGenerica.stream().filter(objeto -> objeto.equals(objetoBuscar)).findFirst().get();
        } else 
            return null;

    }

    public T update(T objetoAntiguo, T objetoNuevo) {
        int index = listaGenerica.indexOf(objetoAntiguo);
        return listaGenerica.set(index, objetoNuevo);
    }

    public boolean delete(T objetoEliminar) {
        return listaGenerica.remove(objetoEliminar);
    }

    public List<T> findAll() {
        return listaGenerica;
    }

    public abstract int cargarCodigo();

}
