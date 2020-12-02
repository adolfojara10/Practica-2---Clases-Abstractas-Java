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
public class Docente extends Persona implements Serializable {

    private Curso curso;
    private String correo;
    private String password;
    public static Docente instance;

    private Docente(int id, String nombre, String apellido, String cedula, String genero,
            String correo, String password) {
        super(id, nombre, apellido, cedula, genero);
        this.correo = correo;
        this.password = password;
    }

    private Docente() {

    }

    public static Docente getInstance() {
        if (Docente.instance == null) {
            Constructor<Docente> constructor;
            try {
                constructor = Docente.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                Docente docente = constructor.newInstance();

                Docente.instance = docente;

                return Docente.instance;
            } catch (Exception e) {
                e.printStackTrace();
            }
            //.instance = new Administrador(1, "", "", "", "", "", "", "", "");

            return Docente.instance;
        }

        return Docente.instance;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        return super.toString() + "Docente: " + "curso=" + curso;
    }

}
