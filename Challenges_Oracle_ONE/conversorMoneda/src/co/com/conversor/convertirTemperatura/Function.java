package co.com.conversor.convertirTemperatura;

import javax.swing.*;

public class Function {

    ConvertirTemperatura temp = new ConvertirTemperatura();

    public void convertirTemperatura() {
        String opcion = (JOptionPane.showInputDialog(null,
                "Elige la moneda a la que desea convertir: ",
                "Monedas", JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"De Celsius a Fahrenheit",
                        "De Celsius a Kelvin",
                        "De Fahrenheit a Celsius",
                        "De Fahrenheit a Kelvin",
                        "De Kelvin a Celsius",
                        "De Kelvin a Fahrenheit"},
                "Seleccion")).toString();

        String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad a convertir: ");

        switch (opcion) {
            case "De Celsius a Fahrenheit":
                temp.ConvertirCelsiusAFahrenheit(0);
                break;
            case "De Celsius a Kelvin":
                temp.ConvertirCelsiusAKelvin(0);
                break;
            case "De Fahrenheit a Celsius":
                temp.ConvertirFahrenheitACelsius(0);
                break;
            case "De Fahrenheit a Kelvin":
                temp.ConvertirFahrenheitAKelvin(0);
                break;
            case "De Kelvin a Celsius":
                temp.ConvertirKelvinACelsius(0);
                break;
            case "De Kelvin a Fahrenheit":
                temp.ConvertirKelvinAFahrenheit(0);
                break;
            default:
        }
    }
}
