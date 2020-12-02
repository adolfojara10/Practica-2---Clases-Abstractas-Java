/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author User
 */
public class Actividad implements Serializable {

    private int id;
    private String titulo;
    private Set<String> aplicaciones;

    public Actividad(int id, String titulo, Set<String> aplicaciones) {
        this.id = id;
        this.titulo = titulo;
        this.aplicaciones = aplicaciones;
    }

    public Actividad(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Actividad(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<String> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(Set<String> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Actividad other = (Actividad) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actividad: " + "id=" + id + ", titulo=" + titulo + ", aplicaciones="
                + aplicaciones;
    }

}
