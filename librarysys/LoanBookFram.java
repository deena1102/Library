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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.Date;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ppu
 */
public class LoanBookFram extends javax.swing.JFrame {

    /**
     * Creates new form LonBookFram
     */
    public LoanBookFram() {
        initComponents();
        Connect();
        showLoanedBooks();
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

    public void showLoanedBooks() {

        try {
            pst = con.prepareStatement("SELECT Loan.loan_id, Loan.SID, Loan.book_id, Loan.loan_date, Loan.due_date "
                    + "FROM Loan "
                    + "JOIN Book ON Loan.book_id = Book.book_id "
                    + "WHERE Book.inLoan = TRUE");
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) LjTable1.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("loan_id"),
                    rs.getString("SID"),
                    rs.getString("book_id"),
                    rs.getString("loan_date"),
                    rs.getString("due_date")
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public boolean studentLoansExceeded(int studentId) {
        try {

            String loanCountSql = "SELECT COUNT(*) AS loanCount FROM loan WHERE SID = ?";
            pst = con.prepareStatement(loanCountSql);
            pst.setInt(1, studentId);

            rs = pst.executeQuery();

            if (rs.next()) {
                int loanCount = rs.getInt("loanCount");

                return loanCount >= 3;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        return true;
    }

    public boolean isBookAvailableForLoan(int bookId) {
        try {
            String bookStatusSql = "SELECT inLoan FROM book WHERE book_id = ?";
            pst = con.prepareStatement(bookStatusSql);
            pst.setInt(1, bookId);

            rs = pst.executeQuery();

            if (rs.next()) {
                boolean inLoan = rs.getBoolean("inLoan");
                return !inLoan;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        STsaveButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SNTextField1 = new javax.swing.JTextField();
        BTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        LjTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Loan Book");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\DD.png")); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 178, 135));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Please enter Loan details :  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 280, 30));

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
        jPanel1.add(STsaveButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 123, 26));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Book ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student ID : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Lone Book List :  ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 30));

        SNTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SNTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SNTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(SNTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 233, -1));

        BTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        BTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(BTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 233, -1));

        LjTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan Id", "Student ID", "Book ID", "Loan Date ", "Due Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        LjTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LjTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(LjTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 170));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\back.png")); // NOI18N
        jButton1.setText("Back to Library");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\download (2).jpg")); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void STsaveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STsaveButton1ActionPerformed

        try {
            int studentId = Integer.parseInt(SNTextField1.getText());
            int bookId = Integer.parseInt(BTextField2.getText());

            if (studentLoansExceeded(studentId)) {
                JOptionPane.showMessageDialog(this, "Student has reached the maximum number of loans.");
                return; // Exit the method if loans exceeded
            }

            if (isBookAvailableForLoan(bookId)) {
                try {
                    String loanSql = "INSERT INTO loan (SID, book_id, loan_date, due_date) VALUES (?, ?, ?, ?)";
                    pst = con.prepareStatement(loanSql);
                    LocalDate currentDate = LocalDate.now();
                    LocalDate dueDate = currentDate.plus(5, ChronoUnit.DAYS);     
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String due = dueDate.format(formatter);
                    String loan = currentDate.format(formatter);

                        pst.setInt(1, studentId);
                        pst.setInt(2, bookId);
                        pst.setString(3, loan);
                        pst.setString(4, due);

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        String updateBookSql = "UPDATE book SET inLoan = true WHERE book_id = ?";
                        pst = con.prepareStatement(updateBookSql);
                        pst.setInt(1, bookId);
                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Book loaned successfully");

                        showLoanedBooks();

                    } else {
                        JOptionPane.showMessageDialog(this, "Error loaning the book");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Book is already on loan.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid student or book ID");
        }


    }//GEN-LAST:event_STsaveButton1ActionPerformed

    private void SNTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SNTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SNTextField1ActionPerformed

    private void BTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTextField2ActionPerformed

    private void LjTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LjTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LjTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        LibraryFram L1 = new LibraryFram();
        L1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoanBookFram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BTextField2;
    private javax.swing.JTable LjTable1;
    private javax.swing.JTextField SNTextField1;
    private javax.swing.JButton STsaveButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
