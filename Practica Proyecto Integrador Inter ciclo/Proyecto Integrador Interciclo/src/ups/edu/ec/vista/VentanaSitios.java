/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import com.toedter.calendar.JMonthChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import ups.edu.ec.controlador.ControladorSitio;
import ups.edu.ec.modelo.EnumEstadoSitio;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class VentanaSitios extends javax.swing.JInternalFrame {

    private ControladorSitio controladorSitio;

    private Sitio sitio;

    /**
     * Creates new form VentanaSitios
     *
     * @param controladorSitio
     */
    public VentanaSitios(ControladorSitio controladorSitio) {
        initComponents();

        this.controladorSitio = controladorSitio;

        sitio = new Sitio();

        limpiar();
    }

    public GridLayout cargarEspaciosPanel(List<Sitio> lista) {
        BigDecimal number = new BigDecimal(lista.size() / 10);

        long iPart = number.longValue();
        BigDecimal fraccion = number.remainder(BigDecimal.ONE);

        GridLayout layout;

        if (lista.size() % 10 != 0) {
            iPart += 1;
            layout = new GridLayout((int) iPart, 10, 5, 5);

        } else {
            layout = new GridLayout((int) iPart, 10, 5, 5);
        }

        return layout;
    }

    public void filtrarSitios(EnumEstadoSitio enumEstadoSitio) {
        var listaSitio = (List<Sitio>) controladorSitio.getListaGenerica();

        //Border border = new BevelBorder(4, Color.BLACK, Color.GRAY);
        panelSitios.removeAll();
        
        GridLayout layout = cargarEspaciosPanel(listaSitio);
        panelSitios.setLayout(layout);
        int codigoSitio = controladorSitio.getListaGenerica().size() - 1;

        

        while (codigoSitio >= 0) {
            sitio = listaSitio.get(codigoSitio);
            JLabel labelSitio = new JLabel();

            JPanel panelito = new JPanel();
            //panelito.setSize(5, 5);
            //panelito.setLayout(new BorderLayout());
            switch (sitio.getEnumEstadoSitio()) {
                case DESOCUPADO -> {
                    panelito.setBackground(Color.GREEN);
                    String texto = "<html><body> . <br> ? <br></body></html>";
                    texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                    texto = texto.replace("?", "Desocupado");
                    labelSitio.setText(texto);
                    break;
                }
                case OCUPADO -> {
                    panelito.setBackground(Color.yellow);
                    String texto = "<html><body> . <br> ? <br></body></html>";
                    texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                    texto = texto.replace("?", "Ocupado");
                    labelSitio.setText(texto);
                    break;
                }

                default -> {
                    panelito.setBackground(Color.RED);
                    String texto = "<html><body> . <br> ? <br></body></html>";
                    texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                    texto = texto.replace("?", "Contratado");
                    labelSitio.setText(texto);
                    break;
                }
            }
            panelito.add(labelSitio);
            if (sitio.getEnumEstadoSitio().equals(enumEstadoSitio)) {
                panelito.setEnabled(true);
            } else {
                panelito.setBackground(Color.DARK_GRAY);
            }
            codigoSitio--;
            panelSitios.add(panelito);
        }
        
        panelSitios.updateUI();
    }

    public void cargarVistaSitios() {
        var listaSitio = (List<Sitio>) controladorSitio.getListaGenerica();

        //Border border = new BevelBorder(4, Color.BLACK, Color.GRAY);
        panelSitios.removeAll();
        GridLayout layout = cargarEspaciosPanel(listaSitio);

        panelSitios.setLayout(layout);
        int codigoSitio = controladorSitio.getListaGenerica().size() - 1;

        while (codigoSitio >= 0) {
            sitio = listaSitio.get(codigoSitio);
            JLabel labelSitio = new JLabel();

            JPanel panelito = new JPanel();
            //panelito.setSize(5, 5);
            //panelito.setLayout(new BorderLayout());
            switch (sitio.getEnumEstadoSitio()) {
                case DESOCUPADO -> {
                    panelito.setBackground(Color.GREEN);
                    String texto = "<html><body> . <br> ? <br></body></html>";
                    texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                    texto = texto.replace("?", "Desocupado");
                    labelSitio.setText(texto);
                    break;
                }
                case OCUPADO -> {
                    panelito.setBackground(Color.yellow);
                    String texto = "<html><body> . <br> ? <br></body></html>";
                    texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                    texto = texto.replace("?", "Ocupado");
                    labelSitio.setText(texto);
                    break;
                }

                default -> {
                    panelito.setBackground(Color.RED);
                    String texto = "<html><body> . <br> ? <br></body></html>";
                    texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                    texto = texto.replace("?", "Contratado");
                    labelSitio.setText(texto);
                    break;
                }
            }
            panelito.add(labelSitio);
            codigoSitio--;
            panelSitios.add(panelito);
        }
        
        panelSitios.updateUI();
        /*
        for (int i = 0; i < layout.getRows(); i++) {
            for (int j = 0; j < layout.getColumns(); j++) {
                sitio = listaSitio.get(codigoSitio);
                JLabel labelSitio = new JLabel();

                JPanel panelito = new JPanel();
                panelito.setSize(5, 5);
                //panelito.setLayout(new BorderLayout());
                switch (sitio.getEnumEstadoSitio()) {
                    case DESOCUPADO -> {
                        panelito.setBackground(Color.GREEN);
                        String texto = "<html><body> . <br> ? <br></body></html>";
                        texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                        texto = texto.replace("?", "Desocupado");
                        labelSitio.setText(texto);
                        break;
                    }
                    case OCUPADO -> {
                        panelito.setBackground(Color.yellow);
                        String texto = "<html><body> . <br> ? <br></body></html>";
                        texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                        texto = texto.replace("?", "Ocupado");
                        labelSitio.setText(texto);
                        break;
                    }

                    default -> {
                        panelito.setBackground(Color.RED);
                        String texto = "<html><body> . <br> ? <br></body></html>";
                        texto = texto.replace(".", String.valueOf(sitio.getCodigo()));
                        texto = texto.replace("?", "Contratado");
                        labelSitio.setText(texto);
                        break;
                    }
                }
                panelito.add(labelSitio);
                codigoSitio--;
                panelSitios.add(panelito);

            }*/

    }

    public void limpiar() {
        txtCodigo.setText("");
        buttonGroupEstadoSitio.clearSelection();
        cargarVistaSitios();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEstadoSitio = new javax.swing.ButtonGroup();
        panelSitios = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        radioBtnDesocupado = new javax.swing.JRadioButton();
        radioBtnOcupado = new javax.swing.JRadioButton();
        radioBtnContratado = new javax.swing.JRadioButton();
        btnCancelarEstadoSitio = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Sitios");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        javax.swing.GroupLayout panelSitiosLayout = new javax.swing.GroupLayout(panelSitios);
        panelSitios.setLayout(panelSitiosLayout);
        panelSitiosLayout.setHorizontalGroup(
            panelSitiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        panelSitiosLayout.setVerticalGroup(
            panelSitiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        jLabel1.setText("Código sitio:");

        btnCrear.setBackground(new java.awt.Color(51, 51, 255));
        btnCrear.setText("Crear Sitio");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(60, 60, 60)
                        .addComponent(btnCancelar)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(69, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setText("Estado sitio");

        buttonGroupEstadoSitio.add(radioBtnDesocupado);
        radioBtnDesocupado.setText("Desocupado");
        radioBtnDesocupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnDesocupadoActionPerformed(evt);
            }
        });

        buttonGroupEstadoSitio.add(radioBtnOcupado);
        radioBtnOcupado.setText("Ocupado");
        radioBtnOcupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnOcupadoActionPerformed(evt);
            }
        });

        buttonGroupEstadoSitio.add(radioBtnContratado);
        radioBtnContratado.setText("Contratado");
        radioBtnContratado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnContratadoActionPerformed(evt);
            }
        });

        btnCancelarEstadoSitio.setText("Cancelar");
        btnCancelarEstadoSitio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEstadoSitioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtnDesocupado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnOcupado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnContratado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btnCancelarEstadoSitio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioBtnDesocupado)
                    .addComponent(radioBtnOcupado)
                    .addComponent(radioBtnContratado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarEstadoSitio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSitios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSitios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        cargarVistaSitios();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        cargarVistaSitios();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        cargarVistaSitios();
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:

        Sitio sitioNuevo = new Sitio(controladorSitio.getListaGenerica().size() + 1, EnumEstadoSitio.DESOCUPADO);

        if (controladorSitio.create(sitioNuevo)) {
            JOptionPane.showMessageDialog(this, "Sitio añadido con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            cargarVistaSitios();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            Sitio sitioEncontrado = new Sitio();
            sitioEncontrado.setCodigo(codigo);
            sitioEncontrado = (Sitio) controladorSitio.read(sitioEncontrado);

            if (sitioEncontrado != null || sitioEncontrado.getEnumEstadoSitio().equals(EnumEstadoSitio.DESOCUPADO)) {
                if (controladorSitio.delete(sitioEncontrado)) {
                    JOptionPane.showMessageDialog(this, "Sitio eliminado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarEstadoSitioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEstadoSitioActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarEstadoSitioActionPerformed

    private void radioBtnDesocupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnDesocupadoActionPerformed
        // TODO add your handling code here:

        filtrarSitios(EnumEstadoSitio.DESOCUPADO);
        
    }//GEN-LAST:event_radioBtnDesocupadoActionPerformed

    private void radioBtnOcupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnOcupadoActionPerformed
        // TODO add your handling code here:

        filtrarSitios(EnumEstadoSitio.OCUPADO);
    }//GEN-LAST:event_radioBtnOcupadoActionPerformed

    private void radioBtnContratadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnContratadoActionPerformed
        // TODO add your handling code here:
        filtrarSitios(EnumEstadoSitio.CONTRATADO);
    }//GEN-LAST:event_radioBtnContratadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarEstadoSitio;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup buttonGroupEstadoSitio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelSitios;
    private javax.swing.JRadioButton radioBtnContratado;
    private javax.swing.JRadioButton radioBtnDesocupado;
    private javax.swing.JRadioButton radioBtnOcupado;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
