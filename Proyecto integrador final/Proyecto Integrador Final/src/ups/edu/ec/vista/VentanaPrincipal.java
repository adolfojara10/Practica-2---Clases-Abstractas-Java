/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.lang.reflect.Constructor;
import javax.swing.JOptionPane;
import ups.edu.ec.controlador.ControladorAdministrador;
import ups.edu.ec.controlador.ControladorCliente;
import ups.edu.ec.controlador.ControladorContrato;
import ups.edu.ec.controlador.ControladorFactura;
import ups.edu.ec.controlador.ControladorSitio;
import ups.edu.ec.controlador.ControladorVehiculo;

import ups.edu.ec.modelo.Administrador;
import ups.edu.ec.modelo.EnumTipoAdministrador;

/**
 *
 * @author User
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Administrador administrador;
    private boolean inicioSesion;
    private String keyUnlock;

    private ControladorAdministrador controladorAdministrador;
    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;

    private ControladorSitio controladorSitio;
    private ControladorFactura controladorFactura;
    private ControladorContrato controladorContrato;

    private VentanaLogIn ventanaLogIn;
    private VentanaCrearUsuario ventanaCrearUsuario;
    private VentanaCrearCliente ventanaCrearCliente;

    private VentanaVehiculo ventanaVehiculo;

    private VentanaEntradaTicket ventanaEntradaTicket;
    private VentanaSalidaTicket ventanaSalidaTicket;

    private VentanaGestionFacturas ventanaGestionFacturas;
    private VentanaContrato ventanaContrato;
    private VentanaVisualizarFactura ventanaVisualizarFactura;
    private VentanaSitios ventanaSitios;

    private VentanaMoverCoche ventanaPruebas;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        inicioSesion = false;
        /*
        try {
            Constructor<Administrador> constructor;
            constructor = Administrador.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            administrador = constructor.newInstance();
            administrador.setNombre("Jose");
            administrador.setApellido("Jose");
            //administrador.setCodigo(1);
            administrador.setCedula("010101010-1");
            administrador.setCorreo("jose@gmail.com");

            administrador.setTipo(EnumTipoAdministrador.COMPLETO.toString());
            System.out.println(EnumTipoAdministrador.COMPLETO.toString());
            Calendar fecha = new GregorianCalendar(1980, 10, 15);
            administrador.setFechaNacimiento(fecha.getTime());
            administrador.setNumeroTelefono("012-345-6789");
        } catch (Exception e) {
            e.printStackTrace();
        }

         */

        controladorAdministrador = new ControladorAdministrador();
        /*
        String passwordEncriptado = controladorAdministrador.encriptarPassword(keyUnlock, "1234");
        administrador.setContrasenia(passwordEncriptado);
        controladorAdministrador.create(administrador);*/

        keyUnlock = "programacion";
        controladorCliente = new ControladorCliente();
        controladorVehiculo = new ControladorVehiculo();

        controladorSitio = new ControladorSitio();
        //System.out.println(controladorSitio.findAll());
        controladorFactura = new ControladorFactura();
        controladorContrato = new ControladorContrato();

        ventanaVisualizarFactura = new VentanaVisualizarFactura();
        //System.out.println(controladorSitio.getListaGenerica().size()); 
        ventanaLogIn = new VentanaLogIn(controladorAdministrador, keyUnlock);
        ventanaCrearUsuario = new VentanaCrearUsuario(controladorAdministrador, keyUnlock);
        ventanaCrearCliente = new VentanaCrearCliente(controladorCliente);
        ventanaVehiculo = new VentanaVehiculo(controladorCliente, controladorVehiculo);
        ventanaEntradaTicket = new VentanaEntradaTicket(controladorSitio, controladorCliente, controladorFactura);
        ventanaSalidaTicket = new VentanaSalidaTicket(controladorFactura, controladorSitio, ventanaVisualizarFactura);
        ventanaGestionFacturas = new VentanaGestionFacturas(controladorFactura);
        ventanaContrato = new VentanaContrato(controladorContrato, controladorSitio, controladorCliente);

        ventanaSitios = new VentanaSitios(controladorSitio);

        ventanaPruebas = new VentanaMoverCoche(controladorSitio);
        ventanaEntradaTicket.setVentanaPruebas(ventanaPruebas);

        desktopPane.add(ventanaLogIn);
        desktopPane.add(ventanaCrearUsuario);
        desktopPane.add(ventanaCrearCliente);
        desktopPane.add(ventanaVehiculo);
        desktopPane.add(ventanaEntradaTicket);
        desktopPane.add(ventanaSalidaTicket);
        desktopPane.add(ventanaGestionFacturas);
        desktopPane.add(ventanaContrato);
        desktopPane.add(ventanaVisualizarFactura);
        desktopPane.add(ventanaSitios);

        desktopPane.add(ventanaPruebas);

        this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
    }

    public void cerrarVentanas() {
        ventanaLogIn.hide();
        ventanaCrearUsuario.hide();
        ventanaCrearCliente.hide();
        ventanaVehiculo.hide();
        ventanaEntradaTicket.hide();
        ventanaSalidaTicket.hide();
        ventanaGestionFacturas.hide();
        ventanaContrato.hide();
        ventanaSitios.hide();
        ventanaPruebas.hide();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logInMenuItem = new javax.swing.JMenuItem();
        cerrarSesionMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        usuarioMenuItem = new javax.swing.JMenuItem();
        clienteMenuItem = new javax.swing.JMenuItem();
        vehiculoMenuItem = new javax.swing.JMenuItem();
        contratoMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        entradaMenuItem = new javax.swing.JMenuItem();
        salidaMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        facturaMenuItem = new javax.swing.JMenuItem();
        sitiosMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Inicio");

        logInMenuItem.setMnemonic('o');
        logInMenuItem.setText("Log In");
        logInMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(logInMenuItem);

        cerrarSesionMenuItem.setMnemonic('s');
        cerrarSesionMenuItem.setText("Cerrar Sesión");
        cerrarSesionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(cerrarSesionMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Crear");

        usuarioMenuItem.setMnemonic('t');
        usuarioMenuItem.setText("Usuario");
        usuarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(usuarioMenuItem);

        clienteMenuItem.setMnemonic('y');
        clienteMenuItem.setText("Cliente");
        clienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(clienteMenuItem);

        vehiculoMenuItem.setText("Vehiculo");
        vehiculoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(vehiculoMenuItem);

        contratoMenuItem.setMnemonic('p');
        contratoMenuItem.setText("Contrato");
        contratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(contratoMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ticket");

        entradaMenuItem.setMnemonic('c');
        entradaMenuItem.setText("Emitir ticket entrada");
        entradaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(entradaMenuItem);

        salidaMenuItem.setMnemonic('a');
        salidaMenuItem.setText("Emitir ticket salida");
        salidaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(salidaMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setText("Gestion");

        facturaMenuItem.setText("Facturas");
        facturaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(facturaMenuItem);

        sitiosMenuItem.setText("Sitios");
        sitiosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sitiosMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(sitiosMenuItem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void logInMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (Administrador.instance == null) {
            ventanaLogIn.setVisible(true);
            inicioSesion = true;
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario que inicio sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_logInMenuItemActionPerformed

    private void cerrarSesionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (inicioSesion) {
            Administrador.instance = null;
            cerrarVentanas();
            JOptionPane.showMessageDialog(this, "Sesión cerrada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            inicioSesion = false;
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cerrarSesionMenuItemActionPerformed

    private void usuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        //ventanaCrearUsuario.setVisible(true);
        
        if (Administrador.instance != null) {
            cerrarVentanas();
            if (Administrador.instance.getTipo().equalsIgnoreCase(EnumTipoAdministrador.COMPLETO.toString())) {

                ventanaCrearUsuario.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "NO tiene acceso", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            cerrarVentanas();
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_usuarioMenuItemActionPerformed

    private void clienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        //ventanaCrearCliente.setVisible(true);

        if (Administrador.instance != null) {
            ventanaCrearCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_clienteMenuItemActionPerformed

    private void vehiculoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculoMenuItemActionPerformed
        // TODO add your handling code here:

        cerrarVentanas();
        //ventanaVehiculo.setVisible(true);

        if (Administrador.instance != null) {
            ventanaVehiculo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_vehiculoMenuItemActionPerformed

    private void entradaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        //ventanaEntradaTicket.setVisible(true);

        if (Administrador.instance != null) {
            ventanaEntradaTicket.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_entradaMenuItemActionPerformed

    private void salidaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaMenuItemActionPerformed
        // TODO add your handling code here:

        cerrarVentanas();
        //ventanaSalidaTicket.setVisible(true);

        if (Administrador.instance != null) {
            ventanaSalidaTicket.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_salidaMenuItemActionPerformed

    private void contratoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratoMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        //ventanaContrato.setVisible(true);

        if (Administrador.instance != null) {
            ventanaContrato.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_contratoMenuItemActionPerformed

    private void facturaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        //ventanaGestionFacturas.setVisible(true);

        if (Administrador.instance != null) {
            ventanaGestionFacturas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_facturaMenuItemActionPerformed

    private void sitiosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sitiosMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        //ventanaSitios.setVisible(true);

        if (Administrador.instance != null) {
            ventanaSitios.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sitiosMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cerrarSesionMenuItem;
    private javax.swing.JMenuItem clienteMenuItem;
    private javax.swing.JMenuItem contratoMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem entradaMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem facturaMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem logInMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem salidaMenuItem;
    private javax.swing.JMenuItem sitiosMenuItem;
    private javax.swing.JMenuItem usuarioMenuItem;
    private javax.swing.JMenuItem vehiculoMenuItem;
    // End of variables declaration//GEN-END:variables

}
