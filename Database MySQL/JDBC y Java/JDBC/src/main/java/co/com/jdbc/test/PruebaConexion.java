package co.com.jdbc.test;

import co.com.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionFactory.getConexion();

        System.out.println("Conexión exitosa");

        con.close();
    }
}
