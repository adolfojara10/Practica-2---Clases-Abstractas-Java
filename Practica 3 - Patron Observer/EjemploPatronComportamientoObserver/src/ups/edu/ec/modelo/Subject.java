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
public interface Subject {

    void añadirSubscriptor(Observer sub);

    void eliminarSubscriptor(Observer sub);

    void notifySubscriptores();
    
}
