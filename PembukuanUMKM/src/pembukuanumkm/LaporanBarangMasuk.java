/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pembukuanumkm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LaporanBarangMasuk extends javax.swing.JFrame {

//    public void bulan (){
//        
//        String kondisi = txtbln.getToolTipText();
//    }
    
    
    
    
    
    
//    public void tbll() {
//        DefaultTableModel tbl = new DefaultTableModel();
//        tbl.addColumn("Tanggal terjual");
//        tbl.addColumn("id transaksi");
//        tbl.addColumn("kode barang");
//        tbl.addColumn("Nama barang");
//        tbl.addColumn("Jumlah barang");
//        tbl.addColumn("Total Pengeluaran");
//        tbl.addColumn("kode karyawan");
//        tbl.addColumn("nama karyawan");
//        tbll.setModel(tbl);
//
////    private void showData() {
//        try {
//            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
//            Statement s = conn.createStatement();
//            ResultSet res = s.executeQuery("SELECT transaksi_pembelian.tanggal_transaksi_beli,transaksi_pembelian.id_transaksi_beli,data_bmentah.id_barang,\n" +
//"transaksi_pembelian.nama_barang,transaksi_pembelian.jumlah_barang,transaksi_pembelian.total_harga,data_karyawan.kode_karyawan,data_karyawan.nama_karyawan\n" +
//"FROM transaksi_pembelian, data_bmentah, data_karyawan WHERE data_karyawan.kode_karyawan = transaksi_pembelian.kode_karyawan AND data_bmentah.id_barang = transaksi_pembelian.id_barang ORDER BY `transaksi_pembelian`.`Tanggal_transaksi_beli` DESC");
//            while (res.next()) {
//                tbl.addRow(new Object[]{
//                    res.getString("Tanggal_transaksi_beli"),
//                    res.getString("id_transaksi_beli"),
//                    res.getString("id_barang"),
//                    res.getString("nama_barang"),
//                    res.getString("jumlah_barang"),
//                    res.getString("total_harga"),
//                    res.getString("kode_karyawan"),
//                    res.getString("nama_karyawan")
//                });
//                tbll.setModel(tbl);
//            }
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//    }
    public void tampilPH() {

        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            System.out.println(date);
            String tgl = date.toString();

            String total = "SELECT SUM(total_harga) AS total FROM transaksi_pembelian WHERE tanggal_transaksi_beli = '" + tgl + "';";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

                //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPDH.setText(String.valueOf(" Rp." + rs.getString("total")));
            } else {
                this.txtPDH.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    public void tampilPB() {

        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

//            java.sql.Statement statement = Koneksi.koneksi.getKoneksi().createStatement();
            String total = "SELECT SUM(total_harga) AS total FROM transaksi_pembelian WHERE MONTH (tanggal_transaksi_beli) LIKE '%" + bln.getText()+ "';";
            System.out.println(total);
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

                //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPDH1.setText(String.valueOf(" Rp." + rs.getString("total")));
            } else {
                this.txtPDH1.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    public void tbll() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Tanggal terbeli");
        tbl.addColumn("id transaksi");
        tbl.addColumn("id bahan");
        tbl.addColumn("Nama bahan");
        tbl.addColumn("Jumlah bahan");
        tbl.addColumn("Pengeluaran");
        tbl.addColumn("kode karyawan");
        tbl.addColumn("nama karyawan");
        tbll1.setModel(tbl);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        String tgl = date.toString();
        txtTgl.setText(tgl);

        try {
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT\n"
                    + "    transaksi_pembelian.tanggal_transaksi_beli,\n"
                    + "    transaksi_pembelian.id_transaksi_beli,\n"
                    + "    data_bmentah.id_bahan,\n"
                    + "    transaksi_pembelian.nama_bahan,\n"
                    + "    transaksi_pembelian.jumlah_bahan,\n"
                    + "    transaksi_pembelian.total_harga,\n"
                    + "    transaksi_pembelian.kode_karyawan,\n"
                    + "    data_karyawan.nama_karyawan\n"
                    + "FROM\n"
                    + "    transaksi_pembelian,\n"
                    + "    data_bmentah,\n"
                    + "    data_karyawan\n"
                    + "WHERE\n"
                    + "    MONTH(tanggal_transaksi_beli) LIKE '%" +bln.getText()+ "' AND data_karyawan.kode_karyawan = transaksi_pembelian.kode_karyawan AND data_bmentah.id_bahan = transaksi_pembelian.id_bahan\n"
                    + "ORDER BY\n"
                    + "    id_transaksi_beli\n"
                    + "DESC\n"
                    + "    ");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Tanggal_transaksi_beli"),
                    res.getString("id_transaksi_beli"),
                    res.getString("id_bahan"),
                    res.getString("nama_bahan"),
                    res.getString("jumlah_bahan"),
                    res.getString("total_harga"),
                    res.getString("kode_karyawan"),
                    res.getString("nama_karyawan")
                });
                tbll1.setModel(tbl);
//                System.out.println();
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void tbllB() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Tanggal terbeli");
        tbl.addColumn("id transaksi");
        tbl.addColumn("id bahan");
        tbl.addColumn("Nama bahan");
        tbl.addColumn("Jumlah bahan");
        tbl.addColumn("Pengeluaran");
        tbl.addColumn("kode karyawan");
        tbl.addColumn("nama karyawan");
        tbll.setModel(tbl);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        try {
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT transaksi_pembelian.Tanggal_transaksi_beli,transaksi_pembelian.id_transaksi_beli , data_bmentah.id_bahan,transaksi_pembelian.nama_bahan, transaksi_pembelian.jumlah_bahan,transaksi_pembelian.total_harga,data_karyawan.kode_karyawan,data_karyawan.nama_karyawan FROM transaksi_pembelian, data_bmentah, data_karyawan WHERE tanggal_transaksi_beli = '" + txtTgl.getText() + "' AND data_karyawan.kode_karyawan = transaksi_pembelian.kode_karyawan AND data_bmentah.id_bahan = transaksi_pembelian.id_bahan ORDER by id_transaksi_beli DESC");

            while (res.next()) {
                tbl.addRow(new Object[]{
                         res.getString("Tanggal_transaksi_beli"),
                    res.getString("id_transaksi_beli"),
                    res.getString("id_bahan"),
                    res.getString("nama_bahan"),
                    res.getString("jumlah_bahan"),
                    res.getString("total_harga"),
                    res.getString("kode_karyawan"),
                    res.getString("nama_karyawan")
                });
                tbll.setModel(tbl);
//                System.out.println();
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public LaporanBarangMasuk() {
        initComponents();
        tbll();
        tampilPH();
        tampilPB();
        tbllB();
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

        txtTgl = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        backtomenu2 = new javax.swing.JButton();
        btnTPembelian = new javax.swing.JButton();
        btnLapBKeluar = new javax.swing.JButton();
        btnDataKaryawan = new javax.swing.JButton();
        btnDataBarang = new javax.swing.JButton();
        backtomenu = new javax.swing.JButton();
        btnTPenjualan = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbll = new javax.swing.JTable();
        txtPDH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        txtTMPL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbll1 = new javax.swing.JTable();
        txtPDH1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bln = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        txtTgl.setBackground(new java.awt.Color(255, 222, 47));
        txtTgl.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtTgl.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1378, 767));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1378, 767));
        setResizable(false);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(backtomenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

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
        jPanel3.add(btnTPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 300, 60));

        btnLapBKeluar.setBackground(new java.awt.Color(51, 51, 51));
        btnLapBKeluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLapBKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnLapBKeluar.setContentAreaFilled(false);
        btnLapBKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapBKeluarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLapBKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 300, 60));

        btnDataKaryawan.setBackground(new java.awt.Color(51, 51, 51));
        btnDataKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btnDataKaryawan.setContentAreaFilled(false);
        btnDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKaryawanActionPerformed(evt);
            }
        });
        jPanel3.add(btnDataKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 300, 50));

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
        jPanel3.add(btnDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 300, 60));

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
        jPanel3.add(backtomenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 80, 60));

        btnTPenjualan.setBackground(new java.awt.Color(51, 51, 51));
        btnTPenjualan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btnTPenjualan.setContentAreaFilled(false);
        btnTPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPenjualanActionPerformed(evt);
            }
        });
        jPanel3.add(btnTPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 300, 60));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 0));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbll.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tanggal Terjual", "Id Transaksi", "Kode Barang", "Nama Barang", "Jumlah Terjual", "Keterangan", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbll.setRowHeight(30);
        tbll.setRowMargin(2);
        tbll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbllMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbll);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 910, 410));

        txtPDH.setEditable(false);
        txtPDH.setBackground(new java.awt.Color(255, 222, 47));
        txtPDH.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtPDH.setBorder(null);
        txtPDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPDHActionPerformed(evt);
            }
        });
        jPanel1.add(txtPDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 280, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setText("TOTAL PENGELUARAN ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 50));

        txtDate.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 180, 40));

        txtTMPL.setText("TAMPIL");
        txtTMPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTMPLActionPerformed(evt);
            }
        });
        jPanel1.add(txtTMPL, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 110, 40));

        jTabbedPane1.addTab("HARIAN", null, jPanel1, "");

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbll1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbll1.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tanggal Terjual", "Id Transaksi", "Kode Barang", "Nama Barang", "Jumlah Terjual", "Keterangan", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbll1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbll1.setRowHeight(30);
        tbll1.setRowMargin(2);
        tbll1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbll1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbll1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 910, 410));

        txtPDH1.setEditable(false);
        txtPDH1.setBackground(new java.awt.Color(255, 222, 47));
        txtPDH1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtPDH1.setBorder(null);
        txtPDH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPDH1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtPDH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 280, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setText("TOTAL PENGELUARAN ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("CARI BULAN KE BERAPA :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 300, 30));

        bln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                blnKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                blnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                blnKeyTyped(evt);
            }
        });
        jPanel2.add(bln, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 120, 30));

        jTabbedPane1.addTab("BULANAN", null, jPanel2, "");

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 890, 550));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\laptophp\\Documents\\NetBeansProjects\\PembukuanUMKM\\src\\images\\lapBeli.png")); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1378, 767));
        jLabel1.setPreferredSize(new java.awt.Dimension(1378, 767));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backtomenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenu2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenu2MousePressed

    private void backtomenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomenu2ActionPerformed
        this.setVisible(false);
        new MenuUtama().setVisible(true);            // TODO add your handling code here:
    }//GEN-LAST:event_backtomenu2ActionPerformed

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
        int dialogResult = JOptionPane.showConfirmDialog(this, "ANDA YAKIN AKAN KELUAR?", "PERINGATAN!", dialogBtn);
        if (dialogResult == 0) {
            System.exit(0);
        } else {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_backtomenuActionPerformed

    private void btnTPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPenjualanActionPerformed
        new TransaksiPenjualan().setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTPenjualanActionPerformed

    private void tbllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbllMouseClicked

    }//GEN-LAST:event_tbllMouseClicked

    private void txtPDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPDHActionPerformed

    private void tbll1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbll1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbll1MouseClicked

    private void txtPDH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPDH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPDH1ActionPerformed

    private void txtTMPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTMPLActionPerformed
        try {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tgl = String.valueOf(fm.format(txtDate.getDate()));

            String total = "SELECT SUM(total_harga) AS total FROM transaksi_pembelian WHERE tanggal_transaksi_beli = '" + tgl + "';";
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(total);
            if (rs.next()) {

                //   int jumlah = Integer.parseInt(txtTgl.getText());
                this.txtPDH.setText(String.valueOf(" Rp." + rs.getString("total")));
            }else {
                this.txtPDH.setText(String.valueOf("Rp.0"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }

        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgl = String.valueOf(fm.format(txtDate.getDate()));

        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Tanggal terbeli");
        tbl.addColumn("id transaksi");
        tbl.addColumn("id bahan");
        tbl.addColumn("Nama bahan");
        tbl.addColumn("Jumlah bahan");
        tbl.addColumn("Pengeluaran");
        tbl.addColumn("kode karyawan");
        tbl.addColumn("nama karyawan");
        tbll.setModel(tbl);

        try {
            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT transaksi_pembelian.Tanggal_transaksi_beli,transaksi_pembelian.id_transaksi_beli , data_bmentah.id_bahan,transaksi_pembelian.nama_bahan, transaksi_pembelian.jumlah_bahan,transaksi_pembelian.total_harga,data_karyawan.kode_karyawan,data_karyawan.nama_karyawan FROM transaksi_pembelian, data_bmentah, data_karyawan WHERE tanggal_transaksi_beli = '" + tgl + "' AND data_karyawan.kode_karyawan = transaksi_pembelian.kode_karyawan AND data_bmentah.id_bahan = transaksi_pembelian.id_bahan ORDER by id_transaksi_beli DESC");

            while (res.next()) {
                tbl.addRow(new Object[]{
                   res.getString("Tanggal_transaksi_beli"),
                    res.getString("id_transaksi_beli"),
                    res.getString("id_bahan"),
                    res.getString("nama_bahan"),
                    res.getString("jumlah_bahan"),
                    res.getString("total_harga"),
                    res.getString("kode_karyawan"),
                    res.getString("nama_karyawan")
                });
                tbll.setModel(tbl);
                //                System.out.println();
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //        DefaultTableModel tbl = new DefaultTableModel();
        //        tbl.addColumn("Tanggal");
        //        tbl.addColumn("ID Transaksi Jual");
        //        tbl.addColumn("ID Produk");
        //        tbl.addColumn("Nama Produk");
        //        tbl.addColumn("Jumalh");
        //        tbl.addColumn("Total Harga");
        //        tbll.setModel(tbl);
        //        try {
            //            String sql = "select * from transaksi_jual WHERE tgl_transaksi = '"+ tgl +"'";
            //            Connection conn = (Connection) Koneksi.koneksi.getKoneksi();
            //            java.sql.Statement stm = conn.createStatement();
            //            java.sql.ResultSet res = stm.executeQuery(sql);
            //            while (res.next()) {
                //                tbl.addRow(new Object[]{
                    //                    res.getString("tgl_transaksi"),
                    //                    res.getString("id_tr_jual"),
                    //                    res.getString("id_produk"),
                    //                    res.getString("nama_produk"),
                    //                    res.getString("jumlah"),
                    //                    res.getString("harga_total")
                    //                });
            //                tbll.setModel(tbl);
            ////                total();
            //
            //            }
        //        } catch (Exception e) {
        //            JOptionPane.showMessageDialog(rootPane, "salah " + e);
        //        }
        //            // TODO add your handling code here:
    }//GEN-LAST:event_txtTMPLActionPerformed

    private void blnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_blnKeyPressed
        tbll();
        tampilPB();        // TODO add your handling code here:
    }//GEN-LAST:event_blnKeyPressed

    private void blnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_blnKeyReleased
        tbll();
        tampilPB();        // TODO add your handling code here:
    }//GEN-LAST:event_blnKeyReleased

    private void blnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_blnKeyTyped
        tbll();
        tampilPB();// TODO add your handling code here:
    }//GEN-LAST:event_blnKeyTyped

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
            java.util.logging.Logger.getLogger(LaporanBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanBarangMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtomenu;
    private javax.swing.JButton backtomenu2;
    private javax.swing.JTextField bln;
    private javax.swing.JButton btnDataBarang;
    private javax.swing.JButton btnDataKaryawan;
    private javax.swing.JButton btnLapBKeluar;
    private javax.swing.JButton btnTPembelian;
    private javax.swing.JButton btnTPenjualan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbll;
    private javax.swing.JTable tbll1;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtPDH;
    private javax.swing.JTextField txtPDH1;
    private javax.swing.JButton txtTMPL;
    private javax.swing.JTextField txtTgl;
    // End of variables declaration//GEN-END:variables
}
