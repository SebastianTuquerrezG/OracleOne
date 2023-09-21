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

        Statement statement = connection.createStatement();

        statement.execute("UPDATE producto SET nombre = '" + nombre
                + "', descripcion = '" + descripcion
                + "', precio = " + precio
                + ", stock = " + stock
                + " WHERE id_producto = " + id);

        return statement.getUpdateCount();
    }

    public int eliminar(Integer id) throws SQLException {
        Connection connection = ConnectionFactory.getConexion();

        Statement statement = connection.createStatement();

        statement.execute("DELETE FROM producto WHERE id_producto = " + id);

        return statement.getUpdateCount();
    }

    public List<Map<String, String>> listar() throws SQLException {
        Connection connection= ConnectionFactory.getConexion();

        Statement statement = connection.createStatement();

        boolean result = statement.execute("SELECT * FROM producto");

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
        Connection con = ConnectionFactory.getConexion();

        Statement statement = con.createStatement();

        statement.execute("INSERT INTO producto (nombre, descripcion, precio, stock) VALUES ('"
                + producto.get("nombre") + "', '"
                + producto.get("descripcion") + "', "
                + producto.get("precio") + ", "
                + producto.get("stock") + ")", Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();

        while (resultSet.next()) {
            System.out.println(
                    String.format(
                            "El id generado es: %d" ,
                            resultSet.getInt(1)));
        }

        con.close();
    }
}
