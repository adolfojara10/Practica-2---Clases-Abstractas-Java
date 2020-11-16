/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ups.edu.ec.modelo.Persona;

/**
 *
 * @author Adolfo
 */
public class ControladorPersona {
    
    private List<Persona> listadoPersonas;

    public ControladorPersona() {
        listadoPersonas = new ArrayList<>();
    }
    
    public void create(Persona persona){
        listadoPersonas.add(persona);
    }
    
    public Optional<Persona> read(String cedula){
        return listadoPersonas.stream().filter(per->per.getCedula().equals(cedula)).findFirst();
    }
    
    public List<Persona> findAll(){
        return listadoPersonas;
    }
    
    public void var(){
        System.out.println("\nImprimiendo desde el método llamado 'var'\n");
    }
}
