package Controller;

import Entity.Detail_Transaksi_Entity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DetailTransaksiController {

    public ArrayList<Detail_Transaksi_Entity>getDetailTransaksi(int id){
        return AllObjectModel.transaksiModel.getDetailTransaksi(id);
    }

   public DefaultTableModel daftarDetailTransaksi(int id){
        DefaultTableModel model = new DefaultTableModel();
        Object[]kolom = {"Nama Pelanggan","Nama Pegawai","Produk","Jumlah Barang","Jumlah Harga"};
        model.setColumnIdentifiers(kolom);
        int size = getDetailTransaksi(id).size();

        for(int i = 0; i<size; i++){
            Object[] data = new Object[5];
            data[0] = AllObjectModel.transaksiModel.getDetailTransaksi(id).get(i).getNama_pelanggan();
            data[1] = AllObjectModel.transaksiModel.getDetailTransaksi(id).get(i).getNama_pegawai();
            data[2] = AllObjectModel.transaksiModel.getDetailTransaksi(id).get(i).getNama_produk();
            data[3] = AllObjectModel.transaksiModel.getDetailTransaksi(id).get(i).getJumlah_barang();
            data[4] = AllObjectModel.transaksiModel.getDetailTransaksi(id).get(i).getJumlah_harga();
            model.addRow(data);
        }
       return model;
    }

}
