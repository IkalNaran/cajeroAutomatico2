package com.mycompany.cajeroautomatico.gui;

import com.mycompany.cajeroautomatico.logic.Consultas;

public class Operacion extends javax.swing.JFrame {
    String miCuenta;
    Consultas cuentas = new Consultas();
    
    public Operacion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Operacion(String miCuenta) {
        this.miCuenta = miCuenta;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bDepositar = new javax.swing.JButton();
        bienvenido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bRetiro = new javax.swing.JButton();
        bTranferencia = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bDepositar.setText("DEPOSITAR");
        bDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDepositarActionPerformed(evt);
            }
        });

        bienvenido.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenido.setText("Bievenido " + cuentas.name(miCuenta) + "!");
        bienvenido.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                bienvenidoComponentAdded(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cuentas con un saldo de: $" + cuentas.money(miCuenta) + " pesos");

        bRetiro.setText("RETIRO");
        bRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetiroActionPerformed(evt);
            }
        });

        bTranferencia.setText("TRANFERENCIA");
        bTranferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTranferenciaActionPerformed(evt);
            }
        });

        bSalir.setText("SALIR");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bTranferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 148, Short.MAX_VALUE))
            .addComponent(bienvenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(bienvenido)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(105, 105, 105)
                .addComponent(bTranferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bTranferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTranferenciaActionPerformed
        Transferencia op = new Transferencia(this.miCuenta); 
        op.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bTranferenciaActionPerformed

    private void bDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDepositarActionPerformed
        Depositar op = new Depositar(this.miCuenta); 
        op.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bDepositarActionPerformed

    private void bRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetiroActionPerformed
        Retiro op = new Retiro(this.miCuenta); 
        op.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bRetiroActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
       Main menu = new Main();
       menu.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_bSalirActionPerformed

    private void bienvenidoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_bienvenidoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_bienvenidoComponentAdded

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
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Operacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDepositar;
    private javax.swing.JButton bRetiro;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bTranferencia;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
