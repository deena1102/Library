/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ppu
 */
public class newStudent extends javax.swing.JFrame {

    /**
     * Creates new form newStudent
     */
    public newStudent() {
        initComponents();
        Connect();
        student_load();

    }

    Connection con;
    PreparedStatement pst;
     ResultSet rs;


    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void student_load() {
        int c;
        try {
            pst = con.prepareStatement("select * from student");
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c =rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            while (rs.next()) { 
                Vector v2 = new Vector();
                for (int i = 1; i <=c; i++) {
                    
                    v2.add(rs.getString("SID"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Address"));
                    v2.add(rs.getString("Birthdate"));
                    v2.add(rs.getString("Majer"));      
                }
                d.addRow(v2);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        STsaveButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SNTextField1 = new javax.swing.JTextField();
        SATextField2 = new javax.swing.JTextField();
        SDateChooser1 = new com.toedter.calendar.JDateChooser();
        SMTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jInternalFrame1.setBackground(new java.awt.Color(204, 204, 255));
        jInternalFrame1.setTitle("New Student");
        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("New Student");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\DD.png")); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 178, 135));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Please enter valid student  details :  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 360, 30));

        STsaveButton1.setBackground(new java.awt.Color(204, 204, 204));
        STsaveButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        STsaveButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\ss.png")); // NOI18N
        STsaveButton1.setText("Save");
        STsaveButton1.setToolTipText("");
        STsaveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STsaveButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(STsaveButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 123, 26));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Student BirthDate : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Student Address : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student Name : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Student List :  ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, 30));

        SNTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SNTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SNTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(SNTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 233, -1));

        SATextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SATextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SATextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(SATextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 233, -1));

        SDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(SDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 233, -1));

        SMTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SMTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(SMTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 233, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Student Majer : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Address", "Birthdate", "Majer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 380, 170));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\back.png")); // NOI18N
        jButton1.setText("Back to Library");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\download (2).jpg")); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SMTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SMTextField3ActionPerformed

    private void SATextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SATextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SATextField2ActionPerformed

    private void SNTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SNTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SNTextField1ActionPerformed

    private void STsaveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STsaveButton1ActionPerformed
        try {
            String name = SNTextField1.getText();
            String Add = SATextField2.getText();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String BD = date.format(SDateChooser1.getDate());
            String majer = SMTextField3.getText();
            try {
                pst = con.prepareStatement("insert into student(Name,Address,BirthDate,Majer)values(?,?,?,?)");
                pst.setString(1, name);
                pst.setString(2, Add);
                pst.setString(3, BD);
                pst.setString(4, majer);
                int K = pst.executeUpdate();

                if (K == 1) {
                    JOptionPane.showMessageDialog(this, "Student Added successfully");
                    student_load();

                } else {
                    JOptionPane.showMessageDialog(this, "Student not Added ");

                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_STsaveButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            System.exit(0);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        LibraryFram L1 = new LibraryFram();
        L1.setVisible(true);
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
            java.util.logging.Logger.getLogger(newStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SATextField2;
    private com.toedter.calendar.JDateChooser SDateChooser1;
    private javax.swing.JTextField SMTextField3;
    private javax.swing.JTextField SNTextField1;
    private javax.swing.JButton STsaveButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
