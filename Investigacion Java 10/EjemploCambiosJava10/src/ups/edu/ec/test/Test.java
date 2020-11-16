/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.test;

import java.lang.Runtime.Version;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collector;
import ups.edu.ec.controlador.ControladorPersona;
import ups.edu.ec.modelo.InformacionTiempoMoneda;
import ups.edu.ec.modelo.Persona;

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

        ControladorPersona controlador = new ControladorPersona();

        controlador.create(new Persona("Jose", "Jose", "01", 65, "Cuenca"));
        controlador.create(new Persona("Pepe", "Pepe", "02", 45, "Azogues"));
        controlador.create(new Persona("Andres", "Andres", "03", 25, "Quito"));
        controlador.create(new Persona("Santiago", "Santiago", "04", 32, "Guayaquil"));
        controlador.create(new Persona("Mateo", "Mateo", "05", 15, "Salinas"));

        //se recibe un List<Persona>
        var personas = controlador.findAll();
        System.out.println(personas);

        System.out.println("\n------------Imprimir una lista----------------\n");

        //usamos ahora la palabra var para recorrer un array
        for (var var : personas) {
            System.out.println(var.toString());
        }

        //llamamos al metodo var del controlador
        controlador.var();

        
        
        
        /*
        Para el segundo ejemplo: Version
         */
        
        System.out.println("\n------------------Ejemplo de la versión--------------------");
        Version version = Runtime.version();
        System.out.println("Feature: " + version.feature());
        System.out.println("Interim: " + version.interim());
        System.out.println("Updates: " + version.update());
        System.out.println("Patches: " + version.patch());

        
        
        
        
        /*
        Para el tercer ejemplo: Unicode Language
         */
        System.out.println("\n---------------Informacion de la localizacion-Moneda-Tiempo---------------");

        //escogemos el primer dia de la semana
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);

        //escogemos la region horaria
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));

        InformacionTiempoMoneda informacion = new InformacionTiempoMoneda(Locale.FRANCE, cal);

        System.out.println(informacion.toString());

        
        
        
        
        
        /*
        Para el cuarto ejemplo: GC
         */
        System.out.println("\n-------------Ejemplo Garbage Collection----------------------");
        
        //creo objeto de esta clase
        Persona t1 = new Persona("Lautaro", "Lautaro", "55", 15, "Loja");
        
        //aviso al GC que va a tener que recoger basura
        System.gc();
        
        //pongo un valor nulo
        t1 = null;
        
        //se pide al JVM que ejecute el GC
        Runtime.getRuntime().gc();
        
        
        
        /*
        Para el quinto ejemplo: Copias de colecciones inmodificables
         */
        
        System.out.println("\n-----------Ejemplo copias de colecciones inmodificables-------------");
        var listaPer = controlador.findAll();

        var copiaListaPer = List.copyOf(listaPer);

        System.out.println("Tamaño lista original: " + listaPer.size()
                + " Tamaño lista copia: " + copiaListaPer.size());

        //se intenta añadir una persona
        try {
            copiaListaPer.add(new Persona("Sebastian", "Sebastian", "10", 30, "Puyo"));
        } catch (UnsupportedOperationException e) {
            System.out.println("\nNO HAY COMO AÑADIR OBJETOS A LA LISTA DUPLICADA\n");
        }

        listaPer.add(new Persona("Sebastian", "Sebastian", "10", 30, "Puyo"));

        System.out.println("Tamaño lista original: " + listaPer.size()
                + " Tamaño lista copia: " + copiaListaPer.size());
        
    }
    
    
    

}
