/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.consulta;

import com.clinicamer.dao.Metodos;
import com.clinicamer.logica.Combo;
import com.clinicamer.logica.Consulta;
import com.clinicamer.logica.Medico;
import com.clinicamer.logica.Paciente;
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
public class frmConsulta extends javax.swing.JInternalFrame {

    // variables para gestionar los metodos a la base de datos HUELLAS
    static Metodos logica = new Metodos();
    public int identificacion;

    /**
     * Creates new form frmConsulta
     */
    public frmConsulta() throws Exception {
        initComponents();
        this.llenarcboPaciente();
        this.llenarcboMedico();
    }

    public void llenarcboPaciente() throws NoSuchAlgorithmException, Exception {
        cboPac.removeAllItems();
        try {
            List<Paciente> l = new LinkedList<Paciente>();
            l = logica.listarPacienteNombre();
            for (int i = 0; i < l.size(); i++) {
                cboPac.addItem(new Combo(l.get(i).getIdpaciente(), l.get(i).getNombre() + " " + l.get(i).getApellido()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarcboMedico() throws NoSuchAlgorithmException, Exception {
        cboMed.removeAllItems();
        try {
            List<Medico> l = new LinkedList<Medico>();
            l = logica.listarMedicoNombre();
            for (int i = 0; i < l.size(); i++) {
                cboMed.addItem(new Combo(l.get(i).getIdmedico(), l.get(i).getNombre() + " " + l.get(i).getApellido()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
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
        cboPac = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboMed = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboTip = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDateFe = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cboEst = new javax.swing.JComboBox<>();
        btnEnviar = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        setTitle("Cita");

        jLabel1.setText("Paciente");

        jLabel2.setText("Medico");

        jLabel3.setText("Tipo");

        cboTip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina General", "Medicina Especializada", "Odontologia", "Laboratorio" }));

        jLabel4.setText("Fecha");

        jDateFe.setDateFormatString("yyyy/MM/dd");

        jLabel5.setText("Estado");
        jLabel5.setEnabled(false);

        cboEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVA", "INACTIVA", "CANCELADA" }));
        cboEst.setEnabled(false);

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

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        jLabel6.setText("Observacion");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTip, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateFe, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMed, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPac, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCan)
                    .addComponent(btnModificar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        // TODO add your handling code here:
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        try {
            Consulta c = new Consulta();

            c.setIdpaciente(cboPac.getItemAt(cboPac.getSelectedIndex()).getIdCombo());
            c.setIdmedico(cboMed.getItemAt(cboMed.getSelectedIndex()).getIdCombo());
            c.setEspecialidad(cboTip.getSelectedItem().toString());
            c.setFeconsulta(jDateFe.getDate());
            c.setObservacion(txtObs.getText());
            c.setEstado("ACTIVA");
            if (!logica.existeCita(logica.consultarPacienteId(c.getIdpaciente()).getNumeroDoc(), new java.sql.Date(c.getFeconsulta().getTime()))) {
                logica.guardarCita(c);
                JOptionPane.showMessageDialog(this, "Cita agregado correctamente", "Consulta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cita existe", "Consulta", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            Consulta c = new Consulta();

            c.setIdconsulta(identificacion);
            c.setIdpaciente(cboPac.getItemAt(cboPac.getSelectedIndex()).getIdCombo());
            c.setIdmedico(cboMed.getItemAt(cboMed.getSelectedIndex()).getIdCombo());
            c.setEspecialidad(cboTip.getSelectedItem().toString());
            c.setFeconsulta(jDateFe.getDate());
            c.setObservacion(txtObs.getText());
            c.setEstado(cboEst.getSelectedItem().toString());
            logica.modificarCita(c);
            JOptionPane.showMessageDialog(this, "Cita modificada correctamente", "Consulta", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCan;
    public javax.swing.JButton btnEnviar;
    public static javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<String> cboEst;
    public javax.swing.JComboBox<Combo> cboMed;
    public javax.swing.JComboBox<Combo> cboPac;
    public javax.swing.JComboBox<String> cboTip;
    public com.toedter.calendar.JDateChooser jDateFe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtObs;
    // End of variables declaration//GEN-END:variables

}
