package co.com.jdbc.controller;

import co.com.jdbc.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoController {
    public int modificar(String nombre, String descripcion, Integer id, Double precio, Integer stock) throws SQLException {
        Connection connection = ConnectionFactory.getConexion();

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE producto SET "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "precio = ?, "
                    + "stock = ? "
                    + "WHERE id_producto = ?");

        statement.setString(1, nombre);
        statement.setString(2, descripcion);
        statement.setDouble(3, precio);
        statement.setInt(4, stock);
        statement.setInt(5, id);

        statement.execute();

        return statement.getUpdateCount();
    }

    public int eliminar(Integer id) throws SQLException {
        Connection connection = ConnectionFactory.getConexion();

        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM producto WHERE id_producto = ?");
        statement.setInt(1, id);

        statement.execute();

        return statement.getUpdateCount();
    }

    public List<Map<String, String>> listar() throws SQLException {
        Connection connection= ConnectionFactory.getConexion();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM producto");

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

        connection.close();

        return productos;
    }

    public void guardar(Map<String, String> producto) throws SQLException {
        String nombre = producto.get("nombre");
        String descripcion = producto.get("descripcion");
        Double precio = Double.parseDouble(producto.get("precio"));
        Integer stock = Integer.parseInt(producto.get("stock"));
        Integer maxCantidad = 50;
        
        Connection con = ConnectionFactory.getConexion();
        con.setAutoCommit(false);

        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO producto "
                        + "(nombre, descripcion, precio, stock)"
                        + "VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

        try {
            do{
                int cantidadParaInsertar = Math.min(stock, maxCantidad);

                ejecutaRegistro(statement, nombre, descripcion, precio, stock);

                stock -= cantidadParaInsertar;
            }while(stock > 0);

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        }

        statement.close();

        con.close();
    }

    private static void ejecutaRegistro(PreparedStatement statement, String nombre, String descripcion, Double precio, Integer stock) throws SQLException {
        statement.setString(1, nombre);
        statement.setString(2, descripcion);
        statement.setDouble(3, precio);
        statement.setInt(4, stock);

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        while (resultSet.next()) {
            System.out.printf(
                    "El id generado es: %d%n",
                    resultSet.getInt(1));
        }

        resultSet.close();
    }
}
