package co.com.jdbc.test;

import co.com.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaPoolDeConexiones {

        public static void main(String[] args) throws SQLException {
            ConnectionFactory connectionFactory = new ConnectionFactory();

            for (int i = 0; i < 20; i++) {
                Connection connection = connectionFactory.getConexion();

                System.out.println("Connection #" + i + ": " + connection);
            }
        }
}
