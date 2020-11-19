/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Adolfo
 */
public class Canal implements Subject {

    private String nombre;
    private String nuevoVideo;
    private List<Observer> listaSubscriptores;

    public Canal(String nombre) {
        this.nombre = nombre;
        listaSubscriptores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNuevoVideo() {
        return nuevoVideo;
    }

    public void setNuevoVideo(String nuevoVideo) {
        this.nuevoVideo = nuevoVideo;
        this.notifySubscriptores();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Canal other = (Canal) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Canal{" + "nombre=" + nombre + ", nuevoVideo=" + nuevoVideo + 
                ", listaSubscriptores=" + listaSubscriptores + '}';
    }

    @Override
    public void añadirSubscriptor(Observer sub) {
        listaSubscriptores.add(sub);
        
    }

    @Override
    public void eliminarSubscriptor(Observer sub) {
        listaSubscriptores.remove(sub);
    }

    @Override
    public void notifySubscriptores() {
        listaSubscriptores.stream().forEach(sub -> sub.update());
    }

}
