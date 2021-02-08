/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ups.edu.ec.controlador.Controlador;
import ups.edu.ec.controlador.ControladorApuesta;
import ups.edu.ec.controlador.ControladorCasino;
import ups.edu.ec.controlador.ControladorCliente;
import ups.edu.ec.modelo.Casino;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.EnumTipoApuesta;
import ups.edu.ec.modelo.Hilo;

/**
 *
 * @author User
 */
public class NewMain {

    private int iNumeroRuleta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ControladorCliente c = new ControladorCliente();
        ControladorCasino cc = new ControladorCasino();
        ControladorApuesta ca = new ControladorApuesta();

        Casino oBanco = new Casino();
        oBanco.setDinero(50000);
        oBanco.setNombre("asadasd");

        //Instanciamos los vectores de hilos de cada estrategia
        int iHilosPorEstrategia = 4;
        Cliente oNConcreto[] = new Cliente[iHilosPorEstrategia];
        Cliente oMaringala[] = new Cliente[iHilosPorEstrategia];
        Cliente oParImpar[] = new Cliente[iHilosPorEstrategia];

        Hilo oNConcretoH[] = new Hilo[iHilosPorEstrategia];
        Hilo oMaringalaH[] = new Hilo[iHilosPorEstrategia];
        Hilo oParImparH[] = new Hilo[iHilosPorEstrategia];

        NewMain oRuleta = new NewMain();

        int iNumeroRuleta = oRuleta.miSacarNumero();
        //Variables locales
        boolean bSeguir = true;
        int iNumeroPartida = 0;
        // Comienza la partida
       /* for (int i = 0; i < iHilosPorEstrategia; i++) {
            oNConcreto[i] = new Cliente("a", "a", EnumTipoApuesta.NUMEROCONCRETO.toString());
            oNConcretoH[i] = new Hilo(oNConcreto[i], oBanco, iNumeroPartida, c, ca, cc);
            oParImpar[i] = new Cliente("b", "b", EnumTipoApuesta.PARIMPAR.toString());
            oParImparH[i] = new Hilo(oParImpar[i], oBanco, iNumeroPartida, c, ca, cc);
            oMaringala[i] = new Cliente("c", "c", EnumTipoApuesta.MARTINGALA.toString());
            oMaringalaH[i] = new Hilo(oMaringala[i], oBanco, iNumeroPartida, c, ca, cc);
        }//Creacion de los hilos

        while (bSeguir) {
            System.out.println(iNumeroPartida + "------------------------------- Numero Ruleta: " + iNumeroRuleta);
            if (iNumeroRuleta != 0) {
                try {
                    for (int i = 0; i < iHilosPorEstrategia; i++) {
                        //Le pasamos el valor que ha sacado el crupier a los hilos
                        oNConcreto[i].setNumeroRuleta(String.valueOf(iNumeroRuleta));
                        oParImpar[i].setNumeroRuleta(String.valueOf(iNumeroRuleta));
                        oMaringala[i].setNumeroRuleta(String.valueOf(iNumeroRuleta));

                        //hilo3.setDineroApuesta(10);
                        Thread th = new Thread(oNConcretoH[i]);
                        Thread thPI = new Thread(oParImparH[i]);
                        Thread thMa = new Thread(oMaringalaH[i]);

                        th.setName("Hilo " + i + " NCo");
                        thPI.setName("Hilo " + i + " PI");
                        thMa.setName("Hilo " + i + " MA");

                        //Inicializamos los hilos
                        th.start();
                        thPI.start();
                        thMa.start();
                    } // for()
                    iNumeroPartida++;
                    //Llamamos al metodo sleep para que se imprima la cuantia del banco justo despues de que se ejecuten los hilos
                    Thread.sleep(50);
                    System.out.println("BANCO: " + oBanco.getDinero());
                    //Volvemos a utilizar el metodo sleep como se pide en el enunciado
                    Thread.sleep(3000);
                    //Sacamos otro numero pasados esos 3 segundos
                    iNumeroRuleta = oRuleta.miSacarNumero();
                } catch (InterruptedException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                bSeguir = false;
            }
        }*/

    }

    public int miSacarNumero() {
        setiNumeroRuleta((int) (Math.random() * 36));
        return getiNumeroRuleta();
    }//miSacarNumero()

    public int getiNumeroRuleta() {
        return iNumeroRuleta;
    }//Getter iNumeroRuleta

    public void setiNumeroRuleta(int iNumeroRuleta) {
        this.iNumeroRuleta = iNumeroRuleta;
    }//Setter iNumeroRuleta

}
