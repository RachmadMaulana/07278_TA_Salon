package GUI;

import Controller.AllObjectModel;
import Entity.ProdukEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBarangGui extends JFrame {
    private String nama;
    private int stok,harga;
    Font TMS = new Font("Times New Roman", Font.BOLD, 17);
    Font TMS2 = new Font("Times New Roman", Font.BOLD, 13);
    JLabel lblNamaBarang = new JLabel("NAMA BARANG");
    JTextField fieldNamaBarang = new JTextField();
    JLabel lblStokBarang = new JLabel("STOK BARANG");
    JTextField fieldStok = new JTextField();
    JLabel lblHargaBarang = new JLabel("HARGA BARANG");
    JTextField fieldHarga = new JTextField();
    JButton btnEditNama = new JButton("EDIT");
    JButton btnEditStok = new JButton("EDIT");
    JButton btnEditHarga = new JButton("EDIT");
    JButton btnKembali = new JButton("KEMBALI");
    EditBarangGui(int id_barang, int id_admin){
        initComponent(id_barang,id_admin);
    }

    public void initComponent(int id_barang, int id_admin){
        setBounds(100, 100, 537, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        for(ProdukEntity produkEntity : AllObjectController.produkController.getProduk(id_barang)){
            this.nama = produkEntity.getNama_produk();
            this.stok = produkEntity.getStok();
            this.harga = produkEntity.getHarga();
        }

        //LabelNamaBarang
        lblNamaBarang.setFont(TMS);
        lblNamaBarang.setBounds(22, 30, 170, 42);
        this.add(lblNamaBarang);

        //FieldNamaBarang
        fieldNamaBarang.setBounds(232, 39, 171, 29);
        fieldNamaBarang.setText(this.nama);
        fieldNamaBarang.setEditable(false);
        this.add(fieldNamaBarang);

        //LabelStokBarang
        lblStokBarang.setFont(TMS);
        lblStokBarang.setBounds(22, 116, 170, 42);
        this.add(lblStokBarang);

        //FieldStokBarang
        fieldStok.setColumns(10);
        fieldStok.setBounds(232, 125, 171, 29);
        fieldStok.setText(String.valueOf(this.stok));
        fieldStok.setEditable(false);
        this.add(fieldStok);

        //LabelHargaBarang
        lblHargaBarang.setFont(TMS);
        lblHargaBarang.setBounds(22, 199, 170, 42);
        this.add(lblHargaBarang);

        //FieldHargaBarang
        fieldHarga.setColumns(10);
        fieldHarga.setBounds(232, 208, 171, 29);
        fieldHarga.setText(String.valueOf(this.harga));
        fieldHarga.setEditable(false);
        this.add(fieldHarga);


        btnEditNama.setFont(TMS2);
        btnEditNama.setBounds(413, 42, 89, 23);
        this.add(btnEditNama);

        btnEditNama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = JOptionPane.showInputDialog(null,"Masukkan Nama Baru");
                int cek =  AllObjectController.produkController.updateNama(nama,id_barang);
                if(cek > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil Update");
                    fieldNamaBarang.setText(nama);
                }
            }
        });

        btnEditStok.setFont(TMS2);
        btnEditStok.setBounds(413, 128, 89, 23);
        this.add(btnEditStok);

        btnEditStok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stok = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan stok Baru"));
                int cek = AllObjectModel.produkModel.updateStok(stok,id_barang);
                if(cek > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil Update");
                    fieldStok.setText(String.valueOf(stok));
                }
            }
        });

        btnEditHarga.setFont(TMS2);
        btnEditHarga.setBounds(413, 211, 89, 23);
        this.add(btnEditHarga);

        btnEditHarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int harga = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan harga Baru"));
                int cek = AllObjectModel.produkModel.updateHarga(harga,id_barang);
                if(cek > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil Update");
                    fieldHarga.setText(String.valueOf(harga));
                }
            }
        });


        btnKembali.setFont(TMS2);
        btnKembali.setBounds(232, 265, 95, 35);
        this.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdukGui(id_admin);
                dispose();
            }
        });

        setVisible(true);
    }
}
