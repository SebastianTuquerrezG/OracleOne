package co.com.jdbc.controller;

import co.com.jdbc.dao.CategoriaDAO;
import co.com.jdbc.factory.ConnectionFactory;
import co.com.jdbc.modelo.Categoria;

import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        var connectionFactory = new ConnectionFactory();
        this.categoriaDAO = new CategoriaDAO(connectionFactory.getConexion());
    }
    public List<Categoria> listar() {
        return this.categoriaDAO.listar();
    }

    public List<Categoria> cargaReporte() {
        return this.categoriaDAO.listarConProductos();
    }
}
