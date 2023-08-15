package co.com.bytebank.test;

import co.com.bytebank.modelo.Administrador;
import co.com.bytebank.modelo.Gerente;
import co.com.bytebank.modelo.SistemaInterno;

public class TestSistemaInterno {
    public static void main(String[] args){
        SistemaInterno sistema = new SistemaInterno();
        Gerente manager1 = new Gerente();
        Administrador admin = new Administrador();

        manager1.setClave("12345");
        admin.setClave("12345");
        sistema.autentica(manager1);
        sistema.autentica(admin);

    }
}
