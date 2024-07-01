package belipenjor;
import static belipenjor.koneksi.buatkoneks;
import java.awt.HeadlessException;
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

public class jForm2 extends javax.swing.JFrame {
    DefaultTableModel TM = new DefaultTableModel();
    
    public jForm2() throws SQLException{
        initComponents();
        jTable1.setModel(TM);
        TM.addColumn("id_pembeli");
        TM.addColumn("nama_pembeli");
        TM.addColumn("harga_penjor");
        TM.addColumn("jumlah_pembelian");
        TM.addColumn("tanggal_beli");
        TM.addColumn("tanggal_kirim");
        TM.addColumn("telp");
        TM.addColumn("alamat");
        
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
            String ph = "src/pembeli/" + idx + format;
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

 private void List_All() throws SQLException {
    TM.getDataVector().removeAllElements();
    TM.fireTableDataChanged();

    Connection cnn = buatkoneks();
    if (!cnn.isClosed()) {
        String sql = "SELECT * FROM pembeli;";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Object[] dta = new Object[8];
            dta[0] = rs.getInt("id_pembeli");
            dta[1] = rs.getString("nama_pembeli");
            dta[2] = rs.getDouble("harga_penjor");
            dta[3] = rs.getInt("jumlah_pembelian");
            dta[4] = rs.getString("tanggal_beli");
            dta[5] = rs.getString("tanggal_kirim");
            dta[6] = rs.getString("telp");
            dta[7] = rs.getString("alamat");
            TM.addRow(dta);
        }
    }
}


private void StoreData() throws SQLException {
    Connection cnn = buatkoneks();
    String NM = txNAMAP.getText();
    double HR = Double.parseDouble(txHRG.getText());
    int JML = Integer.parseInt(txJML.getText()); 
    String TGLB = txTGLB.getText();
    String TGLP = txTGLP.getText();
    String telp = txTLP.getText();
    String ALMT = txALMT.getText();
    

    if (cnn!= null &&!cnn.isClosed()) {
        try (PreparedStatement ps = cnn.prepareStatement("INSERT INTO pembeli(nama_pembeli, harga_penjor, jumlah_pembelian, tanggal_beli, tanggal_kirim, telp, alamat) VALUES(?,?,?,?,?,?,?);")) {
            ps.setString(1, NM);
            ps.setDouble(2, HR);
            ps.setInt(3, JML);
            ps.setString(4, TGLB);
            ps.setString(5, TGLP);
            ps.setString(6, telp);
            ps.setString(7, ALMT);
            
            ps.executeUpdate();
        } finally {
            cnn.close();
        }
    }
}

        
    private void UpdateData() throws SQLException {
     Connection cnn = buatkoneks();
     if (cnn != null && !cnn.isClosed()) {
         try (PreparedStatement PS = cnn.prepareStatement("UPDATE pembeli SET nama_pembeli=?, harga_penjor=?, jumlah_pembelian=?, tanggal_beli=?, tanggal_kirim=?, telp=?, alamat=? WHERE id_pembeli=?;")) {
             PS.setString(1, txNAMAP.getText());
             PS.setDouble(2, Double.parseDouble(txHRG.getText()));
             PS.setInt(3, Integer.parseInt(txJML.getText()));
             PS.setString(4, txTGLB.getText());
             PS.setString(5, txTGLP.getText());
             PS.setString(6, txTLP.getText());
             PS.setString(7, txALMT.getText());
             PS.setInt(8, Integer.parseInt(txIDP.getText()));
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
            try (PreparedStatement PS = cnn.prepareStatement("DELETE FROM pembeli WHERE id_pembeli=?;")) {
                PS.setString(1, txIDP.getText());
                PS.executeUpdate();
            }
        }
    }
            
        private void kosongkanform(){
          txIDP.setText("");
          txNAMAP.setText("");
          txHRG.setText("");
          txJML.setText("");
          txTLP.setText("");
          txTGLB.setText("");
          txTGLP.setText("");
          txALMT.setText("");
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        txIDP = new javax.swing.JTextField();
        txNAMAP = new javax.swing.JTextField();
        txHRG = new javax.swing.JTextField();
        txJML = new javax.swing.JTextField();
        txTLP = new javax.swing.JTextField();
        txStok1 = new javax.swing.JLabel();
        txALMT = new javax.swing.JTextField();
        txStok2 = new javax.swing.JLabel();
        txStok3 = new javax.swing.JLabel();
        txTGLP = new javax.swing.JTextField();
        txTGLB = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setText("DATA PEMBELIAN PENJOR");

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

        txNama.setText("Nama Pembeli");

        txHargaBeli.setText("Harga Penjor");

        txHargaJual.setText("Jumlah ");

        txStok.setText("Telepon");

        txIDBarang1.setText("ID Pembeli");

        txIDP.setText("jTextField1");
        txIDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIDPActionPerformed(evt);
            }
        });

        txNAMAP.setText("jTextField1");

        txHRG.setText("jTextField1");

        txJML.setText("jTextField1");

        txTLP.setText("jTextField1");

        txStok1.setText("Alamat ");

        txALMT.setText("jTextField1");
        txALMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txALMTActionPerformed(evt);
            }
        });

        txStok2.setText("Tanggal Pembelian");

        txStok3.setText("Tanggal Pengiriman");

        txTGLP.setText("jTextField1");
        txTGLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTGLPActionPerformed(evt);
            }
        });

        txTGLB.setText("jTextField1");
        txTGLB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTGLBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(photoPnjr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txIDBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txIDP, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txNama)
                        .addGap(13, 13, 13)
                        .addComponent(txNAMAP, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txHRG, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txJML, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txStok, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txTLP, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txStok1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txALMT, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txStok2)
                        .addGap(33, 33, 33)
                        .addComponent(txTGLB, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txStok3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txTGLP, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBARU)
                        .addGap(50, 50, 50)
                        .addComponent(btnUBAH)
                        .addGap(56, 56, 56)
                        .addComponent(btnHAPUS)
                        .addGap(58, 58, 58)
                        .addComponent(btnTUTUP)))
                .addGap(30, 30, 30))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(photoPnjr, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txIDBarang1)
                    .addComponent(txIDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txNama))
                    .addComponent(txNAMAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txHargaBeli))
                    .addComponent(txHRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txHargaJual))
                    .addComponent(txJML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txStok))
                    .addComponent(txTLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txStok1))
                    .addComponent(txALMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txStok2))
                    .addComponent(txTGLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txStok3))
                    .addComponent(txTGLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBARU)
                    .addComponent(btnUBAH)
                    .addComponent(btnHAPUS)
                    .addComponent(btnTUTUP)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
    int jwb = JOptionPane.showOptionDialog(
            this, "Yakin Menghapus Data?" + txNAMAP.getText() + "?",
            "Hapus Data",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null, 
            null,
            null);

    if (jwb == JOptionPane.YES_OPTION) {
        try {
            int id = Integer.parseInt(txIDP.getText());
            destroyData();
            List_All();
            kosongkanform();
        } catch (SQLException ex) {
            Logger.getLogger(jForm2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(jForm2.class.getName()).log(Level.WARNING, "Invalid ID format", ex);
        }
    }
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void txIDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIDPActionPerformed

    private void btnUBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUBAHActionPerformed
          try {
        UpdateData();
        List_All();
        
        JOptionPane.showMessageDialog(this, "Data Telah Diperbaharui");
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "An unexpected error occurred", "Error", JOptionPane.ERROR_MESSAGE);
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
                Logger.getLogger(jForm2.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(jForm2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBARUActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txIDP.setText( jTable1.getValueAt( jTable1.getSelectedRow(),0 ).toString() );
        txNAMAP.setText( jTable1.getValueAt( jTable1.getSelectedRow(), 1).toString() );
        txHRG.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() );
        txJML.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString() );
        txTLP.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString() );
        txTGLB.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        txTGLP.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        txALMT.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        loadphoto(txIDP.getText());
    }//GEN-LAST:event_jTable1MouseClicked

    private void txALMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txALMTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txALMTActionPerformed

    private void txTGLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTGLPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTGLPActionPerformed

    private void txTGLBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTGLBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTGLBActionPerformed

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
            java.util.logging.Logger.getLogger(jForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new jForm2().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(jForm2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBARU;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnTUTUP;
    private javax.swing.JButton btnUBAH;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photoPnjr;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField txALMT;
    private javax.swing.JTextField txHRG;
    private javax.swing.JLabel txHargaBeli;
    private javax.swing.JLabel txHargaJual;
    private javax.swing.JLabel txIDBarang1;
    private javax.swing.JTextField txIDP;
    private javax.swing.JTextField txJML;
    private javax.swing.JTextField txNAMAP;
    private javax.swing.JLabel txNama;
    private javax.swing.JLabel txStok;
    private javax.swing.JLabel txStok1;
    private javax.swing.JLabel txStok2;
    private javax.swing.JLabel txStok3;
    private javax.swing.JTextField txTGLB;
    private javax.swing.JTextField txTGLP;
    private javax.swing.JTextField txTLP;
    // End of variables declaration//GEN-END:variables

}
