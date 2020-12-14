/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author User
 */
public class Contrato implements Serializable {

    private int codigo;
    private Cliente cliente;
    private Sitio sitio;
    private Date fechaInicio;
    private Date fechaFin;
    private EnumTipoPrecioContrato enumTipoPrecioContrato;
    private boolean pago;
    private double subtotal;
    private boolean descuento;
    private double total;

    public Contrato(int codigo, Cliente cliente, Sitio sitio, Date fechaInicio,
            Date fechaFin, EnumTipoPrecioContrato enumTipoPrecioContrato, boolean pago, double subtotal,
            boolean descuento, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.sitio = sitio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.enumTipoPrecioContrato = enumTipoPrecioContrato;
        this.pago = pago;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }

    public Contrato(int codigo, Cliente cliente, Sitio sitio, Date fechaInicio,
            Date fechaFin, EnumTipoPrecioContrato enumTipoPrecioContrato) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.sitio = sitio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.enumTipoPrecioContrato = enumTipoPrecioContrato;
    }

    public Contrato() {
    }

    public EnumTipoPrecioContrato getEnumTipoPrecioContrato() {
        return enumTipoPrecioContrato;
    }

    public void setEnumTipoPrecioContrato(EnumTipoPrecioContrato enumTipoPrecioContrato) {
        this.enumTipoPrecioContrato = enumTipoPrecioContrato;
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

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
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

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codigo;
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
        final Contrato other = (Contrato) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contrato:" + "codigo=" + codigo + ", cliente=" + cliente + ", sitio="
                + sitio + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
                + ", pago=" + pago + ", subtotal=" + subtotal;
    }

}
