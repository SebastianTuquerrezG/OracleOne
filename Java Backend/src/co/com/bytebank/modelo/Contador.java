package co.com.bytebank.modelo;

public class Contador extends Funcionario{
    @Override
    public double getBonificacion() {
        System.out.println("Llamando metodo del co.com.bytebank.modelo.Contador");
        return 200;
    }
}
