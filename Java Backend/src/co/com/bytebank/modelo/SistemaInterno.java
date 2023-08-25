package co.com.bytebank.modelo;

/**
 * @brief SistemaInterno es la clase que controla el funcionamiento del sistema interno de autenticacion
 */
public class SistemaInterno {
    private String clave = "12345";

    /**
     * autentica permite autenticar al gerente o cualquier usuario autenticable
     * @param gerente usuario autenticable
     * @return true si el usuario autenticado esta en el sistema
     */
    public boolean autentica(Autenticable gerente){
        boolean trueIniciarSesion = gerente.iniciarSesion(clave);
        if(trueIniciarSesion){
            System.out.println("Correcto");
            return true;
        } else{
            System.out.println("Incorrecto");
            return false;
        }
    }
}
