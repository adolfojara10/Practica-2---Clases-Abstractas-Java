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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "hipoteca")
@NamedQueries({
    @NamedQuery(name = "Hipoteca.findAll", query = "SELECT h FROM Hipoteca h"),
    @NamedQuery(name = "Hipoteca.findByCodigo", query = "SELECT h FROM Hipoteca h WHERE h.codigo = :codigo"),
    @NamedQuery(name = "Hipoteca.findByFechaInicio", query = "SELECT h FROM Hipoteca h WHERE h.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Hipoteca.findByFechaFin", query = "SELECT h FROM Hipoteca h WHERE h.fechaFin = :fechaFin"),
    @NamedQuery(name = "Hipoteca.findByPlazoMeses", query = "SELECT h FROM Hipoteca h WHERE h.plazoMeses = :plazoMeses"),
    @NamedQuery(name = "Hipoteca.findByMontoPrestamo", query = "SELECT h FROM Hipoteca h WHERE h.montoPrestamo = :montoPrestamo"),
    @NamedQuery(name = "Hipoteca.findByInteres", query = "SELECT h FROM Hipoteca h WHERE h.interes = :interes"),
    @NamedQuery(name = "Hipoteca.findByCargaFinanciera", query = "SELECT h FROM Hipoteca h WHERE h.cargaFinanciera = :cargaFinanciera"),
    @NamedQuery(name = "Hipoteca.findByPagoTotal", query = "SELECT h FROM Hipoteca h WHERE h.pagoTotal = :pagoTotal"),
    @NamedQuery(name = "Hipoteca.findByTarifaMensual", query = "SELECT h FROM Hipoteca h WHERE h.tarifaMensual = :tarifaMensual"),
    @NamedQuery(name = "Hipoteca.findByGarante", query = "SELECT h FROM Hipoteca h WHERE h.garante = :garante")})
public class Hipoteca implements Serializable {

    @Column(name = "sueldo_necesario")
    private BigDecimal sueldoNecesario;

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
    @Column(name = "plazo_meses")
    private Integer plazoMeses;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_prestamo")
    private BigDecimal montoPrestamo;
    @Column(name = "interes")
    private BigDecimal interes;
    @Column(name = "carga_financiera")
    private BigDecimal cargaFinanciera;
    @Column(name = "pago_total")
    private BigDecimal pagoTotal;
    @Column(name = "tarifa_mensual")
    private BigDecimal tarifaMensual;
    @Column(name = "garante")
    private Boolean garante;
    @JoinColumn(name = "codigo_casa_fk", referencedColumnName = "codigo")
    @ManyToOne
    private Casa codigoCasaFk;
    @JoinColumn(name = "cedula_garante_fk", referencedColumnName = "cedula")
    @ManyToOne
    private Persona cedulaGaranteFk;
    @JoinColumn(name = "cedula_propietario_fk", referencedColumnName = "cedula")
    @ManyToOne
    private Persona cedulaPropietarioFk;

    public Hipoteca() {
    }

    public Hipoteca(Integer codigo) {
        this.codigo = codigo;
    }

    public Hipoteca(BigDecimal sueldoNecesario, Date fechaInicio, Date fechaFin, Integer plazoMeses, BigDecimal montoPrestamo, BigDecimal interes, BigDecimal cargaFinanciera, BigDecimal pagoTotal, BigDecimal tarifaMensual, Boolean garante, Casa codigoCasaFk, Persona cedulaGaranteFk, Persona cedulaPropietarioFk) {
        this.sueldoNecesario = sueldoNecesario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.plazoMeses = plazoMeses;
        this.montoPrestamo = montoPrestamo;
        this.interes = interes;
        this.cargaFinanciera = cargaFinanciera;
        this.pagoTotal = pagoTotal;
        this.tarifaMensual = tarifaMensual;
        this.garante = garante;
        this.codigoCasaFk = codigoCasaFk;
        this.cedulaGaranteFk = cedulaGaranteFk;
        this.cedulaPropietarioFk = cedulaPropietarioFk;
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

    public Integer getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(Integer plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public BigDecimal getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(BigDecimal montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getCargaFinanciera() {
        return cargaFinanciera;
    }

    public void setCargaFinanciera(BigDecimal cargaFinanciera) {
        this.cargaFinanciera = cargaFinanciera;
    }

    public BigDecimal getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(BigDecimal pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public BigDecimal getTarifaMensual() {
        return tarifaMensual;
    }

    public void setTarifaMensual(BigDecimal tarifaMensual) {
        this.tarifaMensual = tarifaMensual;
    }

    public Boolean getGarante() {
        return garante;
    }

    public void setGarante(Boolean garante) {
        this.garante = garante;
    }

    public Casa getCodigoCasaFk() {
        return codigoCasaFk;
    }

    public void setCodigoCasaFk(Casa codigoCasaFk) {
        this.codigoCasaFk = codigoCasaFk;
    }

    public Persona getCedulaGaranteFk() {
        return cedulaGaranteFk;
    }

    public void setCedulaGaranteFk(Persona cedulaGaranteFk) {
        this.cedulaGaranteFk = cedulaGaranteFk;
    }

    public Persona getCedulaPropietarioFk() {
        return cedulaPropietarioFk;
    }

    public void setCedulaPropietarioFk(Persona cedulaPropietarioFk) {
        this.cedulaPropietarioFk = cedulaPropietarioFk;
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
        if (!(object instanceof Hipoteca)) {
            return false;
        }
        Hipoteca other = (Hipoteca) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.modelo.Hipoteca[ codigo=" + codigo + " ]";
    }

    public BigDecimal getSueldoNecesario() {
        return sueldoNecesario;
    }

    public void setSueldoNecesario(BigDecimal sueldoNecesario) {
        this.sueldoNecesario = sueldoNecesario;
    }

}
