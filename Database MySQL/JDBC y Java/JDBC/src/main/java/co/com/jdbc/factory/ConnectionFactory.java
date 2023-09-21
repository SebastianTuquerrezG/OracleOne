package co.com.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "projects",
                "oracle28");
    }
}
