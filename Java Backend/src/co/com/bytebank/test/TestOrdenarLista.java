package co.com.bytebank.test;

import co.com.bytebank.modelo.Cliente;
import co.com.bytebank.modelo.Cuenta;
import co.com.bytebank.modelo.CuentaAhorros;
import co.com.bytebank.modelo.CuentaCorriente;

import java.util.*;

public class TestOrdenarLista {
    public static void main(String[] args) {
        Cuenta cc1 = new CuentaCorriente(100, 44);
        Cliente clientCC1 = new Cliente();
        clientCC1.setNombre("Sebastian");
        cc1.setTitular(clientCC1);
        cc1.deposita(50);

        Cuenta cc2 = new CuentaAhorros(101, 22);
        Cliente clientCC2 = new Cliente();
        clientCC2.setNombre("Paula");
        cc2.setTitular(clientCC2);
        cc2.deposita(100);

        Cuenta cc3 = new CuentaCorriente(102, 11);
        Cliente clientCC3 = new Cliente();
        clientCC3.setNombre("Pedro");
        cc3.setTitular(clientCC3);
        cc3.deposita(150);

        Cuenta cc4 = new CuentaAhorros(103, 33);
        Cliente clientCC4 = new Cliente();
        clientCC4.setNombre("Juan");
        cc4.setTitular(clientCC4);
        cc4.deposita(200);

        List<Cuenta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        System.out.println("Antes de ordenar");
        for (Cuenta account : lista) {
            System.out.println(account);
        }

        //Ordenar las cuentas
        //Espera cualquier clase hija de cuenta
        //Comparator <? extend Cuenta> c
        Comparator<Cuenta> comp = new OrdenarPorNumeroCuenta();
        //lista.sort(new OrdenarPorNumeroCuenta());
        lista.sort(new Comparator<Cuenta>() {
            @Override
            public int compare(Cuenta o1, Cuenta o2) {
                return o1.getNumero() - o2.getNumero();
            }
        });

        System.out.println("Ordenado por numero");
        for (Cuenta account : lista) {
            System.out.println(account.getNumero());
        }

        System.out.println("Antes de ordenar por titular");
        for (Cuenta account : lista) {
            System.out.println(account);
        }

        //comp = new OrdenarPorNombreTitular();
        //lista.sort(new OrdenarPorNombreTitular());

        //Forma antigua antes de java 8
        Collections.sort(lista, new Comparator<Cuenta>() {
            @Override
            public int compare(Cuenta o1, Cuenta o2) {
                return o1.getTitular().getNombre().compareTo(o2.getTitular().getNombre());
            }
        });

        System.out.println("Ordenado por nombre de titular");
        for (Cuenta account : lista) {
            System.out.println(account);
        }

        //Forma orden natural
        Collections.sort(lista);

        System.out.println("Ordenado naturalmente");
        for (Cuenta account : lista) {
            System.out.println(account);
        }
    }
}

class OrdenarPorNumeroCuenta implements Comparator<Cuenta>{
    @Override
    public int compare(Cuenta o1, Cuenta o2) {
        //Forma Normal
        //return o1.getNumero() == o2.getNumero() ? 0 :
        //           o1.getNumero() < o2.getNumero() ? -1 : 1;
        //Forma Intermedia
        //return o1.getNumero() - o2.getNumero();
        //Forma con wrappers
        return Integer.compare(o1.getNumero(), o2.getNumero());
    }
}

class OrdenarPorNombreTitular implements Comparator<Cuenta>{
    @Override
    public int compare(Cuenta o1, Cuenta o2) {
        return o1.getTitular().getNombre().compareTo(o2.getTitular().getNombre());
    }
}

