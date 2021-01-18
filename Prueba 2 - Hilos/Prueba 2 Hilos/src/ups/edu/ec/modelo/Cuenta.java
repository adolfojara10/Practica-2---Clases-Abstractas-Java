/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

/**
 *
 * @author User
 */
public class Cuenta {

    private int saldo;
    private int saldoInicial;

    public Cuenta(int saldo) {
        this.saldoInicial = saldo;
        this.saldo = saldo;
    }

    public synchronized void hacerMovimiento(int cantidad) {
        this.saldo = this.saldo + cantidad;
    }

    public boolean esSimulacionCorrecta() {
        return this.saldo == this.saldoInicial;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + ", saldoInicial=" + saldoInicial + '}';
    }
    
    
    
    
}
