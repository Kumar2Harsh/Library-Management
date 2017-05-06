/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import java.sql.*;
import javax.swing.JOptionPane;
public class AddBook extends javax.swing.JFrame {

    public AddBook() {
        initComponents();
        this.setBounds(0, 0, 400, 350);
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
        callNo = new javax.swing.JTextField();
        bookName = new javax.swing.JTextField();
        bookAuthor = new javax.swing.JTextField();
        publisher = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel1.setText("Call No.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 36, 80, -1));

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 74, 70, -1));

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel3.setText("Author");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 112, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel4.setText("Publisher");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 150, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel5.setText("Quentity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, -1));
        getContentPane().add(callNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 36, 160, -1));
        getContentPane().add(bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 74, 160, -1));
        getContentPane().add(bookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 112, 160, -1));
        getContentPane().add(publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 150, 160, -1));
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 188, 160, -1));

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jButton2.setText("Add Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{
           Connection con = Db.getConnection();
           con.setAutoCommit(false);
           PreparedStatement ps = con.prepareStatement("insert into books(callno, name, author, publisher, quantity, added_date)"
                   + "values(?,?,?,?,?,?)");
           ps.setInt(1, Integer.parseInt(callNo.getText()));
           ps.setString(2, bookName.getText());
           ps.setString(3, bookAuthor.getText());
           ps.setString(4, publisher.getText());
           ps.setInt(5, Integer.parseInt(quantity.getText()));
           ps.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
           int status = ps.executeUpdate();
           if(status != 0)
           {
               int reply=JOptionPane.showConfirmDialog(null, "Book is inserting", "Insert", JOptionPane.OK_CANCEL_OPTION);
               if(reply == JOptionPane.OK_OPTION)
               {
                   callNo.setText("");
                   bookName.setText("");
                   bookAuthor.setText("");
                   publisher.setText("");
                   quantity.setText("");
                   con.commit();
                   con.close();
               }
               
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Insertion fail !!!", "insert", JOptionPane.OK_OPTION);
           }
       }catch(Exception e){
           System.out.println(e.toString());
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookAuthor;
    private javax.swing.JTextField bookName;
    private javax.swing.JTextField callNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField publisher;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}
