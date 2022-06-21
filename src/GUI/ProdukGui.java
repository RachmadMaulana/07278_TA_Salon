package GUI;

import Controller.AllObjectModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdukGui extends JFrame {
    JTable tableProduk = new JTable();
    JScrollPane spProduk = new JScrollPane(tableProduk);
    Font TmsBold = new Font("Times New Roman", Font.BOLD, 15);
    JButton btnTambahBarang = new JButton("TAMBAH BARANG");
    JButton btnEditBarang = new JButton("EDIT BARANG");
    JButton btnHapusBarang = new JButton("HAPUS BARANG");
    JButton btnKeluar = new JButton("KELUAR");
    JTextField textpilih = new JTextField();
    JTextField fieldId = new JTextField();
    AllObjectController produk = new AllObjectController();
    public ProdukGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 647, 510);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //TableProduk
        tableProduk.setModel(AllObjectController.produkController.daftarProduk());
        spProduk.setBounds(0, 0, 414, 364);
        this.add(spProduk);
        tableProduk.addMouseListener(new MouseAdapter() {
            int id;
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableProduk.getSelectedRow();
                textpilih.setText(produk.produkController.daftarProduk().getValueAt(i, 0).toString());
                id = AllObjectModel.produkModel.getProduk2().get(i).getId();
                fieldId.setText(String.valueOf(id));
            }
        });

        //BtntamabahBarang
        btnTambahBarang.setFont(TmsBold);
        btnTambahBarang.setBounds(424, 23, 177, 31);
        this.add(btnTambahBarang);

        btnTambahBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahBarangGui(id);
                dispose();
            }
        });


        //btnEditBarang
        btnEditBarang.setFont(TmsBold);
        btnEditBarang.setBounds(424, 162, 177, 31);
        this.add(btnEditBarang);

        fieldId.setBounds(424, 162, 177, 31);
        fieldId.setVisible(false);
        this.add(fieldId);

        btnEditBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditBarangGui(Integer.parseInt(fieldId.getText()),id);
            }
        });

        //btnHapusBarang
        btnHapusBarang.setFont(TmsBold);
        btnHapusBarang.setBounds(424, 91, 177, 31);
        this.add(btnHapusBarang);
        btnHapusBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int confrim =  JOptionPane.showConfirmDialog(null,"Barang yang ada di detail_transaksi akan hilang, yakin? ");
               if(confrim == 0){
                   int cek = AllObjectModel.produkModel.deleteData(Integer.parseInt(fieldId.getText()));
                   if(cek > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil Dihapus");
                    tableProduk.setModel(AllObjectController.produkController.daftarProduk());
                   }
               }
            }
        });

        //btnKeluar
        btnKeluar.setFont(TmsBold);
        btnKeluar.setBounds(424, 227, 177, 31);
        this.add(btnKeluar);

        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id);
                dispose();
            }
        });


        setVisible(true);
    }

}
