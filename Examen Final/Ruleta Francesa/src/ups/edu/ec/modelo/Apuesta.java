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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "apuesta")
@NamedQueries({
    @NamedQuery(name = "Apuesta.findAll", query = "SELECT a FROM Apuesta a"),
    @NamedQuery(name = "Apuesta.findById", query = "SELECT a FROM Apuesta a WHERE a.id = :id"),
    @NamedQuery(name = "Apuesta.findByCodigo", query = "SELECT a FROM Apuesta a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Apuesta.findByTipoApuesta", query = "SELECT a FROM Apuesta a WHERE a.tipoApuesta = :tipoApuesta"),
    @NamedQuery(name = "Apuesta.findByApostadoPara", query = "SELECT a FROM Apuesta a WHERE a.apostadoPara = :apostadoPara"),
    @NamedQuery(name = "Apuesta.findByResultadoRuleta", query = "SELECT a FROM Apuesta a WHERE a.resultadoRuleta = :resultadoRuleta"),
    @NamedQuery(name = "Apuesta.findByGanador", query = "SELECT a FROM Apuesta a WHERE a.ganador = :ganador"),
    @NamedQuery(name = "Apuesta.findByCantidadApuesta", query = "SELECT a FROM Apuesta a WHERE a.cantidadApuesta = :cantidadApuesta"),
    @NamedQuery(name = "Apuesta.findByDineroCliente", query = "SELECT a FROM Apuesta a WHERE a.dineroCliente = :dineroCliente"),
    @NamedQuery(name = "Apuesta.findByDineroCasino", query = "SELECT a FROM Apuesta a WHERE a.dineroCasino = :dineroCasino")})
public class Apuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "tipo_apuesta")
    private String tipoApuesta;
    @Column(name = "apostado_para")
    private String apostadoPara;
    @Column(name = "resultado_ruleta")
    private String resultadoRuleta;
    @Column(name = "ganador")
    private String ganador;
    @Column(name = "cantidad_apuesta")
    private Integer cantidadApuesta;
    @Column(name = "dinero_cliente")
    private Integer dineroCliente;
    @Column(name = "dinero_casino")
    private Integer dineroCasino;
    @JoinColumn(name = "codigo_cliente_fk", referencedColumnName = "codigo")
    @ManyToOne
    private Cliente codigoClienteFk;

    public Apuesta() {
    }

    public Apuesta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(String tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public String getApostadoPara() {
        return apostadoPara;
    }

    public void setApostadoPara(String apostadoPara) {
        this.apostadoPara = apostadoPara;
    }

    public String getResultadoRuleta() {
        return resultadoRuleta;
    }

    public void setResultadoRuleta(String resultadoRuleta) {
        this.resultadoRuleta = resultadoRuleta;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public Integer getCantidadApuesta() {
        return cantidadApuesta;
    }

    public void setCantidadApuesta(Integer cantidadApuesta) {
        this.cantidadApuesta = cantidadApuesta;
    }

    public Integer getDineroCliente() {
        return dineroCliente;
    }

    public void setDineroCliente(Integer dineroCliente) {
        this.dineroCliente = dineroCliente;
    }

    public Integer getDineroCasino() {
        return dineroCasino;
    }

    public void setDineroCasino(Integer dineroCasino) {
        this.dineroCasino = dineroCasino;
    }

    public Cliente getCodigoClienteFk() {
        return codigoClienteFk;
    }

    public void setCodigoClienteFk(Cliente codigoClienteFk) {
        this.codigoClienteFk = codigoClienteFk;
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
        if (!(object instanceof Apuesta)) {
            return false;
        }
        Apuesta other = (Apuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Apuesta{" + "id=" + id + ", codigo=" + codigo + ", tipoApuesta=" + tipoApuesta + ", apostadoPara=" + apostadoPara + ", resultadoRuleta=" + resultadoRuleta + ", ganador=" + ganador + ", cantidadApuesta=" + cantidadApuesta + ", dineroCliente=" + dineroCliente + ", dineroCasino=" + dineroCasino + ", codigoClienteFk=" + codigoClienteFk + '}';
    }

    
    
}
