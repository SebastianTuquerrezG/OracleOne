package co.com.jdbc.controller;

import co.com.jdbc.factory.ConnectionFactory;
import co.com.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoController {
    public int modificar(String nombre, String descripcion, Integer id, Double precio, Integer stock) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        final Connection connection = connectionFactory.getConexion();

        try(connection) {
            final PreparedStatement statement = connection.prepareStatement(
                    "UPDATE producto SET "
                            + "nombre = ?, "
                            + "descripcion = ?, "
                            + "precio = ?, "
                            + "stock = ? "
                            + "WHERE id_producto = ?");

            try(statement) {
                statement.setString(1, nombre);
                statement.setString(2, descripcion);
                statement.setDouble(3, precio);
                statement.setInt(4, stock);
                statement.setInt(5, id);

                statement.execute();

                return statement.getUpdateCount();
            }
        }
    }

    public int eliminar(Integer id) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        final Connection connection = connectionFactory.getConexion();

        try(connection) {
            final PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM producto WHERE id_producto = ?");
            try(statement) {
                statement.setInt(1, id);

                statement.execute();

                return statement.getUpdateCount();
            }
        }
    }

    public List<Map<String, String>> listar() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        final Connection connection = connectionFactory.getConexion();

        try(connection) {
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM producto");

            try(statement) {
                statement.execute();

                ResultSet resultSet = statement.getResultSet();

                List<Map<String, String>> productos = new ArrayList<>();

                while (resultSet.next()) {
                    Map<String, String> producto = new HashMap<>();
                    producto.put("id_producto", String.valueOf(resultSet.getInt("id_producto")));
                    producto.put("nombre", resultSet.getString("nombre"));
                    producto.put("descripcion", resultSet.getString("descripcion"));
                    producto.put("precio", String.valueOf(resultSet.getDouble("precio")));
                    producto.put("stock", String.valueOf(resultSet.getInt("stock")));

                    productos.add(producto);
                }
                return productos;
            }
        }
    }

    public void guardar(Producto producto) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        final Connection connection = connectionFactory.getConexion();

        try(connection) {
            connection.setAutoCommit(false);

            final PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO producto "
                            + "(nombre, descripcion, precio, stock)"
                            + "VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            try(statement) {
                ejecutaRegistro(producto, statement);

                connection.commit();
            }
        } catch (SQLException e) {
                connection.rollback();
                throw e;
        }
    }

    private static void ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setDouble(3, producto.getPrecio());
        statement.setInt(4, producto.getStock());

        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();

        try(resultSet){
            while (resultSet.next()) {
                producto.setIdProducto(resultSet.getInt(1));
                System.out.printf(
                        String.format(
                        "Se ha insertado el producto: %s%n",
                        producto
                    )
                );
            }
        }
    }
}
