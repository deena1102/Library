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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ppu
 */
public class LibraryFram extends javax.swing.JFrame {

    /**
     * Creates new form LibraryFram
     */
    public LibraryFram() {
        initComponents();
        Connect();
        showBooks();
        showMagazines();
        showJournals();
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

    public void showMagazines() {
        try {
            String sql = "SELECT Magazines.book_id, Magazines.issue_no, Magazines.release_date FROM Magazines JOIN Book ON Magazines.book_id = Book.book_id";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTableMagazines.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("book_id"),
                    rs.getString("issue_no"),
                    rs.getString("release_date"),
                 
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void showJournals() {
        try {
            pst = con.prepareStatement("SELECT Journals.book_id, Journals.conference_no, Journals.conference_name FROM Journals JOIN Book ON Journals.book_id = Book.book_id");
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTableJournals.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("book_id"),
                    rs.getString("conference_no"),
                    rs.getString("conference_name"),
                 
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void showBooks() {
        try {
            pst = con.prepareStatement("SELECT * FROM book");
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTableBook.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("book_id"),
                    rs.getString("Title"),
                    rs.getString("Number"),
                    rs.getString("Gener"),
                    rs.getString("Version"),
                    rs.getString("Date"),
                    rs.getString("author_id")
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Library = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBook = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMagazines = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableJournals = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BTjTextField2 = new javax.swing.JTextField();
        DNUjTextField1 = new javax.swing.JTextField();
        BAjTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library System");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setToolTipText("Library System");

        Library.setBackground(new java.awt.Color(255, 255, 255));
        Library.setFocusable(false);
        Library.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\Desktop\\cate\\lo.jpg")); // NOI18N
        jButton4.setText("Loan Book");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Library.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 173, 55));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\Desktop\\cate\\re.jpg")); // NOI18N
        jButton5.setText("Return Book");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Library.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 173, 54));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\Desktop\\cate\\book.png")); // NOI18N
        jButton3.setText("  New Book");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Library.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 173, 56));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\download (1).png")); // NOI18N
        jButton2.setText("Show All Books");
        jButton2.setActionCommand("Show B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Library.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 173, 54));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Welcome to our Library Management System!");
        Library.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, -1, 20));
        Library.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Happy reading!");
        Library.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, 60));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Library Registration System ");
        Library.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\Desktop\\cate\\download.jpg")); // NOI18N
        Library.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 310, 260));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Embark on a seamless literary journey with us. Explore a vast collection of books, magazines, and journals.");
        Library.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Dive into the world of knowledge, track your loans, and discover the richness of our library");
        Library.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 550, 20));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\Desktop\\cate\\add.png")); // NOI18N
        jButton6.setText("New Student ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Library.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 173, 54));

        jTabbedPane1.addTab("Library System", Library);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\download (1).jpg")); // NOI18N
        jButton7.setText("Search  by Title");
        jButton7.setActionCommand("Search Book by title");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\download (1).jpg")); // NOI18N
        jButton8.setText("Search by Author ID");
        jButton8.setActionCommand("Search Book by title");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ppu\\OneDrive\\Documents\\download (1).jpg")); // NOI18N
        jButton9.setText("Search  by Number");
        jButton9.setActionCommand("Search Book by title");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Title ", "Number", "Genre", "Version ", "Date", "Author ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBook);

        jTableMagazines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Issue No", "Release Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableMagazines);

        jTableJournals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Conference Name", "Conference No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableJournals);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane4.setViewportView(jTextArea1);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Book List ");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 204));
        jLabel7.setText("Magazine List ");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Journals List ");

        BTjTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTjTextField2ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Result found  : ");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("You can search here ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(650, 650, 650)
                .addComponent(jLabel6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BTjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DNUjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BAjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(640, 640, 640)
                .addComponent(jLabel7))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel11)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel10))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DNUjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(BAjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Show Book", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
     
        setVisible(false);
        NewBook b1 = new NewBook();
        b1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        newStudent s1 = new newStudent();
        s1.setVisible(true);


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            String title = BTjTextField2.getText();
            String bookSql = "SELECT Book.*, Magazines.issue_no, Magazines.release_date, Journals.conference_name, Journals.conference_no "
                    + "FROM Book "
                    + "LEFT JOIN Magazines ON Book.book_id = Magazines.book_id "
                    + "LEFT JOIN Journals ON Book.book_id = Journals.book_id "
                    + "WHERE Book.Title LIKE ?";
            try {
                pst = con.prepareStatement(bookSql);
                pst.setString(1, "%" + title + "%");
                rs = pst.executeQuery();

                if (rs.next()) {
                    int bookId = rs.getInt("book_id");

                    boolean isBookInMagazines = rs.getInt("issue_no") > 0;
                    boolean isBookInJournals = rs.getInt("conference_no") > 0;

                    StringBuilder details = new StringBuilder();
                    details.append("Title: ").append(rs.getString("Title")).append("\n");
                    details.append("Number: ").append(rs.getString("Number")).append("\n");
                    details.append("Genre: ").append(rs.getString("Gener")).append("\n");
                    details.append("Version: ").append(rs.getString("Version")).append("\n");
                    details.append("Date: ").append(rs.getString("Date")).append("\n");
                    details.append("Author ID: ").append(rs.getString("author_id")).append("\n");

                    if (isBookInMagazines) {
                        details.append("Issue No: ").append(rs.getString("issue_no")).append("\n");
                        details.append("Release Date: ").append(rs.getString("release_date")).append("\n");
                    }

                    if (isBookInJournals) {
                        details.append("Conference No: ").append(rs.getString("conference_no")).append("\n");
                        details.append("Conference Name: ").append(rs.getString("conference_name")).append("\n");
                    }

                    jTextArea1.setText(details.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Title not found in Books, Magazines, or Journals");

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            jTextArea1.setText("");

            String sql = "SELECT Book.*, Magazines.issue_no, Magazines.release_date, Journals.conference_name, Journals.conference_no "
                    + "FROM Book "
                    + "LEFT JOIN Magazines ON Book.book_id = Magazines.book_id "
                    + "LEFT JOIN Journals ON Book.book_id = Journals.book_id "
                    + "WHERE Book.author_id = ?";
            int authorId = Integer.parseInt( BAjTextField3.getText());
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, authorId);
                rs = pst.executeQuery();

                while (rs.next()) {
                    int bookId = rs.getInt("book_id");
                    String bookTitle = rs.getString("Title");
                    String bookNumber = rs.getString("Number");
                    String bookGenre = rs.getString("Gener");
                    int bookVersion = rs.getInt("Version");
                    String bookDate = rs.getString("Date");

                 
                    boolean isBookInMagazines = rs.getInt("issue_no") > 0;
                    boolean isBookInJournals = rs.getInt("conference_no") > 0;

              
                    StringBuilder details = new StringBuilder();
                    details.append("Book Title: ").append(bookTitle).append("\n");
                    details.append("Book Number: ").append(bookNumber).append("\n");
                    details.append("Book Genre: ").append(bookGenre).append("\n");
                    details.append("Book Version: ").append(bookVersion).append("\n");
                    details.append("Book Date: ").append(bookDate).append("\n");

                    if (isBookInMagazines) {
                        details.append("Issue No: ").append(rs.getString("issue_no")).append("\n");
                        details.append("Release Date: ").append(rs.getString("release_date")).append("\n");
                    }

                    if (isBookInJournals) {
                        details.append("Conference No: ").append(rs.getString("conference_no")).append("\n");
                        details.append("Conference Name: ").append(rs.getString("conference_name")).append("\n");
                    }

                    jTextArea1.append(details.toString());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {

            int bookNumber = Integer.parseInt(DNUjTextField1.getText());
            String bookSql = "SELECT Book.*, Magazines.issue_no, Magazines.release_date, Journals.conference_name, Journals.conference_no "
                    + "FROM Book "
                    + "LEFT JOIN Magazines ON Book.book_id = Magazines.book_id "
                    + "LEFT JOIN Journals ON Book.book_id = Journals.book_id "
                    + "WHERE Book.Number LIKE ?";
            try {
                pst = con.prepareStatement(bookSql);
                pst.setInt(1, bookNumber);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int bookId = rs.getInt("book_id");

                    boolean isBookInMagazines = rs.getInt("issue_no") > 0;
                    boolean isBookInJournals = rs.getInt("conference_no") > 0;

                    StringBuilder details = new StringBuilder();
                    details.append("Title: ").append(rs.getString("Title")).append("\n");
                    details.append("Number: ").append(rs.getString("Number")).append("\n");
                    details.append("Genre: ").append(rs.getString("Gener")).append("\n");
                    details.append("Version: ").append(rs.getString("Version")).append("\n");
                    details.append("Date: ").append(rs.getString("Date")).append("\n");
                    details.append("Author ID: ").append(rs.getString("author_id")).append("\n");

                    if (isBookInMagazines) {
                        details.append("Issue No: ").append(rs.getString("issue_no")).append("\n");
                        details.append("Release Date: ").append(rs.getString("release_date")).append("\n");
                    }

                    if (isBookInJournals) {
                        details.append("Conference No: ").append(rs.getString("conference_no")).append("\n");
                        details.append("Conference Name: ").append(rs.getString("conference_name")).append("\n");
                    }

                    jTextArea1.setText(details.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Book number not found in Books, Magazines, or Journals");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void BTjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTjTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        LoanBookFram LO1 = new LoanBookFram();
         LO1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        ReturnBookFram RB = new ReturnBookFram();
         RB.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(LibraryFram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryFram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryFram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryFram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryFram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BAjTextField3;
    private javax.swing.JTextField BTjTextField2;
    private javax.swing.JTextField DNUjTextField1;
    private javax.swing.JPanel Library;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBook;
    private javax.swing.JTable jTableJournals;
    private javax.swing.JTable jTableMagazines;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
