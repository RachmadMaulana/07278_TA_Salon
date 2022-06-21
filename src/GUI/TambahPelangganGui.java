package GUI;

import com.mysql.cj.protocol.a.NativeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TambahPelangganGui extends JFrame {
    JLabel labelNama = new JLabel("NAMA");
    JLabel lblAlamat = new JLabel("ALAMAT");
    JTextField fieldNama = new JTextField();
    JTextField fieldAlamat = new JTextField();
    JButton btnSimpan = new JButton("SIMPAN");
    JButton btnKembali = new JButton("KEMBALI");

    Font Tms = new Font("Times New Roman", Font.PLAIN, 15);
    Font TmsBold = new Font("Times New Roman", Font.BOLD, 15);
    TambahPelangganGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 405, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //labelNama
        labelNama.setBounds(10, 39, 83, 34);
        labelNama.setFont((Tms));
        this.add(labelNama);

        //labelAlamat
        lblAlamat.setBounds(10, 114, 83, 34);
        lblAlamat.setFont(Tms);
        this.add(lblAlamat);

        //FieldNama
        fieldNama.setBounds(148, 46, 182, 28);
        this.add(fieldNama);

        //FieldAlamat
        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(148, 122, 182, 28);
        this.add(fieldAlamat);

        //btnSimpan
        btnSimpan.setBounds(140, 196, 119, 41);
        btnSimpan.setFont(TmsBold);
        this.add(btnSimpan);

        btnSimpan.addActionListener(new ActionListener() {
            int lastId = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldNama.getText();
                String alamat = fieldAlamat.getText();

                if(nama.isEmpty() || alamat.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else {
                    lastId = AllObjectController.pegawaiController.TambahPelanggan(nama,alamat);
                    if(lastId > 0){
                        dispose();
                        new TokoGui(id,lastId);
                    }
                }
            }
        });


        btnKembali.setFont(TmsBold);
        btnKembali.setBounds(140, 266, 119, 41);
        this.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id);
                dispose();
            }
        });

        setVisible(true);
    }
}
