package co.com.bytebank.modelo;

/**
 * @brief Crea instancias de un cliente, el cual puede autenticarse
 *
 * @author Sebastian Tuquerrez
 * @version 1.0
 */
public class Cliente implements Autenticable {

    private String nombre;
    private String documento;
    private String telefono;
    private AutenticationUtil util;

    /**
     * Instancia un cliente usando su informacion de autenticacion
     */
    public Cliente() {
        this.util = new AutenticationUtil();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean iniciarSesion(String clave) {
        return this.util.iniciarSesion(clave);
    }

    @Override
    public void setClave(String clave) {
        this.setClave(clave);
    }
}
