/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author gulshaneng
 */
public class AddLibrarian extends javax.swing.JFrame {

    /**
     * Creates new form AddLibrarian
     */
    public AddLibrarian() {
        initComponents();
        this.setBounds(0, 0, 500, 410);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lName = new javax.swing.JTextField();
        lEmail = new javax.swing.JTextField();
        lAddr = new javax.swing.JTextField();
        lMob = new javax.swing.JTextField();
        lCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        add = new javax.swing.JButton();
        lPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Librarian");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel1.setText("address");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 80, -1));

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel2.setText("city");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 80, 20));

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel3.setText("Mobile number");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 140, 20));

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel4.setText("Add librarian");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 150, -1));

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 55, 80, 20));

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel6.setText("password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 95, 80, 20));
        getContentPane().add(lName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 160, -1));
        getContentPane().add(lEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 160, -1));
        getContentPane().add(lAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 160, -1));
        getContentPane().add(lMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 160, -1));
        getContentPane().add(lCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 160, -1));

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel7.setText("email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 80, -1));

        cancel.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 80, 30));

        add.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 60, 30));
        getContentPane().add(lPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
      
         try{
            Connection con = Db.getConnection();
           
            PreparedStatement ps = con.prepareStatement("insert into librarian(name,password,email,address,city,contact) "
                    + "values(?,?,?,?,?,?)");
           ps.setString(1, lName.getText());
            ps.setString(2, String.valueOf(lPass.getPassword()));
            ps.setString(3, lEmail.getText());
            ps.setString(4, lAddr.getText());
            ps.setString(5, lCity.getText());
            ps.setString(6, lMob.getText());
            int count=ps.executeUpdate();
            
            if(count !=0)
            {
                 JOptionPane.showMessageDialog(null, "Sucessfully Added Librarian ","Add Librarian", JOptionPane.OK_OPTION);
                 lName.setText("");
                 lPass.setText("");
                 lEmail.setText("");
                 lAddr.setText("");
                 lCity.setText("");
                 lMob.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Add Librarian fail !! ","Insertion Error", JOptionPane.OK_OPTION);
            }
        }catch(Exception e){
             System.out.println(e.toString());
        }
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();        
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(AddLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLibrarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddLibrarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lAddr;
    private javax.swing.JTextField lCity;
    private javax.swing.JTextField lEmail;
    private javax.swing.JTextField lMob;
    private javax.swing.JTextField lName;
    private javax.swing.JPasswordField lPass;
    // End of variables declaration//GEN-END:variables
}
