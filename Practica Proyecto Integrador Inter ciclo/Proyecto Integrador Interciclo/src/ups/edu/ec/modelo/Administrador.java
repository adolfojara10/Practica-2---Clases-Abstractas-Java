/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Calendar;

/**
 *
 * @author User
 */
public class Administrador extends Persona implements Serializable {

    private String correo;
    private String password;
    private EnumTipoAdministrador enumTipoAdministrador;
    public static Administrador instance;

    private Administrador() {

    }

    private Administrador(String correo, String password, int codigo, String codigoIdentificacion,
            String nombre, String apellido, Calendar fechaNacimiento, String numeroTelefono,
            EnumTipoAdministrador enumTipoAdministrador) {
        super(codigo, codigoIdentificacion, nombre, apellido, fechaNacimiento, numeroTelefono);
        this.correo = correo;
        this.password = password;
        this.enumTipoAdministrador = enumTipoAdministrador;
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

    public EnumTipoAdministrador getEnumTipoAdministrador() {
        return enumTipoAdministrador;
    }

    public void setEnumTipoAdministrador(EnumTipoAdministrador enumTipoAdministrador) {
        this.enumTipoAdministrador = enumTipoAdministrador;
    }

    @Override
    public String toString() {
        return super.toString() + "Administrador: " + "correo=" + correo + ", password="
                + password + ", enumTipoAdministrador=" + enumTipoAdministrador;
    }

}
