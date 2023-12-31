package co.com.jdbc.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import co.com.jdbc.controller.CategoriaController;
import co.com.jdbc.controller.ProductoController;
import co.com.jdbc.modelo.Categoria;
import co.com.jdbc.modelo.Producto;

public class ControlDeStockFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private JLabel labelNombre, labelDescripcion, labelPrecio, labelCantidad, labelCategoria;
    private JTextField textoNombre, textoDescripcion, textoPrecio, textoCantidad;
    private JComboBox<Categoria> comboCategoria;
    private JButton botonGuardar, botonModificar, botonLimpiar, botonEliminar, botonReporte;
    private JTable tabla;
    private DefaultTableModel modelo;
    private final ProductoController productoController;
    private final CategoriaController categoriaController;

    public ControlDeStockFrame() {
        super("Productos");

        this.categoriaController = new CategoriaController();
        this.productoController = new ProductoController();

        Container container = getContentPane();
        setLayout(null);

        configurarCamposDelFormulario(container);

        configurarTablaDeContenido(container);

        configurarAccionesDelFormulario();
    }

    private void configurarTablaDeContenido(Container container){
        tabla = new JTable();

        modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Identificador del Producto");
        modelo.addColumn("Nombre del Producto");
        modelo.addColumn("Descripción del Producto");
        modelo.addColumn("Precio del Producto");
        modelo.addColumn("Cantidad del Producto");

        cargarTabla();

        tabla.setBounds(10, 245, 760, 280);

        botonEliminar = new JButton("Eliminar");
        botonModificar = new JButton("Modificar");
        botonReporte = new JButton("Ver Reporte");
        botonEliminar.setBounds(10, 530, 80, 20);
        botonModificar.setBounds(100, 530, 80, 20);
        botonReporte.setBounds(190, 530, 80, 20);

        container.add(tabla);
        container.add(botonEliminar);
        container.add(botonModificar);
        container.add(botonReporte);

        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void configurarCamposDelFormulario(Container container) {
        labelNombre = new JLabel("Nombre del Producto");
        labelDescripcion = new JLabel("Descripción del Producto");
        labelPrecio = new JLabel("Precio del Producto");
        labelCantidad = new JLabel("Cantidad");
        labelCategoria = new JLabel("Categoría del Producto");

        labelNombre.setBounds(10, 10, 240, 15);
        labelDescripcion.setBounds(10, 50, 240, 15);
        labelPrecio.setBounds(10, 90, 240, 15);
        labelCantidad.setBounds(10, 130, 240, 15);
        labelCategoria.setBounds(10, 170, 240, 15);

        labelNombre.setForeground(Color.BLACK);
        labelDescripcion.setForeground(Color.BLACK);
        labelPrecio.setForeground(Color.BLACK);
        labelCantidad.setForeground(Color.BLACK);
        labelCategoria.setForeground(Color.BLACK);

        textoNombre = new JTextField();
        textoDescripcion = new JTextField();
        textoPrecio = new JTextField();
        textoCantidad = new JTextField();
        comboCategoria = new JComboBox<>();
        comboCategoria.addItem(new Categoria(0,"Elige una Categoría"));

        var categorias = this.categoriaController.listar();
        categorias.forEach(categoria -> comboCategoria.addItem(categoria));

        textoNombre.setBounds(10, 25, 265, 20);
        textoDescripcion.setBounds(10, 65, 265, 20);
        textoPrecio.setBounds(10, 105, 265, 20);
        textoCantidad.setBounds(10, 145, 265, 20);
        comboCategoria.setBounds(10, 185, 265, 20);

        botonGuardar = new JButton("Guardar");
        botonLimpiar = new JButton("Limpiar");
        botonGuardar.setBounds(10, 215, 80, 20);
        botonLimpiar.setBounds(100, 215, 80, 20);

        container.add(labelNombre);
        container.add(labelDescripcion);
        container.add(labelPrecio);
        container.add(labelCantidad);
        container.add(labelCategoria);
        container.add(textoNombre);
        container.add(textoDescripcion);
        container.add(textoPrecio);
        container.add(textoCantidad);
        container.add(comboCategoria);
        container.add(botonGuardar);
        container.add(botonLimpiar);
    }

    private void configurarAccionesDelFormulario() {
        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirReporte();
            }
        });
    }

    private void abrirReporte() {
        new ReporteFrame(this);
    }

    private void limpiarTabla() {
        modelo.getDataVector().clear();
    }

    private boolean tieneFilaElegida() {
        return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }

    private void modificar() {
        if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
                    String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
                    String descripcion = (String) modelo.getValueAt(tabla.getSelectedRow(), 2);
                    double precio = Double.parseDouble(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
                    int cantidad = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 4).toString());

                    int cantidadModificada = this.productoController.modificar(nombre, descripcion, cantidad, precio, id);

                    JOptionPane.showMessageDialog(this, cantidadModificada + "Items modificados con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

    private void eliminar() {
        if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());

                    int cantidadEliminada = this.productoController.eliminar(id);

                    modelo.removeRow(tabla.getSelectedRow());

                    JOptionPane.showMessageDialog(this, cantidadEliminada + "Items eliminados con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

    private void cargarTabla() {
        var productos = this.productoController.listar();

        productos.forEach(producto -> modelo.addRow(
                new Object[]{
                        producto.getIdProducto(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getStock()}));{

        };
    }

    private void guardar(){
        if (textoNombre.getText().isBlank() || textoDescripcion.getText().isBlank() || textoCantidad.getText().isBlank() ||  textoPrecio.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Los campos Nombre, Descripción, Cantidad y Precio son requeridos.");
            return;
        }

        int cantidadInt, precioInt;

        try {
            cantidadInt = Integer.parseInt(textoCantidad.getText());
            precioInt = Integer.parseInt(textoPrecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, String
                    .format("El campo cantidad o precio debe ser numérico dentro del rango %d y %d.", 0, Integer.MAX_VALUE));
            return;
        }

        var producto = new Producto(
                textoNombre.getText(),
                textoDescripcion.getText(),
                precioInt, cantidadInt);

        var categoria = (Categoria) comboCategoria.getSelectedItem();

        assert categoria != null;
        this.productoController.guardar(producto, categoria.getIdCategoria());

        JOptionPane.showMessageDialog(this, "Registrado con éxito!");

        this.limpiarFormulario();
    }

    private void limpiarFormulario() {
        this.textoNombre.setText("");
        this.textoDescripcion.setText("");
        this.textoPrecio.setText("");
        this.textoCantidad.setText("");
        this.comboCategoria.setSelectedIndex(0);
    }

}