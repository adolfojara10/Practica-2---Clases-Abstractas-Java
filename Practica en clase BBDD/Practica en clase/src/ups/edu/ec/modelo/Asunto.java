/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Asunto.findAll", query = "SELECT a FROM Asunto a"),
    @NamedQuery(name = "Asunto.findByNumeroExpediente", query = "SELECT a FROM Asunto a WHERE a.numeroExpediente = :numeroExpediente"),
    @NamedQuery(name = "Asunto.findByFechaInicio", query = "SELECT a FROM Asunto a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Asunto.findByFechaFin", query = "SELECT a FROM Asunto a WHERE a.fechaFin = :fechaFin"),
    @NamedQuery(name = "Asunto.findByEstado", query = "SELECT a FROM Asunto a WHERE a.estado = :estado")})
public class Asunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero_expediente")
    private Integer numeroExpediente;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    private String estado;
    @JoinColumn(name = "cedula_cliente_fk", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Cliente cedulaClienteFk;
    @OneToMany(mappedBy = "numeroAsuntoFk")
    private Collection<Procurador> procuradorCollection;

    public Asunto() {
    }

    public Asunto(Integer numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public Asunto(Integer numeroExpediente, Date fechaInicio, Date fechaFin, String estado) {
        this.numeroExpediente = numeroExpediente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(Integer numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCedulaClienteFk() {
        return cedulaClienteFk;
    }

    public void setCedulaClienteFk(Cliente cedulaClienteFk) {
        this.cedulaClienteFk = cedulaClienteFk;
    }

    public Collection<Procurador> getProcuradorCollection() {
        return procuradorCollection;
    }

    public void setProcuradorCollection(Collection<Procurador> procuradorCollection) {
        this.procuradorCollection = procuradorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroExpediente != null ? numeroExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asunto)) {
            return false;
        }
        Asunto other = (Asunto) object;
        if ((this.numeroExpediente == null && other.numeroExpediente != null) || (this.numeroExpediente != null && !this.numeroExpediente.equals(other.numeroExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " numeroExpediente=" + numeroExpediente + " cliente: " + cedulaClienteFk;
    }
    
}
