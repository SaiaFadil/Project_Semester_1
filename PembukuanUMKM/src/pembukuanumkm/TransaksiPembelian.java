/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pembukuanumkm;

//import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laptophp
 */
public class TransaksiPembelian extends javax.swing.JFrame {

    public void tabelbarang() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id_bahan");
        tbl.addColumn("Nama_bahan");
        tbl.addColumn("stok_bahan");
        tabelbarang.setModel(tbl);

        try {
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM data_bmentah");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_bahan"),
                    res.getString("Nama_bahan"),
                    res.getString("stok_bahan")
                });
                tabelbarang.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Salah" );
        }

    }

    public void showbarang() {

        try {
            String kode_barang = tabelbarang.getValueAt(this.tabelbarang.getSelectedRow(), 0).toString();
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT id_bahan, nama_bahan FROM data_bmentah WHERE id_bahan = '" + kode_barang + "'");
            if (r.next()) {

                this.txtKBarang.setText(r.getString("id_bahan"));
                this.txtNBarang.setText(r.getString("nama_bahan"));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

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
            JOptionPane.showConfirmDialog(rootPane, "Salah" );
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
        tbl.addColumn("tanggal transaksi beli");
        tbl.addColumn("id transaksi beli");
        tbl.addColumn("Nama Bahan");
        tbl.addColumn("Jumlah Barang");
        tbl.addColumn("total harga");
        tbl.addColumn("Kode karyawan");
        tbl.addColumn("Nama karyawan");

        loadtable.setModel(tbl);

        //String cari = txtCari.getText();
        try {

            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM transaksi_pembelian order by tanggal_transaksi_beli desc");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("tanggal_transaksi_beli"),
                    res.getString("id_transaksi_beli"),
                    res.getString("Nama_Bahan"),
                    res.getInt("jumlah_Bahan"),
                    res.getString("total_harga"),
                    res.getString("kode_karyawan"),
                    res.getString("nama_karyawan")
                });
                loadtable.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Salah" + e.getMessage());
        }

    }

    public void id_transs() {
        try {
            String sql = "SELECT id_transaksi_beli FROM transaksi_pembelian order by id_transaksi_beli desc";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String Idno = rs.getString("id_transaksi_beli").substring(2);
                String AN = "" + (Integer.parseInt(Idno) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "00";
                } else if (AN.length() == 2) {
                    Nol = "0";
                } else if (AN.length() == 3) {
                    Nol = "";

                }

                txtIdtrans.setText("TP" + Nol + AN);
            } else {
                txtIdtrans.setText("TP001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR " + e.getMessage());
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
//                txtKKaryawan.addItem(rs.getString("kode_karyawan"));
//            }
//
//            rs.last();
//            int jumlahdata = rs.getRow();
//
//            rs.first();
//        } catch (Exception e) {
//        }
//    }
    public void tanggall() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        String tgl = date.toString();
        txtTanggal.setText(tgl);
    }

    public void id_trans() {
        try {
            String sql = "SELECT id_transaksi_beli FROM transaksi_pembelian order by id_transaksi_beli desc";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String Idno = rs.getString("id_transaksi_beli").substring(2);
                String AN = "" + (Integer.parseInt(Idno) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "00";
                } else if (AN.length() == 2) {
                    Nol = "0";
                } else if (AN.length() == 3) {
                    Nol = "";

                }
                txtIdtrans.setText("TB" + Nol + AN);
            } else {
                txtIdtrans.setText("TB001");
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
            ResultSet r = s.executeQuery("SELECT tanggal_transaksi_beli, id_transaksi_beli ,id_bahan, nama_bahan, jumlah_barang, total_harga , kode_karyawan,nama_karyawan FROM transaksi_pembelian WHERE id_transaksi_beli = '" + id_transaksi + "'");
            if (r.next()) {

                this.txtTanggal.setText(r.getString("tanggal_transaksi_beli"));
                this.txtIdtrans.setText(r.getString("id_transaksi_beli"));
                this.txtKBarang.setText(r.getString("id_bahan"));
                this.txtNKaryawan.setText(r.getString("nama_bahan"));
                this.txtJumlah.setText(r.getString("jumlah_bahan"));
                this.txtTotalHarga.setText(r.getString("total_harga"));
                this.txtKKaryawan.setText(r.getString("kode_karyawan"));
                this.txtNKaryawan.setText(r.getString("nama_karyawan"));
            }

        } catch (SQLException | ClassNotFoundException ex) {

            ex.printStackTrace();
        }
    }

    public void bersihkan() {
        id_trans();
        // txtTanggal.setDate(null);
        txtJumlah.setText(null);
        txtTotalHarga.setText(null);
        txtKKaryawan.setText(null);
        txtNBarang.setText(null);
        txtNKaryawan.setText(null);
        txtKBarang.setText(null);

        loadtable();
    }

    /**
     * Creates new form TransaksiPembelian
     */
    public TransaksiPembelian() {

        initComponents();
        loadtable();
        id_transs();
        tanggall();
        bersihkan();
        tabelbarang();
        tabelkaryawan();
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
        txtNKaryawan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIdtrans = new javax.swing.JTextField();
        refreshs = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        txtKBarang = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        loadtable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        txtTanggal = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btnLapBMasuk = new javax.swing.JButton();
        btnLapBKeluar = new javax.swing.JButton();
        btnDataKaryawan = new javax.swing.JButton();
        btnTPenjualan = new javax.swing.JButton();
        btnDataBarang = new javax.swing.JButton();
        backtomenu2 = new javax.swing.JButton();
        backtomenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tb = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelkaryawan = new javax.swing.JTable();
        tb1 = new javax.swing.JTextField();
        txtNBarang = new javax.swing.JTextField();
        txtKKaryawan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1378, 767));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1378, 767));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 27, 30));

        txtIdtrans.setEditable(false);
        txtIdtrans.setBackground(new java.awt.Color(255, 255, 255));
        txtIdtrans.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdtrans.setBorder(null);
        txtIdtrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdtransKeyPressed(evt);
            }
        });
        jPanel1.add(txtIdtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 130, 30));

        refreshs.setBackground(new java.awt.Color(255, 255, 0));
        refreshs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refreshs.setBorder(null);
        refreshs.setContentAreaFilled(false);
        refreshs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshsActionPerformed(evt);
            }
        });
        jPanel1.add(refreshs, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 310, 40));

        btnSimpan.setBackground(new java.awt.Color(255, 255, 0));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setBorder(null);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 130, 40));

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

        btnHapus.setBackground(new java.awt.Color(255, 255, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setBorder(null);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 150, 40));

        loadtable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal Transaksi", "ID TRANSAKSI", "Nama Barang", "Jumlah barang", "Total Harga", "Title 6", "Title 7", "Title 8", "Title 9"
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
        if (tabelbarang.getColumnModel().getColumnCount() > 0) {
            tabelbarang.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, 240, 110));

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
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 130, 20));

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
        jPanel1.add(btnDataKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 300, 60));

        btnTPenjualan.setBackground(new java.awt.Color(51, 51, 51));
        btnTPenjualan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btnTPenjualan.setContentAreaFilled(false);
        btnTPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPenjualanActionPerformed(evt);
            }
        });
        jPanel1.add(btnTPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 300, 60));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, -10, 170, 50));

        tb.setEditable(false);
        tb.setBackground(new java.awt.Color(255, 204, 0));
        tb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tb.setText("                      Tabel Bahan");
        tb.setBorder(null);
        tb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbActionPerformed(evt);
            }
        });
        jPanel1.add(tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, 240, 20));

        tabelkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabelkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkaryawanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelkaryawan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 290, 240, 110));

        tb1.setEditable(false);
        tb1.setBackground(new java.awt.Color(255, 204, 0));
        tb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tb1.setText("                    Tabel Karyawan");
        tb1.setBorder(null);
        tb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb1ActionPerformed(evt);
            }
        });
        jPanel1.add(tb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 270, 240, 20));

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
        jPanel1.add(txtKKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\laptophp\\Documents\\NetBeansProjects\\PembukuanUMKM\\src\\images\\transaksi Beli.png")); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(1378, 767));
        jLabel2.setMinimumSize(new java.awt.Dimension(1378, 767));
        jLabel2.setPreferredSize(new java.awt.Dimension(1378, 767));
        jLabel2.setRequestFocusEnabled(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane4.setViewportView(jPanel1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNKaryawanActionPerformed

    private void txtNKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNKaryawanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNKaryawanKeyPressed

    private void txtIdtransKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdtransKeyPressed

    }//GEN-LAST:event_txtIdtransKeyPressed

    private void refreshsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshsActionPerformed

        id_trans();
        txtJumlah.setText(null);
        txtTotalHarga.setText(null);
        txtNBarang.setText(null);
        txtKBarang.setText(null);
        txtNKaryawan.setText(null);
        txtKKaryawan.setText(null);
        tabelbarang();
        tabelkaryawan();
        loadtable();
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshsActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String tgl = txtTanggal.getText();
        String id = txtIdtrans.getText();
        String kb = txtKBarang.getText();
        String nama = txtNBarang.getText();
        String jumlah = txtJumlah.getText();
        String total = txtTotalHarga.getText();
        String kk = txtKKaryawan.getText();
        String nk = txtNKaryawan.getText();

        try {
            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            statement.executeUpdate("insert into transaksi_pembelian VALUES ('" + tgl + "','" + id + "','" + kb + "','" + nama + "','" + jumlah + "'," + total + ",'" + kk + "','" + nk + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan ");
        }
        loadtable();
        bersihkan();
        tabelbarang();
        tabelkaryawan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtKBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKBarangActionPerformed

    private void txtKBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKBarangKeyPressed

    private void txtTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHargaActionPerformed

    }//GEN-LAST:event_txtTotalHargaActionPerformed

    private void txtTotalHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalHargaKeyPressed

    }//GEN-LAST:event_txtTotalHargaKeyPressed

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
                statement.executeUpdate("DELETE FROM transaksi_pembelian where id_transaksi_beli=('" + id_transaksi + "');");
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

    private void loadtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadtableMouseClicked
        showData();
    }//GEN-LAST:event_loadtableMouseClicked

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed

    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTanggalKeyPressed

    }//GEN-LAST:event_txtTanggalKeyPressed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
//        try {
//            String total = "SELECT * FROM data_barang where id_barang ='" + txtKBarang.getText() + "'";
//            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
//            java.sql.Statement st = conn.createStatement();
//            java.sql.ResultSet rs = st.executeQuery(total);
//            if (rs.next()) {
//                
//                int jumlah = Integer.parseInt(txtJumlah.getText());
//                this.txtTotalHarga.setText(String.valueOf(500 * jumlah));
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//            
//        }                // TODO add your handling codere:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void backtomenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenu2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenu2MousePressed

    private void backtomenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomenu2ActionPerformed
        this.setVisible(false);
        new MenuUtama().setVisible(true);            // TODO add your handling code here:
    }//GEN-LAST:event_backtomenu2ActionPerformed

    private void backtomenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenuMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenuMousePressed

    private void backtomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomenuActionPerformed
        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "ANDA YAKIN AKAN KELUAR?", "PERINGATAN!", dialogBtn);
        if (dialogResult == 0) {
            System.exit(0);
        } else {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenuActionPerformed

    private void btnLapBMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBMasukActionPerformed
        this.setVisible(false);
        new LaporanBarangMasuk().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLapBMasukActionPerformed

    private void btnLapBKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapBKeluarActionPerformed
        this.setVisible(false);
        new LaporanBarangKeluar().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnLapBKeluarActionPerformed

    private void btnDataKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKaryawanActionPerformed
        this.setVisible(false);
        new DataKaryawan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnDataKaryawanActionPerformed

    private void btnTPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPenjualanActionPerformed
        this.setVisible(false);
        new TransaksiPenjualan().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnTPenjualanActionPerformed

    private void btnDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBarangActionPerformed

        new DataBarang().setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDataBarangActionPerformed

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked

        showbarang();
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelbarangMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new petunjuk.beli().setVisible(true);        // TODO add your handling code here:
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

    private void txtNBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNBarangActionPerformed

    private void txtNBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNBarangKeyPressed

    private void txtKKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKKaryawanActionPerformed

    private void txtKKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKKaryawanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKKaryawanKeyPressed

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
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPembelian().setVisible(true);
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
    private javax.swing.JButton btnTPenjualan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
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

//    CATATAN CODINGAN 
//public final Connection conn = null;
//    JasperReport JasRep;
//JasperPrint JasPrint;
//Map param = new HashMap(2);    
//
//public void tampil_combo1(){
//    
//    txtRasa.removeAllItems();
//    txtRasa.addItem("--- Pilih Rasa ---");
//    try {
//         String sql = "SELECT * FROM transaksi_pembelian order by id_transaksi_beli asc";
//            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
//            java.sql.Statement stm = conn.createStatement();
//           ResultSet res = stm.executeQuery(sql);
//            
//            while (res.next()){
//                txtRasa.addItem(res.getString("kode_barang"));
//                
//            }
//            
//    } catch (Exception e) {
//        System.out.println(e.getMessage());
//    }
//}
