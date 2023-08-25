package co.com.bytebank.modelo;

/**
 * @brief  Administrador complementa los metodos para un funcionario y permite la autentificacion del admin
 * @author Sebastian Tuquerrez
 * @version 1.0
 */
public class Administrador extends Funcionario implements Autenticable {
    private AutenticationUtil util;

    public Administrador() {
        this.util = new AutenticationUtil();
    }
    @Override
    public double getBonificacion() {
        return this.getSalario();
    }
    @Override
    public void setClave(String clave) {
        this.util.setClave(clave);
    }
    @Override
    public boolean iniciarSesion(String clave) {
        return this.util.iniciarSesion(clave);
    }
}
