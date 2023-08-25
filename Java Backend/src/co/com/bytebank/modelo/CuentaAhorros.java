package co.com.bytebank.modelo;

/**
 * @brief Cuenta creara instancias de cuenta de ahorros o corriente
 * @version 1.0
 * @author Sebastian Tuquerrez
 */
public class CuentaAhorros extends Cuenta{
    public CuentaAhorros(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
