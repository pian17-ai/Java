/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pian
 */
public class StockForm extends javax.swing.JDialog {
    private PreparedStatement ps;
    private ResultSet rs;
    private final java.sql.Connection connDB;
    DefaultTableModel tabelModel;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StockForm.class.getName());

    /**
     * Creates new form StockForm
     */
    public StockForm() {
        initComponents();
        connDB = ConnectionClass.connectionDB();

        tableUser.setModel(getStock());
        comboItem();

        txtId.setEditable(false);
    }
    
    public DefaultTableModel getStock() {
    Object[][] data = null;

    try {
        String query = "SELECT * FROM stok";

        ps = connDB.prepareStatement(
            query,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY
        );

        rs = ps.executeQuery();

        rs.last();
        int row = rs.getRow();
        rs.beforeFirst();

        data = new Object[row][4];

        int i = 0;

        while (rs.next()) {
            data[i][0] = rs.getString("id");
            data[i][1] = rs.getString("item_id");
            data[i][2] = rs.getString("quantity");
            data[i][3] = rs.getString("tanggal_update");
            i++;
        }

    } catch (SQLException e) {
        System.out.println("Stock model error : " + e.getMessage());
    }

    String[] judulTabel = {
        "ID",
        "ITEM ID",
        "QUANTITY",
        "UPDATE DATE"
    };

    tabelModel = new DefaultTableModel(data, judulTabel);

    return tabelModel;
}
    
    public void comboItem() {

    try {

        String query = "SELECT id, nama FROM item";

        ps = connDB.prepareStatement(query);
        rs = ps.executeQuery();

        comboLevel.removeAllItems();
        comboLevel.addItem("Pilih");

        while (rs.next()) {

            comboLevel.addItem(
                    rs.getString("id")
                    + "-" +
                    rs.getString("nama")
            );

        }

    } catch (SQLException e) {

        System.out.println(
                "Combo item error : "
                + e.getMessage());

    }
}
    
    public void clearData() {

    txtId.setText("");
    txtUsername.setText("");
    txtPassword.setText("");
    txtSearch.setText("");

    comboLevel.setSelectedIndex(0);

}
    
    public void showData() {

    try {

        String query =
                """
                SELECT stok.*,
                       item.nama AS nama_item
                FROM stok
                INNER JOIN item
                ON item.id = stok.item_id
                WHERE stok.id=?
                """;

        ps = connDB.prepareStatement(
                query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ps.setString(1, txtId.getText());

        rs = ps.executeQuery();

        if (rs.next()) {

            comboLevel.setSelectedItem(
                    rs.getString("item_id")
                    + "-"
                    + rs.getString("nama_item")
            );

            txtUsername.setText(
                    rs.getString("quantity"));

            txtPassword.setText(
                    rs.getString("tanggal_update"));

        } else {

            clearData();

        }

    } catch (SQLException e) {

        System.out.println(
                "Show data error : "
                + e.getMessage());

    }

}
    
    public void insertData() {

    try {

        String itemId =
                comboLevel.getSelectedItem()
                .toString()
                .split("-")[0];

        String query =
                "INSERT INTO stok VALUES(?,?,?,?)";

        ps = connDB.prepareStatement(query);

        ps.setString(1, null);
        ps.setString(2, itemId);
        ps.setString(3, txtUsername.getText());
        ps.setString(4, txtPassword.getText());

        ps.executeUpdate();

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Add data success");

    } catch (SQLException e) {

        System.out.println(
                "Insert error : "
                + e.getMessage());

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Insert data error");
    }

}
    
    public void updateData() {

    try {

        String itemId =
                comboLevel.getSelectedItem()
                .toString()
                .split("-")[0];

        String query =
                """
                UPDATE stok
                SET item_id=?,
                    quantity=?,
                    tanggal_update=?
                WHERE id=?
                """;

        ps = connDB.prepareStatement(query);

        ps.setString(1, itemId);
        ps.setString(2, txtUsername.getText());
        ps.setString(3, txtPassword.getText());
        ps.setString(4, txtId.getText());

        ps.executeUpdate();

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Update success");

    } catch (SQLException e) {

        System.out.println(
                "Update error : "
                + e.getMessage());

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Update error");

    }

}
    
    public void deleteData() {

    try {

        String query =
                "DELETE FROM stok WHERE id=?";

        ps = connDB.prepareStatement(query);

        ps.setString(1, txtId.getText());

        ps.executeUpdate();

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Delete success");

    } catch (SQLException e) {

        System.out.println(
                "Delete error : "
                + e.getMessage());

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Delete error");

    }

}
    
    public DefaultTableModel getModelSearch(String search) {

    Object[][] data = null;

    try {

        String query =
                """
                SELECT stok.*,
                       item.nama AS nama_item
                FROM stok
                INNER JOIN item
                ON item.id = stok.item_id
                WHERE stok.id LIKE ?
                   OR item.nama LIKE ?
                   OR stok.quantity LIKE ?
                """;

        ps = connDB.prepareStatement(
                query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ps.setString(1, "%" + search + "%");
        ps.setString(2, "%" + search + "%");
        ps.setString(3, "%" + search + "%");

        rs = ps.executeQuery();

        rs.last();
        int i = rs.getRow();
        rs.beforeFirst();

        data = new Object[i][4];

        i = 0;

        while (rs.next()) {

            data[i][0] = rs.getString("id");
            data[i][1] = rs.getString("item_id");
            data[i][2] = rs.getString("quantity");
            data[i][3] = rs.getString("tanggal_update");

            i++;

        }

    } catch (SQLException e) {

        System.out.println(
                "Search error : "
                + e.getMessage());

    }

    String[] judul = {
        "ID",
        "ITEM ID",
        "QUANTITY",
        "UPDATE DATE"
    };

    tabelModel =
            new DefaultTableModel(data, judul);

    return tabelModel;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        comboLevel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search");

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock FORM");

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity");

        btnAdd.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnCancel.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        btnDelete.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        txtPassword.addActionListener(this::txtPasswordActionPerformed);

        txtId.addActionListener(this::txtIdActionPerformed);

        txtSearch.addActionListener(this::txtSearchActionPerformed);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Item Id", "Quantity", "Update Date"
            }
        ));
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUser);

        jLabel6.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Item Id");

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Update Date");

        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        comboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(381, 381, 381))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jLabel4)
                    .addContainerGap(972, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addContainerGap(296, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(jLabel4)
                    .addContainerGap(528, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        // TODO add your handling code here:
        txtId.setText(
                tabelModel.getValueAt(
                        tableUser.getSelectedRow(),
                        0
                ).toString());

        showData();
    }//GEN-LAST:event_tableUserMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.getText().trim().equals("")) {

            tableUser.setModel(getStock());

        } else {

            tableUser.setModel(
                    getModelSearch(
                            txtSearch.getText()));

        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int jawab =
                javax.swing.JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure for delete?",
                        "Confirm",
                        javax.swing.JOptionPane.YES_NO_OPTION);

        if (jawab ==
                javax.swing.JOptionPane.YES_OPTION) {

            deleteData();
            clearData();

        }

        tableUser.setModel(getStock());
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        updateData();
        tableUser.setModel(getStock());
        clearData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        insertData();
        tableUser.setModel(getStock());
        clearData();
    }//GEN-LAST:event_btnAddActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StockForm dialog = new StockForm();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboLevel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
