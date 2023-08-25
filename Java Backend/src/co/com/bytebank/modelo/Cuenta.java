package co.com.bytebank.modelo;

/**
 * @brief Cuenta creara instancias de cuenta de ahorros o corriente
 *
 * @version 1.0
 * @author Sebastian Tuquerrez
 */
public abstract class Cuenta implements Comparable<Cuenta> {

    protected double saldo = 0;
    private int agencia = 1;
    private int numero;
    private Cliente titular = new Cliente();

    private static int total;

    /**
     * @brief Instancia una cuenta sin parametros
     */
    public Cuenta(){

    }

    /**
     * Instancia una cuenta usando la agencia y el numero
     * @param agencia agencia a la que pertenece
     * @param numero numero de la cuenta
     */
    public Cuenta( int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        System.out.println("Estoy creando una cuenta " + this.numero);

        Cuenta.total ++;
    }

    /**
     * @brief Retorna el saldo de la cuenta
     * @param valor
     */
    public abstract void deposita(double valor);

    /**
     * Retira un valor de dinero de la cuenta
     * @param valor
     * @return true si se pudo retirar el valor
     */
    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @brief Envia un valor de dinero de la cuenta a otra cuenta
     * @param valor
     * @param destino
     * @return
     */
    public boolean transfiere(double valor, Cuenta destino) {
        if(this.saldo >= valor) {
            this.saca(valor);
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if (agencia > 0) {
            this.agencia = agencia;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        }
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public static int getTotal() {
        return Cuenta.total;
    }

    @Override
    public String toString() {
        String cuenta = "Numero: " + this.numero + ", Agencia:" + this.agencia
                + ", Titular: " + this.titular.getNombre();
        return cuenta;
    }

    @Override
    public boolean equals(Object obj) {
        // Basada en valores
        Cuenta cuenta = (Cuenta) obj;
        return this.agencia == cuenta.getAgencia() &&
                this.numero == cuenta.getNumero();
    }

    @Override
    public int compareTo(Cuenta o) {
        // Orden natural: Numero Agencia
        //return Integer.compare(this.agencia, o.getAgencia());
        // Orden natural: Saldo
        return Double.compare(this.getSaldo(), o.getSaldo());
    }
}
