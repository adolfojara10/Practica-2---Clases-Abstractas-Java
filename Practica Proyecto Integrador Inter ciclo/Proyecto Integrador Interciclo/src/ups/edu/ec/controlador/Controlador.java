/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public abstract class Controlador<T> {

    private List<T> listaGenerica;
    private String ruta;

    public Controlador(String ruta) {
        this.ruta = ruta;
        listaGenerica = new ArrayList<>();
        this.cargarDatos();
    }

    public void cargarDatos() {
        try {
            FileInputStream file = new FileInputStream(ruta);
            ObjectInputStream objeto = new ObjectInputStream(file);

            listaGenerica = (List<T>) objeto.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean guardarDatos(List<T> listaGuardar) {

        try {
            FileOutputStream file = new FileOutputStream(ruta);
            ObjectOutputStream objetoEscritura = new ObjectOutputStream(file);

            objetoEscritura.writeObject(listaGuardar);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean create(T objeto) {

        if (!listaGenerica.contains(objeto)) {
            listaGenerica.add(objeto);
            return guardarDatos(listaGenerica);
        } else {
            return false;
        }

    }

    public T read(T objeto) {
        if (listaGenerica.contains(objeto)) {
            return listaGenerica.stream().filter(ob -> ob.equals(objeto)).findFirst().get();
        } else {
            return null;
        }

    }

    public boolean update(T objetoAntiguo, T objetoNuevo) {
        int index = listaGenerica.indexOf(objetoAntiguo);
        listaGenerica.set(index, objetoNuevo);
        return guardarDatos(listaGenerica);
    }

    public boolean delete(T objetoEliminar) {
        listaGenerica.remove(objetoEliminar);
        return guardarDatos(listaGenerica);
    }

    public List<T> getListaGenerica() {
        return listaGenerica;
    }

}
