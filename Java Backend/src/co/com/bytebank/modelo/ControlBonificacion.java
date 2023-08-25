package co.com.bytebank.modelo;

/**
 * @brief Clase ControlBonificacion muestra la suma de bonificaciones con el salario del funcionario
 * @author Sebastian Tuquerrez
 * @version 1.0
 */
public class ControlBonificacion {
    private double suma;

    /**
     * @brief Metodo registrarSalario registra el salario del funcionario
     * @param funcionario
     * @return double
     */
    public double registrarSalario(Funcionario funcionario) {
        this.suma = funcionario.getBonificacion() + this.suma;
        System.out.println("Calculo actual: " + this.suma);
        return this.suma;
    }
}
