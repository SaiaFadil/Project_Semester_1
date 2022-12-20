/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static java.sql.Connection koneksi;
    public static java.sql.Connection getKoneksi() throws ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/aplikasi_kelompok_5";
                String user = "root";
                String password = "";
                
                koneksi = DriverManager.getConnection(url,user,password);
            }catch(SQLException t){
                System.out.println("ERROR MEMBUAT KONEKSI");
            }
        }
        return koneksi;
   }
}
