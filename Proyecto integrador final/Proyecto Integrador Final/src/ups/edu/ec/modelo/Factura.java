/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByCodigo", query = "SELECT f FROM Factura f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Factura.findByTiempo", query = "SELECT f FROM Factura f WHERE f.tiempo = :tiempo"),
    @NamedQuery(name = "Factura.findByDescuento", query = "SELECT f FROM Factura f WHERE f.descuento = :descuento"),
    @NamedQuery(name = "Factura.findBySubtotal", query = "SELECT f FROM Factura f WHERE f.subtotal = :subtotal"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findByFechaEntrada", query = "SELECT f FROM Factura f WHERE f.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Factura.findByFechaSalida", query = "SELECT f FROM Factura f WHERE f.fechaSalida = :fechaSalida")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "tiempo")
    private Integer tiempo;
    @Column(name = "descuento")
    private Boolean descuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @JoinColumn(name = "cedula_cliente_fk", referencedColumnName = "cedula")
    @ManyToOne
    private Cliente cedulaClienteFk;
    @JoinColumn(name = "numero_sitio_fk", referencedColumnName = "codigo")
    @OneToOne
    private Sitio numeroSitioFk;

    public Factura() {
    }

    public Factura(Integer codigo, Integer tiempo, Boolean descuento, BigDecimal subtotal, BigDecimal total, Date fechaEntrada, Date fechaSalida, Cliente cedulaClienteFk, Sitio numeroSitioFk) {
        this.codigo = codigo;
        this.tiempo = tiempo;
        this.descuento = descuento;
        this.subtotal = subtotal;
        this.total = total;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cedulaClienteFk = cedulaClienteFk;
        this.numeroSitioFk = numeroSitioFk;
    }

    public Factura(Integer codigo, Date fechaEntrada, Cliente cedulaClienteFk, Sitio numeroSitioFk) {
        this.codigo = codigo;
        this.fechaEntrada = fechaEntrada;
        this.cedulaClienteFk = cedulaClienteFk;
        this.numeroSitioFk = numeroSitioFk;
    }
    
    

    public Factura(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Boolean getDescuento() {
        return descuento;
    }

    public void setDescuento(Boolean descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Cliente getCedulaClienteFk() {
        return cedulaClienteFk;
    }

    public void setCedulaClienteFk(Cliente cedulaClienteFk) {
        this.cedulaClienteFk = cedulaClienteFk;
    }

    public Sitio getNumeroSitioFk() {
        return numeroSitioFk;
    }

    public void setNumeroSitioFk(Sitio numeroSitioFk) {
        this.numeroSitioFk = numeroSitioFk;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.modelo.Factura[ codigo=" + codigo + " ]";
    }
    
}
