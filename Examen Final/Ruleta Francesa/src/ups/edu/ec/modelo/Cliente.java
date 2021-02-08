/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodigo", query = "SELECT c FROM Cliente c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByDinero", query = "SELECT c FROM Cliente c WHERE c.dinero = :dinero"),
    @NamedQuery(name = "Cliente.findByNumeroVictorias", query = "SELECT c FROM Cliente c WHERE c.numeroVictorias = :numeroVictorias"),
    @NamedQuery(name = "Cliente.findByNumeroDerrotas", query = "SELECT c FROM Cliente c WHERE c.numeroDerrotas = :numeroDerrotas"),
    @NamedQuery(name = "Cliente.findByTipoApuesta", query = "SELECT c FROM Cliente c WHERE c.tipoApuesta = :tipoApuesta"),
    @NamedQuery(name = "Cliente.findByNumeroRuleta", query = "SELECT c FROM Cliente c WHERE c.numeroRuleta = :numeroRuleta")})
public class Cliente implements Serializable {

    @Column(name = "numero_apostado")
    private String numeroApostado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dinero")
    private Integer dinero;
    @Column(name = "numero_victorias")
    private Integer numeroVictorias;
    @Column(name = "numero_derrotas")
    private Integer numeroDerrotas;
    @Column(name = "tipo_apuesta")
    private String tipoApuesta;
    @Column(name = "numero_ruleta")
    private String numeroRuleta;
    @OneToMany(mappedBy = "codigoClienteFk")
    private Collection<Apuesta> apuestaCollection;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String tipoApuesta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoApuesta = tipoApuesta;
        this.dinero = 1000;
        this.numeroDerrotas = 0;
        this.numeroVictorias = 0;
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dinero = 1000;
        this.numeroDerrotas = 0;
        this.numeroVictorias = 0;
        this.numeroRuleta = "-1";
        this.tipoApuesta = "";
        this.numeroApostado = "-1";
    }

    public Cliente(Integer codigo) {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public Integer getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(Integer numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public Integer getNumeroDerrotas() {
        return numeroDerrotas;
    }

    public void setNumeroDerrotas(Integer numeroDerrotas) {
        this.numeroDerrotas = numeroDerrotas;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(String tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public String getNumeroRuleta() {
        return numeroRuleta;
    }

    public void setNumeroRuleta(String numeroRuleta) {
        this.numeroRuleta = numeroRuleta;
    }

    public Collection<Apuesta> getApuestaCollection() {
        return apuestaCollection;
    }

    public void setApuestaCollection(Collection<Apuesta> apuestaCollection) {
        this.apuestaCollection = apuestaCollection;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numeroApostado=" + numeroApostado + ", codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", dinero=" + dinero + ", numeroVictorias=" + numeroVictorias + ", numeroDerrotas=" + numeroDerrotas + ", tipoApuesta=" + tipoApuesta + ", numeroRuleta=" + numeroRuleta + ", apuestaCollection=" + apuestaCollection + '}';
    }

    

    public String getNumeroApostado() {
        return numeroApostado;
    }

    public void setNumeroApostado(String numeroApostado) {
        this.numeroApostado = numeroApostado;
    }

}
