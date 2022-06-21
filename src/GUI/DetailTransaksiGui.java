package GUI;

import Controller.AllObjectModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailTransaksiGui extends JFrame {
    JTable tableDetail = new JTable();
    JScrollPane spDetail = new JScrollPane(tableDetail);
    JButton btnKembali = new JButton("KEMBALI");
    public DetailTransaksiGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 575, 515);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        spDetail.setBounds(21, 47, 501, 427);
        tableDetail.setModel(AllObjectController.detail.daftarDetailTransaksi(id));
        this.add(spDetail);


        btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id);
                dispose();
            }
        });
        btnKembali.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnKembali.setBounds(21, 11, 95, 23);
        this.add(btnKembali);






        setVisible(true);
    }
}
