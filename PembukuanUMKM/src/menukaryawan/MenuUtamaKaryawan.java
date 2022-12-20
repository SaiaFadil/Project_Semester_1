/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menukaryawan;

import pembukuanumkm.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author laptophp
 */
public class MenuUtamaKaryawan extends javax.swing.JFrame {

    
    public void tampilPH(){
        
       try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            System.out.println(date);
            String tgl = date.toString();
            txtTgl.setText(tgl);
            
           
            String total = "SELECT SUM(total_harga) AS total FROM transaksi_penjualan WHERE tanggal_transaksi = '"+txtTgl.getText()+"';";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

             //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPDH.setText(String.valueOf("Rp. "+rs.getString("total")));
            }else {
                 this.txtPDH.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        } } 
    
         public void tampilPB(){
        
       try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            System.out.println(date);
            String tgl = date.toString();
            txtTgl.setText(tgl);
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
           
            String total = "SELECT SUM(total_harga) AS total FROM transaksi_penjualan WHERE MONTH (tanggal_transaksi) = '"+txtTgl.getText().toString().substring(5,7)+"';";
            System.out.println(total);
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

             //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPDH1.setText(String.valueOf("Rp. "+rs.getString("total")));
            }else {
                 this.txtPDH1.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        } } 
  public void tampilPNGH(){
        
       try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            System.out.println(date);
            String tgl = date.toString();
            txtTgl.setText(tgl);
            
           
            String total = "SELECT SUM(total_harga) AS total FROM transaksi_pembelian WHERE tanggal_transaksi_beli = '"+txtTgl.getText()+"';";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

             //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPNGH.setText(String.valueOf("Rp. "+rs.getString("total")));
               
            }else {
                 this.txtPNGH.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        } } 
    public void tampilPNGB(){
        
       try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            System.out.println(date);
            String tgl = date.toString();
            txtTgl.setText(tgl);
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
           
            String total = "SELECT SUM(total_harga) AS total FROM transaksi_pembelian WHERE MONTH (tanggal_transaksi_beli) = '"+txtTgl.getText().toString().substring(5,7)+"';";
            System.out.println(total);
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

             //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPNGB.setText(String.valueOf("Rp. "+rs.getString("total")));
            }else {
                 this.txtPNGB.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        } } 
    public MenuUtamaKaryawan() {
        initComponents();
       tampilPH();
    tampilPB();
    tampilPNGH();
    tampilPNGB();
    ImageIcon icon = new ImageIcon("C:\\Users\\laptophp\\Downloads\\CIRCLE.png");
this.setIconImage(icon.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        btnTPembelian = new javax.swing.JButton();
        btnLapBMasuk = new javax.swing.JButton();
        btnLapBKeluar = new javax.swing.JButton();
        btnDataKaryawan = new javax.swing.JButton();
        btnTPenjualan = new javax.swing.JButton();
        kembaliLogin = new javax.swing.JButton();
        Keluarbtn = new javax.swing.JButton();
        btnDataBarang = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtPNGH = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtPNGB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPDH = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtPDH1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTgl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1378, 767));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1378, 767));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTPembelian.setBackground(new java.awt.Color(51, 51, 51));
        btnTPembelian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTPembelian.setForeground(new java.awt.Color(255, 255, 255));
        btnTPembelian.setContentAreaFilled(false);
        btnTPembelian.setFocusable(false);
        btnTPembelian.setInheritsPopupMenu(true);
        btnTPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPembelianActionPerformed(evt);
            }
        });
        jPanel9.add(btnTPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 300, 60));

        btnLapBMasuk.setBackground(new java.awt.Color(51, 51, 51));
        btnLapBMasuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLapBMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnLapBMasuk.setContentAreaFilled(false);
        btnLapBMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapBMasukActionPerformed(evt);
            }
        });
        jPanel9.add(btnLapBMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 300, 60));

        btnLapBKeluar.setBackground(new java.awt.Color(51, 51, 51));
        btnLapBKeluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLapBKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnLapBKeluar.setContentAreaFilled(false);
        btnLapBKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapBKeluarActionPerformed(evt);
            }
        });
        jPanel9.add(btnLapBKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 300, 60));

        btnDataKaryawan.setBackground(new java.awt.Color(51, 51, 51));
        btnDataKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnDataKaryawan.setContentAreaFilled(false);
        btnDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKaryawanActionPerformed(evt);
            }
        });
        jPanel9.add(btnDataKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 300, 60));

        btnTPenjualan.setBackground(new java.awt.Color(51, 51, 51));
        btnTPenjualan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btnTPenjualan.setContentAreaFilled(false);
        btnTPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPenjualanActionPerformed(evt);
            }
        });
        jPanel9.add(btnTPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 300, 60));

        kembaliLogin.setBackground(java.awt.Color.red);
        kembaliLogin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        kembaliLogin.setForeground(new java.awt.Color(255, 255, 255));
        kembaliLogin.setContentAreaFilled(false);
        kembaliLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliLoginActionPerformed(evt);
            }
        });
        jPanel9.add(kembaliLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        Keluarbtn.setBackground(java.awt.Color.red);
        Keluarbtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Keluarbtn.setForeground(new java.awt.Color(255, 255, 255));
        Keluarbtn.setContentAreaFilled(false);
        Keluarbtn.setHideActionText(true);
        Keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarbtnActionPerformed(evt);
            }
        });
        jPanel9.add(Keluarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 80, 70));

        btnDataBarang.setBackground(new java.awt.Color(51, 51, 51));
        btnDataBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnDataBarang.setContentAreaFilled(false);
        btnDataBarang.setFocusPainted(false);
        btnDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataBarangActionPerformed(evt);
            }
        });
        jPanel9.add(btnDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 310, 60));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("         TENTANG APLIKASI");
        jButton1.setActionCommand("");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 640, 260, 40));

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(255, 222, 47)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBackground(new java.awt.Color(255, 222, 47));

        jPanel6.setBackground(new java.awt.Color(255, 222, 47));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setText("PENGELUARAN HARI INI :");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, -1));

        txtPNGH.setEditable(false);
        txtPNGH.setBackground(new java.awt.Color(255, 222, 47));
        txtPNGH.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtPNGH.setBorder(null);
        txtPNGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNGHActionPerformed(evt);
            }
        });
        jPanel6.add(txtPNGH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, 40));

        jTabbedPane2.addTab("Harian", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 222, 47));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPNGB.setEditable(false);
        txtPNGB.setBackground(new java.awt.Color(255, 222, 47));
        txtPNGB.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtPNGB.setBorder(null);
        txtPNGB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNGBActionPerformed(evt);
            }
        });
        jPanel7.add(txtPNGB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setText("PENGELUARAN BULAN INI :");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, -1));

        jTabbedPane2.addTab("Bulanan", jPanel7);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 397, 413));

        jPanel8.setBackground(new java.awt.Color(255, 204, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel3.setText("PENGELUARAN");
        jPanel8.add(jLabel3);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 50));

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 430, 500));

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(255, 222, 47)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 222, 47));

        jPanel3.setBackground(new java.awt.Color(255, 222, 47));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setText("PENDAPATAN HARI INI :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, -1));

        txtPDH.setEditable(false);
        txtPDH.setBackground(new java.awt.Color(255, 222, 47));
        txtPDH.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtPDH.setBorder(null);
        txtPDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPDHActionPerformed(evt);
            }
        });
        jPanel3.add(txtPDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, 40));

        jTabbedPane1.addTab("Harian", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 222, 47));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPDH1.setEditable(false);
        txtPDH1.setBackground(new java.awt.Color(255, 222, 47));
        txtPDH1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtPDH1.setBorder(null);
        txtPDH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPDH1ActionPerformed(evt);
            }
        });
        jPanel4.add(txtPDH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setText("PENDAPATAN BULAN INI :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, -1));

        jTabbedPane1.addTab("Bulanan", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 397, 413));

        jPanel5.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setText("PENDAPATAN");
        jPanel5.add(jLabel1);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 50));

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 430, 500));

        txtTgl.setBackground(new java.awt.Color(255, 222, 47));
        txtTgl.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtTgl.setBorder(null);
        jPanel9.add(txtTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 630, 210, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\laptophp\\Documents\\NetBeansProjects\\PembukuanUMKM\\src\\images\\dashboard.png")); // NOI18N
        jLabel2.setText("TENTANG APLIKASI");
        jLabel2.setMinimumSize(new java.awt.Dimension(1378, 767));
        jLabel2.setPreferredSize(new java.awt.Dimension(1378, 767));
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));

        jScrollPane1.setViewportView(jPanel9);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KeluarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarbtnActionPerformed
       int dialogBtn = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this,"ANDA YAKIN AKAN KELUAR?", "PERINGATAN!",dialogBtn);
  if (dialogResult == 0 ){
      System.exit(0);
  }else{
      
  }
    }//GEN-LAST:event_KeluarbtnActionPerformed

    private void btnDataKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKaryawanActionPerformed
       new datakariawan().setVisible(true);   
        this.setVisible(false); 
             // TODO add your handling code here:
    }//GEN-LAST:event_btnDataKaryawanActionPerformed

    private void btnLapBMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBMasukActionPerformed
     JOptionPane.showMessageDialog(null, "MAAF\n"
           + "HANYA ADMIN YANG BISA MELIHAT MENU LAPORAN!");       // TODO add your handling code here:
    }//GEN-LAST:event_btnLapBMasukActionPerformed

    private void btnLapBKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBKeluarActionPerformed
   JOptionPane.showMessageDialog(null, "MAAF\n"
           + "HANYA ADMIN YANG BISA MELIHAT MENU LAPORAN!"); 
         // TODO add your handling code here:
    }//GEN-LAST:event_btnLapBKeluarActionPerformed

    private void btnTPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPembelianActionPerformed
new TransaksiPembelianKaryawan().setVisible(true);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnTPembelianActionPerformed

    private void btnTPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPenjualanActionPerformed
new TransaksiPenjualanKaryawan().setVisible(true);
        this.setVisible( false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnTPenjualanActionPerformed

    private void btnDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBarangActionPerformed



        new DataBarangKaryawan().setVisible(true); 
        
        
        this.setVisible(false);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnDataBarangActionPerformed

    private void kembaliLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliLoginActionPerformed

new LoginUser().setVisible(true);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_kembaliLoginActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
new tentangaplikasi(this, rootPaneCheckingEnabled).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPDHActionPerformed

    private void txtPDH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPDH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPDH1ActionPerformed

    private void txtPNGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNGHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPNGHActionPerformed

    private void txtPNGBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNGBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPNGBActionPerformed

    
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
            java.util.logging.Logger.getLogger(MenuUtamaKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtamaKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Keluarbtn;
    private javax.swing.JButton btnDataBarang;
    private javax.swing.JButton btnDataKaryawan;
    private javax.swing.JButton btnLapBKeluar;
    private javax.swing.JButton btnLapBMasuk;
    private javax.swing.JButton btnTPembelian;
    private javax.swing.JButton btnTPenjualan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton kembaliLogin;
    private javax.swing.JTextField txtPDH;
    private javax.swing.JTextField txtPDH1;
    private javax.swing.JTextField txtPNGB;
    private javax.swing.JTextField txtPNGH;
    private javax.swing.JTextField txtTgl;
    // End of variables declaration//GEN-END:variables
}
