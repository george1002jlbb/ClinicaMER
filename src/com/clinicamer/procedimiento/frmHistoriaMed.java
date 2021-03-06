/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.procedimiento;

import com.clinicamer.logica.Combo;
import com.clinicamer.logica.Historia;
import com.clinicamer.logica.HistoriaMed;
import com.clinicamer.logica.Medicamento;
import static com.clinicamer.procedimiento.frmCirugia.logica;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Bermudez
 */
public class frmHistoriaMed extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmHistoriaMed
     */
    public frmHistoriaMed() throws Exception {
        initComponents();
        this.llenarcboHistoria();
        this.llenarcboMedicamento();
    }
    
    public void llenarcboHistoria() throws NoSuchAlgorithmException, Exception {
        cboHis.removeAllItems();
        try {
            List<Historia> l = new LinkedList<Historia>();
            l = logica.listarTodosHistoria();
            for (int i = 0; i < l.size(); i++) {
                cboHis.addItem(new Combo(l.get(i).getIdhistoria(), logica.consultarPacienteId(l.get(i).getIdpaciente()).getNombre() + " " + logica.consultarPacienteId(l.get(i).getIdpaciente()).getApellido()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHistoriaMed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmHistoriaMed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarcboMedicamento() throws NoSuchAlgorithmException, Exception {
        cboMedi.removeAllItems();
        try {
            List<Medicamento> l = new LinkedList<Medicamento>();
            l = logica.consultarTodosMedicamento();
            for (int i = 0; i < l.size(); i++) {
                cboMedi.addItem(new Combo(l.get(i).getIdmedicamento(), l.get(i).getNombre()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHistoriaMed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmHistoriaMed.class.getName()).log(Level.SEVERE, null, ex);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboHis = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboMedi = new javax.swing.JComboBox<>();
        btnEnviar = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setTitle("Agregar Medicamento");

        jLabel1.setText("Historia");

        jLabel2.setText("Medicamento");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnCan.setText("Cerrar");
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboHis, 0, 180, Short.MAX_VALUE)
                            .addComponent(cboMedi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cboMedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCan))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        try {
            HistoriaMed hm = new HistoriaMed();

            hm.setIdmedicamento(cboMedi.getItemAt(cboMedi.getSelectedIndex()).getIdCombo());
            hm.setIdhistoria(cboHis.getItemAt(cboHis.getSelectedIndex()).getIdCombo());

            logica.guardarHistoriaMed(hm);
            JOptionPane.showMessageDialog(this, "Medicamento agregado correctamente", "Cirugia", JOptionPane.INFORMATION_MESSAGE);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmCirugia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmCirugia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        // TODO add your handling code here:
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_btnCanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCan;
    public static javax.swing.JButton btnEnviar;
    public javax.swing.JComboBox<Combo> cboHis;
    private javax.swing.JComboBox<Combo> cboMedi;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
