/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorApuesta;
import ups.edu.ec.controlador.ControladorCasino;
import ups.edu.ec.controlador.ControladorCliente;
import ups.edu.ec.vista.VentanaJuego;

/**
 *
 * @author User
 */
public class Hilo implements Runnable {

    private Cliente cliente;

    private Casino casino;

    private int dineroApuesta;

    private int numeroPartida;

    private ControladorCliente controladorCliente;
    private ControladorApuesta controladorApuesta;
    private ControladorCasino controladorCasino;

    int contadorDineroApuesta = 0;

    private List<Apuesta> apuestas;
    private VentanaJuego ventanaJuego;

    public Hilo(Cliente cliente, Casino casino, int numeroPartida, ControladorCliente controladorCliente,
            ControladorApuesta controladorApuesta, ControladorCasino controladorCasino, VentanaJuego ventanaJuego) {
        this.cliente = cliente;
        this.casino = casino;
        this.dineroApuesta = 10;
        this.numeroPartida = numeroPartida;
        this.controladorCliente = controladorCliente;
        this.controladorApuesta = controladorApuesta;
        this.controladorCasino = controladorCasino;
        apuestas = new ArrayList<>();

        this.ventanaJuego = ventanaJuego;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    public int getDineroApuesta() {
        return dineroApuesta;
    }

    public void setDineroApuesta(int dineroApuesta) {
        this.dineroApuesta = dineroApuesta;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }

    public ControladorApuesta getControladorApuesta() {
        return controladorApuesta;
    }

    public void setControladorApuesta(ControladorApuesta controladorApuesta) {
        this.controladorApuesta = controladorApuesta;
    }

    public ControladorCasino getControladorCasino() {
        return controladorCasino;
    }

    public void setControladorCasino(ControladorCasino controladorCasino) {
        this.controladorCasino = controladorCasino;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public synchronized void llenarTblJuego() {
        DefaultTableModel modelo = (DefaultTableModel) ventanaJuego.getTblJuego().getModel();

        //modelo.setRowCount(0);
        for (int i = 0; i < apuestas.size() - 1; i++) {
            Apuesta ap = apuestas.get(i);
            Object[] row = {ap.getCodigoClienteFk().getNombre().concat(ap.getCodigoClienteFk().getApellido()),
                ap.getApostadoPara(), ap.getDineroCliente(), ap.getDineroCasino(), ap.getResultadoRuleta(),
                ap.getTipoApuesta()};
            modelo.addRow(row);
        }

        ventanaJuego.getTblJuego().setModel(modelo);
    }

    @Override
    public void run() {
        if (bTieneDinero()) {

            Apuesta apuesta = new Apuesta();
            switch (cliente.getTipoApuesta()) {

                case ("NUMEROCONCRETO") -> {
                    //Apostamos siempre y cuando el hilo tenga dinero
                    int iNumeroHilo = miApostarNumeroConcreto();
                    //Dependiendo si coinciden los numeros o no, se hace una operacion u otra
                    cliente.setNumeroApostado(String.valueOf(iNumeroHilo));
                    if (Integer.valueOf(cliente.getNumeroRuleta()) == iNumeroHilo) {
                        miNumeroGanado();
                        //System.out.println(Thread.currentThread().getName() + " ha ganado! Ahora tiene " + cliente.getDinero() + " " + casino.getDinero());
                        apuesta.setCantidadApuesta(10);
                        apuesta.setCodigoClienteFk(cliente);
                        apuesta.setGanador("Cliente");
                        apuesta.setResultadoRuleta(cliente.getNumeroRuleta());
                        apuesta.setApostadoPara(String.valueOf(iNumeroHilo));
                        apuesta.setTipoApuesta(cliente.getTipoApuesta());
                        apuesta.setCodigo(getNumeroPartida());
                        apuesta.setDineroCasino(casino.getDinero());
                        apuesta.setDineroCliente(cliente.getDinero());

                        //System.out.println(apuesta);

                    } else {

                        cliente.setNumeroDerrotas(cliente.getNumeroDerrotas() + 1);
                        apuesta.setCantidadApuesta(10);
                        apuesta.setCodigoClienteFk(cliente);
                        apuesta.setGanador("Casino");
                        apuesta.setResultadoRuleta(cliente.getNumeroRuleta());
                        apuesta.setApostadoPara(String.valueOf(iNumeroHilo));
                        apuesta.setTipoApuesta(cliente.getTipoApuesta());
                        apuesta.setCodigo(getNumeroPartida());
                        apuesta.setDineroCasino(casino.getDinero());
                        apuesta.setDineroCliente(cliente.getDinero());
                        //System.out.println(Thread.currentThread().getName() + " ha perdido! Ahora tiene " + cliente.getDinero() + " " + casino.getDinero());
                        //System.out.println(apuesta);

                    }

                    apuesta.setDineroCasino(casino.getDinero());
                    apuesta.setDineroCliente(cliente.getDinero());
                    apuesta.setCodigo(numeroPartida);
                    /*controladorCliente.update(cliente);
                    controladorCasino.update(casino);
                    controladorApuesta.create(apuesta);*/

                }

                case ("PARIMPAR") -> {
                    String valor = (String.valueOf(miApostarParImpar()));
                    cliente.setNumeroApostado(valor);
                    if (Integer.valueOf(cliente.getNumeroRuleta()) % 2 == 0 && valor.equals("true")) {
                        miNumeroGanado();
                        //System.out.println(Thread.currentThread().getName() + " ha ganado! Ahora tiene " + cliente.getDinero() + " " + casino.getDinero());
                        apuesta.setCantidadApuesta(10);
                        apuesta.setCodigoClienteFk(cliente);
                        apuesta.setGanador("Cliente");
                        apuesta.setResultadoRuleta(cliente.getNumeroRuleta());
                        apuesta.setApostadoPara(String.valueOf(valor));
                        apuesta.setTipoApuesta(cliente.getTipoApuesta());
                        apuesta.setCodigo(getNumeroPartida());
                        apuesta.setDineroCasino(casino.getDinero());
                        apuesta.setDineroCliente(cliente.getDinero());
                        //System.out.println(apuesta);

                    } else {
                        //numeroPerdido();
                        cliente.setNumeroDerrotas(cliente.getNumeroDerrotas() + 1);
                        //System.out.println(Thread.currentThread().getName() + " ha perdido! Ahora tiene " + cliente.getDinero() + " " + casino.getDinero());
                        apuesta.setCantidadApuesta(10);
                        apuesta.setCodigoClienteFk(cliente);
                        apuesta.setGanador("Casino");
                        apuesta.setResultadoRuleta(cliente.getNumeroRuleta());
                        apuesta.setApostadoPara(String.valueOf(valor));
                        apuesta.setTipoApuesta(cliente.getTipoApuesta());
                        apuesta.setCodigo(getNumeroPartida());

                        apuesta.setDineroCasino(casino.getDinero());
                        apuesta.setDineroCliente(cliente.getDinero());

                        //System.out.println(apuesta);

                    }
                    apuesta.setDineroCasino(casino.getDinero());
                    apuesta.setDineroCliente(cliente.getDinero());
                    apuesta.setCodigo(numeroPartida);
                    /*controladorCliente.update(cliente);
                    controladorCasino.update(casino);
                    controladorApuesta.create(apuesta);*/
                }

                default -> {
                    int iNumeroHilo2 = miApostarMartinGala();
                    cliente.setNumeroApostado(String.valueOf(iNumeroHilo2));
                    System.out.println(getDineroApuesta());
                    if (Integer.valueOf(cliente.getNumeroRuleta()) == iNumeroHilo2) {
                        miNumeroGanado();
                        //System.out.println(Thread.currentThread().getName() + " ha ganado! Ahora tiene " + cliente.getDinero() + " " + casino.getDinero());
                        apuesta.setCantidadApuesta(this.getDineroApuesta());
                        apuesta.setCodigoClienteFk(cliente);
                        apuesta.setGanador("Cliente");
                        apuesta.setResultadoRuleta(cliente.getNumeroRuleta());
                        apuesta.setApostadoPara(String.valueOf(iNumeroHilo2));
                        apuesta.setTipoApuesta(cliente.getTipoApuesta());
                        apuesta.setCodigo(getNumeroPartida());
                        apuesta.setDineroCasino(casino.getDinero());
                        apuesta.setDineroCliente(cliente.getDinero());
                        //System.out.println(apuesta);

                    } else {
                        mvNumeroPerdidoMartinGala();
                        cliente.setNumeroDerrotas(cliente.getNumeroDerrotas() + 1);
                        //System.out.println(Thread.currentThread().getName() + " ha perdido! Ahora tiene " + cliente.getDinero() + " " + casino.getDinero());
                        apuesta.setCantidadApuesta(this.getDineroApuesta() / 2);
                        apuesta.setCodigoClienteFk(cliente);
                        apuesta.setGanador("Casino");
                        apuesta.setResultadoRuleta(cliente.getNumeroRuleta());
                        apuesta.setApostadoPara(String.valueOf(iNumeroHilo2));
                        apuesta.setTipoApuesta(cliente.getTipoApuesta());
                        apuesta.setCodigo(getNumeroPartida());
                        apuesta.setDineroCasino(casino.getDinero());
                        apuesta.setDineroCliente(cliente.getDinero());
                        //System.out.println(apuesta);

                    }
                    apuesta.setDineroCasino(casino.getDinero());
                    apuesta.setDineroCliente(cliente.getDinero());
                    apuesta.setCodigo(numeroPartida);

                    /*controladorCliente.update(cliente);
                    controladorCasino.update(casino);
                    controladorApuesta.create(apuesta);*/
                }
            }
            anadirApuesta(apuesta);

            try {
                Thread.sleep(500);

                //llenarTblJuego();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public synchronized void anadirApuesta(Apuesta apue) {
        apuestas.add(apue);
    }

    public boolean bTieneDinero() {
        return cliente.getDinero() >= 10;
    }

    public int miApostarNumeroConcreto() {
        //Sacamos un numero al azar
        int iNumero = (int) (Math.random() * 36 + 1);
        //Quitamos el valor de la apuesta al hilo
        mvDisminuirDineroH(10);
        //Le damos el dinero al banco
        casino.setDinero(casino.getDinero() + 10);
        return iNumero;
    }

    private void miNumeroGanado() {
        //Le quitamos el dinero al banco dependiendo del hilo que sea
        //y del dinero que disponga el banco
        int iDineroDisponibleBanco = casino.getDineroGanado(Thread.currentThread());
        //Aumentamos el dinero al hilo
        mvAumentarDineroH(iDineroDisponibleBanco);
        //Le quitamos el dinero al banco
        casino.setDinero(casino.getDinero() - iDineroDisponibleBanco);
        //Aumentamos los beneficios del grupo
        //oBeneficios.setAumentoiEurosGrupo(iDineroDisponibleBanco);
    }

    public void mvAumentarDineroH(int iDinero) {
        int iNuevoDinero = cliente.getDinero() + iDinero;
        cliente.setDinero(iNuevoDinero);
        cliente.setNumeroVictorias(cliente.getNumeroVictorias() + 1);
    }

    public void mvDisminuirDineroH(int iDinero) {
        int iNuevoDinero = cliente.getDinero() - iDinero;
        cliente.setDinero(iNuevoDinero);

    }

    public String miApostarParImpar() {
        try {
            boolean bPar = Random.class.newInstance().nextBoolean();
            //Quitamos el valor de la apuesta al hilo
            mvDisminuirDineroH(10);
            //Le damos el dinero al banco
            casino.setDinero(casino.getDinero() + 10);
            //Devolvemos el valor buleano aleatorio
            if (bPar) {
                return "true";
            } else {
                return "false";
            }

        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "false";
    }

    public int miApostarMartinGala() {
        //Sacamos un numero al azar
        int iNumero = (int) (Math.random() * 36 + 1);
        //Quitamos el valor de la apuesta al hilo
        mvDisminuirDineroH(getDineroApuesta());
        //Le damos el dinero al banco
        casino.setDinero(casino.getDinero() + getDineroApuesta());

        return iNumero;

    }

    private void mvNumeroPerdidoMartinGala() {
        //oBeneficios.setAumentoiEurosGrupo(getiDineroApuesta());
        setDineroApuesta(getDineroApuesta() * 2);
    }

}
