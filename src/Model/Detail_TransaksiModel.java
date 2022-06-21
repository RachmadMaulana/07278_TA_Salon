package Model;

import Entity.Detail_Transaksi_Entity;
import Helper.KoneksiDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Detail_TransaksiModel {
    public Connection conn = KoneksiDb.getConnection();
    private String sql;

    public ArrayList<Detail_Transaksi_Entity>getDetailTransaksi(int id){
        ArrayList<Detail_Transaksi_Entity>transaksi = new ArrayList<>();
        try{
            sql = "select pelanggan.nama,pegawai.nama, produk.nama_produk, detail_transaksi.jumlah_barang,detail_transaksi.jumlah_harga\n" +
                    "FROM detail_transaksi INNER JOIN produk ON detail_transaksi.id_produk = produk.id\n" +
                    "INNER JOIN transaksi ON detail_transaksi.id_transaksi = transaksi.id\n" +
                    "INNER JOIN pelanggan ON transaksi.id_pelanggan = pelanggan.id\n" +
                    "INNER JOIN pegawai ON transaksi.id_pegawai = pegawai.id\n" +
                    "WHERE transaksi.id_pegawai = ? ORDER BY detail_transaksi.id_transaksi DESC";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                Detail_Transaksi_Entity detailTransaksi = new Detail_Transaksi_Entity();
                detailTransaksi.setNama_pelanggan(rs.getString("pelanggan.nama"));
                detailTransaksi.setNama_pegawai(rs.getString("pegawai.nama"));
                detailTransaksi.setNama_produk(rs.getString("nama_produk"));
                detailTransaksi.setJumlah_barang(rs.getInt("jumlah_barang"));
                detailTransaksi.setJumlah_harga(rs.getInt("jumlah_harga"));
                transaksi.add(detailTransaksi);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return transaksi;
    }

    public void show_data(int id){
        for(Detail_Transaksi_Entity detailTransaksi : getDetailTransaksi(id)){
            System.out.println("Nama Pelanggan: "+detailTransaksi.getNama_pelanggan());;
            System.out.println("Nama Pegawai : "+detailTransaksi.getNama_pegawai());
            System.out.println("Nama Produk : "+detailTransaksi.getNama_produk());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Detail_TransaksiModel transaksiModel = new Detail_TransaksiModel();
        transaksiModel.show_data(1);
    }
}
