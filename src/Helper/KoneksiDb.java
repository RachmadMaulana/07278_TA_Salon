package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDb {
    public static Connection getConnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/salon";
        String user = "root";
        String pass = "";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Berhasil konek database");
        }catch (Exception e){
            System.err.println("Gagal Koneksi Database");
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
