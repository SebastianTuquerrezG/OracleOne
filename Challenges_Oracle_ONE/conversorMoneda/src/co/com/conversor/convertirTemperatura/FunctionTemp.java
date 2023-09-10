package co.com.conversor.convertirTemperatura;

import javax.swing.*;

public class FunctionTemp {

    ConvertirTemperatura temp = new ConvertirTemperatura();

    public void convertirTemperatura(double cantidad, String opcionTemp){
        switch (opcionTemp) {
            case "Celsius":
                String opcioneCelsius = (JOptionPane.showInputDialog(null,
                        "Seleccione una opción:",
                        "Menu",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Convertir Celsius a Fahrenheit",
                                "Convertir Celsius a Kelvin"},
                        "Seleccion")).toString();

                if (opcioneCelsius.equals("Convertir Celsius a Fahrenheit")) {
                    temp.ConvertirCelsiusAFahrenheit(cantidad);
                } else if (opcioneCelsius.equals("Convertir Celsius a Kelvin")) {
                    temp.ConvertirCelsiusAKelvin(cantidad);
                }
                break;
            case "Kelvin":
                String opcioneKelvin = (JOptionPane.showInputDialog(null,
                        "Seleccione una opción:",
                        "Menu",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Convertir Kelvin a Celsius",
                                "Convertir Kelvin a Fahrenheit"},
                        "Seleccion")).toString();
                if (opcioneKelvin.equals("Convertir Kelvin a Celsius")) {
                    temp.ConvertirKelvinACelsius(cantidad);
                } else if (opcioneKelvin.equals("Convertir Kelvin a Fahrenheit")) {
                    temp.ConvertirKelvinAFahrenheit(cantidad);
                }
                break;
            case "Fahrenheit":
                String opcioneFahrenheit = (JOptionPane.showInputDialog(null,
                        "Seleccione una opción:",
                        "Menu",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Convertir Fahrenheit a Celsius",
                                "Convertir Fahrenheit a Kelvin"},
                        "Seleccion")).toString();
                if (opcioneFahrenheit.equals("Convertir Fahrenheit a Celsius")) {
                    temp.ConvertirFahrenheitACelsius(cantidad);
                } else if (opcioneFahrenheit.equals("Convertir Fahrenheit a Kelvin")) {
                    temp.ConvertirFahrenheitAKelvin(cantidad);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }
}
