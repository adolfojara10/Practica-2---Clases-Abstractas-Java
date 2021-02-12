/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Procurador.findAll", query = "SELECT p FROM Procurador p"),
    @NamedQuery(name = "Procurador.findByNombre", query = "SELECT p FROM Procurador p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Procurador.findByApellido", query = "SELECT p FROM Procurador p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Procurador.findByDireccion", query = "SELECT p FROM Procurador p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Procurador.findByTelefono", query = "SELECT p FROM Procurador p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Procurador.findByFechaNacimiento", query = "SELECT p FROM Procurador p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Procurador.findByCedula", query = "SELECT p FROM Procurador p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Procurador.findById", query = "SELECT p FROM Procurador p WHERE p.id = :id")})
public class Procurador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String apellido;
    private String direccion;
    @Basic(optional = false)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String cedula;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "numero_asunto_fk", referencedColumnName = "numero_expediente")
    @ManyToOne
    private Asunto numeroAsuntoFk;

    public Procurador() {
    }

    public Procurador(Integer id) {
        this.id = id;
    }

    public Procurador(Integer id, String nombre, String apellido, String telefono, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asunto getNumeroAsuntoFk() {
        return numeroAsuntoFk;
    }

    public void setNumeroAsuntoFk(Asunto numeroAsuntoFk) {
        this.numeroAsuntoFk = numeroAsuntoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procurador)) {
            return false;
        }
        Procurador other = (Procurador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Procurador id=" + id + " nombre: " + nombre + " " + apellido + " Asunto: " + numeroAsuntoFk;
    }

}
