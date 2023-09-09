package co.com.conversor.convertirTemperatura;

import javax.swing.*;

public class ConvertirTemperatura {
    public void ConvertirCelsiusAFahrenheit(double cantidad){
        double tempCelsius = cantidad*1.8+32;
        tempCelsius = (double) Math.round(tempCelsius*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " grados Celsius es equivalente a " + tempCelsius + " grados Fahrenheit");
    }

    public void ConvertirCelsiusAKelvin(double cantidad){
        double tempCelsius = cantidad+273.15;
        tempCelsius = (double) Math.round(tempCelsius*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " grados Celsius es equivalente a " + tempCelsius + " grados Kelvin");
    }

    public void ConvertirFahrenheitAKelvin(double cantidad){
        double tempFahrenheit = (cantidad-32)*5/9+273.15;
        tempFahrenheit = (double) Math.round(tempFahrenheit*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " grados Fahrenheit es equivalente a " + tempFahrenheit + " grados Kelvin");
    }

    public void ConvertirFahrenheitACelsius(double cantidad){
        double tempFahrenheit = (cantidad-32)*5/9;
        tempFahrenheit = (double) Math.round(tempFahrenheit*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " grados Fahrenheit es equivalente a " + tempFahrenheit + " grados Celsius");
    }

    public void ConvertirKelvinACelsius(double cantidad){
        double tempKelvin = cantidad-273.15;
        tempKelvin = (double) Math.round(tempKelvin*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " grados Kelvin es equivalente a " + tempKelvin + " grados Celsius");
    }

    public void ConvertirKelvinAFahrenheit(double cantidad){
        double tempKelvin = (cantidad-273.15)*9/5+32;
        tempKelvin = (double) Math.round(tempKelvin*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de " + cantidad + " grados Kelvin es equivalente a " + tempKelvin + " grados Fahrenheit");
    }
}
