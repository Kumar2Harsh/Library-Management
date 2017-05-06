/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import java.sql.*;
import javax.swing.*;
public class IssueBook extends javax.swing.JFrame {
static int issued,quantity;
  public int updateIssuedBook()
  {
      Connection con = Db.getConnection();
      int status = 0;
       quantity = checkQuentity();
      if(quantity>0)
      {
          try{
            PreparedStatement ps = con.prepareStatement("update books set quantity=?,issued=? where callno=?");
            ps.setInt(1, quantity-1);
            ps.setInt(2, issued+1);
            ps.setString(3, bookCallNo.getText());
            status=ps.executeUpdate();
          }catch(Exception e){
              System.out.println(e.toString());
          }
      }
      else
      {
          JOptionPane.showMessageDialog(null, "Book not available try next day", "Warning", JOptionPane.OK_OPTION);
      }
      return status;
  }
public int checkQuentity()
  {
      int quantity=0;
      Connection con = Db.getConnection();
      try{
             PreparedStatement ps = con.prepareStatement("select quantity,issued from books where callno=?");
             ps.setInt(1, Integer.parseInt(bookCallNo.getText()));
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
              quantity = rs.getInt("quantity");
              issued = rs.getInt("issued");
             }
      }catch(Exception e)
      {
          System.out.println(e.toString());
      }
      return quantity;
  }
  public IssueBook() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookCallNo = new javax.swing.JTextField();
        studentId = new javax.swing.JTextField();
        studentName = new javax.swing.JTextField();
        studentContact = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel1.setText("Book Call No .");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, -1));

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel2.setText("Student Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 70, -1));

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel3.setText("Student Name");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel4.setText("Student Contact");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 120, -1));
        getContentPane().add(bookCallNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 160, -1));
        getContentPane().add(studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 160, -1));
        getContentPane().add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 160, -1));
        getContentPane().add(studentContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 160, -1));

        jButton1.setText("Cancel");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jButton2.setText("Issue Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel5.setText("Issue Book ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            int issue=updateIssuedBook();
            Connection con = Db.getConnection();
            con.setAutoCommit(false);
           
             if(issue!=0)
             {
            PreparedStatement ps = con.prepareStatement("insert into ISSUEBOOKS(BOOKCALLNO, STUDENTID, STUDENTNAME, STUDENTCONTACT, ISSUEDDATE)"
                + "values(?,?,?,?,?)");
            ps.setString(1, bookCallNo.getText());
            ps.setInt(2, Integer.parseInt(studentId.getText()));
            ps.setString(3, studentName.getText());
            ps.setString(4, studentContact.getText());
            ps.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            int status = ps.executeUpdate();
             if(status != 0)
            {
                int reply=JOptionPane.showConfirmDialog(null, "Book Issued sucessfully", "Issue Book", JOptionPane.OK_CANCEL_OPTION);
                if(reply == JOptionPane.OK_OPTION)
                {
                    bookCallNo.setText("");
                    studentId.setText("");
                    studentName.setText("");
                    studentContact.setText("");
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Insertion fail !!!", "insert", JOptionPane.OK_OPTION);
            }
            
            con.commit();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookCallNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField studentContact;
    private javax.swing.JTextField studentId;
    private javax.swing.JTextField studentName;
    // End of variables declaration//GEN-END:variables
}
