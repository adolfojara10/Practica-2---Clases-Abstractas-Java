/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Random;
import ups.edu.ec.modelo.Filosofo;
import ups.edu.ec.vista.Principal;

/**
 *
 * @author User
 */
public class Controlador {

    public final static Random RANDOMICO = new Random();
    private Principal principal;
    private boolean isComenzar;
    private boolean isPausar;
    private boolean[] tenedores;
    private Filosofo[] filosofos;
    private int numeroFilosofos;

    public Controlador(Principal principal) {
        this.principal = principal;
        tenedores = null;
        filosofos = null;
    }

    public Principal getPrincipal() {
        return this.principal;
    }

    public int getNumeroFilosofos() {
        return this.numeroFilosofos;
    }

    public boolean getTenedores(int numeroTenedores) {
        return this.tenedores[numeroTenedores];
    }

    public Filosofo[] getVecinos(Filosofo filo) {
        int izquierda = (filo.getId() - 1) % this.getNumeroFilosofos();
        int derecha = (filo.getId() + 1) % this.getNumeroFilosofos();

        if (izquierda < 0) {
            izquierda += this.getNumeroFilosofos();
        }

        return new Filosofo[]{
            this.filosofos[izquierda],
            this.filosofos[derecha]
        };
    }

    public void setTenedor(int numeroTenedore, boolean valor) {
        this.tenedores[numeroTenedore] = valor;
    }

    public void inicializador(int numeroFilosofos) {
        this.numeroFilosofos = numeroFilosofos;
    }

    public void comenzarSimulacion() {
        if (this.isComenzar) {
            this.pararSimulacion();
        }

        // inicializamos los arrays
        this.tenedores = new boolean[numeroFilosofos];
        this.filosofos = new Filosofo[numeroFilosofos];

        // inicializamos los tenedores
        for (int i = 0; i < numeroFilosofos; i++) {
            this.tenedores[i] = true;
        }

        // creamos los filosofos
        Filosofo filosofo;
        for (int i = 0; i < numeroFilosofos; i++) {
            filosofo = new Filosofo(this, i);
            filosofo.comenzar();

            this.filosofos[i] = filosofo;
        }

        this.isComenzar = true;
    }

    public void pararSimulacion() {
        if (this.isComenzar) {

            for (int i = 0; i < numeroFilosofos; i++) {
                this.filosofos[i].parar();
            }

            this.isComenzar = false;
            this.isPausar = false;
        }
    }

    public boolean isIsPausar() {
        return this.isPausar;
    }

    public void pausarSimulacion() {
        this.isPausar = true;

        for (Filosofo filosofo : this.filosofos) {
            filosofo.pausar();
        }
    }

    public void reanudarSimulacion() {
        this.isPausar = false;

        for (Filosofo filo : this.filosofos) {
            filo.reanudar();
        }
    }
}
