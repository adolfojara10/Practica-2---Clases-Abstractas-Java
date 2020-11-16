/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.Objects;

/**
 *
 * @author Adolfo
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String ciudadVivir;

    public Persona(String nombre, String apellido, String cedula, int edad, String ciudadVivir) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.ciudadVivir = ciudadVivir;
    }

    public Persona() {
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudadVivir() {
        return ciudadVivir;
    }

    public void setCiudadVivir(String ciudadVivir) {
        this.ciudadVivir = ciudadVivir;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.cedula);
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
    
    
    /**
     * Metodo que se ejecuta con el ejemplo del GC justo antes de borrar un objeto
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable{
        try {
            System.out.println("Garbage collector llamado");
            System.out.println("Garbage collector elimino: " + this);
        } finally {
            super.finalize();
        }
    }

    @Override
    public String toString() {
        return "Persona:\n" + "Nombre: " + nombre + " apellido: " + apellido + 
                " cedula: " + cedula + " edad: " + edad + " ciudadVivir: " + ciudadVivir;
    }
    
    
    
}
