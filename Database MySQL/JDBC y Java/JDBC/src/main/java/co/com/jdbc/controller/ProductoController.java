package co.com.jdbc.controller;

import co.com.jdbc.factory.ConnectionFactory;
import co.com.jdbc.modelo.Producto;
import co.com.jdbc.dao.ProductoDAO;

import java.util.List;

public class ProductoController {

    private ProductoDAO productoDAO;

    public ProductoController(){
        var connectionFactory = new ConnectionFactory();
        this.productoDAO = new ProductoDAO(connectionFactory.getConexion());
    }
    public int modificar(String nombre, String descripcion, int stock, Double precio, int id)  {
        return productoDAO.modificar(nombre, descripcion, stock, precio, id);
    }

    public int eliminar(int id){
        return productoDAO.eliminar(id);
    }

    public List<Producto> listar(){
        return productoDAO.listar();

    }

    public void guardar(Producto producto) {
        productoDAO.guardar(producto);
    }
}
