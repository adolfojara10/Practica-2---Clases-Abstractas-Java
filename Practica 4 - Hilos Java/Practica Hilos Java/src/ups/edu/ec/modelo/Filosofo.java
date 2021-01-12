/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.concurrent.Semaphore;
import ups.edu.ec.controlador.Controlador;

/**
 *
 * @author User
 */
public class Filosofo extends Semaphore implements Runnable {

    private Controlador controlador;
    private Thread hilo;
    private EnumEstado estado;
    private int id;

    public Filosofo(Controlador controlador, int id) {
        super(1, true);

        this.controlador = controlador;
        this.estado = EnumEstado.PIENSA;
        this.id = id;

        this.hilo = new Thread(this);
    }

    public int getId() {
        return this.id;
    }

    public EnumEstado getEstado() {
        return this.estado;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public Thread getHilo() {
        return hilo;
    }

    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Filosofo other = (Filosofo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void comenzar() {
        this.hilo.start();
    }

    public void parar() {
        this.hilo.stop();
    }

    public void pausar() {
        this.hilo.suspend();
    }

    public void reanudar() {
        this.hilo.resume();
    }

    private void saltarseComida() {
        this.controlador.getPrincipal().saltarseComidaInterfaz(this);
    }

    public void pensar() throws InterruptedException {
        if (this.estado != EnumEstado.PIENSA) {
            return;
        }

        this.saltarseComida();
        Thread.sleep(ConstantesColorTiempo.DEMORA_PENSANDO_MIN + Controlador.RANDOMICO.nextInt(ConstantesColorTiempo.DEMORA_PENSANDO_MAX - ConstantesColorTiempo.DEMORA_PENSANDO_MIN));
    }

    public void comer() throws InterruptedException {
        if (this.estado != EnumEstado.COME) {
            return;
        }

        this.saltarseComida();
        Thread.sleep(ConstantesColorTiempo.DEMORA_COMIENDO_MIN + Controlador.RANDOMICO.nextInt(ConstantesColorTiempo.DEMORA_COMIENDO_MAX - ConstantesColorTiempo.DEMORA_COMIENDO_MIN));
    }

    public void preguntarPuedeComer() {
        Filosofo[] vecinos = this.controlador.getVecinos(this);

        if (this.estado == EnumEstado.HAMBRIENTO && vecinos[0].estado != EnumEstado.COME && vecinos[1].estado != EnumEstado.COME) {
            this.estado = EnumEstado.COME;

            this.controlador.setTenedor(this.id, false);
            this.controlador.setTenedor((this.id + 1) % this.controlador.getNumeroFilosofos(), false);

            this.saltarseComida();

            this.release();
        }
    }

    public void tomarTenedores() throws InterruptedException {
        synchronized (this) {
            this.estado = EnumEstado.HAMBRIENTO;
            this.saltarseComida();

            this.preguntarPuedeComer();
        }

        this.acquire();
    }

    public synchronized void dejarTenedores() {
        this.estado = EnumEstado.PIENSA;

        this.controlador.setTenedor(this.id, true);
        this.controlador.setTenedor((this.id + 1) % this.controlador.getNumeroFilosofos(), true);

        this.saltarseComida();

        for (Filosofo filoVecino : this.controlador.getVecinos(this)) {
            filoVecino.preguntarPuedeComer();
        }
    }

    @Override
    public void run() {
        while (!this.controlador.isIsPausar()) {
            try {

                this.pensar();
                this.tomarTenedores();
                this.comer();
                this.dejarTenedores();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Filosofo{" + "controlador=" + controlador + ", hilo=" + hilo
                + ", estado=" + estado + ", id=" + id + '}';
    }

}
