package co.com.bytebank.test;

import co.com.bytebank.modelo.Cuenta;
import co.com.bytebank.modelo.CuentaAhorros;
import co.com.bytebank.modelo.SaldoInsuficienteException;

public class TestCuentaExcepcionSaldo {
    public static void main(String[] args) throws SaldoInsuficienteException {
        Cuenta cuenta = new CuentaAhorros(123, 456);
        cuenta.deposita(210);
        cuenta.getSaldo();
        cuenta.saca(2000);
        cuenta.saca(100);
    }

}
