/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pian
 */
public class ConnectionClass {

    private static Connection connDB = null;

    public static Connection connectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("conn.mysql.jdbc.Driver");
//            String url = "jbdc:mysql://localhost:3306/toko_pian";
            String url = "jdbc:mysql://localhost:3306/toko_pian?serverTimezone=UTC";
            String user = "pma";
            String pass = "pmapass";

            connDB = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed" + e.getMessage());
        }

        return connDB;
    }

    public static void main(String[] args) {
        ConnectionClass kk = new ConnectionClass();
        kk.connectionDB();
    }
}
