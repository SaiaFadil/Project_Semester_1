/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pembukuanumkm;

//import PreviewPrint.TampilkanTransaksiJual;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laptophp
 */
public class TransaksiPenjualan extends javax.swing.JFrame {
 
   
    List<String> menuBahanDiplih = new ArrayList<>();
   public void showbarang(){
           try {
            String kode_barang = tabelbarang.getValueAt(this.tabelbarang.getSelectedRow(), 0).toString();
            
           
              
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT id_produk, nama_produk FROM data_barang WHERE id_produk = '" + kode_barang + "'");
            if (r.next()) {
                menuBahanDiplih = getSelectedMenuBahanFromIdProduk(r.getString("id_produk"));
                System.out.println("id_produk = " + r.getString("id_produk"));
            
                this.txtKBarang.setText(r.getString("id_produk"));
                this.txtNBarang.setText(r.getString("nama_produk"));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }}
  
     public void tabelkaryawan() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("kode karyawan");
        tbl.addColumn("Nama karyawan");
        tabelkaryawan.setModel(tbl);

        try {
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            ResultSet res = statement.executeQuery("SELECT kode_karyawan,nama_karyawan FROM data_karyawan");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kode_karyawan"),
                    res.getString("Nama_karyawan")
                });
                tabelkaryawan.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Salah" + e.getMessage());
        }

    }
   public void showkaryawan() {

        try {
            String kode_barang = tabelkaryawan.getValueAt(this.tabelkaryawan.getSelectedRow(), 0).toString();
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT kode_karyawan,nama_karyawan FROM data_karyawan WHERE kode_karyawan = '" + kode_barang + "'");
            if (r.next()) {

                this.txtKKaryawan.setText(r.getString("kode_karyawan"));
                this.txtNKaryawan.setText(r.getString("nama_karyawan"));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public void loadtable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("tanggal transaksi");
        tbl.addColumn("id transaksi jual");
        tbl.addColumn("id produk");
        tbl.addColumn("Nama produk");
        tbl.addColumn("Jumlah produk");
        tbl.addColumn("total harga");
        tbl.addColumn("Kode karyawan");
        tbl.addColumn("Nama karyawan");

        loadtable.setModel(tbl);

        //String cari = txtCari.getText();
        try {

            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM transaksi_penjualan order by tanggal_transaksi desc");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("tanggal_transaksi"),
                    res.getString("id_transaksi_jual"),
                    res.getString("id_produk"),
                    res.getString("Nama_produk"),
                    res.getInt("jumlah_produk"),
                    res.getInt("total_harga"),
                    res.getString("kode_karyawan"),
                    res.getString("nama_karyawan")
                });
                loadtable.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Salah" + e.getMessage());
        }

    }
    
//public void autos um(){
//    int total = 0;
//    for(int i = 0; i < loadtable.getRowCount(); i++){
//        int amount = Integer.parseInt((String)loadtable.getValueAt(i, 5));
//        total += amount;
//    }
//   labelpendapatan.setText(""+total);
//}
    
    
    public void tabelbarang() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id produk");
        tbl.addColumn("Rasa Produk");
        tabelbarang.setModel(tbl);

        try {
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM data_barang");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_produk"),
                    res.getString("nama_produk")
                });
                tabelbarang.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Salah" + e.getMessage());
        }

    }

//    public void tampil_combo() {
//        try {
//            String sql = "Select * from data_karyawan";
//            java.sql.Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
//            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                txtKKaryawan.addItem(rs.getString("nama_karyawan"));
//            }
//
//            rs.last();
//            int jumlahdata = rs.getRow();
//
//            rs.first();
//        } catch (Exception e) {
//        }
//    }

    public void id_trans() {
        try {
            String sql = "SELECT id_transaksi_jual FROM transaksi_penjualan order by id_transaksi_jual desc";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String Idno = rs.getString("id_transaksi_jual").substring(2);
                String AN = "" + (Integer.parseInt(Idno) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "00";
                } else if (AN.length() == 2) {
                    Nol = "0";
                } else if (AN.length() == 3) {
                    Nol = "";

                }

                txtIdtrans.setText("TJ" + Nol + AN);
            } else {
                txtIdtrans.setText("TJ001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR " + e.getMessage());
        }
    }

    private void showData() {
        try {
            String id_transaksi = loadtable.getValueAt(this.loadtable.getSelectedRow(), 1).toString();
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT tanggal_transaksi, id_transaksi_jual ,id_produk, nama_produk, jumlah_produk, total_harga , kode_karyawan FROM transaksi_penjualan WHERE id_transaksi_jual = '" + id_transaksi + "'");
            if (r.next()) {

                this.txtTanggal.setText(r.getString("tanggal_transaksi"));
                this.txtIdtrans.setText(r.getString("id_transaksi_jual"));
                this.txtKBarang.setText(r.getString("id_produk"));
                this.txtNBarang.setText(r.getString("nama_produk"));
                this.txtJumlah.setText(r.getString("jumlah_produk"));
                this.txtTotalHarga.setText(r.getString("total_harga"));
//                this.txtKKaryawan.setSelectedItem(r.getString("kode_karyawan"));
            }

        } catch (SQLException | ClassNotFoundException ex) {

            ex.printStackTrace();

        }

    }

    public void tanggall() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        String tgl = date.toString();
        txtTanggal.setText(tgl);
    }

    public TransaksiPenjualan() {
        initComponents();
        loadtable();
        id_trans();
        bersihkan();
        tabelkaryawan();
        tanggall();
        tabelbarang();
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

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtTanggal = new javax.swing.JTextField();
        backtomenu2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        loadtable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        txtKBarang = new javax.swing.JTextField();
        txtNBarang = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        refreshs = new javax.swing.JButton();
        txtIdtrans = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        btnLapBMasuk = new javax.swing.JButton();
        btnTPembelian = new javax.swing.JButton();
        btnLapBKeluar = new javax.swing.JButton();
        btnDataKaryawan = new javax.swing.JButton();
        btnDataBarang = new javax.swing.JButton();
        backtomenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tb = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelkaryawan = new javax.swing.JTable();
        tb1 = new javax.swing.JTextField();
        txtNKaryawan = new javax.swing.JTextField();
        txtKKaryawan = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1378, 767));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTanggal.setEditable(false);
        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));
        txtTanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTanggal.setBorder(null);
        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });
        txtTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTanggalKeyPressed(evt);
            }
        });
        jPanel1.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 140, 30));

        backtomenu2.setBackground(new java.awt.Color(255, 0, 0));
        backtomenu2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        backtomenu2.setForeground(new java.awt.Color(255, 255, 255));
        backtomenu2.setBorder(null);
        backtomenu2.setContentAreaFilled(false);
        backtomenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backtomenu2MousePressed(evt);
            }
        });
        backtomenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtomenu2ActionPerformed(evt);
            }
        });
        jPanel1.add(backtomenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        loadtable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal Transaksi", "ID TRANSAKSI", "Nama Barang", "Jumlah barang", "Total Harga", "Title 6", "Title 7", "Title 8"
            }
        ));
        loadtable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadtable.setRowHeight(30);
        loadtable.setRowMargin(2);
        loadtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(loadtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 870, 260));

        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelbarang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 160, 240, 110));

        btnSimpan.setBackground(new java.awt.Color(255, 255, 0));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 140, 40));

        txtKBarang.setEditable(false);
        txtKBarang.setBackground(new java.awt.Color(255, 255, 255));
        txtKBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKBarang.setBorder(null);
        txtKBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKBarangActionPerformed(evt);
            }
        });
        txtKBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKBarangKeyPressed(evt);
            }
        });
        jPanel1.add(txtKBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 140, 30));

        txtNBarang.setEditable(false);
        txtNBarang.setBackground(new java.awt.Color(255, 255, 255));
        txtNBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNBarang.setBorder(null);
        txtNBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNBarangActionPerformed(evt);
            }
        });
        txtNBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNBarangKeyPressed(evt);
            }
        });
        jPanel1.add(txtNBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 140, 30));

        btnHapus.setBackground(new java.awt.Color(255, 255, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 150, 40));

        refreshs.setBackground(new java.awt.Color(255, 255, 0));
        refreshs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refreshs.setContentAreaFilled(false);
        refreshs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshsActionPerformed(evt);
            }
        });
        jPanel1.add(refreshs, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 310, 40));

        txtIdtrans.setEditable(false);
        txtIdtrans.setBackground(new java.awt.Color(255, 255, 255));
        txtIdtrans.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdtrans.setBorder(null);
        txtIdtrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdtransKeyPressed(evt);
            }
        });
        jPanel1.add(txtIdtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 140, 30));

        txtJumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtJumlah.setBorder(null);
        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahKeyPressed(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 140, 20));

        txtTotalHarga.setEditable(false);
        txtTotalHarga.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalHarga.setBorder(null);
        txtTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHargaActionPerformed(evt);
            }
        });
        txtTotalHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalHargaKeyPressed(evt);
            }
        });
        jPanel1.add(txtTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 140, 20));

        btnLapBMasuk.setBackground(new java.awt.Color(51, 51, 51));
        btnLapBMasuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLapBMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnLapBMasuk.setContentAreaFilled(false);
        btnLapBMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapBMasukActionPerformed(evt);
            }
        });
        jPanel1.add(btnLapBMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 300, 60));

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
        jPanel1.add(btnTPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 300, 60));

        btnLapBKeluar.setBackground(new java.awt.Color(51, 51, 51));
        btnLapBKeluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLapBKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnLapBKeluar.setContentAreaFilled(false);
        btnLapBKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapBKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLapBKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 300, 60));

        btnDataKaryawan.setBackground(new java.awt.Color(51, 51, 51));
        btnDataKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnDataKaryawan.setContentAreaFilled(false);
        btnDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(btnDataKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 300, 50));

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
        jPanel1.add(btnDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 300, 60));

        backtomenu.setBackground(new java.awt.Color(255, 0, 0));
        backtomenu.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        backtomenu.setForeground(new java.awt.Color(255, 255, 255));
        backtomenu.setContentAreaFilled(false);
        backtomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backtomenuMousePressed(evt);
            }
        });
        backtomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtomenuActionPerformed(evt);
            }
        });
        jPanel1.add(backtomenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 80, 60));

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        jButton1.setText("<html> PETUNJUK PENGGUNAAN</html>");
        jButton1.setToolTipText("");
        jButton1.setActionCommand("<html><p>Belum Tau Cara Pakai?</p>\n<p>Klik disini</p></html>\n");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName(""); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, -10, 170, 60));

        tb.setEditable(false);
        tb.setBackground(new java.awt.Color(255, 204, 0));
        tb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tb.setText("                     Tabel Produk");
        tb.setBorder(null);
        tb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbActionPerformed(evt);
            }
        });
        jPanel1.add(tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 130, 240, 30));

        tabelkaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkaryawanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelkaryawan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 300, 240, 110));

        tb1.setEditable(false);
        tb1.setBackground(new java.awt.Color(255, 204, 0));
        tb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tb1.setText("                   Tabel Karyawan");
        tb1.setBorder(null);
        tb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb1ActionPerformed(evt);
            }
        });
        jPanel1.add(tb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 270, 240, 30));

        txtNKaryawan.setEditable(false);
        txtNKaryawan.setBackground(new java.awt.Color(255, 255, 255));
        txtNKaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNKaryawan.setBorder(null);
        txtNKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNKaryawanActionPerformed(evt);
            }
        });
        txtNKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNKaryawanKeyPressed(evt);
            }
        });
        jPanel1.add(txtNKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, 140, 30));

        txtKKaryawan.setEditable(false);
        txtKKaryawan.setBackground(new java.awt.Color(255, 255, 255));
        txtKKaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKKaryawan.setBorder(null);
        txtKKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKKaryawanActionPerformed(evt);
            }
        });
        txtKKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKKaryawanKeyPressed(evt);
            }
        });
        jPanel1.add(txtKKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 150, 30));

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setText("TAMPILKAN MENU PRODUK");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 620, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\laptophp\\Documents\\NetBeansProjects\\PembukuanUMKM\\src\\images\\Transaksi jual.png")); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(1366, 768));
        jLabel2.setMinimumSize(new java.awt.Dimension(1366, 768));
        jLabel2.setPreferredSize(new java.awt.Dimension(1366, 768));
        jLabel2.setRequestFocusEnabled(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane4.setViewportView(jPanel1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadtableMouseClicked
//        showData();
    }//GEN-LAST:event_loadtableMouseClicked

    private void txtTotalHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalHargaKeyPressed

    }//GEN-LAST:event_txtTotalHargaKeyPressed

    public void debugLog(String messg){
        System.out.printf("%s%n",messg);
    }
    private void txtIdtransKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdtransKeyPressed

    }//GEN-LAST:event_txtIdtransKeyPressed
    public List<String> getSelectedMenuBahanFromIdProduk(String id_produk){ //untuk membuat list pada detail produk,smoga wktu sidang sy ga lupa:v
        List<String> bahanList = new ArrayList<>(); 
        try{
       String queryGetStockMenu = "SELECT * FROM `detail_produk` JOIN `data_barang` ON `detail_produk`.`id_produk` = `data_barang`.`id_produk` JOIN `data_bmentah` ON `detail_produk`.`id_bahan` = `data_bmentah`.`id_bahan` WHERE `detail_produk`.`id_produk` = '" + id_produk + "';";
       System.out.println(queryGetStockMenu + " TEST QUERY");
       java.sql.Statement stmGetStock = Koneksi.koneksi.getKoneksi().createStatement();
       java.sql.ResultSet rs = stmGetStock.executeQuery(queryGetStockMenu);
       while(rs.next()){
           System.out.println("bahan = " + rs.getString("id_bahan"));
           bahanList.add(rs.getString("id_bahan"));
       }
       System.out.println("size data = " + bahanList.size());
       return bahanList;
      }catch(Exception e){
               e.printStackTrace();
       }   
        System.out.println("size data = " + bahanList.size());
      return bahanList;
    }
     public int getCurrentStockMenu(String id_bahan){
      try{
       String queryGetStockMenu = "SELECT * FROM `data_bmentah` WHERE `id_bahan` = '" + id_bahan +"'";
       java.sql.Statement stmGetStock = Koneksi.koneksi.getKoneksi().createStatement();
       java.sql.ResultSet rs = stmGetStock.executeQuery(queryGetStockMenu);
     
       while(rs.next()){
        return Integer.parseInt(rs.getString("Stok_bahan"));
       }
       
      }catch(Exception e){
            e.printStackTrace();
       }   
        return 0;
   }
     public void updateStock(String idBahan,int stockTerbaru){
  
        try {
         String queryUpdate="UPDATE `data_bmentah` SET `stok_bahan` = '"  + stockTerbaru + "' WHERE `id_bahan` = '" + idBahan +"';";
           System.out.println("QueryUpdate = " + queryUpdate);
         java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
                statement.executeUpdate(queryUpdate);
        } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
            
            Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        for(String sMenuBahanDipilih : this.menuBahanDiplih){
         
            int currentStockBahan = getCurrentStockMenu(sMenuBahanDipilih) - Integer.parseInt(txtJumlah.getText().toString());
            updateStock(sMenuBahanDipilih,currentStockBahan);

        }
        
      
        
     
        String tgl = txtTanggal.getText();
        String id = txtIdtrans.getText();
        String idp = txtKBarang.getText();
        String nama = txtNBarang.getText();
        String jumlah = txtJumlah.getText();
        String total = txtTotalHarga.getText();
        String kk = txtKKaryawan.getText();
        String nk = txtNKaryawan.getText();
//        String kode = (String) txtKKaryawan.getSelectedItem();

        try {
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            statement.executeUpdate("insert into transaksi_penjualan VALUES ('" + tgl + "','" + id + "','" + idp + "','" + nama + "','" + jumlah + "'," + total + ",'" + kk + "','" + nk+ "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan ");
        }
        loadtable();
        bersihkan();
        tabelbarang();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

        try {
            int jawab = JOptionPane.showOptionDialog(this,
                    "Ingin Hapus Data??",
                    "PILIH!",   
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (jawab == JOptionPane.YES_OPTION) {
                String id_transaksi = loadtable.getValueAt(this.loadtable.getSelectedRow(), 1).toString();
                java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
                statement.executeUpdate("DELETE FROM transaksi_penjualan where id_transaksi_jual=('" + id_transaksi + "');");
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Hapus");

                loadtable();
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Di HAPUS");
                this.refreshsActionPerformed(evt);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah");

        }
        loadtable();
        bersihkan();
    }//GEN-LAST:event_btnHapusActionPerformed

    public void bersihkan() {
        id_trans();
        txtKBarang.setText(null);
        // txtTanggal.setDate(null);
        txtJumlah.setText(null);
        txtTotalHarga.setText(null);
        txtNBarang.setText(null);
        txtKKaryawan.setText(null);
        txtNKaryawan.setText(null);

        loadtable();
    }
    private void refreshsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshsActionPerformed

        id_trans();
        txtJumlah.setText(null);
        txtTotalHarga.setText(null);
        txtNBarang.setText(null);
//        txtKKaryawan.setActionCommand(null);
        txtKBarang.setText(null);
        txtKKaryawan.setText(null);
        txtNKaryawan.setText(null);
        tabelkaryawan();
tabelbarang();
        loadtable();
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshsActionPerformed

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void txtTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTanggalKeyPressed

    }//GEN-LAST:event_txtTanggalKeyPressed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed


    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHargaActionPerformed

    }//GEN-LAST:event_txtTotalHargaActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
try {
            String total = "SELECT * FROM data_barang where id_produk ='" + txtKBarang.getText() + "'";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

                int jumlah = Integer.parseInt(txtJumlah.getText());
                this.txtTotalHarga.setText(String.valueOf(1000 * jumlah));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }        // TODO add your handling codere:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void backtomenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenu2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenu2MousePressed

    private void backtomenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomenu2ActionPerformed
        this.setVisible(false);
        new MenuUtama().setVisible(true);            // TODO add your handling code here:
    }//GEN-LAST:event_backtomenu2ActionPerformed

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked

     showbarang();
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelbarangMouseClicked

    private void txtNBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNBarangActionPerformed
txtNBarang.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_txtNBarangActionPerformed

    private void txtNBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNBarangKeyPressed

    private void txtKBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKBarangActionPerformed
txtKBarang.setEnabled(true);          // TODO add your handling code here:
    }//GEN-LAST:event_txtKBarangActionPerformed

    private void txtKBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKBarangKeyPressed

    private void btnLapBMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBMasukActionPerformed
   this.setVisible(false);
        new LaporanBarangMasuk().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLapBMasukActionPerformed

    private void btnTPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPembelianActionPerformed
        this.setVisible(false);
        new TransaksiPembelian().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnTPembelianActionPerformed

    private void btnLapBKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBKeluarActionPerformed
        this.setVisible(false);
        new LaporanBarangKeluar().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnLapBKeluarActionPerformed

    private void btnDataKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKaryawanActionPerformed
        this.setVisible(false);
        new DataKaryawan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnDataKaryawanActionPerformed

    private void btnDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBarangActionPerformed

        new DataBarang().setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDataBarangActionPerformed

    private void backtomenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenuMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenuMousePressed

    private void backtomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomenuActionPerformed
               int dialogBtn = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this,"ANDA YAKIN AKAN KELUAR?", "PERINGATAN!",dialogBtn);
  if (dialogResult == 0 ){
      System.exit(0);
  }else{
      
  }
   // TODO add your handling code here:
    }//GEN-LAST:event_backtomenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    new petunjuk.jual().setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbActionPerformed

    private void tabelkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkaryawanMouseClicked
showkaryawan();        // TODO add your handling code here:
    }//GEN-LAST:event_tabelkaryawanMouseClicked

    private void tb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tb1ActionPerformed

    private void txtNKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNKaryawanActionPerformed

    private void txtNKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNKaryawanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNKaryawanKeyPressed

    private void txtKKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKKaryawanActionPerformed

    private void txtKKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKKaryawanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKKaryawanKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     new Menuproduk(this, rootPaneCheckingEnabled).setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * new
     *
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
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPenjualan().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtomenu;
    private javax.swing.JButton backtomenu2;
    private javax.swing.JButton btnDataBarang;
    private javax.swing.JButton btnDataKaryawan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLapBKeluar;
    private javax.swing.JButton btnLapBMasuk;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTPembelian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable loadtable;
    private javax.swing.JButton refreshs;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JTable tabelkaryawan;
    private javax.swing.JTextField tb;
    private javax.swing.JTextField tb1;
    private javax.swing.JTextField txtIdtrans;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKBarang;
    private javax.swing.JTextField txtKKaryawan;
    private javax.swing.JTextField txtNBarang;
    private javax.swing.JTextField txtNKaryawan;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables

   
}
