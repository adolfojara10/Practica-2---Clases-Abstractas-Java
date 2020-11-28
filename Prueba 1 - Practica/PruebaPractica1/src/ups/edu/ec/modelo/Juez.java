/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Juez extends Persona implements Serializable {

    private List<Matrimonio> listaMatrimonios;

    private static final long serialVersionUID = 6529685098267757693L;

    public Juez(int id, String nombre, String apellido, String cedula, String genero, Direccion direccion, Date fechaNacimiento) {
        super(id, nombre, apellido, cedula, genero, direccion, fechaNacimiento);
        listaMatrimonios = new ArrayList<>();
    }

    public void añadirMatrimonio(Matrimonio matrimonio) {
        listaMatrimonios.add(matrimonio);
    }

    public void updateMatrimonio(Matrimonio matrimonio) {
        int posicion = listaMatrimonios.indexOf(matrimonio);
        listaMatrimonios.set(posicion, matrimonio);
    }

    @Override
    public String toString() {
        return super.toString() + "Juez:" + "listaMatrimonios=" + listaMatrimonios;
    }

}
