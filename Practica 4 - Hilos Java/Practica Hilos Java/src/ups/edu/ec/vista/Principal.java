/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import ups.edu.ec.controlador.Controlador;
import ups.edu.ec.modelo.Filosofo;

/**
 *
 * @author User
 */
public class Principal {

    private InterfacePrincipal interfaz;
    private Controlador controlador;

    private Principal() {
        this.interfaz = new Ventana(this);
        this.controlador = new Controlador(this);
    }

    public void comenzarSimulacion() {
        this.controlador.comenzarSimulacion();
    }

    public void pararSimulacion() {
        this.controlador.pararSimulacion();
    }

    public boolean isSimulacionPausar() {
        return this.controlador.isIsPausar();
    }

    public void pausarSimulacion() {
        this.controlador.pausarSimulacion();
    }

    public void reanudarSimulacion() {
        this.controlador.reanudarSimulacion();
    }

    public void saltarseComidaInterfaz(Filosofo filosofo) {
        this.interfaz.saltarseComida(filosofo);
    }

    public void inicializarFilosofos(int numeroFilosofos) {
        this.controlador.inicializador(numeroFilosofos);
        this.interfaz.comenzar(numeroFilosofos);
    }

    public static void main(String[] args) {
        int numeroFilosofos;

        try {
            numeroFilosofos = Integer.parseInt(args[0]);
        } catch (Exception e) {
            numeroFilosofos = 5;
        }

        new Principal().inicializarFilosofos(numeroFilosofos);
    }
}
