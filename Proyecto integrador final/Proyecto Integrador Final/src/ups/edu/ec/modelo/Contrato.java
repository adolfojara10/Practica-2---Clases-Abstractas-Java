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
@Table(name = "contrato")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByCodigo", query = "SELECT c FROM Contrato c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contrato.findByFechaFin", query = "SELECT c FROM Contrato c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "Contrato.findByPrecio", query = "SELECT c FROM Contrato c WHERE c.precio = :precio"),
    @NamedQuery(name = "Contrato.findByPagado", query = "SELECT c FROM Contrato c WHERE c.pagado = :pagado"),
    @NamedQuery(name = "Contrato.findBySubtotal", query = "SELECT c FROM Contrato c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "Contrato.findByTotal", query = "SELECT c FROM Contrato c WHERE c.total = :total"),
    @NamedQuery(name = "Contrato.findByDescuento", query = "SELECT c FROM Contrato c WHERE c.descuento = :descuento")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "precio")
    private String precio;
    @Column(name = "pagado")
    private String pagado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "descuento")
    private String descuento;
    @JoinColumn(name = "cedula_cliente_fk", referencedColumnName = "cedula")
    @OneToOne
    private Cliente cedulaClienteFk;
    @JoinColumn(name = "numero_sitio_fk", referencedColumnName = "codigo")
    @OneToOne
    private Sitio numeroSitioFk;

    public Contrato() {
    }

    public Contrato(Integer codigo, Date fechaInicio, Date fechaFin, String precio, String pagado, BigDecimal subtotal, BigDecimal total, String descuento, Cliente cedulaClienteFk, Sitio numeroSitioFk) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.pagado = pagado;
        this.subtotal = subtotal;
        this.total = total;
        this.descuento = descuento;
        this.cedulaClienteFk = cedulaClienteFk;
        this.numeroSitioFk = numeroSitioFk;
    }

    public Contrato(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
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

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
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
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.modelo.Contrato[ codigo=" + codigo + " ]";
    }

}
