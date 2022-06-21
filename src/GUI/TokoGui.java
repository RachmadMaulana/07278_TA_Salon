package GUI;

import Controller.AllObjectModel;
import Controller.ProdukController;
import Helper.KoneksiDb;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class TokoGui extends JFrame {
    ProdukController produk = new ProdukController();
    JTable tableProduk = new JTable();
    JTable tableTransaksi = new JTable();
    JTable tableTransaksi2 = new JTable();
    JScrollPane spProduk = new JScrollPane(tableProduk);
    JScrollPane spTransaksi = new JScrollPane(tableTransaksi);
    JScrollPane spTransaksi2 = new JScrollPane(tableTransaksi2);
    JTextField fieldId = new JTextField();
    JTextField textpilih = new JTextField();
    JLabel labelNama = new JLabel("NAMA");
    JTextField fieldnama = new JTextField();
    JLabel labelHarga = new JLabel("HARGA");
    JTextField fieldHarga = new JTextField();
    JLabel labelJumlah = new JLabel("JUMLAH");
    JSpinner jumlah = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    JLabel lblJumlahHarga = new JLabel("JUMLAH HARGA");
    JTextField fieldJumlahHarga = new JTextField();
    JLabel lblTotal = new JLabel("TOTAL");
    JTextField fieldTotal = new JTextField();
    JTextField fieldstok = new JTextField();
    JButton btnHapusBarang = new JButton("HAPUS BARANG");
    JButton btnCheckout = new JButton("CHECKOUT");
    JButton btnKeranjang = new JButton("TAMBAH KE KERANJANG");
    JButton btnKeluar = new JButton("KELUAR");
    int stok = 0;


    public TokoGui(int id_pegawai, int id_pelanggan){
        initComponent(id_pegawai,id_pelanggan);
    }

    public void initComponent(int id_pegawai, int id_pelanggan){
        setBounds(100, 100, 1350, 500);
        //100, 100, 728, 500
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);


        //TABLE PRODUK
        spProduk.setBounds(0, 0, 497, 374);
        tableProduk.setModel(produk.daftarProduk());
        this.add(spProduk);
        //0, 0, 497, 374
        //23, 4, 679, 386

        //TABLE TRANSAKSI
        spTransaksi.setBounds(734, 23, 356, 365);
        tableTransaksi.setBackground(Color.cyan);
        tableTransaksi.setForeground(Color.black);
        Object[]kolom = {"id","Nama","Harga","Jumlah","Jumlah Harga"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(kolom);
        tableTransaksi.setModel(model);
        this.add(spTransaksi);

        tableProduk.addMouseListener(new MouseAdapter() {
            private String nama_barang;
            private int harga,qty,jumlHarga,id;

            private String nama;
            private int harga1,qty1,jumlharga1;

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableProduk.getSelectedRow();
                textpilih.setText(produk.daftarProduk().getValueAt(i, 0).toString());
                id = AllObjectModel.produkModel.getProduk2().get(i).getId();
                nama_barang = AllObjectModel.produkModel.getProduk2().get(i).getNama_produk();
                harga = AllObjectModel.produkModel.getProduk2().get(i).getHarga();
                qty = Integer.parseInt(jumlah.getValue().toString());
                jumlHarga = harga * qty;
                fieldnama.setText(nama_barang);
                fieldHarga.setText(String.valueOf(harga));
                fieldJumlahHarga.setText(String.valueOf(jumlHarga));
                fieldId.setText(produk.daftarProduk().getValueAt(i,0).toString());
                nama = fieldnama.getText();
                harga1 = Integer.parseInt(fieldHarga.getText());
                qty1 = (int) jumlah.getValue();
                jumlharga1 = Integer.parseInt(fieldJumlahHarga.getText());
                stok = AllObjectModel.produkModel.getProduk2().get(i).getStok();
                fieldstok.setText(String.valueOf(stok));

            }
        });

        btnKeranjang.addActionListener(new ActionListener() {
            Object[]row = new Object[5];
            int total = 0;
            public void actionPerformed(ActionEvent e) {
                int spinner = (int) jumlah.getValue();
                row[0] = fieldId.getText();
                row[1] = fieldnama.getText();
                row[2] = fieldHarga.getText();
                row[3] = jumlah.getValue();
                row[4] = fieldJumlahHarga.getText();
                int cek = Integer.parseInt(fieldId.getText());


                    if (spinner > Integer.parseInt(fieldstok.getText())) {
                        JOptionPane.showMessageDialog(null, "STOK TIDAK CUKUP");
                    }else {
                        model.addRow(new Object[]
                                {
                                        fieldId.getText(),
                                        fieldnama.getText(),
                                        fieldHarga.getText(),
                                        jumlah.getValue(),
                                        fieldJumlahHarga.getText()
                                });
                    }
                int size = tableTransaksi.getRowCount();
                int sum = 0;


                for(int i = 0; i<size; i++){
                    sum += Integer.parseInt(String.valueOf(tableTransaksi.getValueAt(i,4))) ;
                }

                fieldTotal.setText(String.valueOf(sum));
                total = Integer.parseInt(fieldTotal.getText());

            }
        });

        //FieldId
        fieldId.setBounds(0,0,111,222);
        fieldId.setVisible(false);
        this.add(fieldId);

        //FieldStok
        fieldstok.setVisible(false);
        this.add(fieldstok);

        //LabelNama
        labelNama.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelNama.setBounds(520, 11, 125, 31);
        this.add(labelNama);

        //FieldNama
        fieldnama.setBounds(520, 52, 182, 31);
        fieldnama.setEditable(false);
        this.add(fieldnama);

        //LabelHarga
        labelHarga.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelHarga.setBounds(521, 94, 125, 31);
        this.add(labelHarga);

        //FieldHarga
        fieldHarga.setBounds(521, 135, 182, 31);
        fieldHarga.setEditable(false);
        this.add(fieldHarga);

        //LabelJumlah
        labelJumlah.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelJumlah.setBounds(521, 177, 125, 31);
        this.add(labelJumlah);

        //Spinner Jumlah
        jumlah.setBounds(520, 219, 182, 31);
        JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor)jumlah.getEditor();
        defaultEditor.getTextField().setEditable(false);


        this.add(jumlah);

        //Jumlah Harga
        lblJumlahHarga.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblJumlahHarga.setBounds(520, 266, 125, 31);
        this.add(lblJumlahHarga);

        //FieldJumlahHarga
        fieldJumlahHarga.setBounds(520, 308, 182, 31);
        fieldJumlahHarga.setEditable(false);
        this.add(fieldJumlahHarga);
        //Btn Keranjang
        btnKeranjang.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnKeranjang.setBounds(521, 376, 181, 40);
        this.add(btnKeranjang);

        //Label Total
        lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblTotal.setBounds(1114, 36, 125, 31);
        this.add(lblTotal);

        //FieldTotal
        fieldTotal.setColumns(10);
        fieldTotal.setBounds(1114, 65, 158, 31);
        fieldTotal.setEditable(false);
        this.add(fieldTotal);

        //btnKeluar
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id_pegawai);
            }
        });
        btnKeluar.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnKeluar.setBounds(1110, 399, 181, 40);
        this.add(btnKeluar);


        //btnHapusBarang
        btnHapusBarang.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnHapusBarang.setBounds(1110, 303, 181, 40);
        this.add(btnHapusBarang);

        btnHapusBarang.addActionListener(new ActionListener() {
            int size = 0;
            int sum = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeRow(tableTransaksi.getSelectedRow());
                size = model.getRowCount();

                if(size == 0){
                    sum = 0;
                }else {
                    for(int i = 0; i<size; i++){
                        sum += Integer.parseInt(String.valueOf(tableTransaksi.getValueAt(i,4))) ;
                    }
                }
                fieldTotal.setText(String.valueOf(sum));
            }
        });

        //btnCheckout
        btnCheckout.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnCheckout.setBounds(1110, 348, 181, 40);
        this.add(btnCheckout);

        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transaksi(id_pegawai, id_pelanggan);
            }
        });

        setVisible(true);

    }
    public void transaksi(int id_pegawai,int id_pelanggan){
        String sql,sql2,sql3;
        int lastId = 0;
        Connection conn = KoneksiDb.getConnection();
        try{
            sql = "INSERT INTO transaksi(id_pegawai,id_pelanggan,tanggal,status,total_harga) VALUES (?,?,NOW(),1,?)";
            PreparedStatement stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int total = Integer.parseInt(fieldTotal.getText());
            stat.setInt(1,id_pegawai);
            stat.setInt(2,id_pelanggan);
            stat.setInt(3,total);
            stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();

            if(rs.next()){
                lastId = rs.getInt(1);
            }

            int row = tableTransaksi.getRowCount();
            int id_produk;
            int jumlah_harga;
            int jumlah_barang;
            int stok = 0;

            sql2 = "INSERT INTO detail_transaksi(id_produk,id_transaksi,jumlah_harga,jumlah_barang)VALUES (?,?,?,?)";
            PreparedStatement stat1 = conn.prepareStatement(sql2);

            sql3 = "UPDATE produk set stok_produk = ? WHERE id = ?";
            PreparedStatement stat2 = conn.prepareStatement(sql3);


                for(int i = 0; i<row; i++){
                    id_produk = Integer.parseInt(String.valueOf(tableTransaksi.getValueAt(i,0)));
                    jumlah_harga = Integer.parseInt(String.valueOf(tableTransaksi.getValueAt(i,4)));
                    jumlah_barang = Integer.parseInt(String.valueOf(tableTransaksi.getValueAt(i,3)));

                    stat1.setInt(1,id_produk);
                    stat1.setInt(2,lastId);
                    stat1.setInt(3,jumlah_harga);
                    stat1.setInt(4,jumlah_barang);
                    stat1.executeUpdate();

                    stok = AllObjectModel.pegawaiModel.getStok(id_produk);
                    stok -= jumlah_barang;
                    stat2.setInt(1,stok);
                    stat2.setInt(2,id_produk);
                    stat2.executeUpdate();
                }
            JOptionPane.showMessageDialog(null,"Transaksi Berhasil");
            dispose();
            new DashboardGui(id_pegawai);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}

