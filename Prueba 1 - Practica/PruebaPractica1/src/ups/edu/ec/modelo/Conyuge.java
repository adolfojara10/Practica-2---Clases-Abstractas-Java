/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author User
 */
public class Conyuge extends Persona implements Serializable{
    
    private Matrimonio matrimonio;

    private static final long serialVersionUID = 6529685098267757691L;
    
    public Conyuge(int id, String nombre, String apellido, String cedula, String genero, 
            Direccion direccion, Date fechaNacimiento) {
        super(id, nombre, apellido, cedula, genero, direccion, fechaNacimiento);
    }  

    public Matrimonio getMatrimonio() {
        return matrimonio;
    }

    public void setMatrimonio(Matrimonio matrimonio) {
        this.matrimonio = matrimonio;
    }

    @Override
    public String toString() {
        return super.toString() + "Conyuge:" + "matrimonio=" + matrimonio;
    }

    
    
    
}
