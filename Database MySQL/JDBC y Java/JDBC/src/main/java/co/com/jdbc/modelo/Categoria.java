package co.com.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int idCategoria;
    private String nombre;

    private List<Producto> productos = new ArrayList<>();

    public Categoria(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombreCategoria) {
        this.nombre = nombreCategoria;
    }

    public void agregar(Producto producto) {
        if(this.productos == null) {
            this.productos = new ArrayList<>();
        }

        this.productos.add(producto);
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Object getProductos() {
        return this.productos;
    }
}
