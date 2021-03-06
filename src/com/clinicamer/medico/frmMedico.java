/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.medico;

import com.clinicamer.dao.Metodos;
import com.clinicamer.logica.Medico;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Bermudez
 */
public class frmMedico extends javax.swing.JInternalFrame {
    
    // variables para gestionar los metodos a la base de datos HUELLAS
    static Metodos logica = new Metodos();
    
    /**
     * Creates new form frmMedico
     */
    public frmMedico() {
        initComponents();
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
        txtNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        txtIde = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTarj = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboEsp = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboEst = new javax.swing.JComboBox<>();
        btnEnviar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();

        setTitle("Medico");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel5.setText("Tipo");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de Cuidadania", "Tarjeta Identidad", "Nit", "Pasaporte", "Cedula Extranjera", " " }));

        jLabel4.setText("Identificacion");

        jLabel3.setText("Tarjeta Profesional");

        jLabel6.setText("Especialidad");

        cboEsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina General", "Medicina Familiar", "Medicina Interna", "Medico Rehabilitador", "Ginecologia", "Obstetricia", "Fisiotereapia", "Enfermeria", "Urologia", "Traumologia", "Pediatria", "Odontologia", "Psicologia", "Dermatologia Clinica", "Dermatologia Estetica", " " }));

        jLabel9.setText("Estado");
        jLabel9.setEnabled(false);

        cboEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        cboEst.setEnabled(false);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtApe))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTarj))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboEsp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboEst, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTipo, 0, 162, Short.MAX_VALUE)
                            .addComponent(txtIde)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTarj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCan)
                    .addComponent(btnModificar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        try {
            Medico m = new Medico();

            m.setNombre( txtNom.getText() );
            m.setApellido( txtApe.getText() );
            m.setTipoDoc( cboTipo.getSelectedItem().toString() );
            m.setNumeroDoc( Integer.parseInt( txtIde.getText() ) );
            m.setNumeroMed( Integer.parseInt( txtTarj.getText() ) );
            m.setIdespecialidad( cboEsp.getSelectedItem().toString() );
            m.setEstado("ACTIVO");
            if (!logica.existeMedico(m.getNumeroDoc())) {
                logica.guardarMedico(m);
                JOptionPane.showMessageDialog(this, "Medico agregado correctamente", "Paciente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Medico existe", "Medico", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            Medico m = new Medico();

            m.setNombre( txtNom.getText() );
            m.setApellido( txtApe.getText() );
            m.setTipoDoc( cboTipo.getSelectedItem().toString() );
            m.setNumeroDoc( Integer.parseInt(txtIde.getText()) );
            m.setNumeroMed( Integer.parseInt( txtTarj.getText() ) );
            m.setIdespecialidad( cboEsp.getSelectedItem().toString() );
            m.setEstado( cboEst.getSelectedItem().toString() );
            logica.modificarMedico(m);
            JOptionPane.showMessageDialog(this, "Medico modificado correctamente", "Medico", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(frmMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(frmMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        // TODO add your handling code here:
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_btnCanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCan;
    public static javax.swing.JButton btnEnviar;
    public static javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<String> cboEsp;
    public javax.swing.JComboBox<String> cboEst;
    public javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtApe;
    public javax.swing.JTextField txtIde;
    public javax.swing.JTextField txtNom;
    public javax.swing.JTextField txtTarj;
    // End of variables declaration//GEN-END:variables
}
