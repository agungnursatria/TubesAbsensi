/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Agung Nursatria
 */
public class UbahPassword extends javax.swing.JFrame {

    /**
     * Creates new form UbahPassword
     */
    public UbahPassword() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSubmitUbahPassword = new javax.swing.JPanel();
        jbtnSubmit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        txtPassLama = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtPassBaru = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ubah Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 190, -1));

        btnSubmitUbahPassword.setBackground(new java.awt.Color(0, 134, 112));
        btnSubmitUbahPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitUbahPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitUbahPasswordMouseExited(evt);
            }
        });

        jbtnSubmit.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jbtnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSubmit.setText("Submit");
        jbtnSubmit.setBorderPainted(false);
        jbtnSubmit.setContentAreaFilled(false);
        jbtnSubmit.setFocusPainted(false);
        jbtnSubmit.setMargin(new java.awt.Insets(0, 10, 2, 14));
        jbtnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnSubmitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSubmitUbahPasswordLayout = new javax.swing.GroupLayout(btnSubmitUbahPassword);
        btnSubmitUbahPassword.setLayout(btnSubmitUbahPasswordLayout);
        btnSubmitUbahPasswordLayout.setHorizontalGroup(
            btnSubmitUbahPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtnSubmit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        btnSubmitUbahPasswordLayout.setVerticalGroup(
            btnSubmitUbahPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(btnSubmitUbahPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        jPanel2.setBackground(new java.awt.Color(9, 83, 74));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 300, -1));

        exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        txtPassLama.setBackground(jPanel1.getBackground());
        txtPassLama.setForeground(new java.awt.Color(255, 255, 255));
        txtPassLama.setText("Password Lama");
        txtPassLama.setBorder(null);
        txtPassLama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassLamaMouseClicked(evt);
            }
        });
        jPanel1.add(txtPassLama, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 115, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 195, 10));

        txtPassBaru.setBackground(jPanel1.getBackground());
        txtPassBaru.setForeground(new java.awt.Color(255, 255, 255));
        txtPassBaru.setText("Password Baru");
        txtPassBaru.setBorder(null);
        txtPassBaru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassBaruMouseClicked(evt);
            }
        });
        jPanel1.add(txtPassBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 115, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 195, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitUbahPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitUbahPasswordMouseEntered
        btnSubmitUbahPassword.setBackground(new Color(0,171,143));
    }//GEN-LAST:event_btnSubmitUbahPasswordMouseEntered

    private void btnSubmitUbahPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitUbahPasswordMouseExited
        btnSubmitUbahPassword.setBackground(new Color(0,134,112));
    }//GEN-LAST:event_btnSubmitUbahPasswordMouseExited

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_exitMouseClicked

    private void txtPassLamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassLamaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassLamaMouseClicked

    private void txtPassBaruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassBaruMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassBaruMouseClicked

    private void jbtnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSubmitMouseEntered
        btnSubmitUbahPassword.setBackground(new Color(0,171,143));
    }//GEN-LAST:event_jbtnSubmitMouseEntered

    private void jbtnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSubmitMouseExited
        btnSubmitUbahPassword.setBackground(new Color(0,134,112));
    }//GEN-LAST:event_jbtnSubmitMouseExited

    public JButton getJbtnSubmit() {
        return jbtnSubmit;
    }

    public JTextField getTxtPassBaru() {
        return txtPassBaru;
    }

    public JTextField getTxtPassLama() {
        return txtPassLama;
    }
    
    public void Reset(){
        txtPassLama.setText("Password Lama");
        txtPassBaru.setText("Password Baru");
    }

    public void addActionListener(ActionListener e){
        jbtnSubmit.addActionListener(e);
    }
    
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
            java.util.logging.Logger.getLogger(UbahPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UbahPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UbahPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UbahPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UbahPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSubmitUbahPassword;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton jbtnSubmit;
    private javax.swing.JTextField txtPassBaru;
    private javax.swing.JTextField txtPassLama;
    // End of variables declaration//GEN-END:variables
}
