import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "projects",
                "oracle28");

        con.close();
    }
}
