/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorActividad;
import ups.edu.ec.controlador.ControladorAlumno;
import ups.edu.ec.controlador.ControladorCurso;
import ups.edu.ec.modelo.Actividad;
import ups.edu.ec.modelo.Alumno;
import ups.edu.ec.modelo.Curso;
import ups.edu.ec.modelo.Docente;

/**
 *
 * @author User
 */
public class VentanaCursoDocente extends javax.swing.JInternalFrame {

    private ControladorCurso controladorCurso;
    private ControladorActividad controladorActividad;
    private ControladorAlumno controladorAlumno;

    private Curso curso;
    private Actividad actividad;
    private Alumno alumno;

    /**
     * Creates new form VentanaCursoDocente
     */
    public VentanaCursoDocente(ControladorCurso controladorCurso, ControladorActividad controladorActividad,
            ControladorAlumno controladorAlumno) {
        initComponents();

        this.controladorCurso = controladorCurso;
        this.controladorActividad = controladorActividad;
        this.controladorAlumno = controladorAlumno;

        llenarTablaAlumnos();
        llenarTablaActividades();

    }

    public void cargarCurso() {
        if (Docente.instance.getCurso() != null) {
            txtBuscarCurso.setText(String.valueOf(Docente.instance.getCurso().getId()));
            curso = Docente.instance.getCurso();
        }
    }

    public void llenarTablaAlumnoEncontrado(Alumno alumno) {

        DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();
        modelo.setRowCount(0);

        Object[] row = {alumno.getNombre() + "||" + alumno.getApellido(), alumno.getCedula(), alumno.getGenero()};
        modelo.addRow(row);

        tblAlumnos.setModel(modelo);
    }

    public void llenarTablaAlumnos() {
        List<Alumno> listaAlumnos = (List<Alumno>) controladorAlumno.getListaGenerica();

        DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();
        modelo.setRowCount(0);

        for (Alumno alumno : listaAlumnos) {
            if (alumno.getCurso() == null) {
                Object[] row = {alumno.getNombre() + "||" + alumno.getApellido(), alumno.getCedula(), alumno.getGenero()};
                modelo.addRow(row);
            }
        }

        tblAlumnos.setModel(modelo);

    }

    public void llenarTablaActividadEncontrada(Actividad actividad) {

        DefaultTableModel modelo = (DefaultTableModel) tblActividades.getModel();
        modelo.setRowCount(0);

        Object[] row = {actividad.getId(), actividad.getTitulo(), actividad.getAplicaciones()};
        modelo.addRow(row);

        tblActividades.setModel(modelo);
    }

    public void llenarTablaActividades() {
        List<Actividad> listaActividades = (List<Actividad>) controladorActividad.getListaGenerica();

        DefaultTableModel modelo = (DefaultTableModel) tblActividades.getModel();
        modelo.setRowCount(0);

        for (Actividad acti : listaActividades) {

            Object[] row = {acti.getId(), acti.getTitulo(), acti.getAplicaciones()};
            modelo.addRow(row);

        }

        tblActividades.setModel(modelo);
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
        txtBuscarEstudiante = new javax.swing.JPasswordField();
        btnBuscarAlumno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnAnadirAlumno = new javax.swing.JButton();
        btnCancelarAlumno = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarCurso = new javax.swing.JTextField();
        btnBuscarCurso = new javax.swing.JButton();
        btnCancelarTodo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarActividad = new javax.swing.JTextField();
        btnBuscarActividad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblActividades = new javax.swing.JTable();
        btnAnadirActividad = new javax.swing.JButton();
        btnCancelarActividad = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Aginar alumnos y actividades del curso");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Alumno", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Buscar por cédula:");

        btnBuscarAlumno.setText("Buscar");
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cédula", "Género"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        btnAnadirAlumno.setBackground(new java.awt.Color(51, 51, 255));
        btnAnadirAlumno.setText("Añadir");
        btnAnadirAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirAlumnoActionPerformed(evt);
            }
        });

        btnCancelarAlumno.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelarAlumno.setText("Cancelar");
        btnCancelarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(txtBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btnBuscarAlumno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnAnadirAlumno)
                        .addGap(83, 83, 83)
                        .addComponent(btnCancelarAlumno)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAlumno))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadirAlumno)
                    .addComponent(btnCancelarAlumno))
                .addGap(25, 25, 25))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Busqueda curso", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel3.setText("Buscar curso por ID:");

        txtBuscarCurso.setEditable(false);

        btnBuscarCurso.setBackground(new java.awt.Color(51, 51, 255));
        btnBuscarCurso.setText("Buscar");
        btnBuscarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCursoActionPerformed(evt);
            }
        });

        btnCancelarTodo.setText("Cancelar");
        btnCancelarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCurso)
                .addGap(33, 33, 33)
                .addComponent(btnCancelarTodo)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCurso)
                    .addComponent(btnCancelarTodo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Actividad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel2.setText("Buscar por ID:");

        btnBuscarActividad.setBackground(new java.awt.Color(51, 51, 255));
        btnBuscarActividad.setText("Buscar");
        btnBuscarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActividadActionPerformed(evt);
            }
        });

        tblActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Aplicaciones"
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
        tblActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActividadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblActividades);

        btnAnadirActividad.setBackground(new java.awt.Color(51, 51, 255));
        btnAnadirActividad.setText("Añadir");
        btnAnadirActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActividadActionPerformed(evt);
            }
        });

        btnCancelarActividad.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelarActividad.setText("Cancelar");
        btnCancelarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(txtBuscarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscarActividad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(btnAnadirActividad)
                .addGap(64, 64, 64)
                .addComponent(btnCancelarActividad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarActividad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadirActividad)
                    .addComponent(btnCancelarActividad))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCursoActionPerformed
        // TODO add your handling code here:
        curso = new Curso(Integer.valueOf((String) txtBuscarCurso.getText()));
        curso = (Curso) controladorCurso.read(curso);

        if (curso != null) {
            JOptionPane.showMessageDialog(this, "Curso encontrado con exito");
        } else {
            JOptionPane.showMessageDialog(this, "Curso no encontrado");
        }

    }//GEN-LAST:event_btnBuscarCursoActionPerformed

    private void btnBuscarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActividadActionPerformed
        // TODO add your handling code here:
        actividad = (Actividad) controladorActividad.read(new Actividad(Integer.valueOf((String) txtBuscarActividad.getText())));

        if (actividad != null) {
            llenarTablaActividadEncontrada(actividad);
        } else {
            JOptionPane.showMessageDialog(this, "Actividad no encontrado");
        }
    }//GEN-LAST:event_btnBuscarActividadActionPerformed

    private void btnAnadirActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActividadActionPerformed
        // TODO add your handling code here:
        if (curso.añadirActividad(actividad)) {
            JOptionPane.showMessageDialog(this, "Actividad añadida con exito");
            controladorCurso.update(curso, curso);
        } else {
            JOptionPane.showMessageDialog(this, "Error al añadir la actividad");
        }

    }//GEN-LAST:event_btnAnadirActividadActionPerformed

    private void tblActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActividadesMouseClicked
        // TODO add your handling code here:

        int fila = tblActividades.getSelectedRow();

        int id = (int) tblActividades.getValueAt(fila, 0);
        actividad = (Actividad) controladorActividad.read(new Actividad((id)));

    }//GEN-LAST:event_tblActividadesMouseClicked

    private void btnCancelarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActividadActionPerformed
        // TODO add your handling code here:

        txtBuscarActividad.setText("");
        llenarTablaActividades();


    }//GEN-LAST:event_btnCancelarActividadActionPerformed

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        // TODO add your handling code here:
        alumno = (Alumno) controladorAlumno.read(new Alumno(txtBuscarEstudiante.getText()));

        if (alumno != null) {
            llenarTablaAlumnoEncontrado(alumno);
        } else {
            JOptionPane.showMessageDialog(this, "Alumno no encontrado");

        }

    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void tblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMouseClicked
        // TODO add your handling code here:
        int fila = tblAlumnos.getSelectedRow();

        alumno = (Alumno) controladorAlumno.read(new Alumno((String) tblAlumnos.getValueAt(fila, 1)));


    }//GEN-LAST:event_tblAlumnosMouseClicked

    private void btnAnadirAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirAlumnoActionPerformed
        // TODO add your handling code here:
        if (curso.añadirAlumno(alumno)) {
            JOptionPane.showMessageDialog(this, "Alumno añadido con exito");
            alumno.setCurso(curso);

            curso.actualizar(alumno, alumno);
            controladorAlumno.update(alumno, alumno);

            controladorCurso.update(curso, curso);
        } else {
            JOptionPane.showMessageDialog(this, "Error al añadir al alumno");
        }
    }//GEN-LAST:event_btnAnadirAlumnoActionPerformed

    private void btnCancelarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlumnoActionPerformed
        // TODO add your handling code here:

        txtBuscarEstudiante.setText("");
        llenarTablaAlumnos();

    }//GEN-LAST:event_btnCancelarAlumnoActionPerformed

    private void btnCancelarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTodoActionPerformed
        // TODO add your handling code here:
        txtBuscarEstudiante.setText("");
        llenarTablaAlumnos();

        txtBuscarActividad.setText("");
        llenarTablaActividades();

        txtBuscarCurso.setText("");
    }//GEN-LAST:event_btnCancelarTodoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        cargarCurso();
        llenarTablaActividades();
        llenarTablaAlumnos();
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadirActividad;
    private javax.swing.JButton btnAnadirAlumno;
    private javax.swing.JButton btnBuscarActividad;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnBuscarCurso;
    private javax.swing.JButton btnCancelarActividad;
    private javax.swing.JButton btnCancelarAlumno;
    private javax.swing.JButton btnCancelarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblActividades;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtBuscarActividad;
    private javax.swing.JTextField txtBuscarCurso;
    private javax.swing.JPasswordField txtBuscarEstudiante;
    // End of variables declaration//GEN-END:variables
}
