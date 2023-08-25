package co.com.bytebank.modelo;

/**
 * @brief AutenticationUtil permite la autenticacion de cada usuario sea administrador o funcionario o cliente
 *
 * @author Sebastian Tuquerrez
 * @version 1.0
 */
public class AutenticationUtil {
    private String clave;

    /**
     * @brief Inicia la sesion del usuario autenticando la clave
     * @param clave
     * @return
     */
    public boolean iniciarSesion(String clave) {
        return this.clave == clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void getClave(){
        System.out.println(this.clave);
    }
}
