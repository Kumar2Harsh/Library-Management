/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author gulshaneng
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        this.setBounds(0, 0, 444, 350);
        addLibraian.setVerticalTextPosition(SwingConstants.BOTTOM);
        addLibraian.setHorizontalTextPosition(SwingConstants.CENTER);
        addLibraian.setOpaque(false);
        addLibraian.setContentAreaFilled(false);
        addLibraian.setBorderPainted(false);
        viewLibraian.setVerticalTextPosition(SwingConstants.BOTTOM);
        viewLibraian.setHorizontalTextPosition(SwingConstants.CENTER);
        viewLibraian.setOpaque(false);
        viewLibraian.setContentAreaFilled(false);
        viewLibraian.setBorderPainted(false);
        logOut.setVerticalTextPosition(SwingConstants.BOTTOM);
        logOut.setHorizontalTextPosition(SwingConstants.CENTER);
        logOut.setOpaque(false);
        logOut.setContentAreaFilled(false);
        logOut.setBorderPainted(false);
        
        deleteLibraian.setVerticalTextPosition(SwingConstants.BOTTOM);
        deleteLibraian.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteLibraian.setOpaque(false);
        deleteLibraian.setContentAreaFilled(false);
        deleteLibraian.setBorderPainted(false);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logOut = new javax.swing.JButton();
        addLibraian = new javax.swing.JButton();
        viewLibraian = new javax.swing.JButton();
        deleteLibraian = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOut.setFont(new java.awt.Font("Tekton Pro", 0, 16)); // NOI18N
        logOut.setIcon(new javax.swing.ImageIcon("D:\\Java\\Library Management\\Button image\\1492972917_exit.png")); // NOI18N
        logOut.setText("Log out");
        logOut.setToolTipText("Log out");
        logOut.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        getContentPane().add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 120, 70));

        addLibraian.setFont(new java.awt.Font("Tekton Pro", 0, 16)); // NOI18N
        addLibraian.setIcon(new javax.swing.ImageIcon("D:\\Java\\Library Management\\Button image\\add-librarian.png")); // NOI18N
        addLibraian.setText("Add Libraian");
        addLibraian.setToolTipText("Add Libraian");
        addLibraian.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        addLibraian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLibraianActionPerformed(evt);
            }
        });
        getContentPane().add(addLibraian, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 130, 90));

        viewLibraian.setFont(new java.awt.Font("Tekton Pro", 0, 16)); // NOI18N
        viewLibraian.setIcon(new javax.swing.ImageIcon("D:\\Java\\Library Management\\Button image\\1492977951_gwenview.png")); // NOI18N
        viewLibraian.setText("View Libraian");
        viewLibraian.setToolTipText("View Libraian");
        viewLibraian.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        viewLibraian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLibraianActionPerformed(evt);
            }
        });
        getContentPane().add(viewLibraian, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 120, 90));

        deleteLibraian.setFont(new java.awt.Font("Tekton Pro", 0, 16)); // NOI18N
        deleteLibraian.setIcon(new javax.swing.ImageIcon("D:\\Java\\Library Management\\Button image\\delete-user.png")); // NOI18N
        deleteLibraian.setText("Delete Libraian");
        deleteLibraian.setToolTipText("Delete Libraian");
        deleteLibraian.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        deleteLibraian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLibraianActionPerformed(evt);
            }
        });
        getContentPane().add(deleteLibraian, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, 70));

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel1.setText("Admin Section");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        JOptionPane.showMessageDialog(null, "Are You Sure !","Log out", JOptionPane.ERROR_MESSAGE);
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void addLibraianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLibraianActionPerformed
        AddLibrarian addLibrarian = new AddLibrarian();
        addLibrarian.setVisible(true);
        
    }//GEN-LAST:event_addLibraianActionPerformed

    private void viewLibraianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLibraianActionPerformed
       ViewLibrarian viewLibrarian = new ViewLibrarian();
       viewLibrarian.setVisible(true);
    }//GEN-LAST:event_viewLibraianActionPerformed

    private void deleteLibraianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLibraianActionPerformed
        DeleteLibrarian deleteLibrarian = new DeleteLibrarian();
        deleteLibrarian.setVisible(true);
    }//GEN-LAST:event_deleteLibraianActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLibraian;
    private javax.swing.JButton deleteLibraian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOut;
    private javax.swing.JButton viewLibraian;
    // End of variables declaration//GEN-END:variables
}