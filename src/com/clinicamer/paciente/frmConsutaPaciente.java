/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.paciente;

import com.clinicamer.dao.Metodos;
import com.clinicamer.logica.Paciente;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static clinicamer.principal.jDesktopPane;
        

/**
 *
 * @author Jorge Bermudez
 */
public class frmConsutaPaciente extends javax.swing.JInternalFrame {
    
     // variables para gestionar los metodos a la base de datos HUELLAS
    static Metodos logica = new Metodos();
    
    /**
     * Creates new form frmConsutaPaciente
     */
    public frmConsutaPaciente() {
        initComponents();
    }
    
    // metodo para reiniciar tabla
    public void reiniciarJTable(javax.swing.JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        TableColumnModel modCol = Tabla.getColumnModel();
        while (modCol.getColumnCount() > 0) {
            modCol.removeColumn(modCol.getColumn(0));
        }
        txtBusqueda.setText(""); // limpar caja de texto
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
        txtBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblBusqPaciente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnLim = new javax.swing.JButton();
        btnCer = new javax.swing.JButton();

        setTitle("Paciente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Escriba su busqueda");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar por");

        cboBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Nombre", "Apellidos", "Todos" }));

        jtblBusqPaciente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtblBusqPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblBusqPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBusqPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblBusqPaciente);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Resultado");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnLim.setText("Limpiar");
        btnLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimActionPerformed(evt);
            }
        });

        btnCer.setText("Cerrar");
        btnCer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCer)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnLim)
                    .addComponent(btnCer))
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void jtblBusqPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblBusqPacienteMouseClicked
        // TODO add your handling code here:
        try {
           int seleccionfila = jtblBusqPaciente.rowAtPoint(evt.getPoint()); // obtenemos la posicion
            String identificacion = String.valueOf(jtblBusqPaciente.getValueAt(seleccionfila, 0));
            Paciente p = logica.consultarPaciente( identificacion );
            
            frmPaciente frmpaciente = new frmPaciente();
            frmpaciente.txtNom.setText( p.getNombre() );
            frmpaciente.txtApe.setText( p.getApellido() );
            frmpaciente.cboSex.setSelectedItem( p.getSexo() );
            frmpaciente.cboSan.setSelectedItem( p.getTipoSangre() );
            frmpaciente.cboTipo.setSelectedItem( p.getTipoDoc() );
            frmpaciente.txtIde.setText( String.valueOf( p.getNumeroDoc() ) );
            frmpaciente.txtEps.setText( p.getEps() );
            frmpaciente.txtPeso.setText( String.valueOf( p.getPeso() ) );
            
            frmpaciente.cboTipo.setEnabled(false);
            frmpaciente.txtIde.setEnabled(false);
            frmpaciente.btnEnviar.setEnabled(false);
            frmpaciente.btnModificar.setEnabled(true);
            frmpaciente.jLabel9.setEnabled(true);
            frmpaciente.cboEst.setEnabled(true);
            
            int x = (jDesktopPane.getWidth() / 2) - frmpaciente.getWidth() / 2;
            int y = (jDesktopPane.getHeight() / 2) - frmpaciente.getHeight() / 2;
            frmpaciente.setLocation(x, y);
            jDesktopPane.add(frmpaciente);
            frmpaciente.show();
            
        } catch (SQLException ex) {
            Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jtblBusqPacienteMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        List l = new LinkedList();

        String busqueda = (String) cboBuscar.getSelectedItem();
        //System.out.println("busqueda "+busqueda);
        switch (busqueda) {
            case "Cedula":
                try {
                    l.clear(); // limpiamos el listado
                    l = logica.consultarPacientes( txtBusqueda.getText().toUpperCase());
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqPaciente.setModel(modelo);
                    modelo.addColumn("Cedula");
                    modelo.addColumn("Nombres");
                    modelo.addColumn("Apellidos");
                    modelo.addColumn("Eps");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.                         
                        Paciente p = (Paciente) l.get(i);
                        //fila[i] = l.get(i);
                        modelo.setValueAt(p.getNumeroDoc(), i, 0);
                        modelo.setValueAt(p.getNombre(), i, 1);
                        modelo.setValueAt(p.getApellido(), i, 2);
                        modelo.setValueAt(p.getEps(), i, 3);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Nombre":
                try {
                    l.clear(); // limpiamos el listado
                    l = logica.consultarPacienteNombre(txtBusqueda.getText().toUpperCase());
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqPaciente.setModel(modelo);
                    modelo.addColumn("Cedula");
                    modelo.addColumn("Nombres");
                    modelo.addColumn("Apellidos");
                    modelo.addColumn("Eps");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.                         
                        Paciente p = (Paciente) l.get(i);
                        //fila[i] = l.get(i);
                        modelo.setValueAt(p.getNumeroDoc(), i, 0);
                        modelo.setValueAt(p.getNombre(), i, 1);
                        modelo.setValueAt(p.getApellido(), i, 2);
                        modelo.setValueAt(p.getEps(), i, 3);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Apellidos":
                try {
                    l.clear(); // limpiamos el listado
                    l = logica.consultarPacienteApellido(txtBusqueda.getText().toUpperCase());
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqPaciente.setModel(modelo);
                    modelo.addColumn("Cedula");
                    modelo.addColumn("Nombres");
                    modelo.addColumn("Apellidos");
                    modelo.addColumn("Eps");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.                         
                        Paciente p = (Paciente) l.get(i);
                        //fila[i] = l.get(i);
                       modelo.setValueAt(p.getNumeroDoc(), i, 0);
                        modelo.setValueAt(p.getNombre(), i, 1);
                        modelo.setValueAt(p.getApellido(), i, 2);
                        modelo.setValueAt(p.getEps(), i, 3);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Todos":
                try {
                    l.clear(); // limpiamos el listado
                    l = logica.listarTodosPacientes();
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqPaciente.setModel(modelo);
                    modelo.addColumn("Cedula");
                    modelo.addColumn("Nombres");
                    modelo.addColumn("Apellidos");
                    modelo.addColumn("Eps");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.                         
                        Paciente p = (Paciente) l.get(i);
                        //fila[i] = l.get(i);
                        modelo.setValueAt(p.getNumeroDoc(), i, 0);
                        modelo.setValueAt(p.getNombre(), i, 1);
                        modelo.setValueAt(p.getApellido(), i, 2);
                        modelo.setValueAt(p.getEps(), i, 3);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsutaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                jLabel3.setText("Resultado");
                throw new IllegalArgumentException(":: Error de aplicacion ::" + busqueda);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimActionPerformed
        // TODO add your handling code here:
         this.reiniciarJTable(jtblBusqPaciente); // Limpiar tabla
        jLabel3.setText("Resultado");
    }//GEN-LAST:event_btnLimActionPerformed

    private void btnCerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerActionPerformed
        // TODO add your handling code here:
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_btnCerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCer;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLim;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblBusqPaciente;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
