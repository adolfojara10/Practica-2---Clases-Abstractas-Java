/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author User
 */
public class Factura implements Serializable {

    private int codigo;
    private Cliente cliente;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int tiempo;
    private boolean descuento;
    private double subtotal;
    private double total;
    private Sitio sitio;

    public Factura(int codigo, Cliente cliente, Date fechaEntrada, Date fechaSalida,
            int tiempo, boolean descuento, double total, Sitio sitio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.tiempo = tiempo;
        this.descuento = descuento;
        this.total = total;
        this.sitio = sitio;
    }

    public Factura(int codigo, Cliente cliente, Date fechaEntrada, Sitio sitio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.sitio = sitio;
        this.subtotal = 0;
    }

    public Factura() {
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factura other = (Factura) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura: " + "codigo=" + codigo + ", cliente=" + cliente + ", fechaEntrada="
                + fechaEntrada + ", fechaSalida=" + fechaSalida + ", tiempo=" + tiempo
                + ", descuento=" + descuento + ", total=" + total + ", sitio:" + sitio;
    }

}
