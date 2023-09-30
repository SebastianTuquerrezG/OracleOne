package co.com.jdbc.dao;

import co.com.jdbc.modelo.Categoria;
import co.com.jdbc.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection conection;
    public CategoriaDAO(Connection conexion) {
        this.conection = conexion;
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();

        try {
            var query = "SELECT id_categoria, nombre FROM categoria";
            final PreparedStatement statement = conection.prepareStatement(
                    query);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();
                try (resultSet) {
                    while (resultSet.next()) {
                        var categoria = new Categoria(
                                resultSet.getInt("id_categoria"),
                                resultSet.getString("nombre")
                        );
                        categorias.add(categoria);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return categorias;
    }

    public List<Categoria> listarConProductos() {
        List<Categoria> categorias = new ArrayList<>();

        try {
            String query = "SELECT id_categoria, nombre, p.nombre, p.stock FROM categoria c " +
                    "INNER JOIN producto p ON c.id_categoria = p.id_categoria ";
            final PreparedStatement statement = conection.prepareStatement(
                    query);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();
                try (resultSet) {
                    while (resultSet.next()) {
                        int categoriaID = resultSet.getInt("c.id_categoria");
                        String nombre = resultSet.getString("c.nombre");

                        Categoria categoria = categorias
                                .stream()
                                .filter(c -> c.getIdCategoria() == categoriaID)
                                .findAny().orElseGet(() -> {
                                    Categoria cat = new Categoria(categoriaID, nombre);

                                    categorias.add(cat);

                                    return cat;
                                });

                        Producto producto = new Producto(
                                resultSet.getInt("p.id_producto"),
                                resultSet.getString("p.nombre"),
                                resultSet.getInt("p.stock")
                        );

                        categoria.agregar(producto);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return categorias;
    }
}
