package co.com.conversor.main;

import javax.swing.*;

import co.com.conversor.convertirMoneda.Function;

public class Principal {
    public static void main(String[] args) {
        Function monedas = new Function();

        boolean flag = true;

        while (flag) {
            String opciones = (JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menu", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Convertir Moneda", "Convertir Temperatura"}, "Seleccion")).toString();

            switch (opciones) {
                case "Convertir Moneda":
                    String input = JOptionPane.showInputDialog("Ingrese la cantidad a convertir: ");
                    if(validarNumero(input)){
                        double miInput = Double.parseDouble(input);
                        monedas.convertirMoneda(miInput);
                    }
                    break;
                case "Convertir Temperatura":
                    //monedas.convertirTemperatura();
                    break;
            }
        }
    }

    public static boolean validarNumero(String input){
        try {
            double x = Double.parseDouble(input);
            if(x >= 0 || x < 0);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
