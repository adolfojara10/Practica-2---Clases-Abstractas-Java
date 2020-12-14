/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorDocente;
import ups.edu.ec.modelo.Curso;
import ups.edu.ec.modelo.Docente;
import ups.edu.ec.modelo.Rector;

/**
 *
 * @author User
 */
public class VentanaCrearDocente extends javax.swing.JInternalFrame {

    private ControladorDocente controladorDocente;
    private int id;
   // private Curso cursoProfesor;
    
    /**
     * Creates new form VentanaCrearDocente
     */
    public VentanaCrearDocente(ControladorDocente controladorDocente) {
        initComponents();

        this.controladorDocente = controladorDocente;
       // cursoProfesor = null;
        llenarTablaDocente();
    }

    public void llenarTablaDocente() {
        List<Docente> listaDocentes = (List<Docente>) controladorDocente.getListaGenerica();

        DefaultTableModel modelo = (DefaultTableModel) tblDocentes.getModel();
        modelo.setRowCount(0);

        listaDocentes.forEach(var -> {
            String curso = "";
            if (var.getCurso() == null) {
                curso = "Sin cursos";
            } else {
                
                curso = var.getCurso().getNombreCurso();
            }
            Object[] row = {var.getNombre() + " " + var.getApellido(), var.getCedula(),
                var.getCorreo(), var.getPassword(), curso, var.getGenero()};

            id = var.getId();
            modelo.addRow(row);
        });

        tblDocentes.setModel(modelo);

    }

    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtFormattedCedula.setValue("");
        txtCorreo.setText("");
        txtPassword.setText("");
        cbxGenero.setSelectedIndex(0);

        btnCrear.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);

        tblDocentes.clearSelection();

    }

    public void activarBotones() {
        btnCrear.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtFormattedCedula = new javax.swing.JFormattedTextField();
        txtPassword = new javax.swing.JPasswordField();
        cbxGenero = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocentes = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("Nombre(s):");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Cédula:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Password:");

        jLabel6.setText("Género:");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Masculino", "Femenino" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreo)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtFormattedCedula)
                    .addComponent(txtPassword)
                    .addComponent(cbxGenero, 0, 212, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFormattedCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnCrear.setBackground(new java.awt.Color(51, 51, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(51, 51, 255));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnCrear)
                .addGap(41, 41, 41)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(35, 35, 35)
                .addComponent(btnCancelar)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        tblDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cédula", "Correo", "Password", "Curso", "Género"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDocentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded

        llenarTablaDocente();
    }//GEN-LAST:event_formAncestorAdded

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtFormattedCedula.getText();
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();
        String genero = (String) cbxGenero.getSelectedItem();

        if (nombre.isBlank() || apellido.isBlank() || cedula.isBlank() || correo.isBlank() || password.isBlank()
                || genero.equals("--Seleccionar--")) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            try {
                Constructor<Docente> constructor = Docente.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                Docente docente = constructor.newInstance();

                docente.setId(controladorDocente.generarID());
                docente.setNombre(nombre);
                docente.setApellido(apellido);
                docente.setCedula(cedula);
                docente.setGenero(genero);
                docente.setCorreo(correo);
                docente.setPassword(password);

                if (controladorDocente.create(docente)) {
                    JOptionPane.showMessageDialog(this, "Docente creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    llenarTablaDocente();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ha existido un problema", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtFormattedCedula.getText();
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();
        String genero = (String) cbxGenero.getSelectedItem();

        if (nombre.isBlank() || apellido.isBlank() || cedula.isBlank() || correo.isBlank() || password.isBlank()
                || genero.equals("--Seleccionar--")) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            try {
                Constructor<Docente> constructor = Docente.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                Docente docente = constructor.newInstance();
                
                docente.setCedula(cedula);
                
                docente = (Docente) controladorDocente.read(docente);
                
                docente.setId(docente.getId());
                docente.setNombre(nombre);
                docente.setApellido(apellido);
                docente.setCedula(cedula);
                docente.setGenero(genero);
                docente.setCorreo(correo);
                docente.setPassword(password);

                if (controladorDocente.update(docente, docente)) {
                    JOptionPane.showMessageDialog(this, "Docente creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    llenarTablaDocente();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ha existido un problema", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        try {
            Constructor<Docente> constructor = Docente.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Docente docente = constructor.newInstance();

            docente.setId(id);
            docente.setCedula((String) txtFormattedCedula.getValue());

            if (controladorDocente.delete(docente)) {
                JOptionPane.showMessageDialog(this, "Docente eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                llenarTablaDocente();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Ha existido un problema", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(VentanaRector.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblDocentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocentesMouseClicked
        // TODO add your handling code here:
        int fila = tblDocentes.getSelectedRow();

        String nombres = (String) tblDocentes.getValueAt(fila, 0);
        String[] nombre = nombres.split(" ", 2);

        txtNombre.setText(nombre[0]);
        txtApellido.setText(nombre[1]);
        txtFormattedCedula.setValue((String) tblDocentes.getValueAt(fila, 1));
        txtCorreo.setText((String) tblDocentes.getValueAt(fila, 2));
        txtPassword.setText((String) tblDocentes.getValueAt(fila, 3));
        cbxGenero.setSelectedItem((String) tblDocentes.getValueAt(fila, 5));

        activarBotones();

    }//GEN-LAST:event_tblDocentesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDocentes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFormattedCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}