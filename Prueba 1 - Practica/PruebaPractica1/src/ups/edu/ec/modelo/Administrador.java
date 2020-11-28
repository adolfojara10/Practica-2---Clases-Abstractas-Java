/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.lang.System.Logger;
import java.lang.reflect.Constructor;
import java.util.Date;

/**
 *
 * @author User
 */
public class Administrador extends Persona implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    private String email;
    private String password;
    public static Administrador instance;

    private Administrador(int id, String nombre, String apellido, String cedula, String genero,
            Direccion direccion, Date fechaNacimiento, String email, String password) {
        super(id, nombre, apellido, cedula, genero, direccion, fechaNacimiento);
        this.email = email;
        this.password = password;

    }

    private Administrador() {

    }
    
    public Administrador(String cedula){
        super(cedula);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Administrador getInstance() {
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
            //.instance = new Administrador(1, "", "", "", "", "", "", "", "");

            return Administrador.instance;
        }

        return Administrador.instance;
    }

    public void setInstance(Administrador instance) {
        Administrador.instance = instance;
    }
    
    

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + "Administrador:" + "email=" + email + ", password=" + password;
    }

}
