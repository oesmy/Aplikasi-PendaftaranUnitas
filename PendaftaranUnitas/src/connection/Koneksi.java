package connection;

import java.sql.*;

public class Koneksi {
    
    private Connection connect;
    
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
        } catch (ClassNotFoundException err) {
            System.out.println("Gagal Koneksi "+ err);
        }
        String url = "jdbc:mysql://localhost/aplikasi_unitas";
        try{
            connect = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil Terkoneksi Ke Database");
        } catch (SQLException err){
            System.out.println("Gagal Terkoneksi Ke Database" + err);
        }
        return connect;
    }
    
    
}
