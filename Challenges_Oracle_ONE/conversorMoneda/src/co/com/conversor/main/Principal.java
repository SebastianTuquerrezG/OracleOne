package co.com.conversor.main;

import javax.swing.*;

import co.com.conversor.convertirMoneda.FunctionCoin;
import co.com.conversor.convertirTemperatura.FunctionTemp;

public class Principal {
    public static void main(String[] args) {
        FunctionCoin monedas = new FunctionCoin();

        FunctionTemp temp = new FunctionTemp();

        boolean flag = true;

        while (flag) {
            String opciones = (JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Convertir Pesos a Moneda Extranjera",
                            "Convertir Moneda Extranjera a Pesos",
                            "Convertir Temperaturas",
                            "Salir"},
                    "Seleccion")).toString();

            switch (opciones) {
                case "Convertir Pesos a Moneda Extranjera":
                    String input = JOptionPane.showInputDialog("Ingrese la cantidad a convertir: ");
                    if(validarNumero(input)){
                        double miInput = Double.parseDouble(input);
                        monedas.convertirMoneda(miInput);
                    }
                    break;
                case "Convertir Moneda Extranjera a Pesos":
                    String input2 = JOptionPane.showInputDialog("Ingrese la cantidad a convertir: ");
                    if(validarNumero(input2)){
                        double miInput2 = Double.parseDouble(input2);
                        monedas.convertirMonedaAPesos(miInput2);
                    }
                case "Convertir Temperaturas":
                    String temps = (JOptionPane.showInputDialog(null,
                            "Seleccione una opción:",
                            "Menu",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Celsius",
                                    "Fahrenheit",
                                    "Kelvin"},
                            "Seleccion")).toString();

                    switch (temps) {
                        case "Celsius":
                            String cels = JOptionPane.showInputDialog(null,
                                    "Opcion: ",
                                    "Menu",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    new Object[]{"Celsius a Fahrenheit",
                                    "Celsius a Kelvin"},
                                    "Seleccion").toString();

                            String inputtemp = JOptionPane.showInputDialog("Ingrese la cantidad a convertir: ");

                            switch (cels) {
                                case "Celsius a Fahrenheit":
                                    temp.convertirTemperatura();
                                    break;
                                case "Celsius a Kelvin":
                                    temp.convertirTemperatura();
                            }
                            //monedas.convertirTemperatura();
                            break;
                        case "Fahrenheit":
                            //monedas.convertirTemperatura();
                            break;
                        case "Kelvin":
                            //monedas.convertirTemperatura();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            break;
                    }
                    break;
                case "Salir":
                    flag = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
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
