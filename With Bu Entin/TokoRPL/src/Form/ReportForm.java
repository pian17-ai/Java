/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author pian
 */
public class ReportForm extends javax.swing.JDialog {
    
        private PreparedStatement ps;
    private ResultSet rs;
    private final java.sql.Connection konDB;
    DefaultTableModel tabelModel;
    JasperDesign jasDes;
    JasperReport jasRep;
    JasperPrint jasPrint;
//    JasperViewer jasView;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportForm.class.getName());

    /**
     * Creates new form ReportForm
     */
    public ReportForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        konDB = ConnectionClass.connectionDB();
    }
    
    public DefaultTableModel getModelTransaksi(){
        
    Object data [][] = null;

    try{
      String query = "SELECT t.id, u.nama, t.total_harga, "
              + "t.jumlah_item, t.tanggal_transaksi "
              + "FROM transaksi t INNER JOIN user u "
              + "ON u.id = t.user_id";

      ps = konDB.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = ps.executeQuery();

      rs.last();
      int i = rs.getRow();
      rs.beforeFirst();
      data = new Object[i][5];
      i = 0;

      while(rs.next()){
        data[i][0] = rs.getString("id");
        data[i][1] = rs.getString("nama");
        data[i][2] = rs.getString("total_harga");
        data[i][3] = rs.getString("jumlah_item");
        data[i][4] = rs.getString("tanggal_transaksi");
        i++;
      }
    }catch(SQLException e){
      System.out.println("model transaksi error, " +e.getMessage());
    }

    String[] judulTabel = {"ID", "NAMA KASIR", "TOTAL HARGA", "JUMLAH ITEM", "TANGGAL TRANSAKSI"};
    tabelModel = new DefaultTableModel(data, judulTabel);
    return tabelModel;
  }
    
    public DefaultTableModel getModelDTransaksi(String IDTransaksi){
    
       DefaultTableModel model;
    Object data[][] = null;

    try{

        String query = "SELECT i.nama, dt.quantity, dt.subtotal_harga "
                     + "FROM detail_transaksi dt "
                     + "INNER JOIN item i ON dt.item_id = i.id "
                     + "WHERE dt.transaksi_id = ?";

        ps = konDB.prepareStatement(
                query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ps.setString(1, IDTransaksi);

        System.out.println("ID Transaksi = " + IDTransaksi);

        rs = ps.executeQuery();

        rs.last();
        int jumlahData = rs.getRow();

        System.out.println("Jumlah Data Detail = " + jumlahData);

        rs.beforeFirst();

        data = new Object[jumlahData][3];

        int i = 0;

        while(rs.next()){

            System.out.println(
                rs.getString("nama") + " | " +
                rs.getString("quantity") + " | " +
                rs.getString("subtotal_harga")
            );

            data[i][0] = rs.getString("nama");
            data[i][1] = rs.getString("quantity");
            data[i][2] = rs.getString("subtotal_harga");

            i++;
        }

    }catch(SQLException e){

        System.out.println("ERROR getModelDTransaksi");
        e.printStackTrace();

        data = new Object[0][3];
    }

    String[] judulTabel = {
        "NAMA ITEM",
        "QUANTITY",
        "SUBTOTAL"
    };

    model = new DefaultTableModel(data, judulTabel);

    return model;
    
  }
    
    public DefaultTableModel getModelSearch(String cari){
    
    Object data [][] = null;

    try{
      String query = "SELECT t.id, u.nama, t.total_harga, "
              + "t.jumlah_item, t.tanggal_transaksi "
              + "FROM transaksi t INNER JOIN user u "
              + "ON u.id = t.user_id "
              + "WHERE u.nama LIKE '"+cari+"%' ";

      ps = konDB.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = ps.executeQuery();

      rs.last();
      int i = rs.getRow();
      rs.beforeFirst();
      data = new Object[i][5];
      i = 0;

      while(rs.next()){
        data[i][0] = rs.getString("id");
        data[i][1] = rs.getString("nama");
        data[i][2] = rs.getString("total_harga");
        data[i][3] = rs.getString("jumlah_item");
        data[i][4] = rs.getString("tanggal_transaksi");
        i++;
      }
    }catch(SQLException e){
      System.out.println("model search error " +e.getMessage());
    }

    String[] judulTable = {"ID", "NAMA KASIR", "TOTAL HARGA", "JUMLAH ITEM", "TANGGAL TRANSAKSI"};
    tabelModel = new DefaultTableModel(data, judulTable);
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
        btnCetak = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_DetailTransaksi = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search");

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transaction FORM");

        btnCetak.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        btnCetak.setText("Cetak Struk");
        btnCetak.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCetak.addActionListener();

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Detail Transaksi");

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nama Kasir", "Total Harga", "Jml Item", "Tgl Transaksi"
            }
        ));
        tabelTransaksi.addMouseListener();
        jScrollPane2.setViewportView(tabelTransaksi);

        tabel_DetailTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Item", "Quantity", "Subtotal"
            }
        ));
        tabel_DetailTransaksi.addMouseListener();
        jScrollPane3.setViewportView(tabel_DetailTransaksi);

        txtCari.addActionListener();
        txtCari.addKeyListener();

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(381, 381, 381))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnCetakActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void tabel_DetailTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_DetailTransaksiMouseClicked
        // TODO add your handling code here:\                                        
        String idTransaksi = tabelTransaksi.getValueAt(
                tabelTransaksi.getSelectedRow(), 0).toString();

    System.out.println("ID TERPILIH = " + idTransaksi);

    tabel_DetailTransaksi.setModel(getModelDTransaksi(idTransaksi));
    }                                           

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        tabelTransaksi.setModel(getModelTransaksi());
    }                                 

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {                                    
        if(txtCari.getText().isEmpty()){
      tabelTransaksi.setModel(getModelTransaksi());
    }else{
      tabelTransaksi.setModel(getModelSearch(txtCari.getText()));
    }
    }//GEN-LAST:event_tabel_DetailTransaksiMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariKeyReleased

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
                ReportForm dialog = new ReportForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCetak;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTable tabel_DetailTransaksi;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
