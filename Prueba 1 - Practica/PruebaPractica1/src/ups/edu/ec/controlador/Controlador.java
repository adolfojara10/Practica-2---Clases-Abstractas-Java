/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 * @param <T>
 */
public abstract class Controlador<T> {

    private List<T> listaGenerica;
    private String ruta;

    public Controlador(String ruta) {
        listaGenerica = new ArrayList<>();
        this.ruta = ruta;
        this.cargarDatos();
    }

    public abstract int generarID();

    public void cargarDatos() {
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream objetoLectura = new ObjectInputStream(archivo);

            listaGenerica = (List<T>) objetoLectura.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean guardarDatos(List<T> listaGuardar) {
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream objetoEscritura = new ObjectOutputStream(archivo);

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
            return true;
        }
    }

    public T read(T objeto) {

        if (listaGenerica.contains(objeto)) {
            return (T) listaGenerica.stream().filter(obj -> obj.equals(objeto)).findFirst().get();
        } else {
            return null;
        }

    }

    public boolean update(T objetoAntiguo, T objetoNuevo) {
        int index = listaGenerica.indexOf(objetoAntiguo);
        listaGenerica.set(index, objetoNuevo);
        return guardarDatos(listaGenerica);
    }

    public boolean delete(T objeto) {
        listaGenerica.remove(objeto);
        return guardarDatos(listaGenerica);
    }

    public List<T> getListaGenerica() {
        return listaGenerica;
    }

}
