package Model;
import Entity.ProdukEntity;
import Helper.KoneksiDb;

import java.sql.*;
import java.util.ArrayList;

public class ProdukModel {
    private String sql;
    public Connection conn = KoneksiDb.getConnection();

    public int insertData(ProdukEntity produkEntity){
        try {
            sql = "INSERT INTO produk(kategori_id,nama_produk,harga_produk,stok_produk)" +
                    "VALUES(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,produkEntity.getKategori_id());
            stat.setString(2,produkEntity.getNama_produk());
            stat.setInt(3,produkEntity.getHarga());
            stat.setInt(4,produkEntity.getStok());
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateHarga(int harga, int id){
        try {
            sql = "UPDATE produk SET harga_produk = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,harga);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateStok(int stok, int id){
        try {
            sql = "UPDATE produk SET stok_produk = ? WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,stok);
            stat.setInt(2,id);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateNama(String nama, int id){
        try {
            sql = "UPDATE produk SET nama_produk = ? WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setInt(2,id);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


    public int deleteData(int id){
        try{
            sql = "DELETE FROM produk WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
   public ArrayList<ProdukEntity>getProduk(int id){
        ArrayList<ProdukEntity>arrayListProduk = new ArrayList<>();
        try{
            sql = "SELECT * FROM produk WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                ProdukEntity produkEntity = new ProdukEntity();
                produkEntity.setId(rs.getInt("id"));
                produkEntity.setKategori_id(rs.getInt("kategori_id"));
                produkEntity.setNama_produk(rs.getString("nama_produk"));
                produkEntity.setHarga(rs.getInt("harga_produk"));
                produkEntity.setStok(rs.getInt("stok_produk"));
                arrayListProduk.add(produkEntity);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return arrayListProduk;
    }

    public ArrayList<ProdukEntity>getProduk2(){
        ArrayList<ProdukEntity>arrayListProduk = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT produk.id, nama_produk,k.kategori, harga_produk,stok_produk\n" +
                    "FROM produk INNER JOIN kategori\n" +
                    "k on produk.kategori_id = k.id;";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                ProdukEntity produkEntity = new ProdukEntity();
                produkEntity.setId(rs.getInt("id"));
                produkEntity.setNama_produk(rs.getString("nama_produk"));
                produkEntity.setNama_kategori(rs.getString("kategori"));
                produkEntity.setHarga(rs.getInt("harga_produk"));
                produkEntity.setStok(rs.getInt("stok_produk"));
                arrayListProduk.add(produkEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arrayListProduk;
    }

}
