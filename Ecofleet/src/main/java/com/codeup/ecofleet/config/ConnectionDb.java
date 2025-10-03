
package com.codeup.ecofleet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Coder
 */
public class ConnectionDb {

    public static void main(String[] args) {
        String vendor = "mysql";
        String host = "localhost";
        String port = "3306";
        String db = "ecofleet";
        String user ="vehiculo_user";
        String pass ="Qwe.123*";

        String url = String.format(
            "jdbc:%s://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
            vendor, host, port, db
        );

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println(" La conexión ha sido exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
