/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import javax.swing.JOptionPane;
import ups.edu.ec.controlador.ControladorActividad;
import ups.edu.ec.controlador.ControladorAlumno;
import ups.edu.ec.controlador.ControladorCurso;
import ups.edu.ec.controlador.ControladorDocente;
import ups.edu.ec.controlador.ControladorRector;
import ups.edu.ec.modelo.Docente;
import ups.edu.ec.modelo.Rector;

/**
 *
 * @author User
 */
public class VentanaPrincipal1 extends javax.swing.JFrame {

    private ControladorRector controladorRector;
    private ControladorDocente controladorDocente;
    private ControladorAlumno controladorAlumno;
    private ControladorActividad controladorActividad;
    private ControladorCurso controladorCurso;

    private VentanaRector ventanaRector;
    private VentanaLogIn ventanaLogIn;
    private VentanaCrearDocente ventanaCrearDocente;
    private VentanaAlumno ventanaAlumno;
    private VentanaCursoRector ventanaCursoRector;
    private VentanaCursoDocente ventanaCursoDocente;
    private VentanaActividad ventanaActividad;
    private VentanaGestionCurso ventanaGestionCurso;

    private boolean inicioSesion;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal1() {
        initComponents();
        controladorRector = new ControladorRector("C:\\Users\\User\\Desktop\\ProgramacionAplicada\\Examen Practico Java\\rector.obj");
        controladorDocente = new ControladorDocente("C:\\Users\\User\\Desktop\\ProgramacionAplicada\\Examen Practico Java\\docentes.obj");
        controladorAlumno = new ControladorAlumno("C:\\Users\\User\\Desktop\\ProgramacionAplicada\\Examen Practico Java\\alumnos.obj");
        controladorActividad = new ControladorActividad("C:\\Users\\User\\Desktop\\ProgramacionAplicada\\Examen Practico Java\\actividades.obj");
        controladorCurso = new ControladorCurso("C:\\Users\\User\\Desktop\\ProgramacionAplicada\\Examen Practico Java\\cursos.obj");

        inicioSesion = false;

        ventanaRector = new VentanaRector(controladorRector);
        ventanaLogIn = new VentanaLogIn(controladorRector, controladorDocente);
        ventanaCrearDocente = new VentanaCrearDocente(controladorDocente);
        ventanaAlumno = new VentanaAlumno(controladorAlumno, controladorCurso);
        ventanaCursoRector = new VentanaCursoRector(controladorCurso, controladorDocente);
        ventanaCursoDocente = new VentanaCursoDocente(controladorCurso, controladorActividad, controladorAlumno);
        ventanaActividad = new VentanaActividad(controladorActividad);
        ventanaGestionCurso = new VentanaGestionCurso(controladorCurso, controladorActividad, controladorAlumno);

        desktopPane.add(ventanaRector);
        desktopPane.add(ventanaLogIn);
        desktopPane.add(ventanaCrearDocente);
        desktopPane.add(ventanaAlumno);
        desktopPane.add(ventanaCursoRector);
        desktopPane.add(ventanaCursoDocente);
        desktopPane.add(ventanaActividad);
        desktopPane.add(ventanaGestionCurso);

        this.setExtendedState(VentanaPrincipal1.MAXIMIZED_BOTH);

    }

    public void cerrarVentanas() {
        ventanaRector.hide();
        ventanaLogIn.hide();
        ventanaCrearDocente.hide();
        ventanaAlumno.hide();
        ventanaCursoRector.hide();
        ventanaCursoDocente.hide();
        ventanaActividad.hide();
        ventanaGestionCurso.hide();
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
        rectorMenuItem = new javax.swing.JMenuItem();
        logInMenuItem = new javax.swing.JMenuItem();
        cerrarSesionMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        docenteMenuItem = new javax.swing.JMenuItem();
        alumnoMenuItem = new javax.swing.JMenuItem();
        actividadMenuItem = new javax.swing.JMenuItem();
        cursoAsignarRectorMenuItem = new javax.swing.JMenuItem();
        cursoDocenteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        gestionCursoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Inicio");

        rectorMenuItem.setMnemonic('o');
        rectorMenuItem.setText("Rector");
        rectorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectorMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(rectorMenuItem);

        logInMenuItem.setMnemonic('s');
        logInMenuItem.setText("Log In");
        logInMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(logInMenuItem);

        cerrarSesionMenuItem.setMnemonic('a');
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
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });

        docenteMenuItem.setMnemonic('t');
        docenteMenuItem.setText("Docente");
        docenteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docenteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(docenteMenuItem);

        alumnoMenuItem.setMnemonic('y');
        alumnoMenuItem.setText("Alumno");
        alumnoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(alumnoMenuItem);

        actividadMenuItem.setMnemonic('p');
        actividadMenuItem.setText("Actividad");
        actividadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actividadMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(actividadMenuItem);

        cursoAsignarRectorMenuItem.setMnemonic('d');
        cursoAsignarRectorMenuItem.setText("Curso - Rector");
        cursoAsignarRectorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoAsignarRectorMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cursoAsignarRectorMenuItem);

        cursoDocenteMenuItem.setText("Curso - Docente");
        cursoDocenteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoDocenteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cursoDocenteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Gestion");

        gestionCursoMenuItem.setMnemonic('c');
        gestionCursoMenuItem.setText("Curso");
        gestionCursoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionCursoMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(gestionCursoMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void rectorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectorMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        ventanaRector.setVisible(true);
    }//GEN-LAST:event_rectorMenuItemActionPerformed

    private void logInMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInMenuItemActionPerformed
        cerrarVentanas();
        if (Rector.instance == null || Docente.instance == null) {
            ventanaLogIn.setVisible(true);
            inicioSesion = true;
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario que inicio sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_logInMenuItemActionPerformed

    private void cerrarSesionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionMenuItemActionPerformed
        // TODO add your handling code here:
        if (inicioSesion) {
            Rector.instance = null;
            Docente.instance = null;
            cerrarVentanas();
            JOptionPane.showMessageDialog(this, "Sesión cerrada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Nadie ha iniciado sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cerrarSesionMenuItemActionPerformed

    private void docenteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docenteMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (Rector.instance != null) {
            ventanaCrearDocente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicie Sesion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_docenteMenuItemActionPerformed

    private void alumnoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnoMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (Docente.instance != null) {
            ventanaAlumno.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicie Sesion", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_alumnoMenuItemActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_editMenuActionPerformed

    private void cursoAsignarRectorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoAsignarRectorMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (Rector.instance != null) {
            ventanaCursoRector.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicie Sesion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cursoAsignarRectorMenuItemActionPerformed

    private void cursoDocenteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoDocenteMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (Docente.instance != null) {
            ventanaCursoDocente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicie Sesion", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_cursoDocenteMenuItemActionPerformed

    private void actividadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actividadMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        if (Docente.instance != null) {
            ventanaActividad.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicie Sesion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actividadMenuItemActionPerformed

    private void gestionCursoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionCursoMenuItemActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();

        if (Docente.instance != null) {
            ventanaGestionCurso.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicie Sesion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_gestionCursoMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actividadMenuItem;
    private javax.swing.JMenuItem alumnoMenuItem;
    private javax.swing.JMenuItem cerrarSesionMenuItem;
    private javax.swing.JMenuItem cursoAsignarRectorMenuItem;
    private javax.swing.JMenuItem cursoDocenteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem docenteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem gestionCursoMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem logInMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem rectorMenuItem;
    // End of variables declaration//GEN-END:variables

}
