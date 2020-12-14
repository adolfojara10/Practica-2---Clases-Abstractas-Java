/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Persona implements Serializable {

    private int codigo;
    private String cedula;
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;
    private String numeroTelefono;

    public Persona() {

    }

    public Persona(int codigo, String cedula, String nombre, String apellido,
            Calendar fechaNacimiento, String numeroTelefono) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
    }

    public Persona(String cedula) {
        this.cedula = cedula;
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

    public void setCedula(String codigoIdentificacion) {
        this.cedula = codigoIdentificacion;
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

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.cedula);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", codigoIdentificacion=" + cedula
                + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", numeroTelefono=" + numeroTelefono + '}';
    }

}
