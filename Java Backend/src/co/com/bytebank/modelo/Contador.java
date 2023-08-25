package co.com.bytebank.modelo;

/**
 * @brief Clase que implementa la interfaz Funcionario para diferenciar los funcionarios
 *
 * @version 1.0
 * @author Sebastian Tuquerrez
 */
public class Contador extends Funcionario{

    /**
     * @brief Metodo sobrecargado que calcula la bonificacion de  un contador
     * @return double bonificacion
     */
    @Override
    public double getBonificacion() {
        System.out.println("Llamando metodo del co.com.bytebank.modelo.Contador");
        return 200;
    }
}
