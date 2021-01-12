/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ups.edu.ec.modelo.ConstantesColorTiempo;
import ups.edu.ec.modelo.EnumEstado;
import ups.edu.ec.modelo.Filosofo;

/**
 *
 * @author User
 */
public class Ventana extends JFrame implements InterfacePrincipal, ActionListener {

    private JButton comenzar, parar, pausar, numeroFilosofos;

    private GraficarComedor comedor;

    private Principal principal;

    public Ventana(Principal principal) {
        this.principal = principal;

        this.setTitle("Filosofos");
        this.setMinimumSize(new Dimension(800, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar botones
        this.comenzar = new JButton("Comenzar");
        this.parar = new JButton("Parar");
        this.pausar = new JButton("Pausar");
        this.numeroFilosofos = new JButton("Numero filosofos");

        this.parar.setEnabled(false);
        this.pausar.setEnabled(false);
/*
        this.comenzar.setBackground(Color.BLUE);
        this.parar.setBackground(Color.red);
        this.pausar.setBackground(Color.ORANGE);
    */
        
        this.comenzar.addActionListener(this);
        this.parar.addActionListener(this);
        this.pausar.addActionListener(this);
        this.numeroFilosofos.addActionListener(this);

        JPanel pieDePagina = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        //para poner los colores en el pie de pagina
        for (int i = 0; i < ConstantesColorTiempo.ESTADOS_COLOR.length; i++) {
            this.hacerPieDePagina(pieDePagina, EnumEstado.getEstado(i).toString(), ConstantesColorTiempo.ESTADOS_COLOR[i]);
        }

        pieDePagina.setOpaque(false);

        // botones superiores
        Container containerSuperior = new Container();
        containerSuperior.setLayout(new FlowLayout());
        containerSuperior.add(this.comenzar);
        containerSuperior.add(this.parar);
        containerSuperior.add(this.pausar);
        containerSuperior.add(this.numeroFilosofos);
     
        Container containerInferior = new Container();
        containerInferior.setLayout(new FlowLayout());
        containerInferior.add(pieDePagina);

        this.add(containerSuperior, BorderLayout.NORTH);
        this.add(containerInferior, BorderLayout.SOUTH);

        this.getContentPane().setBackground(ConstantesColorTiempo.COLOR_PANEL2);
        
        this.setExtendedState(Ventana.MAXIMIZED_BOTH);
    }

    @Override
    public void comenzar(int numero) {
        //para borrar el comedor
        if (this.comedor != null) {
            this.comedor.parar();
            this.remove(this.comedor);
        }
        
        //nuevo comedor
        this.comedor = new GraficarComedor(numero);
        this.add(this.comedor);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void saltarseComida(Filosofo filo) {
        // se cambio el estado del filosofo
        this.comedor.getEstados()[filo.getId()] = filo.getEstado();
        
        repaint();
    }

    /**
     * acciones de los botones
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        //boton comenzar
        if (evento.getSource() == this.comenzar) {
            this.comenzar.setEnabled(false);
            this.parar.setEnabled(true);
            this.pausar.setEnabled(true);

            this.comedor.comenzar();
            this.principal.comenzarSimulacion();
        //boton pausar    
        } else if (evento.getSource() == this.pausar) {
            boolean pausado = this.principal.isSimulacionPausar();

            if (pausado) {
                this.principal.reanudarSimulacion();
                this.comedor.reanudar();

                this.pausar.setText("Pausar");
            } else {
                this.principal.pausarSimulacion();
                this.comedor.pausar();

                this.pausar.setText("Reanudar");
            }
            
        //boton numero filosofos
        } else if (evento.getSource() == this.numeroFilosofos) {
            String mensaje = "Escribir el número de filosofos:";
            String numeroJOption = JOptionPane.showInputDialog(this, mensaje);
            int numeroFilosofos;

            try {
                numeroFilosofos = Integer.parseInt(numeroJOption);
            } catch (Exception ex) {
                return;
            }

            //para poner un maximo y minimo de numero de filosofos
            numeroFilosofos = Math.max(Math.min(numeroFilosofos, 30), 3);

            // reiniciar los botones
            this.comenzar.setEnabled(true);
            this.parar.setEnabled(false);
            this.pausar.setEnabled(false);

            // se reinicia el numero de filosofos  
            this.principal.pararSimulacion();
            this.principal.inicializarFilosofos(numeroFilosofos);
            
        //boton parar
        } else if (evento.getSource() == this.parar) {
            this.comenzar.setEnabled(true);
            this.parar.setEnabled(false);
            this.pausar.setEnabled(false);

            this.comedor.parar();
            this.principal.pararSimulacion();
        } 
    }

    
    public void hacerPieDePagina(JPanel panelPieDePagina, String texto, Color color) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(texto + "  ");

        panel.setBackground(color);
        label.setForeground(color);

        panelPieDePagina.add(panel);
        panelPieDePagina.add(label);
    }
}
