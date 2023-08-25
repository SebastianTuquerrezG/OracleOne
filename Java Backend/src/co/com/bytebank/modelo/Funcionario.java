package co.com.bytebank.modelo;

/**
 * @brief Clase abstracta Funcionario
 * @version 1.0
 * @author Sebastian Tuquerrez
 */
public abstract class Funcionario {
    private String nombre;
    private String documento;
    private double salario;
    private int tipo;

    protected String prueba;

    public Funcionario() {

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double getBonificacion();

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
