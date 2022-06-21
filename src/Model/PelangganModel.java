package Model;

import Entity.*;
import Helper.KoneksiDb;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PelangganModel {
    private String sql;
    public Connection conn = KoneksiDb.getConnection();

    public int insertData(PelangganEntity pelangganEntity){
        try{
            sql = "INSERT INTO pelanggan(nama,alamat)VALUES(?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,pelangganEntity.getNama());
            stat.setString(2, pelangganEntity.getAlamat());
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateNama(String nama, int id){
        try{
            sql = "UPDATE pelanggan SET nama = ? WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setInt(2,id);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateAlamat(String alamat, int id){
        try{
            sql = "UPDATE pelanggan SET alamat = ? WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,alamat);
            stat.setInt(2,id);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteData(int id){
        try{
            sql = "DELETE FROM pelanggan WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<PelangganEntity>getPelanggan(int id){
        ArrayList<PelangganEntity>pelanggaan = new ArrayList<>();
        try{
            sql = "SELECT * FROM pelanggan WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                PelangganEntity pelangganEntity = new PelangganEntity();
                pelangganEntity.setId(rs.getInt("id"));
                pelangganEntity.setNama(rs.getString("nama"));
                pelangganEntity.setAlamat(rs.getString("alamat"));
                pelanggaan.add(pelangganEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pelanggaan;
    }

    public String getNamaPelanggan(int id){
        try{
            sql = "SELECT * FROM pelanggan WHERE id = ? ";
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

    public static void main(String[] args) {

    }
}
