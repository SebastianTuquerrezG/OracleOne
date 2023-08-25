package co.com.bytebank.modelo;

/**
 * @brief Interfaz para autenticar un usuario
 *
 * @version 1.0
 * @author Sebastian Tuquerrez
 */
public interface Autenticable{

    public void setClave(String clave);

    public boolean iniciarSesion(String clave);
}
