/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "casa")
@NamedQueries({
    @NamedQuery(name = "Casa.findAll", query = "SELECT c FROM Casa c"),
    @NamedQuery(name = "Casa.findByCodigo", query = "SELECT c FROM Casa c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Casa.findByDireccion", query = "SELECT c FROM Casa c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Casa.findByAvaluo", query = "SELECT c FROM Casa c WHERE c.avaluo = :avaluo"),
    @NamedQuery(name = "Casa.findByMetrosConstruccion", query = "SELECT c FROM Casa c WHERE c.metrosConstruccion = :metrosConstruccion"),
    @NamedQuery(name = "Casa.findByNumeroHabitaciones", query = "SELECT c FROM Casa c WHERE c.numeroHabitaciones = :numeroHabitaciones"),
    @NamedQuery(name = "Casa.findByNumeroPisos", query = "SELECT c FROM Casa c WHERE c.numeroPisos = :numeroPisos"),
    @NamedQuery(name = "Casa.findByEstado", query = "SELECT c FROM Casa c WHERE c.estado = :estado")})
public class Casa implements Serializable {

    @OneToMany(mappedBy = "codigoCasaFk")
    private Collection<Hipoteca> hipotecaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "direccion")
    private String direccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avaluo")
    private BigDecimal avaluo;
    @Column(name = "metros_construccion")
    private BigDecimal metrosConstruccion;
    @Column(name = "numero_habitaciones")
    private Integer numeroHabitaciones;
    @Column(name = "numero_pisos")
    private Integer numeroPisos;
    @Column(name = "estado")
    private String estado;

    public Casa() {
    }

    public Casa(String direccion, BigDecimal avaluo, BigDecimal metrosConstruccion, Integer numeroHabitaciones, Integer numeroPisos, String estado) {
        this.direccion = direccion;
        this.avaluo = avaluo;
        this.metrosConstruccion = metrosConstruccion;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroPisos = numeroPisos;
        this.estado = estado;
    }

    public Casa(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getAvaluo() {
        return avaluo;
    }

    public void setAvaluo(BigDecimal avaluo) {
        this.avaluo = avaluo;
    }

    public BigDecimal getMetrosConstruccion() {
        return metrosConstruccion;
    }

    public void setMetrosConstruccion(BigDecimal metrosConstruccion) {
        this.metrosConstruccion = metrosConstruccion;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Integer getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(Integer numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Casa)) {
            return false;
        }
        Casa other = (Casa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.modelo.Casa[ codigo=" + codigo + " ]";
    }

    public Collection<Hipoteca> getHipotecaCollection() {
        return hipotecaCollection;
    }

    public void setHipotecaCollection(Collection<Hipoteca> hipotecaCollection) {
        this.hipotecaCollection = hipotecaCollection;
    }

}
