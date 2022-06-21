package Model;

import Helper.KoneksiDb;

import java.sql.*;

public class PegawaiModel {
    public Connection conn = KoneksiDb.getConnection();
    public String sql;

    public int cekLogin(String username, String password){
        try{
            sql = "SELECT * FROM pegawai WHERE nama = ? AND password = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,username);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getInt("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int tambahPelanggan(String nama, String alamat){
        try{
            sql = "INSERT INTO pelanggan(nama,alamat) VALUES (?,?)";
            PreparedStatement stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1,nama);
            stat.setString(2,alamat);
            stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();

            if(rs.next()){
                return rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public String getNamaPegawai(int id){
        try {
            sql = "SELECT * FROM pegawai WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getString("nama");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getStok(int id){
        try {
            sql = "SELECT * FROM produk WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getInt("stok_produk");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
