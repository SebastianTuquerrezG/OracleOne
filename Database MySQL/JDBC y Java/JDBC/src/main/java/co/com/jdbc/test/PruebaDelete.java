package co.com.jdbc.test;

import co.com.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaDelete {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        final Connection connection = connectionFactory.getConexion();

        Statement statement = connection.createStatement();

        statement.execute("DELETE FROM producto WHERE id_producto = 99");

        System.out.println(statement.getUpdateCount());

        statement.close();

        connection.close();
    }
}
