/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import ups.edu.ec.controlador.ControladorMatrimonio;
import ups.edu.ec.controlador.ControladorPersona;
import ups.edu.ec.modelo.Conyuge;
import ups.edu.ec.modelo.Direccion;
import ups.edu.ec.modelo.Juez;
import ups.edu.ec.modelo.Matrimonio;
import ups.edu.ec.modelo.Testigo;

/**
 *
 * @author User
 */
public class VentanaJuez extends javax.swing.JInternalFrame {

    private ControladorPersona controladorPersona;
    private ControladorMatrimonio controladorMatrimonio;

    private Juez juez;

    private Conyuge conyuge1;
    private Conyuge conyuge2;

    private Testigo testigo1;
    private Testigo testigo2;

    private VentanaCrearMatrimonio ventanaCrearMatrimonio;
    private VentanaTestigos ventanaTestigos;

    /**
     * Creates new form VentanaJuez
     */
    public VentanaJuez(ControladorPersona controladorPersona, ControladorMatrimonio controladorMatrimonio) {
        initComponents();

        this.controladorMatrimonio = controladorMatrimonio;
        this.controladorPersona = controladorPersona;

    }

    public void setVentanaCrearMatrimonio(VentanaCrearMatrimonio ventanaCrearMatrimonio) {
        this.ventanaCrearMatrimonio = ventanaCrearMatrimonio;
    }

    public void setVentanaTestigos(VentanaTestigos ventanaTestigos) {
        this.ventanaTestigos = ventanaTestigos;
    }

    public Juez getJuez() {
        return juez;
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
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtFormattedCedula = new javax.swing.JFormattedTextField();
        dateChooser = new rojeru_san.rsdate.RSDateChooser();
        cbxGenero = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCalle1 = new javax.swing.JTextField();
        txtCalle2 = new javax.swing.JTextField();
        txtFormattedNumero = new javax.swing.JFormattedTextField();
        btnFinalizar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Crear Matrimonio - Juez");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nombre(s):");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Cédula:");

        jLabel4.setText("Fecha de nacimiento:");

        jLabel5.setText("Género:");

        try {
            txtFormattedCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--", "Masculino", "Femenino" }));

        jLabel9.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(txtFormattedCedula)
                    .addComponent(txtApellido1)
                    .addComponent(txtNombre)
                    .addComponent(cbxGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFormattedCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Dirección", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel6.setText("Calle # 1:");

        jLabel7.setText("Calle # 2:");

        jLabel8.setText("Número: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCalle1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txtCalle2)
                    .addComponent(txtFormattedNumero))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCalle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFormattedNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnFinalizar.setBackground(new java.awt.Color(51, 51, 255));
        btnFinalizar.setForeground(new java.awt.Color(0, 0, 0));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:

        String nombre = txtNombre.getText();
        String apellido = txtApellido1.getText();
        String cedula = txtFormattedCedula.getText();
        Date fechaNacimiento = dateChooser.getDatoFecha();
        String genero = (String) cbxGenero.getSelectedItem();
        String email = txtEmail.getText();

        String calle1 = txtCalle1.getText();
        String calle2 = txtCalle2.getText();
        String numeroCalle = txtFormattedNumero.getText();

        if (nombre.isBlank() || apellido.isBlank() || cedula.isBlank() || fechaNacimiento == null || genero.equals("--Seleccione--")
                || email.isBlank() || calle1.isBlank() || calle2.isBlank() || numeroCalle.isBlank()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Direccion direccion = new Direccion(calle1, calle2, numeroCalle);

            juez = new Juez(controladorPersona.generarID(), nombre, apellido,
                    cedula, genero, direccion, fechaNacimiento);

            limpiar();
            this.hide();
            JOptionPane.showMessageDialog(this, "Mtrimonio creado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            guardarDatos();

            /*
            if (controladorPersona.create(admin)) {
                JOptionPane.showMessageDialog(this, "Administrador creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Administrador ya existente", "Error", JOptionPane.ERROR_MESSAGE);
            }*/
        }


    }//GEN-LAST:event_btnFinalizarActionPerformed

    public void limpiar() {
        txtNombre.setText("");
        txtApellido1.setText("");
        txtFormattedCedula.setValue("");
        dateChooser.setDatoFecha(new Date());
        cbxGenero.setSelectedIndex(0);
        txtEmail.setText("");

        txtCalle1.setText("");
        txtCalle2.setText("");
        txtFormattedNumero.setValue("");
    }

    public void guardarDatos() {

        conyuge1 = ventanaCrearMatrimonio.getConyuge1();
        conyuge2 = ventanaCrearMatrimonio.getConyuge2();

        List<Conyuge> listaConyuges = new ArrayList<>();

        testigo1 = ventanaTestigos.getTestigo1();
        testigo2 = ventanaTestigos.getTestigo2();

        List<Testigo> listaTestigo = new ArrayList<>();

        Matrimonio matrimonio = new Matrimonio(controladorMatrimonio.generarID(),
                listaConyuges, listaTestigo, this.juez, new Date());

        conyuge1.setMatrimonio(matrimonio);
        conyuge2.setMatrimonio(matrimonio);
        listaConyuges.add(conyuge1);
        listaConyuges.add(conyuge2);
        controladorPersona.create(this.conyuge1);
        controladorPersona.create(this.conyuge2);

        testigo1.añadirMatrimonio(matrimonio);
        testigo2.añadirMatrimonio(matrimonio);
        listaTestigo.add(testigo1);
        listaTestigo.add(testigo2);
        controladorPersona.create(this.testigo1);
        controladorPersona.create(this.testigo2);

        matrimonio.setListaTestigo(listaTestigo);
        matrimonio.setListaConyuges(listaConyuges);
        controladorMatrimonio.create(matrimonio);

        System.out.println(matrimonio);
        //System.out.println(controladorMatrimonio.getListaGenerica());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox<String> cbxGenero;
    private rojeru_san.rsdate.RSDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtCalle1;
    private javax.swing.JTextField txtCalle2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtFormattedCedula;
    private javax.swing.JFormattedTextField txtFormattedNumero;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
