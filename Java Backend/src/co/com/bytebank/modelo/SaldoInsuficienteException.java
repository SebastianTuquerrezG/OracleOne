package co.com.bytebank.modelo;

/**
 * SaldoInsuficienteException lanzada cuando el saldo es insuficiente
 */
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
