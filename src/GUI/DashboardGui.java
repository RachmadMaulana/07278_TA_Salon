package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardGui extends JFrame {
    JLabel labelIcon = new JLabel("");
    Image image = new ImageIcon(this.getClass().getResource("images/icons8-user-60.png")).getImage();
    Image image1 = new ImageIcon(this.getClass().getResource("images/icons8-shop-100.png")).getImage();
    Image image2 = new ImageIcon(this.getClass().getResource("images/icons8-used-product-100.png")).getImage();
    Image image3 = new ImageIcon(this.getClass().getResource("images/icons8-clipboard-100.png")).getImage();
    JButton btnEditProfile = new JButton("Profile");
    JLabel labelNama = new JLabel();
    JLabel labelToko = new JLabel("");
    JLabel labelProduk = new JLabel("");
    JLabel labelPesanan = new JLabel("");
    JButton btnToko = new JButton("KASIR");
    JButton btnproduk= new JButton("PRODUK");
    JButton btnHistori = new JButton("HISTORI");

    DashboardGui(int id) {
        initComponent(id);
    }

    DashboardGui(){
    }

    public void initComponent(int id) {
        String nama = AllObjectController.pegawaiController.getNamaPegawai(id);
        setBounds(100, 100, 563, 434);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //LabelIcon
        labelIcon.setIcon(new ImageIcon(image));
        labelIcon.setBounds(21, 11, 60, 54);
        this.add(labelIcon);

        //LabelNamaProfile
        labelNama.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        labelNama.setBounds(97, 11, 140, 25);
        labelNama.setText(nama);
        this.add(labelNama);

        //LabelToko
        labelToko.setIcon(new ImageIcon(image1));
        labelToko.setVerticalAlignment(SwingConstants.TOP);
        labelToko.setBounds(57, 155, 115, 137);
        this.add(labelToko);

        //LabelIsiSaldo
        labelProduk.setIcon(new ImageIcon(image2));
        labelProduk.setVerticalAlignment(SwingConstants.TOP);
        labelProduk.setBounds(235, 155, 115, 137);
        this.add(labelProduk);

        //LabelPesanan
        labelPesanan.setIcon(new ImageIcon(image3));
        labelPesanan.setVerticalAlignment(SwingConstants.TOP);
        labelPesanan.setBounds(410, 164, 115, 137);
        this.add(labelPesanan);

        //btn Profile
        btnEditProfile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnEditProfile.setBounds(96, 42, 141, 25);
        btnEditProfile.setBackground(Color.cyan);
        this.add(btnEditProfile);

        //btn Toko
        btnToko.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnToko.setBounds(67, 278, 89, 23);

        btnToko.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TambahPelangganGui(id);
            }
        });

        this.add(btnToko);

        //btnProduk
        btnproduk.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnproduk.setBounds(235, 277, 97, 25);
        this.add(btnproduk);

        btnproduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdukGui(id);
                dispose();
            }
        });

        //btn Pesanan
        btnHistori.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnHistori.setBounds(413, 278, 93, 25);
        this.add(btnHistori);

        btnHistori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DetailTransaksiGui(id);
                dispose();
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new DashboardGui(1);
    }

}
