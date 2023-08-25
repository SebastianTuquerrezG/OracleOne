package co.com.bytebank.modelo;

/**
 * @brief Clase Gerente genera un objeto de tipo Funcionario
 */
public class Gerente extends Funcionario implements Autenticable {
    //Sobreescritura de metodo

    /**
     * retorna la bonificacion del gerente
     * @return la bonificacion
     */
    public double getBonificacion() {
        System.out.println("Llamando metodo del co.com.bytebank.modelo.Gerente");
        return 2000;
    }

    @Override
    public void setClave(String clave) {

    }

    @Override
    public boolean iniciarSesion(String clave) {
        return false;
    }
}
