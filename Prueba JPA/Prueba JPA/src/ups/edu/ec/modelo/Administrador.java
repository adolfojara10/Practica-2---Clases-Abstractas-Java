/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.lang.reflect.Constructor;
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
@Table(name = "administrador")
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByCodigo", query = "SELECT a FROM Administrador a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Administrador.findByCedula", query = "SELECT a FROM Administrador a WHERE a.cedula = :cedula"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByApellido", query = "SELECT a FROM Administrador a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Administrador.findByNumeroTelefono", query = "SELECT a FROM Administrador a WHERE a.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo"),
    @NamedQuery(name = "Administrador.findByPassword", query = "SELECT a FROM Administrador a WHERE a.password = :password")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "password")
    private String password;

    public static Administrador instance;

    public Administrador() {
    }

    public Administrador(String cedula) {
        this.cedula = cedula;
    }

    public Administrador(String cedula, int codigo) {
        this.cedula = cedula;
        this.codigo = codigo;
    }

    public Administrador(String cedula, String nombre, String apellido, String numeroTelefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
    }

    public Administrador getInstance() {
        if (Administrador.instance == null) {
            Constructor<Administrador> constructor;
            try {
                constructor = Administrador.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                Administrador admin = constructor.newInstance();

                Administrador.instance = admin;

                return Administrador.instance;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return Administrador.instance;
        }

        return Administrador.instance;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.modelo.Administrador[ cedula=" + cedula + " ]";
    }

}
