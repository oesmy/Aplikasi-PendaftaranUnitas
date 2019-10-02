/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import utils.UserLogin;

/**
 *
 * @author asus
 */
public class SignIn extends javax.swing.JFrame {
        private Connection conn = new Koneksi().connect();
 
    public SignIn() {
        initComponents();
        setTitle("Hy, Welcome to Aplikasi Unitas TI !");
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    protected void kosong(){
        txtusername.setText("");
        txtpassword.setText("");
        txtusername.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        signup = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnSignin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signup.setBackground(new java.awt.Color(255, 255, 255));
        signup.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        signup.setForeground(new java.awt.Color(0, 204, 255));
        signup.setText("SIGNUP ?");
        signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        jPanel1.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 60, 20));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 140, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 140, 30));

        btnSignin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btnSignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btn_signin.png"))); // NOI18N
        jPanel1.add(btnSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg_login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM bakordik WHERE username='" + txtusername.getText() + "' and password ='" + txtpassword.getText() + "'";
            ResultSet res = stat.executeQuery(sql);

            if (res.next()) {
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                UserLogin.setUserLogin(txtusername.getText());
                new Dashboard().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau Password Salah!");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error : " + err);
        }
        kosong();
    
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        new SignUp().setVisible(true);
        dispose();
    }//GEN-LAST:event_signupMouseClicked

    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt){
        try{
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM admin WHERE username='"+ txtusername.getText() + "' and password ='" + txtpassword.getText() + "'";
            ResultSet res = stat.executeQuery(sql);
            
            if (res.next()){
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                UserLogin.setUserLogin(txtusername.getText());
                new Dashboard().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau Password Salah !");
            }
        } catch (Exception err){
            JOptionPane.showMessageDialog(null, "Error : " + err);
        }
        kosong();
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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }
    
//    
//    java.awt.EventQueue.invokeLater(new Runnable(){
//        public void run(){
//            new SignIn().setVisible(true);
//        }
//    })

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSignin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel signup;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
