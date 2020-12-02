/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Alumno extends Persona implements Serializable {

    private Curso curso;

    public Alumno(Curso curso, int id, String nombre, String apellido, String cedula, String genero) {
        super(id, nombre, apellido, cedula, genero);
        this.curso = curso;
    }

    public Alumno(String cedula) {
        super(cedula);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno:" + "curso=" + curso + '}';
    }

}
