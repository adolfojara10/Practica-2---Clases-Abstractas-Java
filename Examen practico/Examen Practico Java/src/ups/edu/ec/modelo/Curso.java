/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author User
 */
public class Curso implements Serializable {

    private int id;
    private String nombreCurso;
    private Docente docente;
    private Set<Alumno> alumnos;
    private Set<Actividad> actividades;
       

    public Curso(int id, String nombreCurso, Docente docente, Set<Alumno> alumnos, Set<Actividad> actividades) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.docente = docente;
        this.alumnos = alumnos;
        this.actividades = actividades;
        
        alumnos = new HashSet<>();
        actividades = new HashSet<>();
    }

    public Curso(int id, String nombreCurso, Docente docente) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.docente = docente;
        
        alumnos = new HashSet<>();
        actividades = new HashSet<>();
    }

    public Curso(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public boolean añadirAlumno(Alumno alumno) {
        return alumnos.add(alumno);
    }

    public void actualizar(Alumno alumnoViejo, Alumno alumnoNuevo) {
        alumnos.remove(alumnoViejo);
        alumnos.add(alumnoNuevo);
    }

    public void delete(Alumno alumnoEliminar) {
        alumnos.remove(alumnoEliminar);
    }

    public boolean añadirActividad(Actividad actividad) {
        return actividades.add(actividad);
    }

    public void delete(Actividad actividad) {
        actividades.remove(actividad);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Curso:" + "id=" + id + ", nombreCurso=" + nombreCurso + ", docente="
                + docente + ", alumnos=" + alumnos + ", actividades=" + actividades;
    }

}
