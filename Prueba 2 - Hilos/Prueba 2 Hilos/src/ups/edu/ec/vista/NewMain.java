/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import ups.edu.ec.modelo.Cuenta;

/**
 *
 * @author User
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//application will be closed when you close frame
        frame.setSize(1300, 600);
        frame.setLayout(new GridLayout(1, 2, 4, 5));

        //JPanel panelMayor = new JPanel(new GridLayout(1, 2, 5, 10));
        JPanel panelPersonas = new JPanel();

        JLabel[] labels = new JLabel[13];
        ImageIcon imagenPersona = new ImageIcon("contornoPersona.jpg");
        for (int i = 0; i < 10; i++) {
            JLabel l2 = new JLabel(imagenPersona, JLabel.CENTER);
            panelPersonas.add(l2);
            labels[i] = l2;
        }

        boolean[] cajeros = new boolean[3];
        int[] posicionXCajeros = new int[3];
        //JPanel panelCajeros = new JPanel(new GridLayout(1, 3, 5, 10));
        ImageIcon imagenCajero = new ImageIcon("cajero.jpg");
        for (int i = 0; i < 3; i++) {
            JLabel l2 = new JLabel(imagenCajero, JLabel.CENTER);
            panelPersonas.add(l2);
            posicionXCajeros[i] = l2.getLocation().x;

            labels[i + 10] = l2;
            cajeros[i] = false;
        }

        /*int contador = 0;
        JLabel[] labelsSalidos = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            JLabel l2 = new JLabel(imagenPersona, JLabel.CENTER);
            l2.setLocation(600 + contador, 55);
            labelsSalidos[i] = l2;
            contador += 50;
            panelPersonas.add(l2);
        }*/
        //panelMayor.add(panelPersonas);
        //panelMayor.add(panelCajeros);
        frame.add(panelPersonas);
        /*
        JList<String> jList = new JList<>();
        frame.add(jList);*/
        JTextField txtInfo = new JTextField("Informacion");
        frame.add(txtInfo);

        frame.getContentPane().validate();
        frame.repaint();

        frame.setVisible(true);

        //System.out.println(labels[9].getText());
        Imagen im1 = new Imagen(9, labels[9], cajeros, posicionXCajeros);
        Imagen i2 = new Imagen(8, labels[8], cajeros, posicionXCajeros);
        Imagen i3 = new Imagen(7, labels[7], cajeros, posicionXCajeros);

        Imagen[] imagenes = new Imagen[3];
        imagenes[0] = im1;
        imagenes[1] = i2;
        imagenes[2] = i3;

        /*        im1.setFrame(frame);
        i2.setFrame(frame);
        i3.setFrame(frame);*/

 /* Thread t = new Thread(i1);
        Thread t2 = new Thread(i2);
        Thread t3 = new Thread(i3);
        t.start();

        t2.start();

        t3.start();*/
        /**
         * intento de unir con la clase test
         *
         */
        final int NUM_OPS_CON_100 = 40;
        final int NUM_OPS_CON_50 = 20;
        final int NUM_OPS_CON_20 = 60;

        Thread[] hilosIngresan100 = new Thread[NUM_OPS_CON_100];
        Thread[] hilosRetiran100 = new Thread[NUM_OPS_CON_100];
        Thread[] hilosIngresan50 = new Thread[NUM_OPS_CON_50];
        Thread[] hilosRetiran50 = new Thread[NUM_OPS_CON_50];
        Thread[] hilosIngresan20 = new Thread[NUM_OPS_CON_20];
        Thread[] hilosIngresan20SegundaVez = new Thread[20];

        Cliente[] listadoClientes = new Cliente[100];
        int contadorClientes = 0;
        int numeroOperaciones100 = 0;
        int numeroOperaciones50 = 0;
        int numeroOperaciones20 = 0;
        int numeroOperaciones20SegundaVez = 0;
        int numeroRepetirAccion = 60;
        int numeroEscoger = 1;

        //creaacion 100 clientes
        for (int i = 0; i < 100; i++) {
            Cliente cl = new Cliente(i, new Cuenta(100), 0);
            //cl.setFrame(frame);
            listadoClientes[i] = cl;

        }

        int numeroImagenPersona = 2;

        String[] informacionTransacciones = new String[120];

        int contadorBorrarPersonaFila = 0;

        for (int i = 0; i < 120; i++) {

            if (i == NUM_OPS_CON_100) {
                numeroEscoger++;
            } else if (i == (NUM_OPS_CON_100 + NUM_OPS_CON_50)) {
                numeroEscoger++;
            }
            /* if (numeroEscoger >3) {
                numeroEscoger = 1;
            }*/

            if (numeroImagenPersona == -1) {
                numeroImagenPersona = 2;
            }

            if (numeroEscoger == 1) {
                //numeroEscoger++;
                Cliente ingresa = listadoClientes[contadorClientes];
                ingresa.setImagen(imagenes[numeroImagenPersona]);

                ingresa.setCantidadTransferencia(100);
                hilosIngresan100[numeroOperaciones100] = new Thread(ingresa);
                hilosIngresan100[numeroOperaciones100].start();

                hilosIngresan100[numeroOperaciones100].join(4000);

                numeroImagenPersona--;

                numeroOperaciones100++;

                informacionTransacciones[i] = ingresa.toString();

                //DefaultListModel listModel = (DefaultListModel) jList.getModel();
                //jList.setListData(informacionTransacciones);
                txtInfo.setText("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));
                System.out.println("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));
                //hilosIngresan100[numeroOperaciones100].join(7500);
                //frame.add(ingresa.mostrarInformacion(txtInfo));

                frame.add(txtInfo);

            } else if (numeroEscoger == 2) {
                //numeroEscoger++;
                Cliente ingresa = listadoClientes[contadorClientes];
                ingresa.setImagen(imagenes[numeroImagenPersona]);
                numeroImagenPersona--;
                ingresa.setCantidadTransferencia(50);
                hilosIngresan50[numeroOperaciones50] = new Thread(ingresa);
                hilosIngresan50[numeroOperaciones50].start();
                hilosIngresan50[numeroOperaciones50].join(4000);
                numeroOperaciones50++;

                txtInfo.setText("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));

                frame.add(txtInfo);

                System.out.println("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));

            } else if (numeroEscoger == 3) {
                //numeroEscoger++;

                if (i < 100) {
                    //System.out.println(i + "     " + contadorClientes);

                    Cliente ingresa = listadoClientes[contadorClientes];
                    ingresa.setImagen(imagenes[numeroImagenPersona]);
                    numeroImagenPersona--;
                    ingresa.setCantidadTransferencia(20);
                    hilosIngresan20[numeroOperaciones20] = new Thread(ingresa);
                    hilosIngresan20[numeroOperaciones20].start();
                    hilosIngresan20[numeroOperaciones20].join(4000);
                    numeroOperaciones20++;

                    txtInfo.setText("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));

                    frame.add(txtInfo);

                    System.out.println("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));

                } else {
                    Cliente ingresa = listadoClientes[numeroRepetirAccion];
                    ingresa.setImagen(imagenes[numeroImagenPersona]);
                    numeroImagenPersona--;
                    numeroRepetirAccion++;
                    ingresa.setCantidadTransferencia(20);
                    hilosIngresan20SegundaVez[numeroOperaciones20SegundaVez] = new Thread(ingresa);
                    hilosIngresan20SegundaVez[numeroOperaciones20SegundaVez].start();
                    hilosIngresan20SegundaVez[numeroOperaciones20SegundaVez].join(4000);
                    numeroOperaciones20SegundaVez++;

                    txtInfo.setText("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));

                    frame.add(txtInfo);

                    System.out.println("Cliente id: " + ingresa.getId() + " saldo: " + (ingresa.getCuenta().getSaldo()));

                }
            }
/*
            if (contadorBorrarPersonaFila < 7) {
                JLabel l = labels[i]; 
                l.setText("");
                labels[i] = l;
                frame.repaint();
            }
            */
            contadorClientes++;
            System.out.println("i: " + i + " " + numeroEscoger);

        }

        numeroEscoger = 1;
        contadorClientes = 0;
        numeroOperaciones100 = 0;
        numeroOperaciones50 = 0;
        numeroOperaciones20 = 0;
        numeroOperaciones20SegundaVez = 0;
        numeroRepetirAccion = 60;
        numeroImagenPersona = 2;

        for (int i = 0; i < 120; i++) {

            if (i == NUM_OPS_CON_100) {
                numeroEscoger++;
            } else if (i == (NUM_OPS_CON_100 + NUM_OPS_CON_50)) {
                numeroEscoger++;
            }

            if (numeroImagenPersona == -1) {
                numeroImagenPersona = 2;
            }

            if (numeroEscoger == 1 && i < NUM_OPS_CON_100) {

                Cliente retira = listadoClientes[contadorClientes];
                retira.setImagen(imagenes[numeroImagenPersona]);
                numeroImagenPersona--;
                retira.setCantidadTransferencia(-100);
                hilosRetiran100[numeroOperaciones100] = new Thread(retira);
                hilosRetiran100[numeroOperaciones100].start();
                hilosRetiran100[numeroOperaciones100].join(4000);

                numeroOperaciones100++;

                txtInfo.setText("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

                frame.add(txtInfo);

                System.out.println("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

            } else if (numeroEscoger == 2) {
                Cliente retira = listadoClientes[contadorClientes];
                retira.setImagen(imagenes[numeroImagenPersona]);
                numeroImagenPersona--;
                retira.setCantidadTransferencia(-50);
                hilosRetiran50[numeroOperaciones50] = new Thread(retira);
                hilosRetiran50[numeroOperaciones50].start();
                hilosRetiran50[numeroOperaciones50].join(4000);

                numeroOperaciones50++;

                txtInfo.setText("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

                frame.add(txtInfo);

                System.out.println("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

            } else if (numeroEscoger == 3) {
                if (i < 100) {
                    Cliente retira = listadoClientes[contadorClientes];
                    retira.setImagen(imagenes[numeroImagenPersona]);
                    numeroImagenPersona--;
                    retira.setCantidadTransferencia(-20);
                    hilosIngresan20[numeroOperaciones20] = new Thread(retira);
                    hilosIngresan20[numeroOperaciones20].start();
                    hilosIngresan20[numeroOperaciones20].join(4000);
                    numeroOperaciones20++;

                    txtInfo.setText("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

                    frame.add(txtInfo);

                    System.out.println("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

                } else {
                    Cliente retira = listadoClientes[numeroRepetirAccion];
                    retira.setImagen(imagenes[numeroImagenPersona]);
                    numeroImagenPersona--;
                    numeroRepetirAccion++;
                    retira.setCantidadTransferencia(-20);
                    hilosIngresan20SegundaVez[numeroOperaciones20SegundaVez] = new Thread(retira);
                    hilosIngresan20SegundaVez[numeroOperaciones20SegundaVez].start();
                    hilosIngresan20SegundaVez[numeroOperaciones20SegundaVez].join(4000);
                    numeroOperaciones20SegundaVez++;

                    txtInfo.setText("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

                    frame.add(txtInfo);

                    System.out.println("Cliente id: " + retira.getId() + " saldo: " + (retira.getCuenta().getSaldo()));

                }
            }

            contadorClientes++;
        }

        frame.setVisible(false);
        frame.dispose();

        JFrame frameCuentas = new JFrame("Cuentas");
        frameCuentas.setSize(800, 600);
        frameCuentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//application will be closed when you close frame

        String[] saldoCuentas = new String[100];
        int posicion = 0;
        for (Cliente cl : listadoClientes) {
            String texto = "Cliente id: " + cl.getId() + " saldo: " + cl.getCuenta().getSaldo();
            saldoCuentas[posicion] = texto;
            posicion++;
        }

        JList<String> listCuentas = new JList<>(saldoCuentas);
        JScrollPane scrollPane = new JScrollPane(listCuentas);
        /*scrollPane.setViewportView(listCuentas);
        listCuentas.setLayoutOrientation(JList.VERTICAL);*/

 /* JPanel panelSaldoCuentas = new JPanel();
        panelSaldoCuentas.add(listCuentas);
        panelSaldoCuentas.add(scrollPane);       
        frameCuentas.add(panelSaldoCuentas);*/
        //frameCuentas.add(scrollPane);
        Container contentPane = frameCuentas.getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        frameCuentas.getContentPane().validate();
        frameCuentas.repaint();
        frameCuentas.setVisible(true);

    }

}

class Imagen implements Runnable {

    int id;
    JLabel label;
    boolean[] cajeros = new boolean[3];
    int[] posicionXCajeros = new int[3];
    Cuenta cuenta;
    //private JFrame frame;

    public Imagen(int id, JLabel label, boolean[] cajeros, int[] posicionXCajeros) {
        this.id = id;
        this.label = label;
        this.cajeros = cajeros;
        this.posicionXCajeros = posicionXCajeros;

    }

    /*
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }*/
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public synchronized void run() {

        irAlCajero();

        //this.run();
        /*int ubicacionXCajero = 0;
        int numeroCajero = 0;
        Random random = new Random();
        boolean ocupados = false;
        int ubicacionX = label.getLocation().x;
        int ubicacionY = label.getLocation().y;

        try {

            for (int i = 0; i < 3; i++) {
                if (!cajeros[i]) {
                    numeroCajero = i;
                    ocupados = false;
                    cajeros[i] = true;
                    break;
                } else {
                    ocupados = true;
                }
            }

            if (ocupados) {
                this.wait();
            }

            for (int i = 0; i < 2; i++) {
                label.setLocation(label.getLocation().x, label.getLocation().y + 60);
                //label.setLocation((label.getLocationOnScreen().x+10), label.getLocationOnScreen().y);
                Thread.sleep(100);
                //System.out.println("5555");
            }

            int tiempoLlegarCajero = (int) (Math.random() * (3 - 1 + 1) + 1);
            //System.out.println(tiempoLlegarCajero);

            //int movimiento = posicionXCajeros[numeroCajero] / tiempoLlegarCajero;
            //System.out.println(movimiento);
            switch (id) {
                case 9 -> {
                    switch (numeroCajero) {
                        case 0 -> {
                            int movimiento = 55 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento, label.getLocation().y);
                                //System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                        case 1 -> {
                            int movimiento2 = 130 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento2, label.getLocation().y);
                                //System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                        case 2 -> {
                            int movimiento3 = 204 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento3, label.getLocation().y);
                                //System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                    }
                }
                case 8 -> {
                    switch (numeroCajero) {
                        case 0 -> {
                            int movimiento = 95 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                        case 1 -> {
                            int movimiento2 = 170 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento2, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                        case 2 -> {
                            int movimiento3 = 244 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento3, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                    }
                }
                default -> {
                    switch (numeroCajero) {
                        case 0 -> {
                            int movimiento = 115 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                        case 1 -> {
                            int movimiento2 = 190 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento2, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                        case 2 -> {
                            int movimiento3 = 264 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento3, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(500);
                            }
                        }

                    }
                }
            }

            for (int i = 0; i < 7; i++) {
                label.setLocation(label.getLocation().x, label.getLocation().y - 10);
                //label.setLocation((label.getLocationOnScreen().x+10), label.getLocationOnScreen().y);
                Thread.sleep(100);

            }

            this.ocuparCajero(new Thread(this), numeroCajero);

            this.dejarCajero(new Thread(this));

            int tiempoLlegarCajero2 = (int) (Math.random() * (50 - 30 + 1) + 30);
            Thread.sleep(tiempoLlegarCajero2);
            label.setLocation(ubicacionX, ubicacionY);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public synchronized void irAlCajero() {

        int ubicacionXCajero = 0;
        int numeroCajero = 0;
        Random random = new Random();
        boolean ocupados = false;
        int ubicacionX = label.getLocation().x;
        int ubicacionY = label.getLocation().y;

        try {

            for (int i = 0; i < 3; i++) {
                if (!cajeros[i]) {
                    numeroCajero = i;
                    ocupados = false;
                    cajeros[i] = true;
                    break;
                } else {
                    ocupados = true;
                }
            }

            if (ocupados) {
                this.wait();
            }

            for (int i = 0; i < 5; i++) {
                label.setLocation(label.getLocation().x, label.getLocation().y + 22);
                //label.setLocation((label.getLocationOnScreen().x+10), label.getLocationOnScreen().y);
                Thread.sleep(10);
                //System.out.println("5555");
            }

            int tiempoLlegarCajero = (int) (Math.random() * (9 - 7 + 1) + 7);
            //System.out.println(tiempoLlegarCajero);

            /*int movimiento = posicionXCajeros[numeroCajero] / tiempoLlegarCajero;
            System.out.println(movimiento);*/
            switch (this.id) {
                case 9 -> {
                    switch (numeroCajero) {
                        case 0 -> {
                            int movimiento = 55 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento, label.getLocation().y);
                                //System.out.println(i);
                                Thread.sleep(308);
                            }
                        }

                        case 1 -> {
                            int movimiento2 = 130 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento2, label.getLocation().y);
                                //System.out.println(i);
                                Thread.sleep(300);
                            }
                        }

                        case 2 -> {
                            int movimiento3 = 204 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento3, label.getLocation().y);
                                //System.out.println(i);
                                Thread.sleep(290);
                            }
                        }

                    }
                }
                case 8 -> {
                    switch (numeroCajero) {
                        case 0 -> {
                            int movimiento = 95 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(310);
                            }
                        }

                        case 1 -> {
                            int movimiento2 = 170 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento2, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(300);
                            }
                        }

                        case 2 -> {
                            int movimiento3 = 244 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento3, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(290);
                            }
                        }

                    }
                }
                default -> {
                    switch (numeroCajero) {
                        case 0 -> {
                            int movimiento = 115 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(310);
                            }
                        }

                        case 1 -> {
                            int movimiento2 = 190 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento2, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(300);
                            }
                        }

                        case 2 -> {
                            int movimiento3 = 264 / tiempoLlegarCajero;
                            for (int i = 0; i < tiempoLlegarCajero; i++) {
                                label.setLocation(label.getLocation().x + movimiento3, label.getLocation().y);
                                System.out.println(i);
                                Thread.sleep(290);
                            }
                        }

                    }
                }
            }

            /**
             * para que suba al cajero
             */
            for (int i = 0; i < 7; i++) {
                label.setLocation(label.getLocation().x, label.getLocation().y - 10);
                //label.setLocation((label.getLocationOnScreen().x+10), label.getLocationOnScreen().y);
                Thread.sleep(100);

            }

            this.ocuparCajero(new Thread(this), numeroCajero);

            this.dejarCajero(new Thread(this));

            notifyAll();

            /* int tiempoLlegarCajero2 = (int) (Math.random() * (50 - 30 + 1) + 30);
            Thread.sleep(tiempoLlegarCajero2);*/
            label.setLocation(ubicacionX, ubicacionY);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ocuparCajero(Thread hilo, int numeroCajero) {

        int tiempoCajero = (int) (Math.random() * (20 - 15 + 1) + 15);
        try {

            Thread.sleep(tiempoCajero * 100);
            cajeros[numeroCajero] = false;
            /*
            int numeroCompo = frame.getComponentCount();
            
            JTextField txtInfo = (JTextField) frame.getComponent(numeroCompo);
            
            txtInfo.setText(t);*/

        } catch (InterruptedException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println((int) (Math.random() * (20 - 15 + 1) + 15));

        /*
        try {

            int tiempoCajero = (int) (Math.random() * (20 - 15 + 1) + 15);

            Thread.sleep(tiempoCajero * 1000);

            cajeros[numeroCajero] = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public synchronized void dejarCajero(Thread hilo) {

        for (int i = 0; i < 13; i++) {
            notifyAll();
            label.setLocation(label.getLocation().x, label.getLocation().y + 30);
            try {
                //label.setLocation((label.getLocationOnScreen().x+10), label.getLocationOnScreen().y);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /*
    public void moverPersonas(JLabel[] labelsFila){
        
        for (int i=0;i<)
    }*/
}

class Cliente implements Runnable {

    Imagen imagen;
    private int id;
    private Cuenta cuenta;
    private int cantidadTransferencia;
    private JTextField texto;
    //private JFrame frame;

    public Cliente(Cuenta cuenta, int cantidadTransferencia) {
        this.cuenta = cuenta;
        this.cantidadTransferencia = cantidadTransferencia;
    }

    public Cliente(int id, Cuenta cuenta, int cantidadTransferencia) {
        this.id = id;
        this.cuenta = cuenta;
        this.cantidadTransferencia = cantidadTransferencia;
    }

    public Cliente(Imagen imagen, int id, Cuenta cuenta, int cantidadTransferencia) {
        this.imagen = imagen;
        this.id = id;
        this.cuenta = cuenta;
        this.cantidadTransferencia = cantidadTransferencia;
        texto = new JTextField("Informacion");
    }

    /*
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
     */
    public JTextField getTexto() {
        return texto;
    }

    public void setTexto(JTextField texto) {
        this.texto = texto;
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

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Cliente: " + "id: " + id + " cuenta: " + cuenta;
    }

    @Override
    public void run() {

        Thread hilo = new Thread(imagen);

        hilo.start();
        try {
            cuenta.hacerMovimiento(cantidadTransferencia);
            hilo.join();

            /*
            int numeroCompo = frame.getComponentCount();

            JTextField txtInfo = (JTextField) frame.getComponent(numeroCompo);

            txtInfo.setText("Cliente id: " + this.id + " saldo: " + this.cuenta.getSaldo());

            frame.add(txtInfo);
            frame.repaint();
            frame.getContentPane().validate();*/
            hilo.interrupt();
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JTextField mostrarInformacion(JTextField textoInfo) {
        textoInfo.setText("Cliente id: " + this.id + " saldo: " + this.cuenta.getSaldo());

        return textoInfo;
    }
}
