package Controller;

import Entity.ProdukEntity;

import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProdukController {
    public int insertData(int kategori_id,String nama_produk, int harga, int stok){
        return AllObjectModel.produkModel.insertData(new ProdukEntity(kategori_id,nama_produk,harga,stok));
    }

    public void updateData(int pilih, int param, int id){
        switch (pilih){
            case 1 -> AllObjectModel.produkModel.updateHarga(param,id);
            case 2 -> AllObjectModel.produkModel.updateStok(param,id);
        }
    }

    public int updateNama(String nama, int id){
      return AllObjectModel.produkModel.updateNama(nama, id);
    }

    public int deleteData(int id){
        return AllObjectModel.produkModel.deleteData(id);
    }

    public ArrayList<ProdukEntity>getAllDataProduk(){
        return AllObjectModel.produkModel.getProduk2();
    }

    public ArrayList<ProdukEntity>getProduk(int id){
        return AllObjectModel.produkModel.getProduk(id);
    }

    public DefaultTableModel daftarProduk(){
        DefaultTableModel daftarProduk = new DefaultTableModel();
        Object[] kolom = {"id","nama","kategori","harga","stok"};
        daftarProduk.setColumnIdentifiers(kolom);
        int size = getAllDataProduk().size();

        for(int i = 0; i<size; i++){
            Object [] data = new Object[5];
            data[0] = AllObjectModel.produkModel.getProduk2().get(i).getId();
            data[1] = AllObjectModel.produkModel.getProduk2().get(i).getNama_produk();
            data[2] = AllObjectModel.produkModel.getProduk2().get(i).getNama_kategori();
            data[3] = AllObjectModel.produkModel.getProduk2().get(i).getHarga();
            data[4] = AllObjectModel.produkModel.getProduk2().get(i).getStok();
            daftarProduk.addRow(data);
        }
        return daftarProduk;
    }
}
