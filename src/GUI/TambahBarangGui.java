package GUI;

import Helper.KoneksiDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TambahBarangGui extends JFrame {
    Font Tms = new Font("Times New Roman", Font.PLAIN, 17);
    Font TmsBold = new Font("Times New Roman", Font.BOLD, 17);
    JLabel lblNamaBarang = new JLabel("Nama Barang");
    JTextField fieldNama = new JTextField();
    JLabel lblKategori = new JLabel("Kategori");
    JComboBox comboBoxKategori = new JComboBox();
    JLabel lblHarga = new JLabel("Harga");
    JTextField  fieldHarga = new JTextField();
    JLabel lblStok = new JLabel("Stok");
    JTextField fieldStok = new JTextField();
    JButton btnTambah = new JButton("TAMBAH");
    JButton btnKembali = new JButton("KEMBALI");

    TambahBarangGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 450, 387);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

       //LabelNamaBarang
        lblNamaBarang.setFont(Tms);
        lblNamaBarang.setBounds(10, 53, 98, 38);
        this.add(lblNamaBarang);

        //FieldNamaBarang
        fieldNama.setBounds(198, 61, 170, 27);
        this.add(fieldNama);

        //LabelKategori
        lblKategori.setFont(Tms);
        lblKategori.setBounds(10, 102, 98, 38);
        this.add(lblKategori);

        //JComboBox Kategori
        comboBoxKategori.setBounds(198, 112, 170, 27);
        ComboBoxKategori();//Mengambil nilai dari tabel kategori
        this.add(comboBoxKategori);

        //LabelHarga
        lblHarga.setFont(Tms);
        lblHarga.setBounds(10, 162, 98, 38);
        this.add(lblHarga);

        //FieldHarga
        fieldHarga.setColumns(10);
        fieldHarga.setBounds(198, 170, 170, 27);
        this.add(fieldHarga);

        //LabelStok
        lblStok.setFont(Tms);
        lblStok.setBounds(10, 223, 98, 38);
        this.add(lblStok);

        //FieldStok
        fieldStok.setColumns(10);
        fieldStok.setBounds(198, 231, 170, 27);
        this.add(fieldStok);

        //BtnTambah
        btnTambah.setFont(TmsBold);
        btnTambah.setBounds(156, 295, 111, 27);
        this.add(btnTambah);

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kategori,harga,stok,temp;
                String nama;
                temp = comboBoxKategori.getSelectedIndex();
                if(temp == 0){
                    kategori = 1;
                }else {
                    kategori = 2;
                }
                if(fieldNama.getText().isEmpty() || fieldStok.getText().isEmpty() || fieldHarga.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else {
                    harga = Integer.parseInt(fieldHarga.getText());
                    stok = Integer.parseInt(fieldStok.getText());
                    nama = fieldNama.getText();
                    AllObjectController.produkController.insertData(kategori,nama,harga,stok);
                    JOptionPane.showMessageDialog(null,"Berhasil tambah barang");
                    dispose();
                    new ProdukGui(id);
                }
            }
        });

        //btnKembali
        btnKembali.setFont(TmsBold);
        btnKembali.setBounds(10, 11, 120, 27);
        this.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdukGui(id);
                dispose();
            }
        });


        setVisible(true);
    }

    public void ComboBoxKategori(){
        String sql;
        Connection conn = KoneksiDb.getConnection();
        try{
            sql = "SELECT kategori FROM kategori";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                String kategori = rs.getString("kategori");
                comboBoxKategori.addItem(kategori);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
