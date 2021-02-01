/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorCasa;
import ups.edu.ec.controlador.ControladorHipoteca;
import ups.edu.ec.controlador.ControladorPersona;
import ups.edu.ec.modelo.Casa;
import ups.edu.ec.modelo.EnumEstadoCasa;
import ups.edu.ec.modelo.EnumPersonaTipo;
import ups.edu.ec.modelo.Hipoteca;
import ups.edu.ec.modelo.Persona;

/**
 *
 * @author User
 */
public class VentanaCrearHipoteca extends javax.swing.JInternalFrame {

    private ControladorHipoteca controladorHipoteca;
    private ControladorPersona controladorPersona;
    private ControladorCasa controladorCasa;

    private VentanaMostrarPagos ventanaMostrarPagos;

    private boolean necesidadGarante;
    private boolean botonesActualizar;

    private Hipoteca hipotecaActualizar;

    /**
     * Creates new form VentanaCrearHipoteca
     *
     * @param controladorHipoteca
     * @param controladorPersona
     * @param controladorCasa
     * @param ventanaMostrarPagos
     */
    public VentanaCrearHipoteca(ControladorHipoteca controladorHipoteca, ControladorPersona controladorPersona,
            ControladorCasa controladorCasa, VentanaMostrarPagos ventanaMostrarPagos) {
        initComponents();

        this.controladorHipoteca = controladorHipoteca;
        this.controladorPersona = controladorPersona;
        this.controladorCasa = controladorCasa;

        this.ventanaMostrarPagos = ventanaMostrarPagos;

        necesidadGarante = false;
        botonesActualizar = false;

        limpiar();

    }

    public void bloquearTxts() {
        txtCodigoCasa.setEnabled(false);
        jDateFechaInicio.setEnabled(false);

    }

    public void botonesInicio() {
        btnCalcular.setEnabled(true);
        btnMensualidadTabla.setEnabled(false);
        btnCrear.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);

    }

    public void botonesCrear() {
        btnCalcular.setEnabled(true);
        btnMensualidadTabla.setEnabled(true);
        btnCrear.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);

    }

    public void botonesActualizar() {
        btnCalcular.setEnabled(true);
        btnMensualidadTabla.setEnabled(true);
        btnCrear.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);

    }

    public void cargarCodigo() {
        txtCodigo.setText(String.valueOf(controladorHipoteca.getCodigo() + 1));
    }

    public void limpiar() {
        botonesInicio();
        cargarCodigo();
        txtCargaFinaciera.setText("");
        txtCedulaGarante.setText("");
        txtCedulaGarante.setEditable(false);
        txtCedulaHipotecario.setText("");
        txtCodigoCasa.setText("");
        txtInteres.setText("");
        txtPlazo.setText("");
        txtPrestamo.setText("");
        txtTarifaMensual.setText("");
        txtTotal.setText("");
        jDateFechaInicio.setDate(new Date());
        jDateFechaFin.setDate(new Date());
        txtCodigoCasa.setEnabled(true);
        jDateFechaInicio.setEnabled(true);
        txtSueldoNecesario.setText("");

        necesidadGarante = false;
        botonesActualizar = false;
        llenarTblHipotecas();

    }

    public void llenarTblHipotecas() {

        var listaHipotecas = controladorHipoteca.findAll();

        DefaultTableModel modelo = (DefaultTableModel) tblHipotecas.getModel();
        modelo.setRowCount(0);

        for (Hipoteca hipo : listaHipotecas) {

            String nombrePropietario = hipo.getCedulaPropietarioFk().getNombre().concat(hipo.getCedulaPropietarioFk().getApellido());
            String nombreGarante = "";
            if (hipo.getCedulaGaranteFk() != null) {
                nombreGarante = hipo.getCedulaGaranteFk().getNombre().concat(hipo.getCedulaGaranteFk().getApellido());
            } else {
                nombreGarante = "Null";
            }

            Object[] row = {hipo.getCodigo(), hipo.getInteres(), hipo.getMontoPrestamo(),
                hipo.getPlazoMeses(), hipo.getFechaInicio().toString(), hipo.getFechaFin(),
                hipo.getCargaFinanciera(), hipo.getPagoTotal(), hipo.getTarifaMensual(),
                hipo.getCodigoCasaFk().getCodigo(), nombrePropietario, nombreGarante

            };

            modelo.addRow(row);
        }

        tblHipotecas.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrestamo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCargaFinaciera = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtTarifaMensual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigoCasa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCedulaHipotecario = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCedulaGarante = new javax.swing.JFormattedTextField();
        btnCalcular = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtSueldoNecesario = new javax.swing.JTextField();
        btnMensualidadTabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHipotecas = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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

        jLabel1.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setText("Interes:");

        jLabel3.setText("Prestamo:");

        jLabel4.setText("Plazo:");

        jLabel5.setText("Carga financiera:");

        txtCargaFinaciera.setEditable(false);
        txtCargaFinaciera.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(102, 102, 102));

        txtTarifaMensual.setEditable(false);
        txtTarifaMensual.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setText("Tarifa mensual:");

        jLabel8.setText("Fecha inicio:");

        jDateFechaFin.setEnabled(false);

        jLabel9.setText("Fecha fin");

        jLabel10.setText("Código casa:");

        jLabel11.setText("Cédula hipotecario:");

        try {
            txtCedulaHipotecario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Cédula garante:");

        txtCedulaGarante.setEditable(false);
        try {
            txtCedulaGarante.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCalcular.setBackground(new java.awt.Color(102, 255, 153));
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel13.setText("Sueldo necesario:");

        txtSueldoNecesario.setEditable(false);
        txtSueldoNecesario.setBackground(new java.awt.Color(102, 102, 102));

        btnMensualidadTabla.setBackground(new java.awt.Color(255, 204, 102));
        btnMensualidadTabla.setText("Mensualidad Tabla");
        btnMensualidadTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensualidadTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnCalcular)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMensualidadTabla)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedulaGarante, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo)
                                    .addComponent(txtInteres)
                                    .addComponent(txtPrestamo)
                                    .addComponent(txtPlazo)
                                    .addComponent(txtCargaFinaciera)
                                    .addComponent(txtTotal)
                                    .addComponent(txtTarifaMensual)
                                    .addComponent(jDateFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(jDateFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigoCasa)
                                    .addComponent(txtCedulaHipotecario))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSueldoNecesario))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCargaFinaciera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarifaMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSueldoNecesario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCodigoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCedulaHipotecario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCedulaGarante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(btnMensualidadTabla))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHipotecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Interes", "Prestamo", "Plazo", "Fecha inicio", "Fecha fin", "Carga financiera", "Total", "Tarifa mensual", "Casa", "Hipotecario", "Garante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHipotecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHipotecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHipotecas);

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnCrear)
                        .addGap(39, 39, 39)
                        .addComponent(btnActualizar)
                        .addGap(40, 40, 40)
                        .addComponent(btnEliminar)
                        .addGap(45, 45, 45)
                        .addComponent(btnCancelar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        limpiar();

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:

        BigDecimal interes = BigDecimal.valueOf(Double.valueOf(txtInteres.getText()));
        BigDecimal prestamo = BigDecimal.valueOf(Double.valueOf(txtPrestamo.getText()));
        int plazo = Integer.valueOf(txtPlazo.getText());
        Date fechaInicio = jDateFechaInicio.getDate();

        if (interes == null || prestamo == null || plazo == 0 || fechaInicio == null) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            BigDecimal carga = controladorHipoteca.calcularCargaFinaciera(prestamo, interes, plazo);
            txtCargaFinaciera.setText(carga.toString());

            Date fechaFin = controladorHipoteca.calcularFechaFin(fechaInicio, plazo);
            jDateFechaFin.setDate(fechaFin);

            BigDecimal total = controladorHipoteca.calcularTotal(prestamo, carga);
            txtTotal.setText(total.toString());

            BigDecimal mensualidad = controladorHipoteca.calcularMensualidad(total, plazo);
            txtTarifaMensual.setText(mensualidad.toString());

            BigDecimal sueldoNecesario = controladorHipoteca.calcularSueldoNecesario(mensualidad, plazo);
            txtSueldoNecesario.setText(sueldoNecesario.toString());

            var casa = controladorCasa.read(Integer.valueOf(txtCodigoCasa.getText()));

            if (!txtCedulaHipotecario.getText().equals("0        - ")) {

                var persona = controladorPersona.findByCedula(txtCedulaHipotecario.getText());

                if (persona != null && persona.getTipo().equalsIgnoreCase(EnumPersonaTipo.PROPIETARIO.toString())) {
                    if (sueldoNecesario.doubleValue() > persona.getSueldo().doubleValue() || total.doubleValue() > casa.getAvaluo().doubleValue()) {
                        txtCedulaGarante.setEditable(true);
                        necesidadGarante = true;
                    } else {
                        txtCedulaGarante.setEditable(false);
                        necesidadGarante = false;
                    }
                }

            }

            if (botonesActualizar) {
                botonesActualizar();
            } else {
                botonesCrear();
            }
        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnMensualidadTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensualidadTablaActionPerformed
        // TODO add your handling code here:

        ventanaMostrarPagos.setPlazos(Integer.valueOf(txtPlazo.getText()));
        ventanaMostrarPagos.setFechaInicio(jDateFechaInicio.getDate());
        ventanaMostrarPagos.setTotal(BigDecimal.valueOf(Double.valueOf(txtTotal.getText())));
        ventanaMostrarPagos.setMensualidad(BigDecimal.valueOf(Double.valueOf(txtTarifaMensual.getText())));
        ventanaMostrarPagos.setVisible(true);

    }//GEN-LAST:event_btnMensualidadTablaActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:

        BigDecimal interes = BigDecimal.valueOf(Double.valueOf(txtInteres.getText()));
        if (interes == null || interes.doubleValue() < 8.99 || interes.doubleValue() > 16.99) {
            JOptionPane.showMessageDialog(this, "Error en los intereses", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            BigDecimal prestamo = BigDecimal.valueOf(Double.valueOf(txtPrestamo.getText()));
            int plazo = Integer.valueOf(txtPlazo.getText());
            Date fechaInicio = jDateFechaInicio.getDate();
            Date fechaFin = jDateFechaFin.getDate();
            BigDecimal carga = BigDecimal.valueOf(Double.valueOf(txtCargaFinaciera.getText()));
            BigDecimal total = BigDecimal.valueOf(Double.valueOf(txtTotal.getText()));
            BigDecimal mensualidad = BigDecimal.valueOf(Double.valueOf(txtTarifaMensual.getText()));
            BigDecimal sueldoNecesario = BigDecimal.valueOf(Double.valueOf(txtSueldoNecesario.getText()));
            int codigoCasa = Integer.valueOf(txtCodigoCasa.getText());
            String cedulaPropietario = txtCedulaHipotecario.getText();

            Casa casa = controladorCasa.read(codigoCasa);
            Persona persona = controladorPersona.findByCedula(cedulaPropietario);
            if (casa == null || !(casa.getEstado().equalsIgnoreCase(EnumEstadoCasa.ENVENTA.toString()))
                    || persona == null || persona.getTipo().equalsIgnoreCase(EnumPersonaTipo.GARANTE.toString())) {
                JOptionPane.showMessageDialog(this, "Error casa o hipotecario", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                if (necesidadGarante) {
                    String cedulaGarante = txtCedulaGarante.getText();
                    Persona p = controladorPersona.findByCedula(cedulaGarante);
                    if (p == null || p.getTipo().equalsIgnoreCase(EnumPersonaTipo.PROPIETARIO.toString())) {
                        JOptionPane.showMessageDialog(this, "Persona no existente o es propietario", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Hipoteca hipoteca = new Hipoteca(sueldoNecesario, fechaInicio, fechaFin, plazo,
                                prestamo, interes, carga, total, mensualidad, necesidadGarante, casa, p, persona);

                        if (controladorHipoteca.create(hipoteca)) {
                            JOptionPane.showMessageDialog(this, "Hipoteca creada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            casa.setEstado(EnumEstadoCasa.VENDIDA.toString());
                            controladorCasa.update(casa);
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    Hipoteca hipoteca = new Hipoteca(sueldoNecesario, fechaInicio, fechaFin, plazo,
                            prestamo, interes, carga, total, mensualidad, necesidadGarante, casa, null, persona);

                    if (controladorHipoteca.create(hipoteca)) {
                        JOptionPane.showMessageDialog(this, "Hipoteca creada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        casa.setEstado(EnumEstadoCasa.VENDIDA.toString());
                        controladorCasa.update(casa);
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        BigDecimal interes = BigDecimal.valueOf(Double.valueOf(txtInteres.getText()));
        if (interes == null || interes.doubleValue() < 8.99 || interes.doubleValue() > 16.99) {
            JOptionPane.showMessageDialog(this, "Error en los intereses", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            BigDecimal prestamo = BigDecimal.valueOf(Double.valueOf(txtPrestamo.getText()));
            int plazo = Integer.valueOf(txtPlazo.getText());
            Date fechaInicio = jDateFechaInicio.getDate();
            Date fechaFin = jDateFechaFin.getDate();
            BigDecimal carga = BigDecimal.valueOf(Double.valueOf(txtCargaFinaciera.getText()));
            BigDecimal total = BigDecimal.valueOf(Double.valueOf(txtTotal.getText()));
            BigDecimal mensualidad = BigDecimal.valueOf(Double.valueOf(txtTarifaMensual.getText()));
            BigDecimal sueldoNecesario = BigDecimal.valueOf(Double.valueOf(txtSueldoNecesario.getText()));
            int codigoCasa = Integer.valueOf(txtCodigoCasa.getText());
            String cedulaPropietario = txtCedulaHipotecario.getText();

            var casa = hipotecaActualizar.getCodigoCasaFk();
            var persona = hipotecaActualizar.getCedulaPropietarioFk();
            if (necesidadGarante) {
                String cedulaGarante = txtCedulaGarante.getText();
                Persona p = controladorPersona.findByCedula(cedulaGarante);
                if (p == null || p.getTipo().equalsIgnoreCase(EnumPersonaTipo.PROPIETARIO.toString())) {
                    JOptionPane.showMessageDialog(this, "Persona no existente o es propietario", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    /*Hipoteca hipoteca = new Hipoteca(sueldoNecesario, fechaInicio, fechaFin, plazo,
                            prestamo, interes, carga, total, mensualidad, necesidadGarante, casa, p, persona);*/
                    hipotecaActualizar.setInteres(interes);
                    hipotecaActualizar.setMontoPrestamo(prestamo);
                    hipotecaActualizar.setPlazoMeses(plazo);
                    hipotecaActualizar.setFechaInicio(fechaInicio);
                    hipotecaActualizar.setFechaFin(fechaFin);
                    hipotecaActualizar.setCargaFinanciera(carga);
                    hipotecaActualizar.setPagoTotal(total);
                    hipotecaActualizar.setTarifaMensual(mensualidad);
                    hipotecaActualizar.setSueldoNecesario(sueldoNecesario);
                    hipotecaActualizar.setCodigoCasaFk(casa);
                    hipotecaActualizar.setCedulaPropietarioFk(persona);
                    hipotecaActualizar.setGarante(necesidadGarante);
                    hipotecaActualizar.setCedulaGaranteFk(p);

                    if (controladorHipoteca.update(hipotecaActualizar)) {
                        JOptionPane.showMessageDialog(this, "Hipoteca actualizada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        casa.setEstado(EnumEstadoCasa.VENDIDA.toString());
                        controladorCasa.update(casa);
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                /*Hipoteca hipoteca = new Hipoteca(sueldoNecesario, fechaInicio, fechaFin, plazo,
                        prestamo, interes, carga, total, mensualidad, necesidadGarante, casa, null, persona);*/

                hipotecaActualizar.setInteres(interes);
                hipotecaActualizar.setMontoPrestamo(prestamo);
                hipotecaActualizar.setPlazoMeses(plazo);
                hipotecaActualizar.setFechaInicio(fechaInicio);
                hipotecaActualizar.setFechaFin(fechaFin);
                hipotecaActualizar.setCargaFinanciera(carga);
                hipotecaActualizar.setPagoTotal(total);
                hipotecaActualizar.setTarifaMensual(mensualidad);
                hipotecaActualizar.setSueldoNecesario(sueldoNecesario);
                hipotecaActualizar.setCodigoCasaFk(casa);
                hipotecaActualizar.setCedulaPropietarioFk(persona);
                hipotecaActualizar.setGarante(necesidadGarante);
                hipotecaActualizar.setCedulaGaranteFk(null);

                if (controladorHipoteca.update(hipotecaActualizar)) {
                    JOptionPane.showMessageDialog(this, "Hipoteca actualizada con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    casa.setEstado(EnumEstadoCasa.VENDIDA.toString());
                    controladorCasa.update(casa);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblHipotecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHipotecasMouseClicked
        // TODO add your handling code here:

        int fila = tblHipotecas.getSelectedRow();

        int codigo = (int) (tblHipotecas.getValueAt(fila, 0));

        hipotecaActualizar = controladorHipoteca.read(codigo);

        txtCodigo.setText(String.valueOf(hipotecaActualizar.getCodigo()));
        txtInteres.setText(hipotecaActualizar.getInteres().toString());
        txtPrestamo.setText(hipotecaActualizar.getMontoPrestamo().toString());
        txtPlazo.setText(hipotecaActualizar.getPlazoMeses().toString());
        jDateFechaInicio.setDate(hipotecaActualizar.getFechaInicio());
        jDateFechaFin.setDate(hipotecaActualizar.getFechaFin());
        txtCargaFinaciera.setText(hipotecaActualizar.getCargaFinanciera().toString());
        txtTotal.setText(hipotecaActualizar.getPagoTotal().toString());
        txtTarifaMensual.setText(hipotecaActualizar.getTarifaMensual().toString());
        txtSueldoNecesario.setText(hipotecaActualizar.getSueldoNecesario().toString());
        txtCodigoCasa.setText(String.valueOf(hipotecaActualizar.getCodigoCasaFk().getCodigo()));
        txtCedulaHipotecario.setText(hipotecaActualizar.getCedulaPropietarioFk().getCedula());

        if (hipotecaActualizar.getGarante()) {
            txtCedulaGarante.setText(hipotecaActualizar.getCedulaGaranteFk().getCedula());
        }

        botonesActualizar();
        botonesActualizar = true;
        bloquearTxts();
        tblHipotecas.clearSelection();


    }//GEN-LAST:event_tblHipotecasMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        int codigo = Integer.valueOf(txtCodigo.getText());

        hipotecaActualizar = controladorHipoteca.read(codigo);

        var casa = hipotecaActualizar.getCodigoCasaFk();
        casa.setEstado(EnumEstadoCasa.ENVENTA.toString());

        if (controladorHipoteca.delete(hipotecaActualizar)) {
            JOptionPane.showMessageDialog(this, "Hipoteca eliminado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            controladorCasa.update(casa);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMensualidadTabla;
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHipotecas;
    private javax.swing.JTextField txtCargaFinaciera;
    private javax.swing.JFormattedTextField txtCedulaGarante;
    private javax.swing.JFormattedTextField txtCedulaHipotecario;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoCasa;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtPrestamo;
    private javax.swing.JTextField txtSueldoNecesario;
    private javax.swing.JTextField txtTarifaMensual;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
