/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 *
 * @author User
 */
public class Rector extends Persona implements Serializable {

    private String correo;
    private String password;
    public static Rector instance;

    private Rector(String correo, String password, Rector instace, int id, String nombre,
            String apellido, String cedula, String genero) {
        super(id, nombre, apellido, cedula, genero);
        this.correo = correo;
        this.password = password;

    }

    private Rector() {

    }

    public static Rector getInstance() {
        if (Rector.instance == null) {
            Constructor<Rector> constructor;
            try {
                constructor = Rector.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                Rector admin = constructor.newInstance();

                Rector.instance = admin;

                return Rector.instance;
            } catch (Exception e) {
                e.printStackTrace();
            }
            //.instance = new Administrador(1, "", "", "", "", "", "", "", "");

            return Rector.instance;
        }

        return Rector.instance;
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
    public String toString() {
        return super.toString() + "Rector: " + "correo=" + correo + ", password=" + password;
    }

}
