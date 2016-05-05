/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import db.mysql;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillermo
 */
public class interfaz extends javax.swing.JFrame {

    /**
     * Creates new form interfaz
     */
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    
    public interfaz() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        conn = mysql.getConnect();
        deshabilitarCajas();
        datosTabla();
        limpiarCajas();
    }
    void deshabilitarCajas(){
        cNombre.setEnabled(false);
        cApellidos.setEnabled(false);
        cCargo.setEnabled(false);
        cDireccion.setEnabled(false);
        cTelefono.setEnabled(false);
        cCorreo.setEnabled(false);
        cJefe.setEnabled(false);
    }
    void limpiarCajas(){
        cNombre.setText("");
        cApellidos.setText("");
        cCargo.setText("");
        cDireccion.setText("");
        cTelefono.setText("");
        cCorreo.setText("");
        cJefe.setText("");
    }
    void reiniciarBotones(){
        bNuevo.setEnabled(true);
        bActualizar.setEnabled(false);
        bEliminar.setEnabled(false);
        bEditar.setEnabled(false);
        bGuardar.setEnabled(false);
        bCancelar.setEnabled(false);
    }
    void comenzarNuevo(){
        bNuevo.setEnabled(false);
        bActualizar.setEnabled(false);
        bEliminar.setEnabled(false);
        bEditar.setEnabled(false);
        bGuardar.setEnabled(true);
        bCancelar.setEnabled(true);
    }
    void editarRegistro(){
        bNuevo.setEnabled(false);
        bActualizar.setEnabled(true);
        bEliminar.setEnabled(false);
        bEditar.setEnabled(false);
        bGuardar.setEnabled(false);
        bCancelar.setEnabled(true);
    }
    void habilitarCajas(){
        cNombre.setEnabled(true);
        cApellidos.setEnabled(true);
        cCargo.setEnabled(true);
        cDireccion.setEnabled(true);
        cTelefono.setEnabled(true);
        cCorreo.setEnabled(true);
        cJefe.setEnabled(true);
        cNombre.requestFocus();
    }
    void datosTabla(){
        try{
        String[] titulos = {"ID","Nombre","Apellidos","Cargo","Jefe Inmediato","Dirección","Teléfono","E-Mail"};
        String SQL = "SELECT * FROM contactos";
        model = new DefaultTableModel(null,titulos);
        sent = conn.createStatement();
        ResultSet rs = sent.executeQuery(SQL);
        String[]fila = new String[8];
        while(rs.next()){
            fila[0] = rs.getString("ID");
            fila[1] = rs.getString("Nombre");
            fila[2] = rs.getString("Apellidos");
            fila[3] = rs.getString("Cargo");
            fila[4] = rs.getString("JefeInmediato");
            fila[5] = rs.getString("Direccion");
            fila[6] = rs.getString("Telefono");
            fila[7] = rs.getString("Correo");
            model.addRow(fila);
        }
        jTable1.setModel(model);
        }catch(Exception e){
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bNuevo = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cApellidos = new javax.swing.JTextField();
        cCargo = new javax.swing.JTextField();
        cJefe = new javax.swing.JTextField();
        cTelefono = new javax.swing.JTextField();
        cCorreo = new javax.swing.JTextField();
        cDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGENDA");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Kartika", 1, 24)); // NOI18N
        jLabel1.setText("AGENDA");

        bNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-icono-5633-16.png"))); // NOI18N
        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar-borrar-la-salida-icono-8537-16.png"))); // NOI18N
        bEliminar.setText("Eliminar");
        bEliminar.setEnabled(false);
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/garrapata-icono-8022-16.png"))); // NOI18N
        bActualizar.setText("Actualizar");
        bActualizar.setEnabled(false);
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos Personales:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel4.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel6.setText("Cargo:");

        jLabel7.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel7.setText("Jefe Inmediato:");

        jLabel8.setFont(new java.awt.Font("Euphemia", 0, 14)); // NOI18N
        jLabel8.setText("E-Mail:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(66, 66, 66)
                                .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(35, 35, 35)
                                .addComponent(cDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cTelefono)
                                    .addComponent(cCorreo)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20)
                        .addComponent(cJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excepto-icono-9554-16.png"))); // NOI18N
        bGuardar.setText("Guardar");
        bGuardar.setEnabled(false);
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar-edicion-icono-4630-16.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.setEnabled(false);
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar-una-pluma-para-escribir-icono-8707-16.png"))); // NOI18N
        bEditar.setText("Editar");
        bEditar.setEnabled(false);
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar-borrar-la-salida-icono-8537-16.png"))); // NOI18N
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(bEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(bEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(bGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(bCancelar))
                    .addComponent(jScrollPane1))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        // TODO add your handling code here:
                try {
        String SQL = "UPDATE contactos SET Nombre=?, Apellidos=?, Cargo=?, JefeInmediato=?, Direccion=?, Telefono=?, Correo=?" 
                + "WHERE ID=?";
        
            int fila = jTable1.getSelectedRow();
            String dato = (String)jTable1.getValueAt(fila, 0);
            
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1,cNombre.getText());
            pst.setString(2,cApellidos.getText());
            pst.setString(3,cCargo.getText());
            pst.setString(4,cJefe.getText());
            pst.setString(5,cDireccion.getText());
            pst.setString(6,cTelefono.getText());
            pst.setString(7,cCorreo.getText());
            pst.setString(8,dato);
            
            int n = pst.executeUpdate();
            if(n > 0)
                datosTabla();
                limpiarCajas();
                deshabilitarCajas();
                reiniciarBotones();
                JOptionPane.showMessageDialog(null,"Datos actualizados correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error: " + e);
        }
    }//GEN-LAST:event_bActualizarActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        // TODO add your handling code here:
        habilitarCajas();
        limpiarCajas();
        comenzarNuevo();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        // TODO add your handling code here:
        try {
        String SQL = "INSERT INTO contactos(Nombre, Apellido, Cargo, JefeInmediato, Direccion, Telefono, Correo)" 
                + "VALUES (?,?,?,?,?,?,?)";
        
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1,cNombre.getText());
            pst.setString(2,cApellidos.getText());
            pst.setString(3,cCargo.getText());
            pst.setString(4,cJefe.getText());
            pst.setString(5,cDireccion.getText());
            pst.setString(6,cTelefono.getText());
            pst.setString(7,cCorreo.getText());
            
            int n = pst.executeUpdate();
            if(n > 0)
                datosTabla();
                limpiarCajas();
                deshabilitarCajas();
                reiniciarBotones();
                JOptionPane.showMessageDialog(null,"Datos guardados correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error: " + e);
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getButton() == 1){
            bEditar.setEnabled(true);
            bEliminar.setEnabled(true);
            int fila = jTable1.getSelectedRow();
            try{
                String SQL = "SELECT * FROM contactos WHERE ID=" + jTable1.getValueAt(fila,0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(SQL);
                rs.next();
                cNombre.setText(rs.getString("Nombre"));
                cApellidos.setText(rs.getString("Apellidos"));
                cCargo.setText(rs.getString("Cargo"));
                cJefe.setText(rs.getString("JefeInmediato"));
                cDireccion.setText(rs.getString("Direccion"));
                cTelefono.setText(rs.getString("Telefono"));
                cCorreo.setText(rs.getString("Correo"));
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCajas();
        deshabilitarCajas();
        reiniciarBotones();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        int i = JOptionPane.showConfirmDialog(this,"¿Desea eliminar el registro con el ID " + jTable1.getValueAt(fila,0) + "?" ,"Confirmar",JOptionPane.YES_NO_OPTION);
        if(i == 0)
        {
            try{
                String SQL = "DELETE FROM contactos WHERE ID=" + jTable1.getValueAt(fila,0);
                sent = conn.createStatement();
                int n = sent.executeUpdate(SQL);
                if(n > 0){
                    datosTabla();
                    limpiarCajas();
                    deshabilitarCajas();
                    reiniciarBotones();
                    JOptionPane.showMessageDialog(null,"El registro se ha eliminado correctamente");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        // TODO add your handling code here:
        habilitarCajas();
        editarRegistro();
    }//GEN-LAST:event_bEditarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed
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
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSalir;
    private javax.swing.JTextField cApellidos;
    private javax.swing.JTextField cCargo;
    private javax.swing.JTextField cCorreo;
    private javax.swing.JTextField cDireccion;
    private javax.swing.JTextField cJefe;
    private javax.swing.JTextField cNombre;
    private javax.swing.JTextField cTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
