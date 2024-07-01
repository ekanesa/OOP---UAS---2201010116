package belipenjor;
import belipenjor.BeliPenjor;
import belipenjor.jForm2;
import static belipenjor.koneksi.buatkoneks;
import javax.swing.JTable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ekanesa
 */
public class jForm1 extends javax.swing.JFrame {
    DefaultTableModel TM = new DefaultTableModel();
    
    public jForm1() throws SQLException{
        initComponents();
        jTable1.setModel(TM);
        TM.addColumn("id_barang");
        TM.addColumn("nama_barang");
        TM.addColumn("harga_beli_barang");
        TM.addColumn("harga_jual_barang");
        TM.addColumn("stok");
        
        this.setTitle("APLIKASI DATA PENJOR");
        ImageIcon IC = new ImageIcon("img/logo.png");
        this.setIconImage(IC.getImage());
        
        loadphoto("");
        List_All();
        kosongkanform();
                
    }

    private void loadphoto(String idx) {
        String nopic = "src/imageh/logo.png";
        String[] formats = {".jpg", ".jpeg", ".png", ".bmp", ".gif"};
        BufferedImage photoPnjrImg = null;

        for (String format : formats) {
            String ph = "src/imageh/" + idx + format;
            photoPnjrImg = loadImage(ph);
            if (photoPnjrImg != null) {
                break;
            }
        }

        if (photoPnjrImg == null) {
            photoPnjrImg = loadImage(nopic);
        }

        ImageIcon iconPhoto = new ImageIcon(photoPnjrImg);
        this.photoPnjr.setIcon(iconPhoto);
    }

    private BufferedImage loadImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            return null;
        }
    }

    
        private void List_All() throws SQLException{
        TM.getDataVector().removeAllElements();
        TM.fireTableDataChanged();
        
        Connection cnn = buatkoneks();
        if( !cnn.isClosed() ){
            String sql = "SELECT * FROM penjor;";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            while( rs.next() ){
                Object[] dta = new Object[5];
                dta[0] = rs.getInt("id_barang");
                dta[1] = rs.getString("nama_barang");
                dta[2] = rs.getString("harga_beli_barang");
                dta[3] = rs.getString("harga_jual_barang");
                dta[4] = rs.getString("stok");
                TM.addRow(dta);
            }
        }
        
    }
    private void StoreData() throws SQLException {
        Connection cnn = buatkoneks();
        String NM = txNAMA.getText();
        double HB = Double.parseDouble(txHRGBELI.getText());
        double HJ = Double.parseDouble(txHRGJUAL.getText());
        int SK = Integer.parseInt(txSTOK.getText());

        if (cnn != null && !cnn.isClosed()) {
            try (PreparedStatement PS = cnn.prepareStatement("INSERT INTO penjor(nama_barang, harga_beli_barang, harga_jual_barang, stok) VALUES(?, ?, ?, ?);")) {
                PS.setString(1, NM);
                PS.setDouble(2, HB);
                PS.setDouble(3, HJ);
                PS.setInt(4, SK);
                PS.executeUpdate();
            } finally {
                cnn.close();
            }
        }
    }


        
    private void UpdateData() throws SQLException {
        Connection cnn = buatkoneks();
        if (cnn != null && !cnn.isClosed()) {
            try (PreparedStatement PS = cnn.prepareStatement("UPDATE penjor SET nama_barang=?, harga_beli_barang=?, harga_jual_barang=?, stok=? WHERE id_barang=?;")) {
                PS.setString(1, txNAMA.getText());
                PS.setDouble(2, Double.parseDouble(txHRGBELI.getText()));
                PS.setDouble(3, Double.parseDouble(txHRGJUAL.getText()));
                PS.setInt(4, Integer.parseInt(txSTOK.getText()));
                PS.setInt(5, Integer.parseInt(txID.getText()));
                PS.executeUpdate();
            } finally {
                cnn.close();
            }
        }
    }

        
        private void destroyData() throws SQLException {
        Connection cnn = buatkoneks();
        if(!cnn.isClosed()){
            cnn.isClosed();
            PreparedStatement PS = cnn.prepareStatement("DELETE FROM penjor WHERE id_barang=?;");
            PS.setString(1, txID.getText());
            PS.executeUpdate();
            PS.close();
        }
    }
            
        private void kosongkanform(){
        txID.setText("");
        txNAMA.setText("");
        txHRGBELI.setText("");
        txHRGJUAL.setText("");
        txSTOK.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBARU = new javax.swing.JButton();
        btnUBAH = new javax.swing.JButton();
        btnHAPUS = new javax.swing.JButton();
        btnTUTUP = new javax.swing.JButton();
        photoPnjr = new javax.swing.JLabel();
        txNama = new javax.swing.JLabel();
        txHargaBeli = new javax.swing.JLabel();
        txHargaJual = new javax.swing.JLabel();
        txStok = new javax.swing.JLabel();
        txIDBarang1 = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        txNAMA = new javax.swing.JTextField();
        txHRGBELI = new javax.swing.JTextField();
        txHRGJUAL = new javax.swing.JTextField();
        txSTOK = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setText("DATA PENJOR");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnBARU.setText("BARU");
        btnBARU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBARUActionPerformed(evt);
            }
        });

        btnUBAH.setText("UBAH");
        btnUBAH.setToolTipText("");
        btnUBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUBAHActionPerformed(evt);
            }
        });

        btnHAPUS.setText("HAPUS");
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        btnTUTUP.setText("TUTUP");
        btnTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTUTUPActionPerformed(evt);
            }
        });

        photoPnjr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txNama.setText("Nama Barang");

        txHargaBeli.setText("Harga Beli");

        txHargaJual.setText("Harga Jual");

        txStok.setText("Jumlah Stok");

        txIDBarang1.setText("ID Barang");

        txID.setText("jTextField1");
        txID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIDActionPerformed(evt);
            }
        });

        txNAMA.setText("jTextField1");

        txHRGBELI.setText("jTextField1");

        txHRGJUAL.setText("jTextField1");

        txSTOK.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBARU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUBAH)
                                .addGap(48, 48, 48)
                                .addComponent(btnHAPUS)
                                .addGap(52, 52, 52)
                                .addComponent(btnTUTUP))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txStok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txHargaJual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txHargaBeli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txIDBarang1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txID)
                                    .addComponent(txNAMA)
                                    .addComponent(txHRGBELI)
                                    .addComponent(txHRGJUAL)
                                    .addComponent(txSTOK)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(photoPnjr, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(photoPnjr, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txIDBarang1)
                    .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNama)
                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txHargaBeli)
                    .addComponent(txHRGBELI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txHargaJual)
                    .addComponent(txHRGJUAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txStok)
                    .addComponent(txSTOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTUTUP)
                    .addComponent(btnHAPUS)
                    .addComponent(btnUBAH)
                    .addComponent(btnBARU))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
    int jwb = JOptionPane.showOptionDialog(
            this, "Yakin Menghapus Data?" + txNAMA.getText() + "?",
            "Hapus Data",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null, 
            null,
            null);

    if (jwb == JOptionPane.YES_OPTION) {
        try {
            int id = Integer.parseInt(txID.getText());
            destroyData();
            List_All();
            kosongkanform();
        } catch (SQLException ex) {
            Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(jForm1.class.getName()).log(Level.WARNING, "Invalid ID format", ex);
        }
    }
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void txIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIDActionPerformed

    private void btnUBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUBAHActionPerformed
        try {
            UpdateData();
            List_All();
            
            JOptionPane.showMessageDialog(this,"Data Telah Diperbaharui");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUBAHActionPerformed

    private void btnTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTUTUPActionPerformed
        if(btnTUTUP.getText().equals("TutupForm")){
            dispose();
        }else{
            btnTUTUP.setText("TutupForm");
            btnBARU.setText("Baru");
                       this.dispose();
            try {
                BeliPenjor.main(new String[0]);
            } catch (SQLException ex) {
                Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnTUTUPActionPerformed

    private void btnBARUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBARUActionPerformed
        if(btnBARU.getText().equals("Baru")){
            btnBARU.setText("Simpan");
            btnTUTUP.setText("Batal");
            kosongkanform();
            jTable1.setEnabled(false);
        }else{
            btnBARU.setText("Baru");
            btnTUTUP.setText("TutupForm");
            jTable1.setEnabled(true);
            try {
                StoreData();
                List_All();
            } catch (SQLException ex) {
                Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBARUActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txID.setText( jTable1.getValueAt( jTable1.getSelectedRow(),0 ).toString() );
        txNAMA.setText( jTable1.getValueAt( jTable1.getSelectedRow(), 1).toString() );
        txHRGBELI.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() );
        txHRGJUAL.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString() );
        txSTOK.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString() );
        loadphoto(txID.getText());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new jForm1().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBARU;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnTUTUP;
    private javax.swing.JButton btnUBAH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photoPnjr;
    private javax.swing.JTextField txHRGBELI;
    private javax.swing.JTextField txHRGJUAL;
    private javax.swing.JLabel txHargaBeli;
    private javax.swing.JLabel txHargaJual;
    private javax.swing.JTextField txID;
    private javax.swing.JLabel txIDBarang1;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JLabel txNama;
    private javax.swing.JTextField txSTOK;
    private javax.swing.JLabel txStok;
    // End of variables declaration//GEN-END:variables
}
