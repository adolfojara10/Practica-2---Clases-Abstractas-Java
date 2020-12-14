/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Sitio implements Serializable {

    private int codigo;
    private EnumEstadoSitio enumEstadoSitio;
    private double precioIntervalo;

    public Sitio(int codigo, EnumEstadoSitio enumEstadoSitio) {
        this.codigo = codigo;
        this.enumEstadoSitio = enumEstadoSitio;
        this.precioIntervalo = 0.25;
    }

    public Sitio() {
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public EnumEstadoSitio getEnumEstadoSitio() {
        return enumEstadoSitio;
    }

    public void setEnumEstadoSitio(EnumEstadoSitio enumEstadoSitio) {
        this.enumEstadoSitio = enumEstadoSitio;
    }

    public double getPrecioHora() {
        return precioIntervalo;
    }

    public void setPrecioHora(double precioHora) {
        this.precioIntervalo = precioHora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
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
        final Sitio other = (Sitio) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sitio:" + "codigo=" + codigo + ", estado=" + enumEstadoSitio + ", precioHora="
                + precioIntervalo;
    }

}
