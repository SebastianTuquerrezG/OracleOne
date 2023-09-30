package co.com.jdbc.dao;

import co.com.jdbc.modelo.Categoria;
import co.com.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    final private Connection connection;

    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Producto producto) {
        try(connection) {
            connection.setAutoCommit(false);

            final PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO producto "
                            + "(nombre, descripcion, precio, stock, id_categoria)"
                            + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            try(statement) {
                ejecutaRegistro(producto, statement);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setDouble(3, producto.getPrecio());
        statement.setInt(4, producto.getStock());
        statement.setInt(5, producto.getCategoriaID());

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

    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try(connection) {
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM producto");

            try(statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try(resultSet) {
                    while (resultSet.next()) {
                        productos.add(new Producto(
                                resultSet.getInt("id_producto"),
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"),
                                resultSet.getDouble("precio"),
                                resultSet.getInt("stock")
                        ));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    public int eliminar(int id) {
        try {
            final PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM PRODUCTO WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(String nombre, String descripcion, int cantidad, Double precio, int id) {
        try {
            final PreparedStatement statement = connection.prepareStatement(
                    "UPDATE PRODUCTO SET "
                            + " NOMBRE = ?, "
                            + " DESCRIPCION = ?,"
                            + " PRECIO = ?,"
                            + " CANTIDAD = ?"
                            + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, descripcion);
                statement.setDouble(3, precio);
                statement.setInt(4, cantidad);
                statement.setInt(5, id);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar(Categoria idCategoria) {
        List<Producto> productos = new ArrayList<>();

        try(connection) {
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM producto"
                            + " WHERE id_categoria = ?");

            try(statement) {
                statement.setInt(1, idCategoria.getIdCategoria());
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try(resultSet) {
                    while (resultSet.next()) {
                        productos.add(new Producto(
                                resultSet.getInt("id_producto"),
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"),
                                resultSet.getDouble("precio"),
                                resultSet.getInt("stock")
                        ));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productos;
    }
}