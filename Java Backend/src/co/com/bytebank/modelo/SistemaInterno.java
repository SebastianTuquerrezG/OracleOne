package co.com.bytebank.modelo;

public class SistemaInterno {
    private String clave = "12345";

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
