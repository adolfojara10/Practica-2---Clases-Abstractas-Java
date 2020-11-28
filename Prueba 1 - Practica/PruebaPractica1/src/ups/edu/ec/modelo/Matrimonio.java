/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author User
 */
public class Matrimonio implements Serializable {

    private int numeroMatrimonio;
    private List<Conyuge> listaConyuges;
    private List<Testigo> listaTestigo;
    private Juez juez;
    private Date fechaMatrimonio;

    private static final long serialVersionUID = 6529685098267757694L;

    public Matrimonio(int numeroMatrimonio, List<Conyuge> listaConyuges, List<Testigo> listaTestigo,
            Juez juez, Date fechaMatrimonio) {
        this.numeroMatrimonio = numeroMatrimonio;
        this.listaConyuges = listaConyuges;
        this.listaTestigo = listaTestigo;
        this.juez = juez;
        this.fechaMatrimonio = fechaMatrimonio;
    }

    public Matrimonio(int numeroMatrimonio) {
        this.numeroMatrimonio = numeroMatrimonio;
    }
    
    

    public int getNumeroMatrimonio() {
        return numeroMatrimonio;
    }

    public void setNumeroMatrimonio(int numeroMatrimonio) {
        this.numeroMatrimonio = numeroMatrimonio;
    }

    public List<Conyuge> getListaConyuges() {
        return listaConyuges;
    }

    public void setListaConyuges(List<Conyuge> listaConyuges) {
        this.listaConyuges = listaConyuges;
    }

    public List<Testigo> getListaTestigo() {
        return listaTestigo;
    }

    public void setListaTestigo(List<Testigo> listaTestigo) {
        this.listaTestigo = listaTestigo;
    }

    public Juez getJuez() {
        return juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
    }

    public Date getFechaMatrimonio() {
        return fechaMatrimonio;
    }

    public void setFechaMatrimonio(Date fechaMatrimonio) {
        this.fechaMatrimonio = fechaMatrimonio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.numeroMatrimonio;
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
        final Matrimonio other = (Matrimonio) obj;
        if (this.numeroMatrimonio != other.numeroMatrimonio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimonio:" + "numeroMatrimonio=" + numeroMatrimonio + ", listaConyuges="
                + listaConyuges + ", listaTestigo=" + listaTestigo + ", juez="
                + juez + ", fechaMatrimonio=" + fechaMatrimonio;
    }

}
