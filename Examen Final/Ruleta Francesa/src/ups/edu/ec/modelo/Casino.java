/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "casino")
@NamedQueries({
    @NamedQuery(name = "Casino.findAll", query = "SELECT c FROM Casino c"),
    @NamedQuery(name = "Casino.findByCodigo", query = "SELECT c FROM Casino c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Casino.findByNombre", query = "SELECT c FROM Casino c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Casino.findByDinero", query = "SELECT c FROM Casino c WHERE c.dinero = :dinero")})
public class Casino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dinero")
    private Integer dinero;

    public Casino() {
    }

    public Casino(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public synchronized Integer getDinero() {
        return dinero;
    }

    public synchronized void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public synchronized int getDineroGanado(Thread thread) {
        if (thread.getName().contains("NCo")) //Es un hilo de estrategia numero concreto
        {
            if (getDinero() > 360) {
                return 360;
            } else {
                return 0;
            }
        } else if (thread.getName().contains("PI")) //Hilo par impar
        {
            if (getDinero() > 20) {
                return 20;
            } else {
                return 0;
            }
        } else {
            return 360;
        }

    }

    public int getDineroGanado(Thread currentThread, int iiDineroApuesta) {
        //Hilo Maringala
        if (getDinero() > iiDineroApuesta * 36) {
            return iiDineroApuesta * 36;
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casino)) {
            return false;
        }
        Casino other = (Casino) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.modelo.Casino[ codigo=" + codigo + " ]";
    }

}
