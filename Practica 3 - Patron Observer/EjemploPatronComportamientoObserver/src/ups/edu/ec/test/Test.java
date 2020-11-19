/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.test;

import ups.edu.ec.controlador.Controlador;
import ups.edu.ec.modelo.Canal;
import ups.edu.ec.modelo.Subscriptor;

/**
 *
 * @author Adolfo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //controladores
        Controlador controSubs = new Controlador();
        Controlador controCanal = new Controlador();

        //canal
        Canal c1 = new Canal("Codigos");

        controCanal.create(c1);

        //subscriptores
        Subscriptor s1 = new Subscriptor("Lionel", c1);
        Subscriptor s2 = new Subscriptor("Andres", c1);
        Subscriptor s3 = new Subscriptor("Mateo", c1);
        Subscriptor s4 = new Subscriptor("Pizarro", c1);
        Subscriptor s5 = new Subscriptor("Claudio", c1);

        controSubs.create(s1);
        controSubs.create(s2);
        controSubs.create(s3);
        controSubs.create(s4);
        controSubs.create(s5);

        c1.añadirSubscriptor(s1);
        c1.añadirSubscriptor(s2);
        c1.añadirSubscriptor(s3);
        c1.añadirSubscriptor(s4);
        c1.añadirSubscriptor(s5);

        controCanal.update(c1, c1);
        

        c1.setNuevoVideo("Primer video");

        controCanal.update(c1, c1);

        System.out.println("\n--------------------------\n");

        c1.eliminarSubscriptor(s1);
        c1.eliminarSubscriptor(s2);
        
        s1.setCanalSuscripcion(null);
        s2.setCanalSuscripcion(null);
        
        c1.setNuevoVideo("Segundo video");

        controCanal.update(c1, c1);

        //System.out.println(c1.toString());
        System.out.println(c1.toString());

    }

}
