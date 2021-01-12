/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import ups.edu.ec.modelo.ConstantesColorTiempo;
import ups.edu.ec.modelo.EnumEstado;
import ups.edu.ec.modelo.EstadoTenedor;

/**
 *
 * @author User
 */
public class GraficarComedor extends JPanel implements Runnable {

    private final Ellipse2D.Double formaMesa;
    private Thread hilo;
    private int numeroFilosofos;
    private EnumEstado[] estados;
    private Dimension dimensionComedor;
    //este objeto nos sirve para poner la tabla al medio de la ventana
    private AffineTransform affineTransform;

    public GraficarComedor(int n) {
        formaMesa = new Ellipse2D.Double(-2.5, -2.5, 5, 5);
        this.numeroFilosofos = n;
        this.setBackground(ConstantesColorTiempo.COLOR_PANEL);
        this.estados = new EnumEstado[n];
        dimensionComedor = new Dimension(0, 0);
    }

    public EnumEstado[] getEstados() {
        return this.estados;
    }

    public void disenioFilosofos(int i, Graphics2D grafico2d) {
        // color
        if (this.estados[i] != null) {
            grafico2d.setPaint(ConstantesColorTiempo.ESTADOS_COLOR[this.estados[i].getId()]);
        } else {
            grafico2d.setPaint(getBackground());
        }

        // tamaño
        double size = Math.min(6 / Math.pow(numeroFilosofos, .8), 1.5);
        Ellipse2D.Double formaEliptica = new Ellipse2D.Double(3, -size / 2, size, size);

        // color base
        if (hilo == null || !hilo.isAlive()) {
            grafico2d.setColor(new Color(51, 102, 0));
        }

        // dibujar filosofos
        grafico2d.fill(formaEliptica);
        grafico2d.setPaint(Color.black);

        /*String text = i + " ";
        
        grafico2d.drawString(text, 0, 0);*/
        grafico2d.draw(formaEliptica);
        //para que el grafico vaya de lado
        grafico2d.rotate(2 * Math.PI / numeroFilosofos);

    }

    public EstadoTenedor getEstadoTenedor(int id) {
        if (this.estados[(id - 1 + numeroFilosofos) % numeroFilosofos] == EnumEstado.COME) {
            return EstadoTenedor.USANDO_IZQUIERDA;
        } else if (this.estados[id] == EnumEstado.COME) {
            return EstadoTenedor.USANDO_DERECHA;
        } else {
            return EstadoTenedor.DESOCUPADO;
        }
    }

    public void disenioTenedor(int i, Graphics2D grafico2d) {
        // determinar posicion
        double posicion = (2 * i - 1) * Math.PI / numeroFilosofos;

        EstadoTenedor estado = this.getEstadoTenedor(i);
        float redondoFilo = 0;

        if (estado == EstadoTenedor.USANDO_IZQUIERDA) {
            redondoFilo = -.8f;
        } else if (estado == EstadoTenedor.USANDO_DERECHA) {
            redondoFilo = .8f;
        }

        posicion = posicion + redondoFilo * (Math.PI / (2 * numeroFilosofos));

        //longitud de tenedores
        double longitudTenedor = (2.0 * 3) / numeroFilosofos;

        // grafico tenedores
        grafico2d.setPaint(ConstantesColorTiempo.COLOR_TENEDOR);
        //para que los tenedores vayan de lado
        grafico2d.rotate(posicion);
        //afinar la grafica
        grafico2d.setStroke(new BasicStroke((float) (.3 / Math.pow(numeroFilosofos, .55))));

        if (estado == EstadoTenedor.USANDO_IZQUIERDA || estado == EstadoTenedor.USANDO_DERECHA) {
            //mover los tenedores al lado del filosofo
            grafico2d.draw(new Line2D.Double(3, 0, 3 + longitudTenedor, 0));
        } else {
            //poner tenedores en la mesa
            grafico2d.draw(new Line2D.Double(2.3 - longitudTenedor, 0, 2.3, 0));
        }

        grafico2d.rotate(-posicion);
    }

    public void saltarseComidaGraficoMesa() {
        // formar la dimension de la tabla
        if (!dimensionComedor.equals(this.getSize())) {
            this.dimensionComedor = this.getSize();

            // el tamaño de la tabla
            double escalar = Math.min(dimensionComedor.width, dimensionComedor.height) / 10.0;

            // poner en el medio de la tabla
            this.affineTransform = new AffineTransform();
            this.affineTransform.translate(dimensionComedor.width / 2.0, dimensionComedor.height / 2.0);
            this.affineTransform.scale(escalar, escalar);
        }
    }

    public void comenzar() {
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    public void parar() {
        if (this.hilo != null) {
            this.hilo.interrupt();
        }
    }

    public void pausar() {
        this.hilo.suspend();
    }

    public void reanudar() {
        this.hilo.resume();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(ConstantesColorTiempo.TIEMPO_DORMIR_HILO);
            } catch (InterruptedException e) {
                break;
            }

            repaint();
        }

        for (int i = 0; i < numeroFilosofos; i++) {
            this.estados[i] = null;
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D grafico2d = (Graphics2D) g;
        AffineTransform afinarMesa = grafico2d.getTransform();

        // diseñar formas
        RenderingHints lineasFilo = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        lineasFilo.add(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        grafico2d.setRenderingHints(lineasFilo);

        this.saltarseComidaGraficoMesa();

        // mesa en el medio
        grafico2d.transform(affineTransform);

        // dibujo mesa
        grafico2d.setStroke(new BasicStroke(.15f));
        grafico2d.setPaint(ConstantesColorTiempo.COLOR_MESA);
        grafico2d.fill(this.formaMesa);
        grafico2d.setPaint(ConstantesColorTiempo.COLOR_FILO_MESA);
        grafico2d.draw(this.formaMesa);

        // diseño filosofos
        grafico2d.setStroke(new BasicStroke(.04f));

        for (int i = 0; i < numeroFilosofos; i++) {
            this.disenioFilosofos(i, grafico2d);
        }

        // diseño tenedores
        for (int i = 0; i < numeroFilosofos; i++) {
            this.disenioTenedor(i, grafico2d);
        }

        grafico2d.setTransform(afinarMesa);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

}
