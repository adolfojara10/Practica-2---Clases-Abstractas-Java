/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Cliente implements Runnable {

    private int id;
    private Cuenta cuenta;
    private int cantidadTransferencia;

    public Cliente(Cuenta cuenta, int cantidadTransferencia) {
        this.cuenta = cuenta;
        this.cantidadTransferencia = cantidadTransferencia;
    }

    public Cliente(int id, Cuenta cuenta, int cantidadTransferencia) {
        this.id = id;
        this.cuenta = cuenta;
        this.cantidadTransferencia = cantidadTransferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getCantidadTransferencia() {
        return cantidadTransferencia;
    }

    public void setCantidadTransferencia(int cantidadTransferencia) {
        this.cantidadTransferencia = cantidadTransferencia;
    }

    @Override
    public String toString() {
        return "Cliente: " + "id: " + id + " cuenta: " + cuenta;
    }

    @Override
    public void run() {

        cuenta.hacerMovimiento(cantidadTransferencia);
        System.out.println("holaaa");

    }
    
    
    
/*
    JLabel label;

    public Cliente(int id, Cuenta cuenta, int cantidadTransferencia, JLabel label) {
        this.id = id;
        this.cuenta = cuenta;
        this.cantidadTransferencia = cantidadTransferencia;
        this.label = label;
    }

    public void caminarAlCajero(int numeroCajero) {

    }

    public void moverFila(JLabel[] labels) {

        for (int i = 0; i < labels.length; i++) {
            
        }
    }

    public void hacerTransferencia() {

    }

    public void dejarCajero(JLabel label, int numeroCajero) {

    }

    public void colocarSiguientePersona() {

    }
*/
}
