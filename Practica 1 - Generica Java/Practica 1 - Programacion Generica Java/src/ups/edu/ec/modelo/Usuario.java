/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Adolfo
 */
public class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private List<Telefono> listaTelefonos;

    public Usuario(String cedula, String nombre, String apellido, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        
        listaTelefonos = new ArrayList<>();
    }

    public Usuario(String cedula, String nombre, String apellido, String correo, String password, List<Telefono> listaTelefonos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.listaTelefonos = listaTelefonos;
    }

    public Usuario(String apellido) {
        this.apellido = apellido;
    }

    public Usuario() {
        
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

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }
    
    public void agregarTelefono(Telefono telefono){
        this.listaTelefonos.add(telefono);
    }
    
    public Telefono buscarTelefono(String numero){
        return this.listaTelefonos.stream().filter(t -> t.getNumero().equals(numero)).findFirst().get();
    }
    
    public void actualizarTelefono(Telefono telefono){
        var telefonoCambiar = listaTelefonos.stream().filter(t -> t.getCodigo() == telefono.getCodigo()).findFirst().get();
        int index = listaTelefonos.indexOf(telefonoCambiar);
        listaTelefonos.remove(telefonoCambiar);
        listaTelefonos.add(index, telefono);
    }
    
    public void eliminarTelefono(int codigo){
        var telefonoEliminar = listaTelefonos.stream().filter(telefono -> telefono.getCodigo() == codigo).findFirst().get();
        listaTelefonos.remove(telefonoEliminar);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.apellido);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return "Usuario\n" + "cedula=" + cedula + ", nombre=" + nombre 
                + ", apellido=" + apellido + ", correo=" + correo + ", password=" 
                + password + ",\nlistaTelefonos=" + listaTelefonos;
    }
    
    
}
