/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorApuesta;
import ups.edu.ec.controlador.ControladorCasino;
import ups.edu.ec.controlador.ControladorCliente;
import ups.edu.ec.modelo.Apuesta;
import ups.edu.ec.modelo.Casino;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.EnumTipoApuesta;
import ups.edu.ec.modelo.Hilo;

/**
 *
 * @author User
 */
public class VentanaJuego extends javax.swing.JInternalFrame {
    
    private ControladorCliente controladorCliente;
    private ControladorCasino controladorCasino;
    private ControladorApuesta controladorApuesta;
    
    private List<Cliente> listaNumeroConreto;
    private List<Cliente> listaParImpar;
    private List<Cliente> listaMartinGala;
    private List<Cliente> listaJugadores;
    
    private List<Thread> listaThreads;
    
    private List<Hilo> listaHilos;
    private int iNumeroRuleta;
    
    private boolean juegoPausado;

    /**
     * Creates new form VentanaJuego
     *
     * @param controladorCliente
     * @param controladorCasino
     * @param controladorApuesta
     */
    public VentanaJuego(ControladorCliente controladorCliente, ControladorCasino controladorCasino,
            ControladorApuesta controladorApuesta) {
        initComponents();
        
        this.controladorApuesta = controladorApuesta;
        this.controladorCasino = controladorCasino;
        this.controladorCliente = controladorCliente;
        
        listaMartinGala = new ArrayList<>();
        listaNumeroConreto = new ArrayList<>();
        listaParImpar = new ArrayList<>();
        listaJugadores = new ArrayList<>();
        listaThreads = new ArrayList<>();
        listaHilos = new ArrayList<>();
        
        juegoPausado = false;
    }
    
    public String escogerJuego() {
        List<String> tiposJuego = new ArrayList<>();
        
        if (listaMartinGala.size() < 4) {
            tiposJuego.add(EnumTipoApuesta.MARTINGALA.toString());
        }
        
        if (listaNumeroConreto.size() < 4) {
            tiposJuego.add(EnumTipoApuesta.NUMEROCONCRETO.toString());
        }
        
        if (listaParImpar.size() < 4) {
            tiposJuego.add(EnumTipoApuesta.PARIMPAR.toString());
        }
        
        Random randomico = new Random();
        
        int eleccion = randomico.nextInt(3);
        
        return tiposJuego.get(eleccion);
        
    }
    
    public void comenzarBotones() {
        btnComenzar.setEnabled(false);
        btnParar.setEnabled(true);
        btnTerminar.setEnabled(true);
        
    }
    
    public void agregarNumeroConcreto(Cliente cli) {
        
        listaNumeroConreto.add(cli);
    }
    
    public void agregarParImpar(Cliente cli) {
        listaParImpar.add(cli);
    }
    
    public void agregarMartinGala(Cliente cli) {
        listaMartinGala.add(cli);
    }
    
    public void llenarTblClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);
        
        for (var cliente : listaJugadores) {
            Object[] row = {cliente.getCodigo(), cliente.getNombre().concat(cliente.getApellido()), cliente.getTipoApuesta()};
            modelo.addRow(row);
        }
        
        tblClientes.setModel(modelo);
        
    }
    
    public void limpiarCampos() {
        txtCodigo.setText("");
        llenarTblClientes();
    }
    
    public void limpiarListas() {
        listaJugadores.clear();
        listaMartinGala.clear();
        listaNumeroConreto.clear();
        listaParImpar.clear();
        listaThreads.clear();
        btnJugadoresAleatorios.setEnabled(true);
    }
    
    public int getiNumeroRuleta() {
        return iNumeroRuleta;
    }
    
    public void setiNumeroRuleta(int iNumeroRuleta) {
        this.iNumeroRuleta = iNumeroRuleta;
    }
    
    public int miSacarNumero() {
        setiNumeroRuleta((int) (Math.random() * 36));
        return getiNumeroRuleta();
    }//miSacarNumero()

    public JTable getTblJuego() {
        return tblJuego;
    }
    
    public void setTblJuego(JTable tblJuego) {
        this.tblJuego = tblJuego;
    }
    
    public synchronized void llenarTablaJuego(List<Hilo> resultadoNumeroConcreto, List<Hilo> resultadoParImpar,
            List<Hilo> resultadoMartinGala) {
        
        DefaultTableModel modelo = (DefaultTableModel) tblJuego.getModel();
        //modelo.setRowCount(0);

        for (int i = 0; i < 4; i++) {
            Object[] row1 = {resultadoNumeroConcreto.get(i).getCliente().getNombre().concat(resultadoNumeroConcreto.get(i).getCliente().getApellido()),
                resultadoNumeroConcreto.get(i).getApuestas().get(0).getApostadoPara(),
                resultadoNumeroConcreto.get(i).getApuestas().get(0).getDineroCliente(),
                resultadoNumeroConcreto.get(i).getApuestas().get(0).getDineroCasino(),
                resultadoNumeroConcreto.get(i).getCliente().getNumeroRuleta(),
                resultadoNumeroConcreto.get(i).getCliente().getTipoApuesta()};
            
            modelo.addRow(row1);
            
            String numeroEscogido;
            if (resultadoParImpar.get(i).getApuestas().get(0).getApostadoPara().equalsIgnoreCase("true")) {
                numeroEscogido = "par";
            } else {
                numeroEscogido = "impar";
            }
            Object[] row2 = {resultadoParImpar.get(i).getCliente().getNombre().concat(resultadoParImpar.get(i).getCliente().getApellido()),
                numeroEscogido,
                resultadoParImpar.get(i).getApuestas().get(0).getDineroCliente(),
                resultadoParImpar.get(i).getApuestas().get(0).getDineroCasino(),
                resultadoParImpar.get(i).getCliente().getNumeroRuleta(),
                resultadoParImpar.get(i).getCliente().getTipoApuesta()};
            
            modelo.addRow(row2);
            
            Object[] row3 = {resultadoMartinGala.get(i).getCliente().getNombre().concat(resultadoMartinGala.get(i).getCliente().getApellido()),
                resultadoMartinGala.get(i).getApuestas().get(0).getApostadoPara(),
                resultadoMartinGala.get(i).getApuestas().get(0).getDineroCliente(),
                resultadoMartinGala.get(i).getApuestas().get(0).getDineroCasino(),
                resultadoMartinGala.get(i).getCliente().getNumeroRuleta(),
                resultadoMartinGala.get(i).getCliente().getTipoApuesta()};
            
            modelo.addRow(row3);
            
        }
        
        tblJuego.setModel(modelo);
        
    }
    
    public void llenarTabla(List<Hilo> hilos) {
        DefaultTableModel modelo = (DefaultTableModel) tblJuego.getModel();
        
        hilos.forEach(cl -> {
            cl.getApuestas().stream().map(ap -> {
                String numeroApostado = "";
                if (ap.getApostadoPara().equalsIgnoreCase("true")) {
                    numeroApostado = "par";
                } else if ((ap.getApostadoPara().equalsIgnoreCase("false"))) {
                    numeroApostado = "impar";
                } else {
                    numeroApostado = ap.getApostadoPara();
                }
                ap.setApostadoPara(numeroApostado);
                Object[] row = {ap.getCodigoClienteFk().getNombre().concat(ap.getCodigoClienteFk().getApellido()),
                    numeroApostado, ap.getDineroCliente(), ap.getDineroCasino(), ap.getResultadoRuleta(),
                    ap.getTipoApuesta()};
                return row;
            }).forEachOrdered(row -> {
                modelo.addRow(row);
            });
        });
        
        tblJuego.setModel(modelo);
    }
    
    public void guardarApuestas(List<Hilo> hilos) {
        
        hilos.forEach(hi -> {
            hi.getApuestas().forEach(ap -> {
                controladorApuesta.create(ap);
            });
        });
    }
    
    public void actualizarClientes(List<Hilo> hilos) {
        hilos.forEach(hi -> {
            hi.getApuestas().forEach(ap -> {
                controladorCliente.update(ap.getCodigoClienteFk());
            });
        });
    }
    
    public void actualizarCasino(List<Hilo> hilos) {
        var casino = hilos.get(hilos.size() - 1).getCasino();
        controladorCasino.update(casino);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComenzar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cbxJuego = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnTerminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroRuleta = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblJuego = new javax.swing.JTable();
        btnJugadoresAleatorios = new javax.swing.JButton();

        btnComenzar.setText("Comenzar");
        btnComenzar.setEnabled(false);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        btnParar.setText("Pausar");
        btnParar.setEnabled(false);
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Código:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cbxJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cualquiera", "NumeroConcreto", "ParImpar", "MartinGala" }));

        jLabel2.setText("Juego:");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxJuego, 0, 162, Short.MAX_VALUE)
                            .addComponent(txtCodigo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregar)
                        .addGap(49, 49, 49)
                        .addComponent(btnCancelar)))
                .addContainerGap(19, Short.MAX_VALUE))
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
                    .addComponent(cbxJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Jugador", "Juego"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        btnTerminar.setText("Terminar");
        btnTerminar.setEnabled(false);
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ups/edu/ec/imagenes/ruleta.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Número Ruleta:");

        txtNumeroRuleta.setEditable(false);
        txtNumeroRuleta.setBackground(new java.awt.Color(153, 153, 153));

        tblJuego.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Número", "Dinero", "Banco", "Ruleta", "Juego"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblJuego);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel4)
                .addGap(59, 59, 59)
                .addComponent(txtNumeroRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumeroRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        btnJugadoresAleatorios.setText("Jugadores aleatorios");
        btnJugadoresAleatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugadoresAleatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnJugadoresAleatorios)
                        .addGap(53, 53, 53)
                        .addComponent(btnComenzar)
                        .addGap(50, 50, 50)
                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnTerminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComenzar)
                    .addComponent(btnParar)
                    .addComponent(btnTerminar)
                    .addComponent(btnJugadoresAleatorios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:

        int codigo = Integer.valueOf(txtCodigo.getText());
        String opcionJuego = (String) cbxJuego.getSelectedItem();
        
        if (codigo == 0) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            Cliente cliente = controladorCliente.read(codigo);
            if (cliente != null && !listaJugadores.contains(cliente)) {
                if (opcionJuego.equalsIgnoreCase("Cualquiera")) {
                    opcionJuego = escogerJuego();
                }
                
                if (opcionJuego.equalsIgnoreCase("NumeroConcreto")) {
                    if (listaNumeroConreto.size() < 4) {
                        cliente.setTipoApuesta(EnumTipoApuesta.NUMEROCONCRETO.toString());
                        agregarNumeroConcreto(cliente);
                    } else {
                        JOptionPane.showMessageDialog(this, "Tipo de juego lleno", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (opcionJuego.equalsIgnoreCase("ParImpar")) {
                    if (listaParImpar.size() < 4) {
                        cliente.setTipoApuesta(EnumTipoApuesta.PARIMPAR.toString());
                        agregarParImpar(cliente);
                    } else {
                        JOptionPane.showMessageDialog(this, "Tipo de juego lleno", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } else {
                    
                    if (listaMartinGala.size() < 4) {
                        cliente.setTipoApuesta(EnumTipoApuesta.MARTINGALA.toString());
                        agregarMartinGala(cliente);
                    } else {
                        JOptionPane.showMessageDialog(this, "Tipo de juego lleno", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                listaJugadores.add(cliente);
                limpiarCampos();
                btnJugadoresAleatorios.setEnabled(false);
                if (listaJugadores.size() == 12) {
                    btnAgregar.setEnabled(false);
                    btnComenzar.setEnabled(true);
                }
                JOptionPane.showMessageDialog(this, "Jugador agregado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Jugador no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarListas();
        limpiarCampos();
        DefaultTableModel modelo = (DefaultTableModel) tblJuego.getModel();
        modelo.setRowCount(0);
        tblJuego.setModel(modelo);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnJugadoresAleatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugadoresAleatoriosActionPerformed
        // TODO add your handling code here:

        int tamanioJugadores = controladorCliente.findAll().size();
        
        int numeroJugadores = 4;
        
        var jugadores = controladorCliente.findAll();
        
        Random numeroRandom = new Random();
        for (int i = 0; i < numeroJugadores; i++) {
            int posicion = numeroRandom.nextInt(tamanioJugadores);
            var cl = jugadores.get(posicion);
            if (!listaJugadores.contains(cl)) {
                cl.setTipoApuesta(EnumTipoApuesta.NUMEROCONCRETO.toString());
                listaJugadores.add(cl);
                listaNumeroConreto.add(cl);
            } else {
                numeroJugadores++;
            }
        }
        
        numeroJugadores = 4;
        for (int i = 0; i < numeroJugadores; i++) {
            int posicion = numeroRandom.nextInt(tamanioJugadores);
            var cl = jugadores.get(posicion);
            if (!listaJugadores.contains(cl)) {
                cl.setTipoApuesta(EnumTipoApuesta.PARIMPAR.toString());
                listaJugadores.add(cl);
                listaParImpar.add(cl);
            } else {
                numeroJugadores++;
            }
        }
        
        numeroJugadores = 4;
        for (int i = 0; i < numeroJugadores; i++) {
            int posicion = numeroRandom.nextInt(tamanioJugadores);
            var cl = jugadores.get(posicion);
            if (!listaJugadores.contains(cl)) {
                cl.setTipoApuesta(EnumTipoApuesta.MARTINGALA.toString());
                listaJugadores.add(cl);
                listaMartinGala.add(cl);
            } else {
                numeroJugadores++;
            }
        }
        
        limpiarCampos();
        btnJugadoresAleatorios.setEnabled(false);
        btnComenzar.setEnabled(true);
        

    }//GEN-LAST:event_btnJugadoresAleatoriosActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        // TODO add your handling code here:

        comenzarBotones();
        
        var oBanco = controladorCasino.findAll().get(0);
        
        int numeroRuleta = miSacarNumero();
        
        boolean bSeguir = true;
        int iNumeroPartida = controladorApuesta.numeroPartida() + 1;
        
        int contador = 0;
        
        List<Hilo> listaHilosNumeroConceto = new ArrayList<>();
        List<Hilo> listaHilosParImpar = new ArrayList<>();
        List<Hilo> listaHilosMartinGala = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            listaHilosNumeroConceto.add(new Hilo(listaNumeroConreto.get(i),
                    oBanco, iNumeroPartida, controladorCliente, controladorApuesta, controladorCasino, this));
            
            listaHilosParImpar.add(new Hilo(listaParImpar.get(i),
                    oBanco, iNumeroPartida, controladorCliente, controladorApuesta, controladorCasino, this));
            
            listaHilosMartinGala.add(new Hilo(listaMartinGala.get(i),
                    oBanco, iNumeroPartida, controladorCliente, controladorApuesta, controladorCasino, this));
        }
        
        while (bSeguir) {
            System.out.println(iNumeroPartida + "------------------------------- Numero Ruleta: " + iNumeroRuleta);
            
            if (iNumeroRuleta != 0 && contador != 2) {
                try {
                    for (int i = 0; i < 4; i++) {
                        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh");
                        //Le pasamos el valor que ha sacado el crupier a los hilos
                        listaNumeroConreto.get(i).setNumeroRuleta(String.valueOf(iNumeroRuleta));
                        listaParImpar.get(i).setNumeroRuleta(String.valueOf(iNumeroRuleta));
                        listaMartinGala.get(i).setNumeroRuleta(String.valueOf(iNumeroRuleta));
                        
                        listaHilosNumeroConceto.get(i).setNumeroPartida(iNumeroPartida);
                        listaHilosParImpar.get(i).setNumeroPartida(iNumeroPartida);
                        listaHilosMartinGala.get(i).setNumeroPartida(iNumeroPartida);
                        listaHilos.add(listaHilosNumeroConceto.get(i));
                        listaHilos.add(listaHilosParImpar.get(i));
                        listaHilos.add(listaHilosMartinGala.get(i));

                        //hilo3.setDineroApuesta(10);
                        Thread th = new Thread(listaHilosNumeroConceto.get(i));
                        Thread thPI = new Thread(listaHilosParImpar.get(i));
                        Thread thMa = new Thread(listaHilosMartinGala.get(i));
                        
                        th.setName("Hilo " + i + " NCo");
                        thPI.setName("Hilo " + i + " PI");
                        thMa.setName("Hilo " + i + " MA");
                        listaThreads.add(th);
                        listaThreads.add(thPI);
                        listaThreads.add(thMa);
                        //llenarTablaJuego(listaHilosNumeroConceto, listaHilosParImpar, listaHilosMartinGala);

                        //Inicializamos los hilos
                        th.start();
                        thPI.start();
                        thMa.start();
                        //llenarTablaJuego(listaHilosNumeroConceto, listaHilosParImpar, listaHilosMartinGala);
                    } // for()
                    iNumeroPartida++;
                    txtNumeroRuleta.setText(String.valueOf(iNumeroRuleta));
                    //llenarTablaJuego(listaHilosNumeroConceto, listaHilosParImpar, listaHilosMartinGala);
                    //Llamamos al metodo sleep para que se imprima la cuantia del banco justo despues de que se ejecuten los hilos
                    Thread.sleep(50);
                    System.out.println("BANCO: " + oBanco.getDinero());

                    //Volvemos a utilizar el metodo sleep como se pide en el enunciado
                    Thread.sleep(3000);
                    //Sacamos otro numero pasados esos 3 segundos
                    iNumeroRuleta = miSacarNumero();
                    contador++;
                } catch (InterruptedException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                bSeguir = false;
            }
        }
        
        llenarTabla(listaHilos);
        guardarApuestas(listaHilos);
        actualizarClientes(listaHilos);
        actualizarCasino(listaHilos);
        //llenarTablaJuego(listaHilosNumeroConceto, listaHilosParImpar, listaHilosMartinGala);

    }//GEN-LAST:event_btnComenzarActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        // TODO add your handling code here:

        if (!juegoPausado) {
            listaThreads.forEach(hi -> {
                hi.interrupt();
            });
        } else {
            listaThreads.forEach(Thread::resume);
        }

    }//GEN-LAST:event_btnPararActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        // TODO add your handling code here:

        try {
            listaThreads.forEach(hi -> {
                hi.stop();
            });
            
            System.out.println(listaJugadores);
            btnComenzar.setEnabled(false);
            btnParar.setEnabled(false);
            btnComenzar.setEnabled(false);
            btnJugadoresAleatorios.setEnabled(true);
            btnTerminar.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //llenarTabla(listaHilos);

    }//GEN-LAST:event_btnTerminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnJugadoresAleatorios;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JComboBox<String> cbxJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblJuego;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNumeroRuleta;
    // End of variables declaration//GEN-END:variables
}
