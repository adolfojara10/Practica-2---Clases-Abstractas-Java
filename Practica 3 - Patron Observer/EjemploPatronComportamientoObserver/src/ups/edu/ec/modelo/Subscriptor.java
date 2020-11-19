/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

/**
 *
 * @author Adolfo
 */
public class Subscriptor extends Persona {

    private Canal canalSuscripcion;

    public Subscriptor(String nombre, Canal canalSuscripcion) {
        super(nombre);
        this.canalSuscripcion = canalSuscripcion;
    }  
    
    public Canal getCanalSuscripcion() {
        return canalSuscripcion;
    }

    public void setCanalSuscripcion(Canal canalSuscripcion) {
        this.canalSuscripcion = canalSuscripcion;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Subscriptor{" + "nombre=";
    }

    @Override
    public void update() {
        System.out.println(this.getNombre() + " Hay un nuevo video de: " + 
                canalSuscripcion.getNombre() + " :" + canalSuscripcion.getNuevoVideo());
    
    }
    
    
    
    
}
